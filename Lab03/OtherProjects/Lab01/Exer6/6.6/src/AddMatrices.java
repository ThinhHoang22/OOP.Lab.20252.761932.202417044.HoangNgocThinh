import java.util.Scanner;
public class AddMatrices {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap kich co ma tran");
		System.out.print("Nhap so hang cua ma tran: ");
		int h = sc.nextInt();
		System.out.print("Nhap so cot cua ma tran: ");
		int c = sc.nextInt();
		int [][] arr1 = new int[h][c];
		int [][] arr2 = new int[h][c];
		
		// Nhap du lieu ma tran 1
		System.out.println("Nhap du lieu ma tran 1 ");
		for (int i = 0 ; i < h ; i++) {
			for (int j = 0; j < c ; j++) {
				arr1[i][j] = sc.nextInt();
			}
		}
		
		// Nhap du lieu ma tran 2
		System.out.println("Nhap du lieu ma tran 2 ");
		for (int i = 0 ; i < h ; i++) {
			for (int j = 0; j < c ; j++) {
				arr2[i][j] = sc.nextInt();
			}
		}
		
		int [][] sum = new int [h][c];
		// Tinh tong
		System.out.println("Tong cua hai ma tran la: ");
		for (int i = 0 ; i < h ; i++) {
			for (int j = 0; j < c ; j++) {
				sum[i][j] = arr1[i][j] + arr2[i][j];
				System.out.print(sum[i][j] + " ");
			}
			System.out.println();
		}
	}
}
