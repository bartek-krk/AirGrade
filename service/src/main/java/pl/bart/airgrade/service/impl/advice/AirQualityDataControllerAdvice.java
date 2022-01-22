package pl.bart.airgrade.service.impl.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import pl.bart.airgrade.data.impl.log.*;
import pl.bart.airgrade.service.impl.response.ErrorResponse;
import pl.bart.airgrade.service.impl.response.ResponseMessage;

@RestControllerAdvice
public class AirQualityDataControllerAdvice extends ResponseEntityExceptionHandler {
    @ExceptionHandler(AqicnInvalidApiKeyException.class)
    public ResponseEntity<ErrorResponse> handleAqicnInvalidApiKeyException(AqicnInvalidApiKeyException e, WebRequest webRequest) {
        final HttpStatus status = HttpStatus.FORBIDDEN;
        return new ResponseEntity<>(new ErrorResponse(ResponseMessage.AQICN_INVALID_API_KEY, status.value()), status);
    }

    @ExceptionHandler(AqicnApiQuotaLimitExceededException.class)
    public ResponseEntity<ErrorResponse> handleAqicnApiQuotaLimitExceededException(AqicnApiQuotaLimitExceededException e) {
        final HttpStatus status = HttpStatus.SERVICE_UNAVAILABLE;
        return new ResponseEntity<>(new ErrorResponse(ResponseMessage.AQICN_QUOTA_LIMIT_EXCEEDED, status.value()), status);
    }

    @ExceptionHandler(AqicnApiException.class)
    public ResponseEntity<ErrorResponse> handleAqicnApiException(AqicnApiException e) {
        final HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        return new ResponseEntity<>(new ErrorResponse(ResponseMessage.AQICN_UNKNOWN_API_ERROR, status.value()), status);
    }

    @ExceptionHandler(StormWeatherApiForbiddenException.class)
    public ResponseEntity<ErrorResponse> handleStormWeatherApiForbiddenException(StormWeatherApiForbiddenException e) {
        final HttpStatus status = HttpStatus.FORBIDDEN;
        return new ResponseEntity<>(new ErrorResponse(ResponseMessage.WEATHER_API_FORBIDDEN, status.value()), status);
    }

    @ExceptionHandler(StormWeatherApiInvalidCoordinatesException.class)
    public ResponseEntity<ErrorResponse> handleStormWeatherApiInvalidCoordinatesException(StormWeatherApiInvalidCoordinatesException e) {
        final HttpStatus status = HttpStatus.BAD_REQUEST;
        return new ResponseEntity<>(new ErrorResponse(ResponseMessage.WEATHER_API_INVALID_COORDINATES, status.value()), status);
    }

    @ExceptionHandler(StormWeatherApiException.class)
    public ResponseEntity<ErrorResponse> handleStormWeatherApiException(StormWeatherApiException e) {
        final HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        return new ResponseEntity<>(new ErrorResponse(String.format(ResponseMessage.WEATHER_API_ERROR, e.getCode()), status.value()), status);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception e) {
        final HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        return new ResponseEntity<>(new ErrorResponse("Unknown exception", status.value()), status);
    }

}

