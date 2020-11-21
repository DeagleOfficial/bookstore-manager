import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;

public class MainSystem extends Book {
	static Scanner Sc = new Scanner(System.in);

	static Book bookList[] = new Book[30];
	static ManipulateExcelFile obj = new ManipulateExcelFile();

	public static void checkAvailability(String sBook) {
		try {
			int flag = 0;

			for (int i = 0; i < (bookList.length); i++) {
				if (null != bookList[i] && null != bookList[i].bookName && null != sBook) {
					if ((bookList[i].bookName).equalsIgnoreCase(sBook)) {
						flag++;
						break;
					}
				}

			}

			if (flag == 1)
				System.out.println("This Book is Available");

			else
				System.out.println("This Book is Not Available");
		} catch (Exception e) {
			System.out.println();
		}
	}

	public static void buyBook() throws BiffException, WriteException, IOException {
		System.out.println("Enter the srl.no of the book");
		int rowNo = Sc.nextInt();

		if (rowNo <= 30) {
			obj.deleteRecord(rowNo - 1);

			System.out.println("Your Transaction was successful");
		} else {
			System.out.println("Sorry, this Srl. no.is invalid.");
		}
	}

	public static void main(String[] args) throws BiffException, IOException, WriteException, NullPointerException {
		obj.readExcel();

		System.out.println(
				"*****************************************************************************************************************");
		System.out.println("WELCOME TO BOOKSTORE MANAGER");
		System.out.println(
				"*****************************************************************************************************************");
		System.out.println();

		System.out.println("a.Check availability of a book");
		System.out.println("b.View Book Details");
		System.out.println("c.View all Books in the Store");
		System.out.println("d.Buy a book");
		System.out.println();
		System.out.println("Enter your choice");

		char choice = Sc.next().charAt(0);

		switch (choice) {
		case 'a': {

			System.out.println("Enter the name of the book");
			BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
			String sBook = bufferRead.readLine();
			checkAvailability(sBook);
			break;
		}

		case 'b': {
			try {

				System.out.println("Enter the Srl.no. of a book");
				int rowNo = Sc.nextInt();

				bookList[rowNo - 1].display();
				break;
			} catch (Exception e) {
				System.out.println("THE BOOK DOES NOT EXIST");
			}
			break;
		}

		case 'd': {
			buyBook();
			break;
		}

		case 'c': {
			try {

				System.out.println("BOOKS AVAILABLE: " + "\t");
				for (int i = 0; i < 30; i++) {
					System.out.println((i + 1) + ". " + bookList[i].bookName);
				}
			} catch (NullPointerException e) {
				System.out.println();

			}
			break;
		}

		default:
			System.out.println("WRONG INPUT!");
			break;
		}
	}

}
