package com.rabindra.virtualpowerplant.dtos;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T> {
    private int errorCode;
    private String errorDescription;
    private String message;
    private T body;
    private Integer totalPages;

    private ApiResponse() {}

    public static <T> ApiResponse<T> forErrorWithBody(int errorCode, String errorDescription,T body) {
        ApiResponse<T> apiResponse=new ApiResponse<>();
        apiResponse.setErrorCode(errorCode);
        apiResponse.setErrorDescription(errorDescription);
        apiResponse.setBody(body);
        return apiResponse;
    }

    public static ApiResponse<?> forSuccessWithoutBody(int errorCode) {
        ApiResponse<?> apiResponse=new ApiResponse<>();
        apiResponse.setErrorCode(errorCode);
        return apiResponse;
    }

    public static <T> ApiResponse<T> forSuccess(int errorCode,T body) {
        ApiResponse<T> apiResponse=new ApiResponse<>();
        apiResponse.setErrorCode(errorCode);
        apiResponse.setBody(body);
        return apiResponse;
    }
}
