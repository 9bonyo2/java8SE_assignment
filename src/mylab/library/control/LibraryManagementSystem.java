package mylab.library.control;

import java.util.ArrayList;
import java.util.List;

import mylab.library.entity.Book;
import mylab.library.entity.Library;

public class LibraryManagementSystem {

	public static void main(String[] args) {
		LibraryManagementSystem libraryManager = new LibraryManagementSystem();

		//도서관 객체 생성
		Library library = new Library("중앙 도서관");

		//Book 객체를 저장할 List 생성
		List<Book> bookList = new ArrayList<>();

		//샘플 도서 생성
		libraryManager.addSampleBooks(bookList);

		//생성된 도서를 Library에 추가
		libraryManager.addBooksToLibrary(bookList, library);

		//도서관 기능 테스트
		libraryManager.displayLibraryStatus(library);
		libraryManager.testFindBook(library);
		libraryManager.testCheckOut(library);
		libraryManager.testReturn(library);
		libraryManager.displayAvailableBooks(library);
	}

	//샘플 도서를 List에 저장
	public void addSampleBooks(List<Book> books) {
		books.add(new Book("자바 프로그래밍", "김자바", "978-89-01-12345-6", 2022));
		books.add(new Book("객체지향의 사실과 오해", "조영호", "978-89-01-67890-1", 2015));
		books.add(new Book("Clean Code", "Robert C. Martin", "978-0-13-235088-4", 2008));
		books.add(new Book("Effective Java", "Joshua Bloch", "978-0-13-468599-1", 2018));
		books.add(new Book("Head First Java", "Kathy Sierra", "978-0-596-00920-5", 2005));
		books.add(new Book("자바의 정석", "남궁성", "978-89-01-14077-4", 2019));
	}

	//List에 저장된 도서를 Library에 추가
	public void addBooksToLibrary(List<Book> books, Library library) {
		for (Book book : books) {
			library.addBook(book);
		}
	}

	//도서관 상태 출력
	public void displayLibraryStatus(Library library) {
		System.out.println("===== " + library.getName() + " =====");
		System.out.println("전체 도서 수: " + library.getTotalBooks());
		System.out.println("대출 가능 도서 수: " + library.getAvailableBooksCount());
		System.out.println("대출 중인 도서 수: " + library.getBorrowedBooksCount());
	}

	//도서 검색 테스트
	public void testFindBook(Library library) {
		System.out.println("===== 도서 검색 테스트 =====");

		//제목으로 검색
		System.out.println("제목으로 검색 결과:");
		Book findBook = library.findByTitle("자바의 정석");

		if(findBook != null) {
			System.out.println(findBook);
		}

		//저자로 검색
		System.out.println("저자로 검색 결과:");
		List<Book> findBooks = library.findByAuthor("Robert C. Martin");

		for (Book book : findBooks) {
			System.out.println(book);
		}
	}

	//도서 대출 테스트
	public void testCheckOut(Library library) {
		System.out.println("===== 도서 대출 테스트 =====");

		String isbn = "978-89-01-14077-4";
		boolean result = library.checkOutBook(isbn);

		if(result) {
			System.out.println("도서 대출 성공!");
		}else {
			System.out.println("도서 대출 실패!");
		}

		System.out.println("대출된 도서 정보:");
		Book book = library.findByISBN(isbn);

		if(book != null) {
			System.out.println(book);
		}

		System.out.println("도서관 현재 상태:");
		System.out.println("전체 도서 수: " + library.getTotalBooks());
		System.out.println("대출 가능 도서 수: " + library.getAvailableBooksCount());
		System.out.println("대출 중인 도서 수: " + library.getBorrowedBooksCount());
	}

	//도서 반납 테스트
	public void testReturn(Library library) {
		System.out.println("===== 도서 반납 테스트 =====");

		String isbn = "978-89-01-14077-4";
		boolean result = library.returnBook(isbn);

		if(result) {
			System.out.println("도서 반납 성공!");
		}else {
			System.out.println("도서 반납 실패!");
		}

		System.out.println("반납된 도서 정보:");
		Book book = library.findByISBN(isbn);

		if(book != null) {
			System.out.println(book);
		}

		System.out.println("도서관 현재 상태:");
		System.out.println("전체 도서 수: " + library.getTotalBooks());
		System.out.println("대출 가능 도서 수: " + library.getAvailableBooksCount());
		System.out.println("대출 중인 도서 수: " + library.getBorrowedBooksCount());
	}

	//대출 가능한 도서 목록 출력
	public void displayAvailableBooks(Library library) {
		System.out.println("===== 대출 가능한 도서 목록 =====");

		List<Book> availableBooks = library.getAvailableBooks();

		for (Book book : availableBooks) {
			System.out.println(book);
			System.out.println("------------------------");
		}
	}
}