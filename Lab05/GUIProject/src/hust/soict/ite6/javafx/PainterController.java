package hust.soict.ite6.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController{

    @FXML
    private Pane drawingAreaPane;

    @FXML
    private RadioButton penRadioButton;

    @FXML
    private RadioButton eraserRadioButton;

    @FXML
    void clearButtonPressed(ActionEvent event) {
        // Xóa sạch toàn bộ các nét vẽ trên bảng trắng
        drawingAreaPane.getChildren().clear();
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
        // Tạo một vòng tròn nhỏ (bán kính bằng 4) ngay tại vị trí con trỏ chuột di qua
        Circle newCircle = new Circle(event.getX(), event.getY(), 4);

        // Kiểm tra chế độ bút vẽ hoặc tẩy để gán màu
        if (penRadioButton.isSelected()) {
            newCircle.setFill(Color.BLACK); // Pen -> Vẽ màu đen
        } else if (eraserRadioButton.isSelected()) {
            newCircle.setFill(Color.WHITE); // Eraser -> Đè màu trắng lên nền trắng
        }

        // Thêm hình tròn vừa tạo vào vùng vẽ
        drawingAreaPane.getChildren().add(newCircle);
    }
}