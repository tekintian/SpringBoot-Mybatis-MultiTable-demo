package cn.tekin.api.utils.result;
import lombok.Data;

@Data
public class ApiResponseSuccess extends ApiResponse {

    private Object data;

    /**
     * 构造函数
     * @param data
     */
    ApiResponseSuccess(Object data){
        this.code="200";
        this.msg="success";
        this.data=data;
    }
}
