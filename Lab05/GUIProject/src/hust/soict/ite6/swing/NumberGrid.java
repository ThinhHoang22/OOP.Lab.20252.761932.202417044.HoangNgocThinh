package hust.soict.ite6.swing;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class NumberGrid extends JFrame {
    private JButton[] btnNumbers = new JButton[10];
    private JButton btnDelete, btnReset;
    private JTextField tfDisplay;

    // --- CONSTRUCTOR ---
    public NumberGrid() {
        tfDisplay = new JTextField();
        tfDisplay.setComponentOrientation(
                ComponentOrientation.RIGHT_TO_LEFT);

        JPanel panelButtons = new JPanel(new GridLayout(4, 3));
        addButtons(panelButtons);

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(tfDisplay, BorderLayout.NORTH);
        cp.add(panelButtons, BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Number Grid");
        setSize(200, 200);
        setVisible(true);
    }

    public static void main(String[] args) {
        new NumberGrid();
    }

    // --- ADD BUTTONS METHOD ---
    private void addButtons(JPanel panelButtons) {
        ButtonListener listener = new ButtonListener();
        for (int i = 1; i <= 9; i++) {
            btnNumbers[i] = new JButton("" + i);
            panelButtons.add(btnNumbers[i]);
            btnNumbers[i].addActionListener(listener);
        }

        btnDelete = new JButton("DEL");
        panelButtons.add(btnDelete);
        btnDelete.addActionListener(listener);

        btnNumbers[0] = new JButton("0");
        panelButtons.add(btnNumbers[0]);
        btnNumbers[0].addActionListener(listener);

        btnReset = new JButton("C");
        panelButtons.add(btnReset);
        btnReset.addActionListener(listener);
    }

    // --- INNER CLASS BUTTON LISTENER ---
    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evt) {
            String buttonLabel = evt.getActionCommand();

            // TH1: Nếu là nút số 
            if (buttonLabel.charAt(0) >= '0' && buttonLabel.charAt(0) <= '9') {
                tfDisplay.setText(tfDisplay.getText() + buttonLabel);
            }
            // TH2: Nếu là nút DEL 
            else if (buttonLabel.equals("DEL")) {
                String currentText = tfDisplay.getText();
                if (currentText.length() > 0) {
                    tfDisplay.setText(currentText.substring(0, currentText.length() - 1));  // Cắt bỏ ký tự cuối cùng của chuỗi hiện tại
                }
            }
            // Trường hợp 3: Nếu là nút C 
            else if (buttonLabel.equals("C")) {
                tfDisplay.setText(""); // Xóa sạch màn hình hiển thị
            }
        }
    }
}