// 2.2.6
import javax.swing.JOptionPane;
public class GiaiPT{
    public static void main(String[] args) {
        String option;
        option=JOptionPane.showInputDialog(null,
            "1. Giai phuong trinh bac nhat (ax+b=0)" +
            "\n2. Giai he phuong trinh 2 an"+
            "\n3. Giai phuong trinh bac hai"+
            "\nChon loai phuong trinh: ", "Chon phuong trinh",
            JOptionPane.INFORMATION_MESSAGE
        );
        
        int choice = Integer.parseInt(option);

        switch(choice){
            case 1:{
                double a = Double.parseDouble(JOptionPane.showInputDialog("Nhap a:"));
                double b = Double.parseDouble(JOptionPane.showInputDialog("Nhap b:"));
                if (a == 0.0){
                    if(b == 0.0){
                        JOptionPane.showMessageDialog(null, "Vo so nghiem");
                    }
                    else {
                        JOptionPane.showMessageDialog(null,"Vo nghiem");
                    }
                }
                else{
                    double x = -b/a;
                    JOptionPane.showMessageDialog(null,"Ket qua la x= "+x, "Ket qua", JOptionPane.INFORMATION_MESSAGE);
                }
                break;
            }
            case 2:{
                double a11 = Double.parseDouble(JOptionPane.showInputDialog("Nhap a11:"));
                double a12 = Double.parseDouble(JOptionPane.showInputDialog("Nhap a12:"));
                double b1  = Double.parseDouble(JOptionPane.showInputDialog("Nhap b1:"));

                double a21 = Double.parseDouble(JOptionPane.showInputDialog("Nhap a21:"));
                double a22 = Double.parseDouble(JOptionPane.showInputDialog("Nhap a22:"));
                double b2  = Double.parseDouble(JOptionPane.showInputDialog("Nhap b2:"));

                double D = a11*a22 - a12*a21;
                double D1 = b1*a22 - a12*b2;
                double D2 = a11*b2 - b1*a21;

                if(D!=0){
                    double x1 = D1/D;
                    double x2 = D2/D;
                    JOptionPane.showMessageDialog(null,"He co nghiem duy nhat:\nx1= "+x1+"\nx2= "+x2,"Ket qua", JOptionPane.INFORMATION_MESSAGE);
                }
                else{
                    if (D1 == 0 && D2 == 0){
                        JOptionPane.showMessageDialog(null, "He vo so nghiem");
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "He vo nghiem");
                    }
                }
                break;
            }
            case 3:{
                double a = Double.parseDouble(JOptionPane.showInputDialog("Nhap a:"));
                double b = Double.parseDouble(JOptionPane.showInputDialog("Nhap b:"));
                double c = Double.parseDouble(JOptionPane.showInputDialog("Nhap c:"));
                if(a == 0){
                    if (b == 0.0){
                        if(c == 0.0){
                            JOptionPane.showMessageDialog(null, "Vo so nghiem");
                        }
                        else {
                            JOptionPane.showMessageDialog(null,"Vo nghiem");
                        }
                    }
                    else{
                        double x = -c/b;
                        JOptionPane.showMessageDialog(null,"Ket qua la x= "+x, "Ket qua", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
                else{
                    double delta = b*b - 4*a*c;
                    if (delta > 0){
                        double x1 = (-b + Math.sqrt(delta))/ (2*a);
                        double x2 = (-b - Math.sqrt(delta))/ (2*a);
                        JOptionPane.showMessageDialog(null,
                            "Hai nghiem phan biet:\nx1= "+x1+"\nx2= "+x2,
                            "Ket qua", JOptionPane.INFORMATION_MESSAGE
                        );
                    }
                    else{
                        if (delta == 0){
                            double x = -b / (2*a);
                            JOptionPane.showMessageDialog(null,
                            "Nghiem kep x= "+x,
                            "Ket qua", JOptionPane.INFORMATION_MESSAGE
                            );
                        }
                        else{
                            JOptionPane.showMessageDialog(null,
                            "Vo nghiem",
                            "Ket qua", JOptionPane.INFORMATION_MESSAGE
                            );
                        }
                    }
                }
                break;
            }
            default:
                JOptionPane.showMessageDialog(null, "Khong hop le!");
        }  
    }
}