package lk.ijse.d24.hostel.controller;

/*
    @author THINUX
    @created 06-Apr-23 - 12:37 
*/

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.d24.hostel.bo.BOFactory;
import lk.ijse.d24.hostel.bo.custom.StudentBO;
import lk.ijse.d24.hostel.model.StudentDTO;

import java.sql.Date;
import java.util.ArrayList;

public class StudentFormController {

    public AnchorPane pane;
    public JFXTextField txtName;
    public JFXTextField txtAddress;
    public JFXTextField txtContact;
    public JFXTextField txtSearch;
    public TableView<StudentDTO> tblStudent;
    public TableColumn colSID;
    public TableColumn colName;
    public TableColumn colAddress;
    public TableColumn colContact;
    public TableColumn colDOB;
    public TableColumn colGender;
    public Label lblAddress;
    public Label lblContact;
    public JFXTextField txtDOB;
    public Label lblDOB;
    public JFXTextField txtGender;
    public Label lblGender;
    public Label lblName;
    public JFXButton btnAdd;
    public JFXButton btnDelete;
    public JFXButton btnUpdate;
    public Label lblSid;
    public Label lblSID;

    StudentBO studentBO = (StudentBO) BOFactory.getBoFactory().getBOTypes(BOFactory.BOTypes.STUDENT);

    public  void initialize() throws Exception {
        colSID.setCellValueFactory(new PropertyValueFactory<>("sId"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colContact.setCellValueFactory(new PropertyValueFactory<>("contact"));
        colDOB.setCellValueFactory(new PropertyValueFactory<>("dOB"));
        colGender.setCellValueFactory(new PropertyValueFactory<>("gender"));

        tblStudent.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            btnDelete.setDisable(newValue == null);
            btnAdd.setDisable(newValue == null);

            if (newValue != null) {
                lblSid.setText(newValue.getsId());
                txtName.setText(newValue.getName());
                txtAddress.setText(newValue.getAddress());
                txtContact.setText(String.valueOf(newValue.getContact()));
                txtDOB.setText(String.valueOf(newValue.getdOB()));
                txtGender.setText(String.valueOf(newValue.getGender()));
            }
        });

        loadAllStudent();
//        lblSid.setText(generateNewID());
    }

    private void loadAllStudent() {
        try {
            ArrayList<StudentDTO> allStudent = (ArrayList<StudentDTO>) studentBO.getAllStudents();
            System.out.println(allStudent);

            for (StudentDTO studentDTO : allStudent) {
                tblStudent.getItems().add(new StudentDTO(
                        studentDTO.getsId(),
                        studentDTO.getName(),
                        studentDTO.getAddress(),
                        studentDTO.getContact(),
                        studentDTO.getdOB(),
                        studentDTO.getGender())
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addOnAction(javafx.event.ActionEvent actionEvent) throws Exception {
        String id = lblSid.getText();
        String name = txtName.getText();
        String address = txtAddress.getText();
        String contact = txtContact.getText();
        Date dOB = Date.valueOf(txtDOB.getText());
        String gender = txtGender.getText();

        try {
            StudentDTO studentDTO = new StudentDTO(id, name, address, contact, dOB, gender);

            studentBO.saveStudent(studentDTO);
            tblStudent.getItems().add(studentDTO);

            clearData();
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
            e.printStackTrace();
        }
    }

    public void updateOnAction(javafx.event.ActionEvent actionEvent) {

    }

    public void deleteOnAction(javafx.event.ActionEvent actionEvent) {

    }

    public void txtIIDKeyTypeOnAction(javafx.scene.input.KeyEvent keyEvent) {

    }

    public void txtUnitPriceKeyTypeOnAction(javafx.scene.input.KeyEvent keyEvent) {

    }

    public void txtQtyOnHandKeyTypeOnAction(javafx.scene.input.KeyEvent keyEvent) {

    }

    private String generateNewID() throws Exception {
        try {
            return studentBO.generateNewId();
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Failed to generate the new ID " + e.getMessage()).show();
            e.printStackTrace();
        }
        return "S00-001";
    }

    private void clearData() {
        txtName.clear();
        txtAddress.clear();
        txtContact.clear();
        txtDOB.clear();
        txtGender.clear();
    }
}
