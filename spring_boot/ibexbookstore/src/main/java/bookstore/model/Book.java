package bookstore.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "books")
public class Book {
	@Id
	private String id;
	private String title;
	private String genre;
	private String isbn;
	private String price;
	private String author;
	private String publisher;
	private String pubYear;
	private String description;
	private String buyBook;
	private String imgPath;
	
	public Book() {
		super();
	}
	
	public Book(String id, String title, String genre, String isbn, String price, String author, String publisher,
			String pubYear, String description, String buyBook, String imgPath) {
		super();
		this.id = id;
		this.title = title;
		this.genre = genre;
		this.isbn = isbn;
		this.price = price;
		this.author = author;
		this.publisher = publisher;
		this.pubYear = pubYear;
		this.description = description;
		this.buyBook = buyBook;
		this.imgPath = imgPath;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getPubYear() {
		return pubYear;
	}
	public void setPubYear(String pubYear) {
		this.pubYear = pubYear;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getBuyBook() {
		return buyBook;
	}
	public void setBuyBook(String buyBook) {
		this.buyBook = buyBook;
	}
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	
	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", genre=" + genre + ", isbn=" + isbn + ", price=" + price
				+ ", author=" + author + ", publisher=" + publisher + ", pubYear=" + pubYear + ", description="
				+ description + ", buyBook=" + buyBook + ", imgPath=" + imgPath + "]";
	}
}







