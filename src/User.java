public class User
{

    private int id;
    private String name;
    private String password;

    public User(int id, String name, String password)
    {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public boolean checkPassword(String password)
    {
        return this.password.equals(password);
    }
}