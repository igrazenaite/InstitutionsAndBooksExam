package bookWorm.institution.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import com.fasterxml.jackson.annotation.JsonBackReference;

import bookWorm.assignation.model.Assignation;
import lombok.EqualsAndHashCode;

@Entity
@EqualsAndHashCode(exclude = { "assignation" })
@PrimaryKeyJoinColumn(name = "institutionId")
public class Institution {

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

	@ManyToOne (fetch=FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.DETACH})
	@JsonBackReference(value = "assignationId")
	@JoinColumn(name = "assignationId")
	private Assignation assignation;

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

	public Assignation getAssignation() {
		return assignation;
	}

	public void setAssignation(Assignation assignation) {
		this.assignation = assignation;
	}

}
