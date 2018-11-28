package cn.tekin.api.utils.result;

import lombok.Data;

@Data
public class ApiResponseFail extends ApiResponse {
    private String msg="fail";

    /**
     * 传递了错误代码的构造函数
     * @param code
     */
    ApiResponseFail(String code){
        this.code=code;
        this.msg=msg;
    }

    /**
     * 传递了错误代码和错误消息的构造函数
     * @param code
     * @param msg
     */
    ApiResponseFail(String code,String msg){
        this.code=code;
        this.msg=msg;
    }
}
