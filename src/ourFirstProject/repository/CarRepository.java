package ourFirstProject.repository;

import ourFirstProject.model.Car;
import ourFirstProject.util.MagicList;
import ourFirstProject.util.MyList;

import java.util.concurrent.atomic.AtomicInteger;

/* Crud операции - будут всегда!!
1. Create (Создание):Создание нового ресурса или записи в базе данных.
(добавление нового пользователя в систему)
2. Read (Чтение):Чтение или извлечение данных из базы данных.
(получение списка всех пользователей или извлечение информации о конкретном пользователе)
3. Update (Обновление):Обновление существующего ресурса или записи в базе данных.
(изменение информации о пользователе, например, его имени или адреса.)
4. Delete (Удаление):Удаление ресурса или записи из базы данных.(удаление пользователя из системы.) */
public class CarRepository {

    private final MyList<Car> cars;
    //объект, отвечающий за генерацию уникальных id
    private final AtomicInteger currentId = new AtomicInteger(1);


    public CarRepository() {
        this.cars = new MagicList<>();
        initData();
    }

    private void initData() {
        cars.addAll(
                new Car(currentId.getAndIncrement(), "Audi", 2021, 200),
                new Car(currentId.getAndIncrement(), "BMW", 2022, 220),
                new Car(currentId.getAndIncrement(), "VW", 2015, 350)

        );
    }
    //Create - add
    public void addCar(String model, int year, int power) {
        //currentId.getAndIncrement() - получение текущего id и увеличение его на +1
        Car car = new Car(currentId.getAndIncrement(), model, year, power);
        cars.add(car);
    }



    // READ
    public MyList<Car> getAllCars() {
        return cars;
    }

    public Car getCarById(int id) {
        for (Car car : cars) {
            if (car.getId() == id) {
                return car;
            }
        }
        return null;
    }

    public MyList<Car> getAllFreeCars() {
        MyList<Car> freeCars = new MagicList<>();
        //Логика перебора, проверки и добавление "подходящих" мышин в список
        return freeCars;
    }

    public MyList<Car> getCarsByModel(String model) {
        MyList<Car> carsList = new MagicList<>();
        // Логика добавления "подходящих" машин
        for (Car car : cars) {
            if (car.getModel().equalsIgnoreCase(model)) {
                carsList.add(car);
            }
        }

        return carsList;
    }

    //UPDATE
    public boolean updateCarModel(int carId, String newModel) {
        Car car = getCarById(carId);
        if (car != null && newModel != null) {
            car.setModel(newModel);
            return true;
        }

        return false;
    }

    public boolean takeCar(int carId) {
        Car car = getCarById(carId);
        if (car == null || car.isBusy()) return false;

        car.setBusy(true);
        return true;
    }

    //DELETE
    public Car removeCar(int carId) {
        Car car = getCarById(carId);
        if (car == null) return null;
        cars.remove(car);
        return car;
    }
}