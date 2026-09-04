package RentalService.model;

public class PriceList {
    private int priceId;
    private String model;
    private int dailyRate;
    private int hourlyRate;

    public PriceList() {
    }

    public PriceList(int priceId, String model, int dailyRate, int hourlyRate) {
        this.priceId = priceId;
        this.model = model;
        this.dailyRate = dailyRate;
        this.hourlyRate = hourlyRate;
    }

    public int getPriceId() {
        return priceId;
    }

    public void setPriceId(int priceId) {
        this.priceId = priceId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getDailyRate() {
        return dailyRate;
    }

    public void setDailyRate(int dailyRate) {
        this.dailyRate = dailyRate;
    }

    public int getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(int hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    @Override
    public String toString() {
        return "PriceList{" +
                "priceId=" + priceId +
                ", model='" + model + '\'' +
                ", dailyRate=" + dailyRate +
                ", hourlyRate=" + hourlyRate +
                '}';
    }
}
