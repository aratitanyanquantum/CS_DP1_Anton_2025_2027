package lesson_16_04_26;


class User{
    private String username;
    private String displayName;
    private String profilePic;
    private Post[] posts=new Post[10];
    User(String username, String displayName, String profilePic){
        this.username = username;
        this.displayName = displayName;
        this.profilePic = profilePic;
    }
    void newTextMessage(String message){
        boolean flag=false;
        for(int j=0;j<posts.length;j++){
            if(posts[j]==null){
                posts[j]=new TextMessage(message);
                flag=true;
            }
        }
        if(flag==false){
            System.out.println("posts are full");
        }
    }
    void newPictureMessage(String message){
        boolean flag=false;
        for(int j=0;j<posts.length;j++){
            if(posts[j]==null){
                posts[j]=new PictureMessage(message);
                flag=true;
            }
        }
        if(flag==false){
            System.out.println("posts are full");
        }
    }
    void newVideoMessage(String message){
        boolean flag=false;
        for(int j=0;j<posts.length;j++){
            if(posts[j]==null){
                posts[j]=new VideoMessage(message);
                flag=true;
            }
        }
        if(flag==false){
            System.out.println("posts are full");
        }
    }
    int getPostCount(){
        return posts.length;
    }
    Post getPost(int index){
        return posts[index];
    }
    void newComment(int index, String message, User user){
        posts[index].newComment(message,user);
    }
    void newLike(int index){
        posts[index].newLike();
    }



}

class Post{
    private Comment[] comments;
    private int likeCount;
    public Post(){
        comments=new Comment[10];
        likeCount=0;
    }

    public Comment[] getComments() {
        return comments;
    }
    public void setComments(Comment[] comments) {
        this.comments = comments;
    }
    public int getLikeCount() {
        return likeCount;
    }
    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    void newComment(String comment, User user){
        for(int j=0;j<comments.length;j++){
            if(comments[j]==null){
                comments[j]=new Comment(comment,user);
            }
        }
    }
    void newLike(){
        likeCount++;
    }


}



    class Comment{
    String comment;
    User author;
    public Comment(String comment, User author){
        this.comment=comment;
    }
    public String getComment() {
        return comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }
    public User getAuthor() {
        return author;
    }
    public void setAuthor(User author) {
        this.author = author;
    }


}



class TextMessage extends Post{
    private String message;
    TextMessage(String message){
        super();
        setMessage(message);
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
}
class PictureMessage extends Post{
    private String pictureURL;
    PictureMessage(String picture){
        setPictureURL(picture);
    }
    public String getPictureURL() {
        return pictureURL;
    }
    public void setPictureURL(String pictureURL) {
        this.pictureURL = pictureURL;
    }
}
class VideoMessage extends Post{
    private String youtubeLink;
    VideoMessage(String videoURL){
        this.youtubeLink = videoURL;
    }
}



public class soicalMedia {
    public static void main(String[] args) {
        User frodo = new User("frodo", "Frodo Baggins", "frodo.png");
        User gandalf = new User("gandalf", "Gandalf the Grey", "gandalf.png");
        User samwise = new User("samwise", "Samwise Gamgee", "samwise.png");
        User aragorn = new User("aragorn", "Aragorn", "aragorn.png");

// Create posts
        frodo.newTextMessage("Just finished my quest to destroy the One Ring. What an adventure! #MissionAccomplished #RingBearer");
        frodo.newPictureMessage("Pic of me after the quest! #MountDoom #Mordor");
        aragorn.newTextMessage("Reunited with my love, Arwen. Forever grateful for her love and support. ❤️ #Elessar #LoveAndDestiny");
        gandalf.newVideoMessage("Just having some fun with my staff and showing off a little wizardry on the dance floor! 💃✨ #GandalfTheDancer #WizardGrooves");

// Create comments
        frodo.newComment(0, "Mr. Frodo! I'm so proud of you! You're the bravest hobbit I know. #TrueFriendship #HobbitHeroes", samwise);
        frodo.newComment(0, "Frodo, you have my gratitude and respect. Your sacrifice has saved Middle-earth. #KingOfGondor #HeroicDeeds", aragorn);
        frodo.newComment(0, "Well done, Frodo! You've shown incredible strength and determination. The world is safer because of you. #RingDestroyer #WizardPride", gandalf);
        frodo.newComment(1, "Who's that great looking bloke next to you?", samwise);
        frodo.newComment(1, "Amazing!", aragorn);
        aragorn.newComment(0, "Aragorn, may your love with Arwen be as enduring as the light of the Silmarils. #LoveAndHope #FellowshipForever", frodo);
        aragorn.newComment(0, "Aragorn, you have found true love. Cherish it always. #Shieldmaiden #HappilyEverAfter", gandalf);
        gandalf.newComment(0, "Love it! #WizardsCanDance", frodo);
        gandalf.newComment(0, "rofl", samwise);

// Create likes
        frodo.newLike(1);
        frodo.newLike(1);
        aragorn.newLike(0);


        for (int i=0; i<1500; i++) {
            gandalf.newLike(0);
        }



    }
}
