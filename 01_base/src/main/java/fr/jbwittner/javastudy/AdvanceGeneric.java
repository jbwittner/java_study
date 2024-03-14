package fr.jbwittner.javastudy;

import java.util.HashMap;
import java.util.Map;

public class AdvanceGeneric {

    public static void main(String[] args) {
        veryComplexeGeneric();
    }

    public static void veryComplexeGeneric() {
        MyEntityRepositoryMockFactory factory = new MyEntityRepositoryMockFactory();
        factory.mockFindById(45);
        MyRepository<MyEntity, Integer> repository = factory.createRepository();
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
    protected final R repository;

    public abstract R createRepository();

    protected AbstractRepositoryMockFactory() {
        this.repository = createRepository();
    }

    public R getRepository() {
        return repository;
    }

    // Méthodes mock avec logs
    public T mockFindById(Integer id) {
        System.out.println("Mock findById called with ID: " + id);
        return null; // Retourne null pour simplifier l'exemple
    }

    public T mockSave(T entity) {
        System.out.println("Mock save called with Entity: " + entity);
        return entity; // Retourne directement l'entité pour simplifier
    }

    public void mockDelete(T entity) {
        System.out.println("Mock delete called with Entity: " + entity);
        // Ne fait rien pour simplifier
    }
}

// Exemple d'utilisation
class MyEntity {}

class MyEntityRepositoryMockFactory
        extends AbstractRepositoryMockFactory<MyEntity, MyRepository<MyEntity, Integer>, Integer> {

    public MyEntityRepositoryMockFactory() {
        super();
    }

    @Override
    public MyRepository<MyEntity, Integer> createRepository() {
        // Retourner une instance concrète de MyRepository pour MyEntity
        return new SimpleInMemoryRepository<>();
    }
}
