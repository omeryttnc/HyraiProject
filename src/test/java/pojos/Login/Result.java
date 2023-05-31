
package pojos.Login;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.processing.Generated;

@Generated("jsonschema2pojo")
public class Result {

    private Integer userId;
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
