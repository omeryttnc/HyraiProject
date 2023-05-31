
package pojos.Login;

import lombok.Getter;

import javax.annotation.processing.Generated;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Generated("jsonschema2pojo")
@Getter

public class PLogin {

    private Boolean status;
    private Result result;
    private List<Object> errors;
    private Object errorCode;
    private UserInfo userInfo;
    private Integer nbNotOpenedNotifications;
    private List<Object> notifications;
    private Object companyInfo;
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();



}
