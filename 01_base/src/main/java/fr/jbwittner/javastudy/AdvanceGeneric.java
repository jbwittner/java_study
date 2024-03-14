package fr.jbwittner.javastudy;

public class AdvanceGeneric {

    public static void main(String[] args) {
        veryComplexeGeneric();
    }

    public static void veryComplexeGeneric() {
        UserEntityRepositoryMockFactory factory = new UserEntityRepositoryMockFactory();
        factory.mockFindById(45);
        UserEntityRepository repository = factory.getRepository();
        repository.findById(45);
    }
}

// Définition de notre propre interface de repository
interface MyRepository<T, ID> {
    T findById(ID id);

    T save(T entity);

    void delete(T entity);
}

// Classe abstraite d'usine pour créer des mocks de repositories
abstract class AbstractRepositoryMockFactory<T, R extends MyRepository<T, ID>, ID> {
    protected final R repository;

    protected abstract R createRepository();

    protected AbstractRepositoryMockFactory() {
        this.repository = createRepository();
    }

    public R getRepository() {
        return repository;
    }

    // Méthodes mock avec logs
    public AbstractRepositoryMockFactory<T, R, ID> mockFindById(Integer id) {
        System.out.println("Mock findById called with ID: " + id);
        return this; // Retourne null pour simplifier l'exemple
    }

    public AbstractRepositoryMockFactory<T, R, ID> mockSave(T entity) {
        System.out.println("Mock save called with Entity: " + entity);
        return this; // Retourne directement l'entité pour simplifier
    }

    public AbstractRepositoryMockFactory<T, R, ID> mockDelete(T entity) {
        System.out.println("Mock delete called with Entity: " + entity);
        // Ne fait rien pour simplifier
        return this;
    }
}

// Exemple d'utilisation
class UserEntity {}

// Définition de notre propre interface de repository
interface UserEntityRepository extends MyRepository<UserEntity, Integer> {
    UserEntity findByUserName(String UserName);
}

class UserEntityRepositorImpl implements UserEntityRepository {

    @Override
    public UserEntity findById(Integer id) {
        // TODO Auto-generated method stub
        System.out.println("Unimplemented method 'findById'");
        return null;
    }

    @Override
    public UserEntity save(UserEntity entity) {
        // TODO Auto-generated method stub
        System.out.println("Unimplemented method 'save'");
        return null;
    }

    @Override
    public void delete(UserEntity entity) {
        // TODO Auto-generated method stub
        System.out.println("Unimplemented method 'delete'");
    }

    @Override
    public UserEntity findByUserName(String UserName) {
        // TODO Auto-generated method stub
        System.out.println("Unimplemented method 'findByUserName'");
        return null;
    }
}

class UserEntityRepositoryMockFactory extends AbstractRepositoryMockFactory<UserEntity, UserEntityRepository, Integer> {

    public UserEntityRepositoryMockFactory() {
        super();
    }

    @Override
    protected UserEntityRepository createRepository() {
        return new UserEntityRepositorImpl();
    }

    public UserEntityRepositoryMockFactory mockFindByUserId(String UserName) {
        System.out.println("Mock findById called with UserName: " + UserName);
        // Ne fait rien pour simplifier
        return this;
    }
}
