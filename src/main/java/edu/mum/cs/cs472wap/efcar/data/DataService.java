package edu.mum.cs.cs472wap.efcar.data;

import edu.mum.cs.cs472wap.efcar.model.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static edu.mum.cs.cs472wap.efcar.model.CarType.COMPACT;
import static edu.mum.cs.cs472wap.efcar.model.CarType.STANDARD;
import static edu.mum.cs.cs472wap.efcar.model.CarType.CONVERTIBLE;
import static edu.mum.cs.cs472wap.efcar.model.CarType.PREMIUM;

public class DataService {

    private static Map<Long, User> users;
    private static Map<Long, Car> cars;
    private static List<String> brands;
    private static List<String> models;

    private DataService() {

    }

    static {
        createUsers();
        createCars();
        createBrands();
        createModels();
    }

    /*Users*/
    public static Map<Long, User> getUsers() {
        return users;
    }

    public static List<User> getUserList() {
        return new ArrayList<>(users.values());
    }

    public static User getUserById(Long id) {
        return users.get(id);
    }

    /*Cars*/
    public static Map<Long, Car> getCars() {
        return cars;
    }

    public static List<Car> getCarList() {
        return new ArrayList<>(cars.values());
    }

    public static Car getCarById(long id) {
        return cars.get(id);
    }

    public static List<Car> getCarListByBrand(String brand) {
        return cars.values().stream().filter(x -> x.getModel().getBrand().getName().equalsIgnoreCase(brand)).collect(Collectors.toList());
    }

    public static List<Car> getCarListByModel(String model) {
        return cars.values().stream().filter(x -> x.getModel().getName().equalsIgnoreCase(model)).collect(Collectors.toList());
    }

    private static List<Car> getCarListByPredicate(Predicate<Car> predicateModel,Predicate<Car> predicateType,
        Predicate<Car> predicateBrand) {

        return cars.values().stream()
                .filter(predicateModel)
                .filter(predicateType)
                .filter(predicateBrand)
              //  .filter(predicateDate)
                .collect(Collectors.toList());
    }

    public static List<Car> getCarListSearch(String type, String brand,  String model, LocalDate date ) {
        Predicate<Car> pModel = (x) -> x.getModel().getName().toLowerCase().contains(model.toLowerCase());
        Predicate<Car> pType  = (x) -> type.equals("all") || x.getModel().getType().equals(CarType.valueOf(type));
        Predicate<Car> pBrand = (x) -> brand.equals("all") || x.getModel().getBrand().getName().equals(brand);
        Predicate<Car> pDate  = (x) -> x.getBookings().stream().filter(y -> date.isAfter(y.getPickUpDate())
                                    && date.isBefore(y.getDropOffDate())).count() > 0;

        return getCarListByPredicate(pModel, pType,pBrand);
    }



    /*Other Lists*/
    public static List<String> getBrands() {
        return brands;
    }

    public static List<String> getModels() {
        return models;
    }

    /*Factory methods*/
    private static void createModels() {
        models = cars.values().stream().map(x -> x.getModel().getName()).distinct().collect(Collectors.toList());
    }

    private static void createBrands() {
        brands = cars.values().stream().map(x -> x.getModel().getBrand().getName()).distinct().collect(Collectors.toList());
    }

    private static void createUsers() {
        users = new HashMap<>();

        Person person = new Person(1L,
                "esat",
                "akyürek",
                LocalDate.of(1988, 12, 6),
                "male",
                new PersonContact(1L, "esat.akyürek@example.com", "(667)-881-9739"),
                new PersonAddress(1L, "4782 anafartalar cd", "", "eskişehir", "ankara", "77537"),
                "https://randomuser.me/api/portraits/men/18.jpg");
        User user = new User("user1", "pass1", person);
        users.put(user.getId(), user);

        person = new Person(2L,
                "terry",
                "little",
                LocalDate.of(1989, 11, 7),
                "female",
                new PersonContact(2L, "terry.little@example.com", "00-8322-2240"),
                new PersonAddress(2L, "5140 robinson rd", "", "rockhampton", "northern territory", "528"),
                "https://randomuser.me/api/portraits/women/81.jpg");
        user = new User("user2", "pass2", person);
        users.put(user.getId(), user);

        person = new Person(3L,
                "stephanie",
                "howard",
                LocalDate.of(1990, 9, 8),
                "female",
                new PersonContact(3L, "stephanie.howard@example.com", "011-101-6539"),
                new PersonAddress(3L, "5592 jones road", "", "cork", "kildare", "11645"),
                "https://randomuser.me/api/portraits/women/51.jpg");
        user = new User("user3", "pass3", person);
        users.put(user.getId(), user);
    }

    private static void createCars() {
        cars = new HashMap<>();

        CarBrand carBrand = new CarBrand(1L, "Saturn");
        CarModel carModel = new CarModel(1L, carBrand, STANDARD, "Saturn", 2004, "1000", 50.0, 5);
        Car car = new Car(1L, carModel, "WAUBH5", 50.0, true, "Red");
        cars.put(car.getId(), car);

        carBrand = new CarBrand(2L, "Bentley");
        carModel = new CarModel(2L, carBrand, PREMIUM, "Flying Spur", 2008, "1001", 73.0, 5);
        car = new Car(2L, carModel, "1G6AJ5", 300.0, true, "Black");
        cars.put(car.getId(), car);

        carBrand = new CarBrand(3L, "Infiniti");
        carModel = new CarModel(3L, carBrand, STANDARD, "Infiniti", 1995, "1002", 96.0, 5);
        car = new Car(3L, carModel, "SCFAD0", 550.0, true, "Green");
        cars.put(car.getId(), car);

        carBrand = new CarBrand(4L, "Buick");
        carModel = new CarModel(4L, carBrand, STANDARD, "Buick", 1994, "1003", 119.0, 5);
        car = new Car(4L, carModel, "19XFA1", 800.0, true, "Black");
        cars.put(car.getId(), car);

        carBrand = new CarBrand(5L, "Nissan");
        carModel = new CarModel(5L, carBrand, STANDARD, "Sentra", 1998, "1004", 142.0, 5);
        car = new Car(5L, carModel, "WBANV1", 1050.0, true, "Black");
        cars.put(car.getId(), car);

        carBrand = new CarBrand(6L, "Aston Martin");
        carModel = new CarModel(6L, carBrand, STANDARD, "Aston Martin", 2010, "1005", 165.0, 5);
        car = new Car(6L, carModel, "2C3CDX", 1300.0, true, "Green");
        cars.put(car.getId(), car);

        carBrand = new CarBrand(7L, "Subaru");
        carModel = new CarModel(7L, carBrand, STANDARD, "Subaru", 1997, "1006", 188.0, 5);
        car = new Car(7L, carModel, "1C3BCB", 1550.0, true, "Black");
        cars.put(car.getId(), car);

        carBrand = new CarBrand(8L, "Chevrolet");
        carModel = new CarModel(8L, carBrand, STANDARD, "Camaro", 1994, "1007", 211.0, 5);
        car = new Car(8L, carModel, "5J8TB2", 1800.0, true, "Black");
        cars.put(car.getId(), car);

        carBrand = new CarBrand(9L, "Mitsubishi");
        carModel = new CarModel(9L, carBrand, STANDARD, "Mitsubishi", 1988, "1008", 234.0, 5);
        car = new Car(9L, carModel, "SAJWA6", 2050.0, true, "Green");
        cars.put(car.getId(), car);

        carBrand = new CarBrand(10L, "Pontiac");
        carModel = new CarModel(10L, carBrand, STANDARD, "Pontiac", 1988, "1009", 257.0, 5);
        car = new Car(10L, carModel, "WBSDX9", 2300.0, true, "Black");
        cars.put(car.getId(), car);

        carBrand = new CarBrand(11L, "Ford");
        carModel = new CarModel(11L, carBrand, STANDARD, "Fiesta", 2007, "1010", 280.0, 5);
        car = new Car(11L, carModel, "1G4GB5", 2550.0, true, "Black");
        cars.put(car.getId(), car);

        carBrand = new CarBrand(12L, "Suzuki");
        carModel = new CarModel(12L, carBrand, STANDARD, "Suzuki", 1998, "1011", 303.0, 5);
        car = new Car(12L, carModel, "1GD11Z", 2800.0, true, "Black");
        cars.put(car.getId(), car);

        carBrand = new CarBrand(13L, "Ford");
        carModel = new CarModel(13L, carBrand, STANDARD, "Fiesta", 2001, "1012", 326.0, 5);
        car = new Car(13L, carModel, "WA1DGA", 3050.0, true, "Black");
        cars.put(car.getId(), car);

        carBrand = new CarBrand(14L, "Chrysler");
        carModel = new CarModel(14L, carBrand, STANDARD, "Chrysler", 1998, "1013", 349.0, 5);
        car = new Car(14L, carModel, "WA1LKA", 3300.0, true, "Yellow");
        cars.put(car.getId(), car);

        carBrand = new CarBrand(15L, "Mitsubishi");
        carModel = new CarModel(15L, carBrand, STANDARD, "Mitsubishi", 2010, "1014", 372.0, 5);
        car = new Car(15L, carModel, "WBAAW3", 3550.0, true, "Blue");
        cars.put(car.getId(), car);

        carBrand = new CarBrand(16L, "Pontiac");
        carModel = new CarModel(16L, carBrand, STANDARD, "Pontiac", 1992, "1015", 395.0, 5);
        car = new Car(16L, carModel, "WBAVB1", 3800.0, true, "Yellow");
        cars.put(car.getId(), car);

        carBrand = new CarBrand(17L, "Honda");
        carModel = new CarModel(17L, carBrand, STANDARD, "Honda", 1995, "1016", 418.0, 5);
        car = new Car(17L, carModel, "3D73M3", 4050.0, true, "Green");
        cars.put(car.getId(), car);

        carBrand = new CarBrand(18L, "Ford");
        carModel = new CarModel(18L, carBrand, STANDARD, "Fiesta", 1998, "1017", 441.0, 5);
        car = new Car(18L, carModel, "WAUBF9", 4300.0, true, "Red");
        cars.put(car.getId(), car);

        carBrand = new CarBrand(19L, "GMC");
        carModel = new CarModel(19L, carBrand, STANDARD, "GMC", 2004, "1018", 464.0, 5);
        car = new Car(19L, carModel, "JN1AY1", 4550.0, true, "Black");
        cars.put(car.getId(), car);

        carBrand = new CarBrand(20L, "Oldsmobile");
        carModel = new CarModel(20L, carBrand, STANDARD, "Oldsmobile", 2000, "1019", 487.0, 5);
        car = new Car(20L, carModel, "1N4AL3", 4800.0, true, "Red");
        cars.put(car.getId(), car);

        carBrand = new CarBrand(21L, "Audi");
        carModel = new CarModel(21L, carBrand, STANDARD, "Model T", 1986, "1020", 510.0, 5);
        car = new Car(21L, carModel, "WBA3F9", 5050.0, true, "Red");
        cars.put(car.getId(), car);

        carBrand = new CarBrand(22L, "Pontiac");
        carModel = new CarModel(22L, carBrand, STANDARD, "Pontiac", 1998, "1021", 533.0, 5);
        car = new Car(22L, carModel, "5GAER2", 5300.0, true, "Yellow");
        cars.put(car.getId(), car);

        carBrand = new CarBrand(23L, "Acura");
        carModel = new CarModel(23L, carBrand, STANDARD, "Acura", 1997, "1022", 556.0, 5);
        car = new Car(23L, carModel, "3VWPG3", 5550.0, true, "Black");
        cars.put(car.getId(), car);

        carBrand = new CarBrand(24L, "Buick");
        carModel = new CarModel(24L, carBrand, STANDARD, "Buick", 1992, "1023", 579.0, 5);
        car = new Car(24L, carModel, "1G4GE5", 5800.0, true, "Green");
        cars.put(car.getId(), car);

        carBrand = new CarBrand(25L, "Mazda");
        carModel = new CarModel(25L, carBrand, STANDARD, "Mazda", 2000, "1024", 602.0, 5);
        car = new Car(25L, carModel, "3D7TP2", 6050.0, true, "Blue");
        cars.put(car.getId(), car);

        carBrand = new CarBrand(26L, "Kia");
        carModel = new CarModel(26L, carBrand, STANDARD, "Kia", 1996, "1025", 625.0, 5);
        car = new Car(26L, carModel, "2T1BU4", 6300.0, true, "Red");
        cars.put(car.getId(), car);

        carBrand = new CarBrand(27L, "Lincoln");
        carModel = new CarModel(27L, carBrand, STANDARD, "Lincoln", 2010, "1026", 648.0, 5);
        car = new Car(27L, carModel, "1FMJU1", 6550.0, true, "Blue");
        cars.put(car.getId(), car);

        carBrand = new CarBrand(28L, "Chevrolet");
        carModel = new CarModel(28L, carBrand, STANDARD, "Camaro", 1974, "1027", 671.0, 5);
        car = new Car(28L, carModel, "SCFBF0", 6800.0, true, "Blue");
        cars.put(car.getId(), car);

        carBrand = new CarBrand(29L, "GMC");
        carModel = new CarModel(29L, carBrand, STANDARD, "GMC", 1998, "1028", 694.0, 5);
        car = new Car(29L, carModel, "WDDEJ7", 7050.0, true, "Black");
        cars.put(car.getId(), car);

        carBrand = new CarBrand(30L, "Chevrolet");
        carModel = new CarModel(30L, carBrand, STANDARD, "Camaro", 2001, "1029", 717.0, 5);
        car = new Car(30L, carModel, "WP1AA2", 7300.0, true, "Yellow");
        cars.put(car.getId(), car);

        carBrand = new CarBrand(31L, "Honda");
        carModel = new CarModel(31L, carBrand, STANDARD, "Honda", 2012, "1030", 740.0, 5);
        car = new Car(31L, carModel, "WBANU5", 7550.0, true, "Yellow");
        cars.put(car.getId(), car);

        carBrand = new CarBrand(32L, "Pontiac");
        carModel = new CarModel(32L, carBrand, STANDARD, "Pontiac", 1983, "1031", 763.0, 5);
        car = new Car(32L, carModel, "1FTEX1", 7800.0, true, "Yellow");
        cars.put(car.getId(), car);

        carBrand = new CarBrand(33L, "Chrysler");
        carModel = new CarModel(33L, carBrand, STANDARD, "Chrysler", 1993, "1032", 786.0, 5);
        car = new Car(33L, carModel, "JN1CV6", 8050.0, true, "Blue");
        cars.put(car.getId(), car);

        carBrand = new CarBrand(34L, "Land Rover");
        carModel = new CarModel(34L, carBrand, STANDARD, "Land Rover", 2009, "1033", 809.0, 5);
        car = new Car(34L, carModel, "WBA5B3", 8300.0, true, "Blue");
        cars.put(car.getId(), car);

        carBrand = new CarBrand(35L, "MINI");
        carModel = new CarModel(35L, carBrand, STANDARD, "MINI", 2012, "1034", 832.0, 5);
        car = new Car(35L, carModel, "1FTSF3", 8550.0, true, "Black");
        cars.put(car.getId(), car);

        carBrand = new CarBrand(36L, "Chrysler");
        carModel = new CarModel(36L, carBrand, STANDARD, "Chrysler", 1999, "1035", 855.0, 5);
        car = new Car(36L, carModel, "5J8TB4", 8800.0, true, "Red");
        cars.put(car.getId(), car);

        carBrand = new CarBrand(37L, "Citroën");
        carModel = new CarModel(37L, carBrand, STANDARD, "Citroën", 1948, "1036", 878.0, 5);
        car = new Car(37L, carModel, "WAUJC6", 9050.0, true, "Red");
        cars.put(car.getId(), car);

        carBrand = new CarBrand(38L, "Chevrolet");
        carModel = new CarModel(38L, carBrand, STANDARD, "Camaro", 1967, "1037", 901.0, 5);
        car = new Car(38L, carModel, "WDDPK4", 9300.0, true, "Blue");
        cars.put(car.getId(), car);

        carBrand = new CarBrand(39L, "Volkswagen");
        carModel = new CarModel(39L, carBrand, STANDARD, "Volkswagen", 1993, "1038", 924.0, 5);
        car = new Car(39L, carModel, "4T1BD1", 9550.0, true, "Yellow");
        cars.put(car.getId(), car);

        carBrand = new CarBrand(40L, "Honda");
        carModel = new CarModel(40L, carBrand, STANDARD, "Honda", 2003, "1039", 947.0, 5);
        car = new Car(40L, carModel, "19XFB2", 9800.0, true, "Yellow");
        cars.put(car.getId(), car);

        carBrand = new CarBrand(41L, "Cadillac");
        carModel = new CarModel(41L, carBrand, PREMIUM, "Cadillac", 2000, "1040", 970.0, 5);
        car = new Car(41L, carModel, "WAUFGB", 10050.0, true, "Red");
        cars.put(car.getId(), car);

        carBrand = new CarBrand(42L, "Hyundai");
        carModel = new CarModel(42L, carBrand, STANDARD, "Santafe", 2012, "1041", 993.0, 5);
        car = new Car(42L, carModel, "JTHBK1", 10300.0, true, "Green");
        cars.put(car.getId(), car);

        carBrand = new CarBrand(43L, "Isuzu");
        carModel = new CarModel(43L, carBrand, STANDARD, "Isuzu", 1994, "1042", 1016.0, 5);
        car = new Car(43L, carModel, "WP0AA2", 10550.0, true, "Green");
        cars.put(car.getId(), car);

        carBrand = new CarBrand(44L, "Lexus");
        carModel = new CarModel(44L, carBrand, STANDARD, "Lexus", 2009, "1043", 1039.0, 5);
        car = new Car(44L, carModel, "WUARU7", 10800.0, true, "Red");
        cars.put(car.getId(), car);

        carBrand = new CarBrand(45L, "Toyota");
        carModel = new CarModel(45L, carBrand, STANDARD, "Toyota", 1993, "1044", 1062.0, 5);
        car = new Car(45L, carModel, "2HNYD2", 11050.0, true, "Yellow");
        cars.put(car.getId(), car);

        carBrand = new CarBrand(46L, "Saab");
        carModel = new CarModel(46L, carBrand, STANDARD, "Saab", 2005, "1045", 1085.0, 5);
        car = new Car(46L, carModel, "JN1CV6", 11300.0, true, "Black");
        cars.put(car.getId(), car);

        carBrand = new CarBrand(47L, "Chevrolet");
        carModel = new CarModel(47L, carBrand, STANDARD, "Camaro", 1999, "1046", 1108.0, 5);
        car = new Car(47L, carModel, "WA1LKA", 11550.0, true, "Blue");
        cars.put(car.getId(), car);

        carBrand = new CarBrand(48L, "Isuzu");
        carModel = new CarModel(48L, carBrand, STANDARD, "Isuzu", 1997, "1047", 1131.0, 5);
        car = new Car(48L, carModel, "1C4SDJ", 11800.0, true, "Black");
        cars.put(car.getId(), car);

        carBrand = new CarBrand(49L, "Audi");
        carModel = new CarModel(49L, carBrand, STANDARD, "Model T", 2003, "1048", 1154.0, 5);
        car = new Car(49L, carModel, "5N1AR2", 12050.0, true, "Red");
        cars.put(car.getId(), car);

        carBrand = new CarBrand(50L, "Dodge");
        carModel = new CarModel(50L, carBrand, STANDARD, "Dodge", 1994, "1049", 1177.0, 5);
        car = new Car(50L, carModel, "KMHFG4", 12300.0, true, "Black");
        cars.put(car.getId(), car);

        carBrand = new CarBrand(51L, "Dodge");
        carModel = new CarModel(51L, carBrand, STANDARD, "Dodge", 2011, "1050", 1200.0, 5);
        car = new Car(51L, carModel, "WBANE5", 12550.0, true, "Black");
        cars.put(car.getId(), car);

        carBrand = new CarBrand(52L, "Dodge");
        carModel = new CarModel(52L, carBrand, STANDARD, "Dodge", 1969, "1051", 1223.0, 5);
        car = new Car(52L, carModel, "WBAUP9", 12800.0, true, "Yellow");
        cars.put(car.getId(), car);

        carBrand = new CarBrand(53L, "Chevrolet");
        carModel = new CarModel(53L, carBrand, STANDARD, "Camaro", 2000, "1052", 1246.0, 5);
        car = new Car(53L, carModel, "4USBT5", 13050.0, true, "Blue");
        cars.put(car.getId(), car);

        carBrand = new CarBrand(54L, "Pontiac");
        carModel = new CarModel(54L, carBrand, STANDARD, "Pontiac", 1998, "1053", 1269.0, 5);
        car = new Car(54L, carModel, "WAUSF7", 13300.0, true, "Black");
        cars.put(car.getId(), car);

        carBrand = new CarBrand(55L, "Nissan");
        carModel = new CarModel(55L, carBrand, STANDARD, "Sentra", 2012, "1054", 1292.0, 5);
        car = new Car(55L, carModel, "1C6RD6", 13550.0, true, "Black");
        cars.put(car.getId(), car);

        carBrand = new CarBrand(56L, "Ford");
        carModel = new CarModel(56L, carBrand, STANDARD, "Fiesta", 1988, "1055", 1315.0, 5);
        car = new Car(56L, carModel, "1FTSW2", 13800.0, true, "Green");
        cars.put(car.getId(), car);

        carBrand = new CarBrand(57L, "Audi");
        carModel = new CarModel(57L, carBrand, STANDARD, "Model T", 1998, "1056", 1338.0, 5);
        car = new Car(57L, carModel, "SCBBR9", 14050.0, true, "Blue");
        cars.put(car.getId(), car);

        carBrand = new CarBrand(58L, "Mitsubishi");
        carModel = new CarModel(58L, carBrand, PREMIUM, "Mitsubishi", 1986, "1057", 1361.0, 5);
        car = new Car(58L, carModel, "1G6DW6", 14300.0, true, "Yellow");
        cars.put(car.getId(), car);

        carBrand = new CarBrand(59L, "Ford");
        carModel = new CarModel(59L, carBrand, COMPACT, "Fiesta", 1996, "1058", 1384.0, 5);
        car = new Car(59L, carModel, "WAUMFA", 14550.0, true, "Yellow");
        cars.put(car.getId(), car);

        carBrand = new CarBrand(60L, "Ford");
        carModel = new CarModel(60L, carBrand, STANDARD, "Fiesta", 2004, "1059", 1407.0, 5);
        car = new Car(60L, carModel, "3D4PG9", 14800.0, true, "Green");
        cars.put(car.getId(), car);

        carBrand = new CarBrand(61L, "Chevrolet");
        carModel = new CarModel(61L, carBrand, STANDARD, "Camaro", 1967, "1060", 1430.0, 5);
        car = new Car(61L, carModel, "WVWDB7", 15050.0, true, "Red");
        cars.put(car.getId(), car);

        carBrand = new CarBrand(62L, "Ford");
        carModel = new CarModel(62L, carBrand, STANDARD, "Fiesta", 2007, "1061", 1453.0, 5);
        car = new Car(62L, carModel, "4T1BK1", 15300.0, true, "Blue");
        cars.put(car.getId(), car);

        carBrand = new CarBrand(63L, "Audi");
        carModel = new CarModel(63L, carBrand, STANDARD, "Model T", 2011, "1062", 1476.0, 5);
        car = new Car(63L, carModel, "WUARL4", 15550.0, true, "Black");
        cars.put(car.getId(), car);

        carBrand = new CarBrand(64L, "Volvo");
        carModel = new CarModel(64L, carBrand, STANDARD, "Volvo", 1996, "1063", 1499.0, 5);
        car = new Car(64L, carModel, "WDDHF5", 15800.0, true, "Red");
        cars.put(car.getId(), car);

        carBrand = new CarBrand(65L, "MINI");
        carModel = new CarModel(65L, carBrand, STANDARD, "MINI", 2009, "1064", 1522.0, 5);
        car = new Car(65L, carModel, "JTDKN3", 16050.0, true, "Blue");
        cars.put(car.getId(), car);

        carBrand = new CarBrand(66L, "Acura");
        carModel = new CarModel(66L, carBrand, STANDARD, "Acura", 2001, "1065", 1545.0, 5);
        car = new Car(66L, carModel, "WBA3T7", 16300.0, true, "Yellow");
        cars.put(car.getId(), car);

        carBrand = new CarBrand(67L, "Mercury");
        carModel = new CarModel(67L, carBrand, STANDARD, "Mercury", 2002, "1066", 1568.0, 5);
        car = new Car(67L, carModel, "WAUHFA", 16550.0, true, "Blue");
        cars.put(car.getId(), car);

        carBrand = new CarBrand(68L, "Chevrolet");
        carModel = new CarModel(68L, carBrand, CONVERTIBLE, "Camaro", 2006, "1067", 1591.0, 5);
        car = new Car(68L, carModel, "SCBFC7", 16800.0, true, "Black");
        cars.put(car.getId(), car);

        carBrand = new CarBrand(69L, "Buick");
        carModel = new CarModel(69L, carBrand, STANDARD, "Buick", 2010, "1068", 1614.0, 5);
        car = new Car(69L, carModel, "4A31K3", 17050.0, true, "Black");
        cars.put(car.getId(), car);

        carBrand = new CarBrand(70L, "Dodge");
        carModel = new CarModel(70L, carBrand, STANDARD, "Dodge", 2001, "1069", 1637.0, 5);
        car = new Car(70L, carModel, "1FMCU4", 17300.0, true, "Blue");
        cars.put(car.getId(), car);

        carBrand = new CarBrand(71L, "Toyota");
        carModel = new CarModel(71L, carBrand, STANDARD, "Toyota", 2010, "1070", 1660.0, 5);
        car = new Car(71L, carModel, "1G6KD5", 17550.0, true, "Yellow");
        cars.put(car.getId(), car);

        carBrand = new CarBrand(72L, "Chevrolet");
        carModel = new CarModel(72L, carBrand, STANDARD, "Camaro", 1977, "1071", 1683.0, 5);
        car = new Car(72L, carModel, "JM1NC2", 17800.0, true, "Blue");
        cars.put(car.getId(), car);

        carBrand = new CarBrand(73L, "Chevrolet");
        carModel = new CarModel(73L, carBrand, STANDARD, "Camaro", 2000, "1072", 1706.0, 5);
        car = new Car(73L, carModel, "WAUML5", 18050.0, true, "Red");
        cars.put(car.getId(), car);

        carBrand = new CarBrand(74L, "Ford");
        carModel = new CarModel(74L, carBrand, STANDARD, "Fiesta", 1988, "1073", 1729.0, 5);
        car = new Car(74L, carModel, "4T1BF3", 18300.0, true, "Green");
        cars.put(car.getId(), car);

        carBrand = new CarBrand(75L, "Bentley");
        carModel = new CarModel(75L, carBrand, STANDARD, "Flying Spur", 2008, "1074", 1752.0, 5);
        car = new Car(75L, carModel, "1GKS1K", 18550.0, true, "Yellow");
        cars.put(car.getId(), car);

        carBrand = new CarBrand(76L, "Chevrolet");
        carModel = new CarModel(76L, carBrand, STANDARD, "Camaro", 2007, "1075", 1775.0, 5);
        car = new Car(76L, carModel, "1FBNE3", 18800.0, true, "Blue");
        cars.put(car.getId(), car);

        carBrand = new CarBrand(77L, "Mitsubishi");
        carModel = new CarModel(77L, carBrand, STANDARD, "Mitsubishi", 1996, "1076", 1798.0, 5);
        car = new Car(77L, carModel, "3C6LD4", 19050.0, true, "Blue");
        cars.put(car.getId(), car);

        carBrand = new CarBrand(78L, "Infiniti");
        carModel = new CarModel(78L, carBrand, STANDARD, "Infiniti", 2009, "1077", 1821.0, 5);
        car = new Car(78L, carModel, "SCFEBB", 19300.0, true, "Black");
        cars.put(car.getId(), car);

        carBrand = new CarBrand(79L, "Honda");
        carModel = new CarModel(79L, carBrand, STANDARD, "Honda", 2006, "1078", 1844.0, 5);
        car = new Car(79L, carModel, "5J8TB3", 19550.0, true, "Red");
        cars.put(car.getId(), car);

        carBrand = new CarBrand(80L, "Pontiac");
        carModel = new CarModel(80L, carBrand, STANDARD, "Pontiac", 1986, "1079", 1867.0, 5);
        car = new Car(80L, carModel, "1N6AF0", 19800.0, true, "Black");
        cars.put(car.getId(), car);

        carBrand = new CarBrand(81L, "Mercury");
        carModel = new CarModel(81L, carBrand, STANDARD, "Mercury", 1987, "1080", 1890.0, 5);
        car = new Car(81L, carModel, "5UXWX9", 20050.0, true, "Red");
        cars.put(car.getId(), car);

        carBrand = new CarBrand(82L, "Chevrolet");
        carModel = new CarModel(82L, carBrand, STANDARD, "Camaro", 2005, "1081", 1913.0, 5);
        car = new Car(82L, carModel, "1G6KD5", 20300.0, true, "Blue");
        cars.put(car.getId(), car);

        carBrand = new CarBrand(83L, "Hyundai");
        carModel = new CarModel(83L, carBrand, STANDARD, "Santafe", 1994, "1082", 1936.0, 5);
        car = new Car(83L, carModel, "1GYS3G", 20550.0, true, "Green");
        cars.put(car.getId(), car);

        carBrand = new CarBrand(84L, "Pontiac");
        carModel = new CarModel(84L, carBrand, STANDARD, "Pontiac", 1973, "1083", 1959.0, 5);
        car = new Car(84L, carModel, "2LNBL8", 20800.0, true, "Red");
        cars.put(car.getId(), car);

        carBrand = new CarBrand(85L, "Isuzu");
        carModel = new CarModel(85L, carBrand, STANDARD, "Isuzu", 2000, "1084", 1982.0, 5);
        car = new Car(85L, carModel, "WBAEH7", 21050.0, true, "Green");
        cars.put(car.getId(), car);

        carBrand = new CarBrand(86L, "Mercury");
        carModel = new CarModel(86L, carBrand, STANDARD, "Mercury", 2004, "1085", 2005.0, 5);
        car = new Car(86L, carModel, "3C4PDD", 21300.0, true, "Blue");
        cars.put(car.getId(), car);

        carBrand = new CarBrand(87L, "Toyota");
        carModel = new CarModel(87L, carBrand, STANDARD, "Toyota", 2010, "1086", 2028.0, 5);
        car = new Car(87L, carModel, "5N1AR1", 21550.0, true, "Yellow");
        cars.put(car.getId(), car);

        carBrand = new CarBrand(88L, "Infiniti");
        carModel = new CarModel(88L, carBrand, CONVERTIBLE, "Infiniti", 1999, "1087", 2051.0, 5);
        car = new Car(88L, carModel, "WAUXL6", 21800.0, true, "Red");
        cars.put(car.getId(), car);

        carBrand = new CarBrand(89L, "GMC");
        carModel = new CarModel(89L, carBrand, STANDARD, "GMC", 2008, "1088", 2074.0, 5);
        car = new Car(89L, carModel, "KMHCT4", 22050.0, true, "Black");
        cars.put(car.getId(), car);

        carBrand = new CarBrand(90L, "Mercury");
        carModel = new CarModel(90L, carBrand, CONVERTIBLE, "Mercury", 1994, "1089", 2097.0, 5);
        car = new Car(90L, carModel, "WBA3B1", 22300.0, true, "Blue");
        cars.put(car.getId(), car);

        carBrand = new CarBrand(91L, "Hyundai");
        carModel = new CarModel(91L, carBrand, STANDARD, "Santafe", 2005, "1090", 2120.0, 5);
        car = new Car(91L, carModel, "JTJBC1", 22550.0, true, "Blue");
        cars.put(car.getId(), car);

        carBrand = new CarBrand(92L, "BMW");
        carModel = new CarModel(92L, carBrand, STANDARD, "BMW", 2002, "1091", 2143.0, 5);
        car = new Car(92L, carModel, "3VW117", 22800.0, true, "Blue");
        cars.put(car.getId(), car);

        carBrand = new CarBrand(93L, "Toyota");
        carModel = new CarModel(93L, carBrand, STANDARD, "Toyota", 2009, "1092", 2166.0, 5);
        car = new Car(93L, carModel, "JHMFA3", 23050.0, true, "Black");
        cars.put(car.getId(), car);

        carBrand = new CarBrand(94L, "Nissan");
        carModel = new CarModel(94L, carBrand, STANDARD, "Sentra", 2000, "1093", 2189.0, 5);
        car = new Car(94L, carModel, "SAJWA1", 23300.0, true, "Yellow");
        cars.put(car.getId(), car);

        carBrand = new CarBrand(95L, "GMC");
        carModel = new CarModel(95L, carBrand, STANDARD, "GMC", 1998, "1094", 2212.0, 5);
        car = new Car(95L, carModel, "3C4PDD", 23550.0, true, "Blue");
        cars.put(car.getId(), car);

        carBrand = new CarBrand(96L, "Kia");
        carModel = new CarModel(96L, carBrand, STANDARD, "Kia", 2007, "1095", 2235.0, 5);
        car = new Car(96L, carModel, "3GYFNB", 23800.0, true, "Blue");
        cars.put(car.getId(), car);

        carBrand = new CarBrand(97L, "Mercury");
        carModel = new CarModel(97L, carBrand, STANDARD, "Mercury", 1994, "1096", 2258.0, 5);
        car = new Car(97L, carModel, "JA4AD3", 24050.0, true, "Green");
        cars.put(car.getId(), car);

        carBrand = new CarBrand(98L, "Oldsmobile");
        carModel = new CarModel(98L, carBrand, STANDARD, "Oldsmobile", 1996, "1097", 2281.0, 5);
        car = new Car(98L, carModel, "1G6AR5", 24300.0, true, "Black");
        cars.put(car.getId(), car);

        carBrand = new CarBrand(99L, "Ford");
        carModel = new CarModel(99L, carBrand, STANDARD, "Fiesta", 2008, "1098", 2304.0, 5);
        car = new Car(99L, carModel, "SCFFDC", 24550.0, true, "Black");
        cars.put(car.getId(), car);

        carBrand = new CarBrand(100L, "Lotus");
        carModel = new CarModel(100L, carBrand, COMPACT, "Lotus", 1996, "1099", 2327.0, 5);
        car = new Car(100L, carModel, "WBADT3", 24800.0, true, "Green");
        cars.put(car.getId(), car);

    }
}
