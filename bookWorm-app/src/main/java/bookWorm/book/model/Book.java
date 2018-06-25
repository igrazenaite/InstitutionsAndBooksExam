package bookWorm.book.model;

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
@PrimaryKeyJoinColumn(name = "bookId")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique = true)

	private long bookId;
	private String bookName;
	private String author;
	private int numberOfPages;
	private String bookPhoto;

	@ManyToOne (fetch=FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.DETACH})
	@JsonBackReference(value = "assignationId")
	@JoinColumn(name = "assignationId")
	private Assignation assignation;

	public long getBookId() {
		return bookId;
	}

	public void setBookId(long bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getNumberOfPages() {
		return numberOfPages;
	}

	public void setNumberOfPages(int numberOfPages) {
		this.numberOfPages = numberOfPages;
	}

	public String getBookPhoto() {
		return bookPhoto;
	}

	public void setBookPhoto(String bookPhoto) {
		this.bookPhoto = bookPhoto;
	}

	public Assignation getAssignation() {
		return assignation;
	}

	public void setAssignation(Assignation assignation) {
		this.assignation = assignation;
	}
}
