package U2.L1.L2.ex2.model.datasets;

import java.util.Date;

/**
 * Created by Сергеева on 18.03.2016.
 *
 */
public class Record {
    private long id;
    private Date date;
    private double amount;
    private String desc;

    public Record(Date date, double amount, String desc) {
        this.date = date;
        this.amount = amount;
        this.desc = desc;
        this.id = -1;
    }

    public Record(long id, Date date, double amount, String desc) {
        this.id = id;
        this.date = date;
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
