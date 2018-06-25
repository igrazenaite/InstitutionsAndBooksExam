package bookWorm.institution.model;

public class InstitutionForClient {

	private long institutionId;
	private String institutionName;
	private String city;
	private String institutionPhoto;
	private String category;
	private String institutionType;
	private String subcategory;
	private long assignationId;

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

	public long getAssignationId() {
		return assignationId;
	}

	public void setAssignationId(long assignationId) {
		this.assignationId = assignationId;
	}

}
