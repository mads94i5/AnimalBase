import java.util.Comparator;

public class AnimalAgeComparator implements Comparator<Animal> {

    @Override
    public int compare(Animal animal1, Animal animal2) {
        return animal1.getAge() - animal2.getAge();
    }
}