public class CarTest {
    public static void main(String[] args) {
        Car car1 = new Car(4, 1, "lambo");
        System.out.println(car1);
        car1.IncreaseMileage(5);
        System.out.println(car1);
    }
}
