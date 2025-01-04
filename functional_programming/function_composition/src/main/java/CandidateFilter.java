import candidate.*;

import java.util.*;
import java.util.function.Predicate;

import static java.util.Optional.ofNullable;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;
import static org.apache.commons.lang3.StringUtils.isNotBlank;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class CandidateFilter {

    private final Predicate<Candidate> hasMobileExperience = Candidate::hasMobileExperience;
    private final Predicate<Candidate> has10yearsOfExperience = candidate -> candidate.getYearsOfExperience() >= 10;
    private final Predicate<Candidate> isSenior = candidate -> Objects.equals(candidate.getLevel(), "Senior");
    private final Predicate<Candidate> hasMongoExperience = candidate -> candidate.getDbs().contains(DataBases.MONGODB);
    private final Predicate<Candidate> isFluent = candidate -> Objects.equals(candidate.getEnglishLevel(), EnglishLevel.FLUENT);

    public Predicate<Candidate> composed = has10yearsOfExperience.and(has10yearsOfExperience).and(isFluent).and(hasMongoExperience).and(isSenior).and(hasMobileExperience);

    public Map<String, String> addRequirements(CandidateDTO candidate) {

        Map<String, String> candidateRequirements = null;


        List<CandidateParameters> params = ofNullable(candidate.getParams()).orElseGet(Collections::emptyList).stream()
                .filter((CandidateParameters candidateParams) -> isNotBlank(candidateParams.getValue()))
                .collect(toList());

        candidate.setParams(params);

        return candidateRequirements;
    }

//    private Map<String, String> getKeyValueMap(List<CandidateParameters> params) {
//        return params.stream()
//                .filter((CandidateParameters reportParam) -> isNotBlank(reportParam.getKey()) && isNotBlank(reportParam.getValue()))
//                .collect(toMap(CandidateParameters::getKey, CandidateParameters::getValue));
//    }

    public static Candidate deserialize(Object object) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return mapper.convertValue(object, Candidate.class);
    }
}
