package films;

public class Studio {

    private String name;
    private String headquarters;

    public Studio(String name, String headquarters) {
        this.name = name;
        this.headquarters = headquarters;
    }

    @Override
    public String toString() {
        return "Studio{" +
                "name='" + name + '\'' +
                ", headquarters='" + headquarters + '\'' +
                '}';
    }
}
