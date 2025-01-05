import candidate.*;

import java.util.*;
import java.util.function.Predicate;

public class CandidateFilter {

    public final Predicate<Candidate> hasMobileExperience = Candidate::hasMobileExperience;
    public final Predicate<Candidate> has10yearsOfExperience = candidate -> candidate.getYearsOfExperience() >= 10;
    private final Predicate<Candidate> isSenior = candidate -> Objects.equals(candidate.getLevel(), "Senior");
    private final Predicate<Candidate> hasMongoExperience = candidate -> candidate.getDbs().contains(DataBases.MONGODB);
    private final Predicate<Candidate> isFluent = candidate -> Objects.equals(candidate.getEnglishLevel(), EnglishLevel.FLUENT);

    public Predicate<Candidate> composed = has10yearsOfExperience.and(has10yearsOfExperience).and(isFluent).and(hasMongoExperience).and(isSenior).and(hasMobileExperience);

    public static List<Predicate<Candidate>> setRequirements(Map<String, Object> criteria) {
        List<Predicate<Candidate>> predicates = new ArrayList<>();

        criteria.forEach((key, value) -> {
            switch (key) {
                case "yearsOfExperience":
                    predicates.add(c -> c.getYearsOfExperience() >= (Integer) value);
                case "mobileExperience":
                    predicates.add(Candidate::hasMobileExperience);
            }
        });

        return predicates;
    }


    public static List<Candidate> filterCandidates(List<Candidate> candidateList, List<Predicate<Candidate>> predicates) {
        List<Candidate> candidates = new ArrayList<>();

        Predicate<Candidate> pred = predicates.stream().reduce(Predicate::and).orElse(c -> false);

        candidateList.stream()
                .filter(pred)
                .forEach(candidates::add);

        return candidates;

    }
}
