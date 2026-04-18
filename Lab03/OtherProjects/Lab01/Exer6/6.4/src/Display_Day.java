import java.util.Scanner;

public class Display_Day {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String Month;
		int year;
		int month = 0;
		// Month Input
		do {
			System.out.print("Nhap thang: ");
			Month = sc.nextLine().trim();
			switch(Month){
				case "January": case "Jan": case "Jan.": case "1":
					month = 1; break;
				case "February": case "Feb": case "Feb.": case "2":
					month = 2; break;
				case "March": case "Mar": case "Mar.": case "3":
					month = 3; break;
				case "April": case "Apr": case "Apr.": case "4":
					month = 4; break;
				case "May": case "5":
					month = 5; break;
				case "June": case "Jun": case "Jun.": case "6":
					month = 6; break;
				case "July": case "Jul": case "Jul.": case "7":
					month = 7; break;
				case "August": case "Aug": case "Aug.": case "8":
					month = 8; break;
				case "September": case "Sep": case "Sept.": case "9":
					month = 9; break;
		        case "October": case "Oct": case "Oct.": case "10":
		            month = 10; break;
		        case "November": case "Nov": case "Nov.": case "11":
		            month = 11; break;
		        case "December": case "Dec": case "Dec.": case "12":
		            month = 12; break;
		        default:
		            System.out.println("Khong hop le, yeu cau nhap lai!");
		            month = 0;
			}
		} while (month == 0);
		
		// Nhap nam 
		do {
            System.out.print("Nhap nam: ");
            while (!sc.hasNextInt()) {
                System.out.println("Nam khong hop le!");
                sc.next();
                System.out.print("Yeu cau nhap lai nam: ");
            }
            year = sc.nextInt();

            if (year < 0) {
                System.out.println("Nam khong hop le!");
            }
        } while (year < 0);
		
		boolean isLY = false;
		if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
            isLY = true;
        }
		
		// Tinh ngay
		int day = 0;
		switch (month) {
			case 1: case 3: case 5: case 7: case 8: case 10: case 12:
				day =31; break;
			case 4: case 6: case 9: case 11:
				day =30; break;
			case 2:
				if(isLY) day =29;
				else day =28;
				break;
		}
		System.out.println("Thang "+month+" nam "+year+" co "+day+" ngay.");
	}
}
