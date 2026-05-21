// 2.2.5: Viết chương trình tính tổng, hiệu, tích và thương của hai số thực (double) do người dùng nhập vào.
import javax.swing.JOptionPane;
public class Calculate2Number{
    public static void main(String[] args) {
        String strNum1, strNum2;
        strNum1=JOptionPane.showInputDialog(null,
            "Enter the first number: ", "First number",
            JOptionPane.INFORMATION_MESSAGE
        );
        
        double num1= Double.parseDouble(strNum1);

        strNum2=JOptionPane.showInputDialog(null,
            "Enter the second number: ", "Second number",
            JOptionPane.INFORMATION_MESSAGE
        );

        double num2= Double.parseDouble(strNum2);

        double sum=num1+num2;
        double diff=num1-num2;
        double product=num1*num2;
        String result;

        if(num2!=0){
            double quotient=num1/num2;
            result= "Sum: "+sum+"\nDifference: "+diff+"\nProduct: "+product+"\nQuotient:"+quotient;
        }
        else {
            result= "Sum: "+sum+"\nDifference: "+diff+"\nProduct: "+product+"\nKhong the thuc hien phep chia";
        }
        
        JOptionPane.showMessageDialog(null, result,
            "Calculating Result", JOptionPane.INFORMATION_MESSAGE
        );
        System.exit(0);
    }
}