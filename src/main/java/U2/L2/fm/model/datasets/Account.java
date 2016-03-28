package U2.L2.fm.model.datasets;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Сергеева on 18.03.2016.
 *
 */
@Entity
@Table(name = "accounts")
public class Account {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "description")
    private String description;

    @Column(name = "amount")
    private double amount;

    @ManyToOne(cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user")
    private User user;


    @OneToMany(fetch = FetchType.EAGER, mappedBy = "accounts")
     private Set<Record> records;

    public Account(){

    }

    public Account(String description, double amount) {
        this.id = -1;
        this.description = description;
        this.amount = amount;
        this.records = new HashSet<>();
    }

    public Account(long id, String description, double amount) {
        this.id = id;
        this.description = description;
        this.amount = amount;
        this.records = new HashSet<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Set<Record> getRecords() {
        return records;
    }

    public void setRecords(Set<Record> records) {
        this.records = records;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


}
