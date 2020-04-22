package springbootpart2;

public interface UserService {

    String addUser(long Id,String name,String surname);

    String removeUser(long Id);

    String getUser(long Id);
}

