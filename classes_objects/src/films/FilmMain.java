package films;

public class FilmMain {

    public static void main(String[] args) {

        Film film = new Film("The Shining", 1980, new Studio("Warner Bros.", "Burbank, CA"));

        System.out.println(film);
    }
}
