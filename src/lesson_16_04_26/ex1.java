package lesson_16_04_26;

class Employee{
    private String name;
    private String surname;
    private int age;
    private int weight;
    private int salary;
    private String country;
    private int experience;
    private boolean  isMale;
    private String gmail;

    Employee(String name, String surname, int age, int weight, int salary, String country, int experience, boolean isMale, String gmail) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.weight = weight;
        this.salary = salary;
        this.country = country;
        this.experience = experience;
        this.isMale = isMale;
        this.gmail = gmail;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        if(age >= 0 && age <= 150) {
            this.age = age;
        }
        else {
            System.out.println("Invalid Age");
        }
    }
    public int getWeight() {
        return weight;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }
    public int getSalary() {
        return salary;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public int getExperience() {
        return experience;
    }
    public void setExperience(int experience) {
        this.experience = experience;
    }
    public boolean isMale() {
        return isMale;
    }
    public void setMale(boolean male) {
        isMale = male;
    }
    public String getGmail() {
        return gmail;
    }
    public void setGmail(String gmail) {
        this.gmail = gmail;
    }


    void print() {
        System.out.println("Name: " + name);
        System.out.println("Surname: " + surname);
        System.out.println("Age: " + age);
        System.out.println("Weight: " + weight);
        System.out.println("Salary: " + salary);
        System.out.println("Country: " + country);
        System.out.println("Experience: " + experience);
        System.out.println("Male: " + isMale);
        System.out.println("Gmail: " + gmail);
    }
    void nameSurnameCountry() {
        System.out.println("Name: " + name);
        System.out.println("Surname: " + surname);
        System.out.println("Country: " + country);
    }

    boolean isGmailValid() {
        if(gmail.endsWith("@gmail.com")) {
            return true;
        }
        return false;
    }


}

class Sportsman extends Employee {
    int titles;
    String club;

    public int getTitles() {
        return titles;
    }
    public void setTitles(int titles) {
        this.titles = titles;
    }
    public String getClub() {
        return club;
    }
    public void setClub(String club) {
        this.club = club;
    }
    Sportsman(String name, String surname, int age, int weight, int salary, String country, int experience, boolean isMale, String gmail, String club, int titles) {
        super(name,surname,age,weight,salary,country,experience, isMale, gmail);
        this.club = club;
        this.titles = titles;
    }
    void print() {
        super.print();
        System.out.println("Titles: " + titles);
        System.out.println("Club: " + club);
    }
}

public class ex1 {
    public static void main(String[] args) {
        Sportsman sportsman1 = new Sportsman(
                "Lionel", "Messi", 38, 72, 50000000, "Argentina", 20, true, "leo@gmail.com", "Inter Miami", 44
        );
        Sportsman sportsman2 = new Sportsman(
                "Coco", "Gauff", 22, 64, 12000000, "USA", 6, false, "coco.gauff@gmail.com", "WTA Independent", 7
        );
        Sportsman sportsman3 = new Sportsman(
                "Erling", "Haaland", 25, 87, 45000000, "Norway", 8, true, "erling.goals@gmail.com", "Manchester City", 12
        );

        sportsman1.print();
        sportsman2.print();
        sportsman3.print();
    }
}
