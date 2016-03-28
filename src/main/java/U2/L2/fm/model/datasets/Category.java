package U2.L2.fm.model.datasets;

import javax.persistence.*;

/**
 * Created by Ксения on 19.03.2016.
 *
 */
@Entity
@Table(name = "category")
public class Category {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@OneToMany(fetch = FetchType.EAGER)
    private long id;

    @Column(name = "name")
    private String nameCategory;

    public Category(long id, String nameCategory) {

        this.nameCategory = nameCategory;
        this.id = id;
    }

    public Category() {
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
