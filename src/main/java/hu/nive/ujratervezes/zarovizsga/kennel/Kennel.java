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

    Dog findByName(String name) throws IllegalArgumentException {
        for (Dog d: dogs) {
            if (d.getName().equals(name)) {
                return d;
            }
        }
        throw new IllegalArgumentException("There is not a dog with this name '" + name + "'");
    }

    void playWith(String name, int hours) {
        try {
            Dog dog = findByName(name);
            dog.play(hours);
        } finally {
        }
    }

    List<String> getHappyDogNames(int minHappiness) {
        List<String> dogNames = new ArrayList<>();
        for (Dog d: dogs) {
            if (d.getHappiness() > minHappiness) {
                dogNames.add(d.getName());
            }
        }
        return  dogNames;
    }

}
