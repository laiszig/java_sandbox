public enum JobTitle {

    // Enum for job titles, guaranteeing no job titles not on this class is accepted
    HR_ASSISTANT("HR Assistant"),
    SOFTWARE_DEVELOPER("Software Developer"),
    MANAGER("Manager"),
    INTERN("Intern");

    private String title;

    JobTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
