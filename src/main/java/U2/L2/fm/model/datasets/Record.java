package U2.L2.fm.model.datasets;

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
    @Column(name = "record_id")
    private Long recordId;

    @Column(name = "type")
    private Boolean isPut;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_rec")
    private Date date;

    @Column(name = "amount")
    private double amount;

    @Column(name = "description")
    private String recordName;

    @ManyToOne(cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    private Account account;

    @ManyToOne(cascade= {CascadeType.MERGE}, fetch=FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    public Record() {
    }

    public Record(Date date, Category category, Boolean isPut, double amount, String recordName) {
        this.date = date;
        this.isPut = isPut;
        this.category = category;
        this.amount = amount;
        this.recordName = recordName;
    }

    public Record(Long id, Date date, Category category, Boolean isPut, double amount, String recordName) {
        this.recordId = id;
        this.date = date;
        this.isPut = isPut;
        this.category = category;
        this.amount = amount;
        this.recordName = recordName;
    }

    public long getRecordId() {
        return recordId;
    }

    public void setRecordId(Long recordId) {
        this.recordId = recordId;
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

    public String getRecordName() {
        return recordName;
    }

    public void setRecordName(String recordName) {
        this.recordName = recordName;
    }

    public Boolean isPut() {
        return isPut;
    }

    public void setIsPut(Boolean isPut) {
        this.isPut = isPut;
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

        return Double.compare(record.amount, amount) == 0
//                && date.equals(record.date)
                && (recordName != null ? recordName.equals(record.recordName) : record.recordName == null);

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = isPut != null ? isPut.hashCode() : 0;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        temp = Double.doubleToLongBits(amount);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (recordName != null ? recordName.hashCode() : 0);
        result = 31 * result + (account != null ? account.hashCode() : 0);
        result = 31 * result + (category != null ? category.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Record{" +
                "recordId=" + recordId +
                ", date=" + date +
                ", amount=" + amount +
                ", recordName='" + recordName + '\'' +
                ", account=" + account +
                ", category=" + category +
                '}';
    }
}
