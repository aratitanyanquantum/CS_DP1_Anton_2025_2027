package RentalService.model;

public class Cars {
    private int carId;
    private String brand;
    private int productionYear;
    private boolean hasInsurance;
    private int officeId;
    private int priceId;

    public Cars() {
    }

    public Cars(int carId, String brand, int productionYear, boolean hasInsurance, int officeId, int priceId) {
        this.carId = carId;
        this.brand = brand;
        this.productionYear = productionYear;
        this.hasInsurance = hasInsurance;
        this.officeId = officeId;
        this.priceId = priceId;
    }

    public int getCarId() {
        return carId;
    }
    public void setCarId(int carId) {
        this.carId = carId;
    }
    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public int getProductionYear() {
        return productionYear;
    }
    public void setProductionYear(int productionYear) {
        this.productionYear = productionYear;
    }
    public boolean isHasInsurance() {
        return hasInsurance;
    }
    public void setHasInsurance(boolean hasInsurance) {
        this.hasInsurance = hasInsurance;
    }
    public int getOfficeId() {
        return officeId;
    }
    public void setOfficeId(int officeId) {
        this.officeId = officeId;
    }
    public int getPriceId() {
        return priceId;
    }
    public void setPriceId(int priceId) {
        this.priceId = priceId;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carId=" + carId +
                ", brand='" + brand + '\'' +
                ", productionYear=" + productionYear +
                ", hasInsurance=" + hasInsurance +
                ", officeId=" + officeId +
                ", priceId=" + priceId +
                '}';
    }


}
