
package pojos.Seach;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.processing.Generated;

@Generated("jsonschema2pojo")
public class Role {

    private Integer id;
    private Company company;
    private String roleName;
    private List<HiringLocation> hiringLocations;
    private List<Skill> skills;
    private Integer willingWorkType;
    private String createdAt;
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<HiringLocation> getHiringLocations() {
        return hiringLocations;
    }

    public void setHiringLocations(List<HiringLocation> hiringLocations) {
        this.hiringLocations = hiringLocations;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    public Integer getWillingWorkType() {
        return willingWorkType;
    }

    public void setWillingWorkType(Integer willingWorkType) {
        this.willingWorkType = willingWorkType;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
