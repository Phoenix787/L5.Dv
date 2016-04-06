package U2.L2.fm.model.datasets;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Ксения on 19.03.2016.
 *
 */
@Entity
@Table(name = "category")
public class Category implements Comparable<Category> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Long categoryId;

    @Column(name = "name")
    private String nameCategory;

    @OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY, mappedBy = "category")
    private List<Record> records;

    public Category(Long id, String nameCategory) {

        this.nameCategory = nameCategory;
        this.categoryId = id;
    }
    public Category(String nameCategory) {

        this.nameCategory = nameCategory;

    }

    public Category() {
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public List<Record> getRecords() {
        return records;
    }

    public void setRecords(List<Record> records) {
        this.records = records;
    }

    @Override
    public int compareTo(Category o) {
        return nameCategory.compareTo(o.getNameCategory());
    }



}
