import java.util.Comparator;

public class AnimalDescComparator implements Comparator<Animal> {

    @Override
    public int compare(Animal animal1, Animal animal2) {
        return animal1.getDesc().compareTo(animal2.getDesc());
    }
}