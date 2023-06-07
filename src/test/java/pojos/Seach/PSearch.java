
package pojos.Seach;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.processing.Generated;

@Generated("jsonschema2pojo")
public class PSearch {

    private Boolean status;
    private Result result;
    private List<Object> errors;
    private Object errorCode;
    private UserInfo userInfo;
    private Integer nbNotOpenedNotifications;
    private List<Object> notifications;
    private Object companyInfo;
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public List<Object> getErrors() {
        return errors;
    }

    public void setErrors(List<Object> errors) {
        this.errors = errors;
    }

    public Object getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Object errorCode) {
        this.errorCode = errorCode;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public Integer getNbNotOpenedNotifications() {
        return nbNotOpenedNotifications;
    }

    public void setNbNotOpenedNotifications(Integer nbNotOpenedNotifications) {
        this.nbNotOpenedNotifications = nbNotOpenedNotifications;
    }

    public List<Object> getNotifications() {
        return notifications;
    }

    public void setNotifications(List<Object> notifications) {
        this.notifications = notifications;
    }

    public Object getCompanyInfo() {
        return companyInfo;
    }

    public void setCompanyInfo(Object companyInfo) {
        this.companyInfo = companyInfo;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
