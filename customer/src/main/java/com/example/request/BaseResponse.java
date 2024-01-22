package com.example.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

/**
 * @author Choco Lee
 */
@Builder
@Data
public class BaseResponse {
    private String status;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String error;

    /**
     * @return 成功狀態
     */
    public static BaseResponse SUCCESS() {
        return BaseResponse.builder()
                .status(RC.SUCCESS.name())
                .build();
    }

    /**
     * @return 失敗狀態
     */
    public static BaseResponse FAILED() {
        return BaseResponse.builder()
                .status(RC.FAILED.name())
                .build();
    }

    @Getter
    @AllArgsConstructor
    public enum RC {
        /** 操作成功 */
        SUCCESS(),
        /** 操作失敗 */
        FAILED();
    }

}
