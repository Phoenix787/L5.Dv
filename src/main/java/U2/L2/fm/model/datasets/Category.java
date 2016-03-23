package U2.L2.fm.model.datasets;

/**
 * Created by Ксения on 19.03.2016.
 *
 */
class Category {
    private long id;
    private String nameCategory;

    public Category(String nameCategory) {

        this.nameCategory = nameCategory;
        this.id = -1;
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
