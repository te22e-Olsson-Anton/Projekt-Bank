import java.util.ArrayList;

public class Bank
{
    private ArrayList<User> users = new ArrayList<>();

    public void addUser(User user)
    {
        users.add(user);
    }

    public User login(String name, String password) {
        for (User user : users) {
            if (user.getName().equals(name) && user.checkPassword(password)) {
                return user;
            }
        }
        return null;
    }


}