package candidate;

public class CandidateParameters {

    private String key;
    private String value;

    public CandidateParameters(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public CandidateParameters() {
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "CandidateParameters{" +
                "key='" + key + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
