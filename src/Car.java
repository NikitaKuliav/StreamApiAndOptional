public class Car {
    private final String model;
    private final int year;

    public Car(String model, int year) {
        this.model = model;
        this.year = year;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return
                "модель = " + model +
                ", год выпуска= " + year;
    }
}
