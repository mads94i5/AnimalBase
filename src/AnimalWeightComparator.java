import java.util.Comparator;

public class AnimalWeightComparator implements Comparator<Animal> {

    @Override
    public int compare(Animal animal1, Animal animal2) {
        return (int)(animal1.getWeight() - animal2.getWeight());
    }
}