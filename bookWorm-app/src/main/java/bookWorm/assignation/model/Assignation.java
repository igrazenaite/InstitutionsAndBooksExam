package bookWorm.assignation.model;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

import bookWorm.book.model.Book;
import bookWorm.institution.model.Institution;
import lombok.EqualsAndHashCode;

@Entity
@EqualsAndHashCode(exclude = { "institutions", "books" })
@PrimaryKeyJoinColumn(name = "assignationId")
public class Assignation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique = true)

	private long assignationId;
	private BigDecimal price;
	private int condition;
	private int quantity;

	@OneToMany(mappedBy = "assignation", fetch=FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.DETACH})
	private List<Institution> institutions;

	@OneToMany(mappedBy = "assignation", fetch=FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.DETACH})
	private List<Book> books;

	public List<Institution> getInstitutions() {
		return institutions;
	}

	public void setInstitutions(List<Institution> institutions) {
		this.institutions = institutions;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

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
