package krd.antonov.db.dataset;

public class UserDataSet extends DataSet {

    private final String name;
    private final int age;

    public UserDataSet(long id, String name, int age) {
        super(id);
        this.name = name;
        this.age = age;
    }

    public long getId() {
        return super.getId();
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "UsersDataSet{" +
                "id=" + super.getId() +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
