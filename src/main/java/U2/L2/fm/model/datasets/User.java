package U2.L2.fm.model.datasets;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Сергеева on 18.03.2016.
 *
 */
public class User {
    private long id;
    private String name;
    private String password;
    private Set<Account> accounts;
    {
        this.name = "Anonymnous";
        this.password = "1234";
        this.accounts = new HashSet<>();
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
        this.id = -1;
    }

    public User() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(Set<Account> accounts) {
        this.accounts = accounts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (!name.equals(user.name)) return false;
        return password.equals(user.password);

    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + password.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", accounts=" + accounts +
                '}';
    }
}
