package U2.L1.L2.ex2.datasets;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Сергеева on 18.03.2016.
 *
 */
public class Account {
    private long id;
    private String description;
    private double amount;
    private List<Record> records;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Account(String description, double amount) {
        this.id = -1;
        this.description = description;
        this.amount = amount;
        this.records = new ArrayList<>();
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

    public List<Record> getRecords() {
        return records;
    }

    public void setRecords(List<Record> records) {
        this.records = records;
    }


}
