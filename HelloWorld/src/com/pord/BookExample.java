package com.pord;

public class BookExample {

	public static void main(String[] args) {
		Book b1 = new Book();
		
		b1.bookName = "혼공자";
		b1.bookAuthor = "신용권";
		b1.bookPublisher = "한빛미디어";
		b1.bookPrice = 24000;
		
		Book b2 = new Book();
		
		b2.bookName = "powerjava";
		b2.bookAuthor = "천인국";
		b2.bookPublisher = "인피니티";
		b2.bookPrice = 35000;
		
		Book b3 = new Book();
		
		b3.bookName = "재밌는 Java";
		b3.bookAuthor = "이호준";
		b3.bookPublisher = "인피니티";
		b3.bookPrice = 20000;
		
		Book[] books = {b1, b2, b3};
		//신용권 혼공자
		for(int i=0; i<books.length; i++)
		{
			if(books[i].bookAuthor.equals("신용권"))
			{
				System.out.println("책 제목 : " + books[i].bookName);
				//System.out.println("책 저자 : " + books[i].bookAuthor);
				//System.out.println("책 가격 : " + books[i].bookPrice);
				System.out.println("=================================");
			}
		}
	}
}
