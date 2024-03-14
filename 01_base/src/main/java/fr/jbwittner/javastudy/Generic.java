package fr.jbwittner.javastudy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Generic {

    public static void main(String[] args) {
        System.out.println("--- Without Generic ---");
        withoutGeneric();

        System.out.println("\n--- With Generic ---");
        withGeneric();

        System.out.println("\n--- Generic Example ---");
        genericExample();

        System.out.println("\n--- Interface Constraint Example ---");
        interfaceConstraintExample();

        complexeGeneric();
    }

    public static void withoutGeneric() {
        List list = new ArrayList();
        String value;
        for (int i = 0; i < 10; i++) {
            value = Integer.toString(i);
            list.add(value);
        }

        for (Iterator iter = list.iterator(); iter.hasNext(); ) {
            value = (String) iter.next();
            System.out.println(value.toUpperCase());
        }
    }

    public static void withGeneric() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            String value = Integer.toString(i);
            list.add(value);
        }

        for (String value : list) {
            System.out.println(value.toUpperCase());
        }
    }

    public static void genericExample() {
        GenericBox<Integer> integerBox = new GenericBox<>();
        integerBox.add(10);
        System.out.println("Integer Value: " + integerBox.get());

        GenericBox<String> stringBox = new GenericBox<>();
        stringBox.add("Hello Generics");
        System.out.println("String Value: " + stringBox.get());

        GenericPair<String, Integer> pair = new GenericPair<>("Age", 25);
        System.out.println("GenericPair: " + pair.getKey() + " = " + pair.getValue());

        boolean isEqual = GenericMethod.compare(pair, new GenericPair<>("Age", 25));
        System.out.println("GenericPair isEqual: " + isEqual);
    }

    public static void interfaceConstraintExample() {
        DisplayBox<DisplayableString> box = new DisplayBox<>();
        box.add(new DisplayableString("Hello, Interface Constraint!"));
        box.displayItem(); // This will call the display method of the contained DisplayableString
        // object
    }

    public static void complexeGeneric() {
        // Création d'une instance complexe avec une clé String et une paire d'un Integer et d'une
        // String
        ComplexGeneric<String, Integer, String> example = new ComplexGeneric<>("Clef", 42, "Valeur");

        System.out.println(example);

        // Création d'une instance complexe avec une clé Integer et une paire de deux Strings
        ComplexGeneric<Integer, String, String> anotherExample = new ComplexGeneric<>(1, "Hello", "World");

        System.out.println(anotherExample);
    }
}

class GenericBox<T> {
    private T t;

    public void add(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }
}

class GenericPair<K, V> {
    private K key;
    private V value;

    public GenericPair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}

class GenericMethod {
    public static <K, V> boolean compare(GenericPair<K, V> p1, GenericPair<K, V> p2) {
        return p1.getKey().equals(p2.getKey()) && p1.getValue().equals(p2.getValue());
    }
}

interface Displayable {
    void display();
}

class DisplayBox<T extends Displayable> {
    private T item;

    public void add(T item) {
        this.item = item;
    }

    public void displayItem() {
        item.display();
    }
}

class DisplayableString implements Displayable {
    private String content;

    public DisplayableString(String content) {
        this.content = content;
    }

    @Override
    public void display() {
        System.out.println("Displaying: " + content);
    }
}

// Classe générique associant une clé à une paire de valeurs
class ComplexGeneric<K, V, T> {
    private K key;
    private GenericPair<V, T> pair;

    public ComplexGeneric(K key, V first, T second) {
        this.key = key;
        this.pair = new GenericPair<>(first, second);
    }

    public K getKey() {
        return key;
    }

    public GenericPair<V, T> getGenericPair() {
        return pair;
    }

    @Override
    public String toString() {
        return "Key: " + key + ", Value: " + pair;
    }
}

// Définition de notre propre interface de repository
interface MyRepository<T, ID> {
    T findById(ID id);

    T save(T entity);

    void delete(T entity);
}

// Implémentation simple d'un repository en mémoire
class SimpleInMemoryRepository<T, ID> implements MyRepository<T, ID> {
    private final Map<ID, T> storage = new HashMap<>();

    @Override
    public T findById(ID id) {
        return storage.get(id); // Retourne l'entité ou null si non trouvée
    }

    @Override
    public T save(T entity) {
        ID id = extractId(entity);
        storage.put(id, entity);
        return entity;
    }

    @Override
    public void delete(T entity) {
        ID id = extractId(entity);
        storage.remove(id);
    }

    // Méthode simplifiée pour extraire l'ID - à adapter selon votre logique d'identification
    private ID extractId(T entity) {
        // Ici, adaptez la logique pour extraire l'ID depuis l'entité
        return null; // Exemple simplifié
    }
}

// Classe abstraite d'usine pour créer des mocks de repositories
abstract class AbstractRepositoryMockFactory<T, R extends MyRepository<T, ID>, ID> {
    public abstract R createRepository();
}

// Exemple d'utilisation
class MyEntity {}
