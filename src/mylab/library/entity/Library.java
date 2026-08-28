package mylab.library.entity;

import java.util.ArrayList;
import java.util.List;

public class Library {
	//도서관 이름
    private String name;
    //도서 목록
    private List<Book> books; 

    //생성자
    public Library(String name) {
        //도서관 이름 초기화
    	this.name = name;

        //비어있는 도서 목록 ***ArrayList
        this.books = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    //도서추가
    public void addBook(Book book) {
    	books.add(book);
    	System.out.println("도서가 추가되었습니다:"+book.getTitle());    
    }
    
    //도서 제목으로 검색
    public Book findByTitle(String title) {
        for (Book book : books) {
            //책 제목과 검색할 제목이 같으면
            if (book.getTitle().equals(title)) {
                return book;
            }
        }
        //일치하는 책이 없으면
        return null;
    }

    //저자 이름으로 검색
    public List<Book> findByAuthor(String author) {
        //검색된 도서를 저장할 새로운 목록
        List<Book> findBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().equals(author)) {
                findBooks.add(book);
            }
        }
        return findBooks;
    }

    //ISBN으로 검색
    public Book findByISBN(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;
    }

    //ISBN으로 도서 대출
    public boolean checkOutBook(String isbn) {
        //ISBN에 해당하는 도서 검색
        Book book = findByISBN(isbn);
        //책을 찾은 경우 대출 실행
        if (book != null) {
            return book.checkOut();
        }
        //책이 없는 경우 대출 실패
        return false;
    }

    //ISBN으로 도서 반납
    public boolean returnBook(String isbn) {
        //ISBN에 해당하는 도서 검색
        Book book = findByISBN(isbn);
        // 책이 존재하고 현재 대출 중인 경우
        // isAvailable이 false이면 대출 중            
        if (book != null && !book.isAvailable()) {
            book.returnBook();
            return true;
        }
        //책이 없거나 이미 반납된 경우
        return false;
    }
    //대출 가능한 도서 목록 반환
    public List<Book> getAvailableBooks() {
        List<Book> availableBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.isAvailable()) {
                availableBooks.add(book);
            }
        }
        return availableBooks;
    }

    //모든 도서 목록 반환
    public List<Book> getAllBooks() {
        return books;
    }

    //모든 도서 개수 반환
    public int getTotalBooks() {
        return books.size();
    }

    //대출 가능한 도서 개수 반환
    public int getAvailableBooksCount() {
        return getAvailableBooks().size();
    }

    //대출 중인 도서 개수 반환
    public int getBorrowedBooksCount() {
        return getTotalBooks() - getAvailableBooksCount();
    }
    
}