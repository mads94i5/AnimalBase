import java.util.Comparator;

public class AnimalTypeComparator implements Comparator<Animal> {

    @Override
    public int compare(Animal animal1, Animal animal2) {
        return animal1.getType().compareTo(animal2.getType());
    }
}