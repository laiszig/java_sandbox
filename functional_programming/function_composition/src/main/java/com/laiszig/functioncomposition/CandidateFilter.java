package com.laiszig.functioncomposition;

import com.laiszig.functioncomposition.candidate.*;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class CandidateFilter {

    // Part 1
    // Predicates created to filter candidates based on criteria, hardcoded, to test simple function composition
    public final Predicate<Candidate> hasMobileExperience = Candidate::hasMobileExperience;
    public final Predicate<Candidate> has10yearsOfExperience = candidate -> candidate.getYearsOfExperience() >= 10;
    private final Predicate<Candidate> isSenior = candidate -> Objects.equals(candidate.getLevel(), "Senior");
    private final Predicate<Candidate> hasMongoExperience = candidate -> candidate.getDbs().contains(DataBases.MONGODB);
    private final Predicate<Candidate> isFluent = candidate -> Objects.equals(candidate.getEnglishLevel(), EnglishLevel.FLUENT);

    // function composition
    public Predicate<Candidate> composed = has10yearsOfExperience
            .and(has10yearsOfExperience)
            .and(isFluent)
            .and(hasMongoExperience)
            .and(isSenior)
            .and(hasMobileExperience);

    // Part 2
    // Dynamic creation of predicates
//    public static List<Predicate<Candidate>> createPredicates(Map<String, Object> criteria) {
//        List<Predicate<Candidate>> predicates = new ArrayList<>();
//
//        criteria.forEach((key, value) -> {
//            switch (key) {
//                case "yearsOfExperience":
//                    predicates.add(c -> c.getYearsOfExperience() >= (Integer) value);
//                case "mobileExperience":
//                    predicates.add(Candidate::hasMobileExperience);
//            }
//        });
//
//        return predicates;
//    }

    public static List<Predicate<Candidate>> createPredicates(Map<String, Object> criteria) {
        // Avoid using variables outside map so that it doesn't change the state of anything outside its scope
         return criteria.entrySet().stream()
                .map(entry -> switch (entry.getKey()) {
                    case "yearsOfExperience" ->
                            (Predicate<Candidate>) c -> c.getYearsOfExperience() >= (Integer) entry.getValue();
                    case "mobileExperience" -> (Predicate<Candidate>) Candidate::hasMobileExperience;
                    case "level" -> (Predicate<Candidate>) c -> c.getLevel().equals(entry.getValue());
                    case "englishLevel" -> (Predicate<Candidate>) c -> c.getEnglishLevel().equals(entry.getValue());
                    // For cases such as list, we add a stream that checks if value is an instance of List contains the value
                    case "frameworks" -> (Predicate<Candidate>) c ->
                            entry.getValue() instanceof List<?> &&
                                    ((List<Frameworks>) entry.getValue())
                                            .stream()
                                            .anyMatch(c.getFrameworks()::contains);
                    case "dbs" -> (Predicate<Candidate>) c ->
                            entry.getValue() instanceof List<?> &&
                                    ((List<DataBases>) entry.getValue())
                                            .stream()
                                            .anyMatch(c.getDbs()::contains);
                    default -> null;
                }).filter(Objects::nonNull)
                 .collect(toList());
    }

    // Refined function composition
    public static List<Candidate> filterCandidates(List<Candidate> candidateList, List<Predicate<Candidate>> predicates) {
        Predicate<Candidate> pred = predicates.stream().reduce(Predicate::and).orElse(c -> false);

        return candidateList.stream()
                .filter(pred)
                .collect(Collectors.toList());
    }
}
