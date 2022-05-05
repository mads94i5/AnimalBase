import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.*;

public class AnimalBase {

    private ArrayList<Animal> animals;

    public AnimalBase() {
        animals = new ArrayList<>();
    }

    public void start() {
        UserInterface ui = new UserInterface(this);
        ui.start();
    }

    public static void main(String[] args) {
        AnimalBase app = new AnimalBase();
        app.start();
    }

    public Iterable<Animal> getAllAnimals() {
        return animals;
    }

    public int getAnimalCount() {
        return animals.size();
    }

    public void sortBy(String sortBy, SortDirection sortDirection) {
        System.out.println("Sort the list of animals by: " + sortBy);
        switch (sortBy) {
            case "name" -> {
                switch (sortDirection) {
                    case ASC -> Collections.sort(animals, new AnimalNameComparator());
                    case DESC -> Collections.sort(animals, new AnimalNameComparator().reversed());
                    default -> throw new IllegalStateException("Unexpected value: " + sortDirection);
                }
            }
            case "description" -> {
                switch (sortDirection) {
                    case ASC -> Collections.sort(animals, new AnimalDescComparator());
                    case DESC -> Collections.sort(animals, new AnimalDescComparator().reversed());
                    default -> throw new IllegalStateException("Unexpected value: " + sortDirection);
                }
            }
            case "type" -> {
                switch (sortDirection) {
                    case ASC -> Collections.sort(animals, new AnimalTypeComparator());
                    case DESC -> Collections.sort(animals, new AnimalTypeComparator().reversed());
                    default -> throw new IllegalStateException("Unexpected value: " + sortDirection);
                }
            }
            case "age" -> {
                switch (sortDirection) {
                    case ASC -> Collections.sort(animals, new AnimalAgeComparator());
                    case DESC -> Collections.sort(animals, new AnimalAgeComparator().reversed());
                    default -> throw new IllegalStateException("Unexpected value: " + sortDirection);
                }
            }
            case "weight" -> {
                switch (sortDirection) {
                    case ASC -> Collections.sort(animals, new AnimalWeightComparator());
                    case DESC -> Collections.sort(animals, new AnimalWeightComparator().reversed());
                    default -> throw new IllegalStateException("Unexpected value: " + sortDirection);
                }
            }
            default -> throw new IllegalStateException("Unexpected value: " + sortBy);
        }
    }

    public void createNewAnimal(String name, String description, String type, int age, double weight) {
        Animal animal = new Animal(name,description,type,age,weight);
        animals.add(animal);
    }

    public boolean deleteAnimal(String name) {
        // find animal with this name
        Animal animal = findAnimalByName(name);
        if(animal == null) {
            return false;
        } else {
            animals.remove(animal);
            return true;
        }
    }

    private Animal findAnimalByName(String name) {
        for(Animal animal : animals) {
            if(animal.getName().equalsIgnoreCase(name)) {
                return animal;
            }
        }
        return null;
    }


    public void loadDatabase() throws FileNotFoundException {
        Scanner fileScanner = new Scanner(new File("animals.csv"));

        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();

            Scanner lineScanner = new Scanner(line).useDelimiter(";");

            String name = lineScanner.next();
            String desc = lineScanner.next();
            String type = lineScanner.next();
            int age = lineScanner.nextInt();
            double weight = lineScanner.nextDouble();

            Animal animal = new Animal(name, desc, type, age, weight);
            animals.add(animal);
        }
    }

    public void saveDatabase() throws FileNotFoundException {
        PrintStream outputFile = new PrintStream("animals.csv");

        for (Animal animal : animals) {
            writeAnimal(outputFile, animal);
        }
        outputFile.close();
    }
    private void writeAnimal(PrintStream outputFile, Animal animal) {
        outputFile.print(animal.getName());
        outputFile.print(";");
        outputFile.print(animal.getDesc());
        outputFile.print(";");
        outputFile.print(animal.getType());
        outputFile.print(";");
        outputFile.print(animal.getAge());
        outputFile.print(";");
        outputFile.print(animal.getWeight());
        outputFile.print("\n");
    }
}
