import java.util.Comparator;

public class AnimalNameComparator implements Comparator<Animal> {

    @Override
    public int compare(Animal animal1, Animal animal2) {
        return animal1.getName().compareTo(animal2.getName());
    }
}