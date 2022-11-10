package films;

public class Film {

    private String name;
    private int year;
    private Studio studio;

    public Film(String name, int year, Studio studio) {
        this.name = name;
        this.year = year;
        this.studio = studio;
    }

    @Override
    public String toString() {
        return "Film{" +
                "name='" + name + '\'' +
                ", year=" + year +
                ", studio=" + studio +
                '}';
    }
}
