package springbootpart2;


import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class FakeRepo  implements FakeRepoInterface{

    private static ArrayList<User> DB =new ArrayList<>();


    @Override
    public String insertUser(long id, String name, String surname) {
        String message=" Entered";
        DB.add(new User(id,name,surname));
        return name + message;
    }

    @Override
    public String findUserById(long id) {
        String message="Hello ";
        for (User a: DB){
            long Id=a.getId();
            if (id==Id){
                return message + a.getName();
            }
        }return null;
    }

    @Override
    public String deleteUser(long id) {
        String message=" Removed";
        for(User b:DB){
            long Id=b.getId();
            if(Id==id){
                DB.remove(b);
                return b.getName() + message;

            }
        }return null;
    }
}
