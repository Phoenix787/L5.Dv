package U2.L2.fm.model.datasets;

import U2.L2.fm.model.enums.Type;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Сергеева on 18.03.2016.
 *
 */
@Entity
@Table(name = "records")
public class Record {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "type")
    private Type type;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_rec")
    private Date date;

    @Column(name = "amount")
    private double amount;

    @Column(name = "description")
    private String desc;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_column", nullable = false)
    private Account account;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "id_category", nullable = false)
    private Category category;

    public Record() {
    }

    public Record(Date date, Category category, Type type, double amount, String desc) {
        this.date = date;
        this.type = type;
        this.category = category;
        this.amount = amount;
        this.desc = desc;
        this.id = -1;
    }

    public Record(long id, Date date, Category category, Type type, double amount, String desc) {
        this.id = id;
        this.date = date;
        this.type = type;
        this.category = category;
        this.amount = amount;
        this.desc = desc;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Record)) return false;

        Record record = (Record) o;

        return id == record.id && Double.compare(record.amount, amount) == 0 && date.equals(record.date) && (desc != null ? desc.equals(record.desc) : record.desc == null);

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int) (id ^ (id >>> 32));
        result = 31 * result + date.hashCode();
        temp = Double.doubleToLongBits(amount);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (desc != null ? desc.hashCode() : 0);
        return result;
    }
}
