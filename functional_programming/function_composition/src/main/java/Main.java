import candidate.*;

import java.util.*;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {

        Candidate candidate1 = new Candidate(
                "Alice Johnson", 5, "Mid-level",
                Arrays.asList(ProgrammingLanguages.JAVA, ProgrammingLanguages.PYTHON),
                Arrays.asList(DataBases.MYSQL, DataBases.POSTGRESQL),
                EnglishLevel.INTERMEDIATE, StudyLevel.BACHELOR,
                Arrays.asList(Frameworks.SPRING, Frameworks.DJANGO),
                false, 80000
        );

        Candidate candidate2 = new Candidate(
                "Bob Smith", 11, "Senior",
                Arrays.asList(ProgrammingLanguages.RUBY, ProgrammingLanguages.JAVASCRIPT),
                Arrays.asList(DataBases.MYSQL, DataBases.MONGODB),
                EnglishLevel.FLUENT, StudyLevel.MASTER,
                Arrays.asList(Frameworks.ANGULAR, Frameworks.RUBY_ON_RAILS),
                true, 120000
        );

        Candidate candidate3 = new Candidate(
                "Charlie Davis", 2, "Junior",
                Arrays.asList(ProgrammingLanguages.PYTHON, ProgrammingLanguages.JAVASCRIPT),
                Arrays.asList(DataBases.MYSQL),
                EnglishLevel.BEGINNER, StudyLevel.ASSOCIATE,
                Arrays.asList(Frameworks.VUE),
                false, 50000
        );

        Candidate candidate4 = new Candidate(
                "Diana Lee", 10, "Senior",
                Arrays.asList(ProgrammingLanguages.JAVA, ProgrammingLanguages.JAVASCRIPT),
                Arrays.asList(DataBases.ORACLE, DataBases.POSTGRESQL),
                EnglishLevel.ADVANCED, StudyLevel.DOCTOR,
                Arrays.asList(Frameworks.SPRING, Frameworks.ANGULAR),
                true, 150000
        );

        Candidate candidate5 = new Candidate(
                "Eve Martinez", 3, "Mid-level",
                Arrays.asList(ProgrammingLanguages.JAVASCRIPT, ProgrammingLanguages.R),
                Arrays.asList(DataBases.ORACLE, DataBases.MONGODB),
                EnglishLevel.INTERMEDIATE, StudyLevel.BACHELOR,
                Arrays.asList(Frameworks.LARAVEL, Frameworks.DJANGO),
                true, 70000
        );

        Candidate candidate6 = new Candidate(
                "Frank Wilson", 1, "Junior",
                Arrays.asList(ProgrammingLanguages.PYTHON, ProgrammingLanguages.RUBY),
                Arrays.asList(DataBases.MYSQL),
                EnglishLevel.INTERMEDIATE, StudyLevel.BACHELOR,
                Arrays.asList(Frameworks.RUBY_ON_RAILS),
                false, 45000
        );

        Candidate candidate7 = new Candidate(
                "Grace Kim", 7, "Mid-level",
                Arrays.asList(ProgrammingLanguages.JAVA, ProgrammingLanguages.JAVASCRIPT, ProgrammingLanguages.RUST),
                Arrays.asList(DataBases.MYSQL, DataBases.REDIS),
                EnglishLevel.ADVANCED, StudyLevel.MASTER,
                Arrays.asList(Frameworks.SPRING, Frameworks.ANGULAR),
                false, 95000
        );

        Candidate candidate8 = new Candidate(
                "Henry White", 4, "Mid-level",
                Arrays.asList(ProgrammingLanguages.PYTHON, ProgrammingLanguages.JAVASCRIPT),
                Arrays.asList(DataBases.POSTGRESQL, DataBases.MONGODB),
                EnglishLevel.INTERMEDIATE, StudyLevel.BACHELOR,
                Arrays.asList(Frameworks.DJANGO, Frameworks.ANGULAR),
                true, 85000
        );

        Candidate candidate9 = new Candidate(
                "Isabel Brown", 6, "Senior",
                Arrays.asList(ProgrammingLanguages.PHP, ProgrammingLanguages.JAVA),
                Arrays.asList(DataBases.MARIADB, DataBases.MONGODB),
                EnglishLevel.FLUENT, StudyLevel.BACHELOR,
                Arrays.asList(Frameworks.ANGULAR, Frameworks.SPRING),
                true, 110000
        );

        Candidate candidate10 = new Candidate(
                "Jack Taylor", 9, "Senior",
                Arrays.asList(ProgrammingLanguages.JAVA, ProgrammingLanguages.C, ProgrammingLanguages.JAVASCRIPT),
                Arrays.asList(DataBases.ORACLE, DataBases.MYSQL),
                EnglishLevel.FLUENT, StudyLevel.MASTER,
                Arrays.asList(Frameworks.SPRING, Frameworks.ANGULAR),
                false, 135000
        );

        CandidateFilter candidateFilter = new CandidateFilter();
        Candidate[] candidates = {candidate1, candidate2, candidate3, candidate4, candidate5,
                candidate6, candidate7, candidate8, candidate9, candidate10};

        List<Candidate> shortListOfCandidates = Arrays.stream(candidates).filter(candidateFilter.composed).toList();

        System.out.println("Part 1 - Short-list of candidates: ");
        for (Candidate c : shortListOfCandidates){
            System.out.println(c.getName());
        }

        Map<String, Object> criteria = new HashMap<>();
        criteria.put("yearsOfExperience", 10);
        criteria.put("hasMobileExperience", true);
        criteria.put("level", "Senior");
        criteria.put("frameworks", List.of(Frameworks.ANGULAR));
        criteria.put("englishLevel", EnglishLevel.FLUENT);

        List<Predicate<Candidate>> preds = CandidateFilter.setRequirements(criteria);

        List<Candidate> newShortList = CandidateFilter.filterCandidates(Arrays.stream(candidates).toList(), preds);

        System.out.println("Part 2 - Short-list of candidates: ");
        for (Candidate candidate : newShortList){
            System.out.println(candidate.getName());
        }

    }
}
