package ourFirstProject.view;


import ourFirstProject.repository.CarRepository;
import ourFirstProject.repository.UserRepository;
import ourFirstProject.service.CarService;

public class CarsApp {
    public static void main(String[] args) {
        UserRepository userRepository = new UserRepository();
        CarRepository carRepository = new CarRepository();

        CarService service = new CarService(carRepository, userRepository);
        Menu menu = new Menu(service);

        menu.run();
    }
}