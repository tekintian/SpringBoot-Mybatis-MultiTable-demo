package cn.tekin.api.utils.result;
import lombok.Data;

@Data
public abstract class ApiResponse {
    protected String code;
    protected String msg;

    /**
     * API调用成功统一返回数据接口
     * @param data
     * @return
     */
    public static ApiResponse success(Object data){
        return new ApiResponseSuccess(data);
    }

    /**
     * API调用失败返回，
     * @param code 错误代码
     * @param msg 错误消息
     * @return
     */
    public static ApiResponse fail(String code,String msg){
        return new ApiResponseFail(code,msg);
    }

    /**
     * 采用默认的错误消息 fail 返回
     * @param code 错误代码
     * @return
     */
    public static ApiResponse fail(String code){
        return new ApiResponseFail(code);
    }
}
