package bookWorm.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bookWorm.assignation.model.Assignation;
import bookWorm.book.model.AddBook;
import bookWorm.book.model.Book;
import bookWorm.book.model.BookForClient;
import bookWorm.repositories.AssignationRepository;
import bookWorm.repositories.BookRepository;

@Transactional
@Service
public class BookService {

	@Autowired
	private BookRepository bookRepo;

	@Autowired
	private AssignationRepository assignationRepo;

	public List<BookForClient> receiveAllBooks() {
		List<Book> booksFromDatabase = getBookRepo().findAll();
		List<BookForClient> booksForClient = booksFromDatabase.stream().map((book) -> {
			BookForClient bfk = new BookForClient();
			bfk.setBookId(book.getBookId());
			bfk.setBookName(book.getBookName());
			bfk.setAuthor(book.getAuthor());
			bfk.setNumberOfPages(book.getNumberOfPages());
			// bfk.setBookPhoto(book.getBookPhoto);
			//bfk.setAssignationId(book.getAssignation().getAssignationId());
			return bfk;
		}).collect(Collectors.toList());
		return booksForClient;
	}

	public BookForClient receiveBookInfo(long bookId) {
		Book book = bookRepo.findByBookId(bookId);
		BookForClient bfk = new BookForClient();
		bfk.setBookId(book.getBookId());
		bfk.setBookName(book.getBookName());
		bfk.setAuthor(book.getAuthor());
		bfk.setNumberOfPages(book.getNumberOfPages());
		// bfk.setBookPhoto(book.getBookPhoto());
		//bfk.setAssignationId(book.getAssignation().getAssignationId());
		return bfk;
	}

	public void addNewBook(AddBook newBook/*, long assignationId*/) {
		Book book = new Book();
		book.setBookName(newBook.getBookName());
		book.setAuthor(newBook.getAuthor());
		book.setNumberOfPages(newBook.getNumberOfPages());
		// book.setBookPhoto(newBook.getBookPhoto());
		// Assignation assignation = assignationRepo.findByAssignationId(assignationId);
		// book.setAssignation(assignation);
		bookRepo.save(book);
	}

	public void updateBook(Book book, Long bookId, long assignationId) {
		Book bkupd = bookRepo.findOne(bookId);
		bkupd.setBookName(book.getBookName());
		bkupd.setAuthor(book.getAuthor());
		bkupd.setNumberOfPages(book.getNumberOfPages());
		// bkupd.setBookPhoto(book.getBookPhoto());
		Assignation assignation = assignationRepo.findByAssignationId(assignationId);
		bkupd.setAssignation(assignation);
		bookRepo.save(bkupd);
	}

	public void deleteBook(Long bookId) {
		bookRepo.delete(bookId);
	}

	public BookRepository getBookRepo() {
		return bookRepo;
	}

	public void setBookRepo(BookRepository bookRepo) {
		this.bookRepo = bookRepo;
	}

	public AssignationRepository getAssignationRepo() {
		return assignationRepo;
	}

	public void setAssignationRepo(AssignationRepository assignationRepo) {
		this.assignationRepo = assignationRepo;
	}

}
