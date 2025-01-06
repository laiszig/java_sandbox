package com.laiszig.functioncomposition.candidate;

public enum Frameworks {

    SPRING("Spring"),
    ANGULAR("Angular"),
    RUBY_ON_RAILS("Ruby on Rails"),
    LARAVEL("Laravel"),
    DJANGO("Django"),
    VUE("Vue");

    private String framework;

    Frameworks(String framework) {
        this.framework = framework;
    }

    public String getFramework() {
        return framework;
    }
}
