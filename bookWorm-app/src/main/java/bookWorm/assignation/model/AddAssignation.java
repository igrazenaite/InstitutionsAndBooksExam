package bookWorm.assignation.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AddAssignation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique = true)

	private long assignationId;
	private BigDecimal price;
	private int condition;
	private int quantity;

	public long getAssignationId() {
		return assignationId;
	}

	public void setAssignationId(long assignationId) {
		this.assignationId = assignationId;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public int getCondition() {
		return condition;
	}

	public void setCondition(int condition) {
		this.condition = condition;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
