package bookWorm.institution.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AddInstitution {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique = true)

	private long institutionId;
	private String institutionName;
	private String city;
	private String institutionPhoto;
	private String category;
	private String institutionType;
	private String subcategory;

	public long getInstitutionId() {
		return institutionId;
	}

	public void setInstitutionId(long institutionId) {
		this.institutionId = institutionId;
	}

	public String getInstitutionName() {
		return institutionName;
	}

	public void setInstitutionName(String institutionName) {
		this.institutionName = institutionName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getInstitutionPhoto() {
		return institutionPhoto;
	}

	public void setInstitutionPhoto(String institutionPhoto) {
		this.institutionPhoto = institutionPhoto;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getInstitutionType() {
		return institutionType;
	}

	public void setInstitutionType(String institutionType) {
		this.institutionType = institutionType;
	}

	public String getSubcategory() {
		return subcategory;
	}

	public void setSubcategory(String subcategory) {
		this.subcategory = subcategory;
	}

}
