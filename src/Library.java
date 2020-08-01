class Item {
	private String title;
	private String ISBN;
	
	public Item() {}
	
	public Item(String title, String isbn) {
		setTitle(title);
		setISBN(isbn);
	}
	
	public String getTitle() { return title; }

	public void setTitle(String title) {
		this.title = title;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	
	public String getInfo() {
		return "Title: " + getTitle() + "\n" + "ISBN: " + getISBN();
	}	
}

class Book extends Item {
	private String[] author;
	private int pages;
	
	public Book() {}
	
	public Book(String title, String ISBN, String[] author, int pages) {
		super(title, ISBN);
		setAuthor(author);
		setPages(pages);
	}

	public String getAuthor() {
		String authors = "";
		for(int i=0; i<author.length; i++) {
			authors = authors + author[i];
			if(i < author.length-1) { authors = authors + ", "; }		
		}
		return authors;
	}

	public void setAuthor(String[] author) {
		this.author = author;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}
	
	public String getInfo() {
		return getAuthor() + " - " + getTitle() + ", pages: " + getPages() + "\n" + "ISBN: " + getISBN();
	}
}

class eBook {
	private Book book;
	private boolean canDownload;
	
	public eBook() {}
	
	public eBook(Book book, boolean cD) {
		setBook(book);
		setCanDownload(cD);
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public boolean isCanDownload() {
		return canDownload;
	}

	public void setCanDownload(boolean canDownload) {
		this.canDownload = canDownload;
	}
	
	public void download(String type) {
		if(canDownload) {
			//few examples
			if(type == "PDF") { System.out.println(book.getTitle() + ".pdf"); }
			else if(type == "EPUB") { System.out.println(book.getTitle() + ".epub"); }
			else { System.out.println("Format not supported."); }
		}
		else { System.out.println("This book is not available for download."); }
	}
}

public class Library {

	public static void main(String[] args) {		
		// simple test for the classes
		Item i = new Item("Call me by your name","123");			
		System.out.println(i.getInfo());	
		
		System.out.println("");
		
		Book b = new Book();
		b.setTitle("Find me");
		b.setISBN("234");
		String[] author = { "Andre Aciman", "Luca Guadagnino"};
		b.setAuthor(author);
		b.setPages(345);
		System.out.println(b.getInfo());
		
		System.out.println();
		
		eBook e = new eBook(b, true);
		e.download("PDF");
	}
}