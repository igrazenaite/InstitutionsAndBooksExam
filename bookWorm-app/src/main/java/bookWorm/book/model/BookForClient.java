package bookWorm.book.model;

public class BookForClient {

	private long bookId;
	private String bookName;
	private String author;
	private int numberOfPages;
	private String bookPhoto;
	private long assignationId;
	
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
	public long getAssignationId() {
		return assignationId;
	}
	public void setAssignationId(long assignationId) {
		this.assignationId = assignationId;
	}
	
}
