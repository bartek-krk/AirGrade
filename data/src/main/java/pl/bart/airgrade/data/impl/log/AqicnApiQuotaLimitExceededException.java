package pl.bart.airgrade.data.impl.log;

public class AqicnApiQuotaLimitExceededException extends RuntimeException {
    public AqicnApiQuotaLimitExceededException(String message) {
        super(message);
    }
}
