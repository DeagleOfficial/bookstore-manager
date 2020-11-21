
public class Book {
	public String bookName;
	public String author;
	public String genre;
	public String publisher;
	public String price;

	public Book() {
		bookName = null;
		author = null;
		genre = null;
		publisher = null;
		price = null;
	}

	public Book(String b, String a, String g, String p, String pr) {
		bookName = b;
		author = a;
		genre = g;
		publisher = p;
		price = pr;
	}

	public void display() {
		System.out.println("\n" + "BOOK NAME :  " + bookName + "\n" + "AUTHOR :  " + author + "\n" + "GENRE :  "  + genre  + "\n" + "PUBLISHER :  " + publisher + "\n" + "PRICE :  " + price );
		}
}
