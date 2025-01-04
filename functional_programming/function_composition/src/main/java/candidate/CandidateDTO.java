package candidate;

import java.util.List;

public class CandidateDTO {

    private List<CandidateParameters> params;

    public CandidateDTO(List<CandidateParameters> params) {
        this.params = params;
    }

    public CandidateDTO() {
    }

    public List<CandidateParameters> getParams() {
        return params;
    }

    public void setParams(List<CandidateParameters> params) {
        this.params = params;
    }

    @Override
    public String toString() {
        return "CandidateDTO{" +
                "params=" + params +
                '}';
    }
}
