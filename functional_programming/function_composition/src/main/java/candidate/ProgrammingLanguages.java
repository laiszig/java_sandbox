package candidate;

public enum ProgrammingLanguages {

    JAVA("Java"),
    C("C"),
    RUST("Rust"),
    PYTHON("Python"),
    RUBY("Ruby"),
    R("R"),
    PHP("PHP"),
    JAVASCRIPT("Javascript");

    private String language;

    ProgrammingLanguages(String language) {
        this.language = language;
    }

    public String getLanguage() {
        return language;
    }
}
