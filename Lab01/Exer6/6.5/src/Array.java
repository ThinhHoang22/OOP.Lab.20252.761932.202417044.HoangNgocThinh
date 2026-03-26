import java.util.Scanner;
import java.util.Arrays;

public class Array {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so phan tu: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        // Nhap mang
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Sap xep
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        // Sau khi sap xep
        System.out.print("Mang sau khi sap xep: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        // SUM
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }

        // AVG
        double avg = (double) sum / n;

        // In kết quả
        System.out.println("Tong = " + sum);
        System.out.println("Trung binh = " + avg);
    }
}