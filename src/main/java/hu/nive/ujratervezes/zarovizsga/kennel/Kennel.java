package hu.nive.ujratervezes.zarovizsga.kennel;

import java.util.ArrayList;
import java.util.List;

public class Kennel {
    List<Dog> dogs = new ArrayList<>();

    void addDog(Dog dog) {
        dogs.add(dog);
    }

    List<Dog> getDogs() {
        return dogs;
    }

    void feedAll() {
        for (Dog d: dogs) {
            d.feed();
        }
    }

}
