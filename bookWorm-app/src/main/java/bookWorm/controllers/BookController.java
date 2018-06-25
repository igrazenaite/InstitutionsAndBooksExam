package bookWorm.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import bookWorm.book.model.AddBook;
import bookWorm.book.model.Book;
import bookWorm.book.model.BookForClient;
import bookWorm.services.BookService;

@RestController
public class BookController {

	@Autowired
	private BookService bookService;

	// get all books
	@RequestMapping(value = "/books", method = RequestMethod.GET)
	public List<BookForClient> giveAllBooks() {
		return getBookService().receiveAllBooks();
	}

	// get one book
	@RequestMapping(value = "/singleBook/{bookId}", method = RequestMethod.GET)
	public BookForClient giveSingleBook(@PathVariable("bookId") final Long bookId) {
		return getBookService().receiveBookInfo(bookId);
	}

	// create new book
	@RequestMapping(value = "/newBook"/*/{assignationId}*/, method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void createBook(@RequestBody final AddBook newBook/*, @PathVariable(value = "assignationId") long assignationId,*/) {
		bookService.addNewBook(newBook/*, assignationId*/);
	}

	// update book
	@RequestMapping(path = "/singleBook/update/{bookId}/{assignationId}", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.CREATED)
	public void updateExistingBook(@RequestBody final Book book, @PathVariable final Long bookId,
			@PathVariable(value = "assignationId") long assignationId) {
		bookService.updateBook(book, bookId, assignationId);
	}

	// delete book
	@RequestMapping(path = "/book/deleteBook/{bookId}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteBookFromDatabase(@PathVariable final Long bookId) {
		bookService.deleteBook(bookId);
	}

	public BookService getBookService() {
		return bookService;
	}

	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}

}
