package lk.ijse.d24.hostel.controller;

/*
    @author THINUX
    @created 06-Apr-23 - 12:37 
*/

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.d24.hostel.bo.BOFactory;
import lk.ijse.d24.hostel.bo.custom.StudentBO;
import lk.ijse.d24.hostel.model.StudentDTO;

import javax.swing.text.html.Option;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    public JFXTextField txtGender;
    public Label lblName;
    public JFXButton btnAdd;
    public JFXButton btnDelete;
    public JFXButton btnUpdate;
    public Label lblSid;
    public DatePicker dateDOB;
    public ComboBox<String> cmbGender;

    private Matcher nameMatcher;
    private Matcher contactMatcher;

    StudentBO studentBO = (StudentBO) BOFactory.getBoFactory().getBOTypes(BOFactory.BOTypes.STUDENT);

    public void initialize() throws Exception {
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

                if (newValue.getGender().equals("Male")) {
                    setCmbGender();
                    cmbGender.getSelectionModel().select(0);
                } else {
                    cmbGender.getSelectionModel().select(1);
                }
            }
        });

        lblSid.setText(generateNewID());
//        loadAllStudent();
        setCmbGender();
    }

    private void loadAllStudent() {
        try {
            ArrayList<StudentDTO> allStudent = (ArrayList<StudentDTO>) studentBO.getAllStudents();

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
        Date dOB = Date.valueOf(dateDOB.getValue());
        String gender = cmbGender.getSelectionModel().getSelectedItem();

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
        String id = lblSid.getText();
        String name = txtName.getText();
        String address = txtAddress.getText();
        String contact = txtContact.getText();
        Date dOB = Date.valueOf(dateDOB.getValue());
        String gender = cmbGender.getSelectionModel().getSelectedItem();

        try {
            StudentDTO studentDTO = new StudentDTO(id, name, address, contact, dOB, gender);

            studentBO.updateStudent(studentDTO);
            tblStudent.getItems().add(studentDTO);

            clearData();

        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
            e.printStackTrace();
        }
    }

    public void deleteOnAction(javafx.event.ActionEvent actionEvent) throws Exception {
        StudentDTO studentDTO = tblStudent.getSelectionModel().getSelectedItem();

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to delete this Student?", ButtonType.YES, ButtonType.NO);
        Optional<ButtonType> buttonType = alert.showAndWait();
        if (buttonType.get() == ButtonType.YES) {
            try {
                studentBO.deleteStudent(studentDTO);
                tblStudent.getItems().remove(studentDTO);
                tblStudent.getSelectionModel().clearSelection();

                clearData();

            } catch (Exception e) {
                new Alert(Alert.AlertType.ERROR, "Failed to delete room: " + e.getMessage()).show();
                e.printStackTrace();
            }
        }
    }


    private String generateNewID() throws Exception {
        try {
            return studentBO.generateNewStudentId();
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

    private void setCmbGender() {
        ArrayList<String> gender = new ArrayList<>();
        gender.add("Male");
        gender.add("Female");

        ObservableList<String> observableList = FXCollections.observableList(gender);
        cmbGender.setItems(observableList);

    }

    public void txtNameKeyTypeOnAction(KeyEvent keyEvent) {
        lblName.setText("");

        Pattern namePattern = Pattern.compile(".*[a-zA-Z0-9]{4,}");
        nameMatcher = namePattern.matcher(txtName.getText());

        if (!nameMatcher.matches()) {
            txtName.requestFocus();
            lblName.setText("Invalid Name");
        }
    }

    public void txtAddressKeyTypeOnAction(KeyEvent keyEvent) {
        lblAddress.setText("");

        Pattern namePattern = Pattern.compile(".*[a-zA-Z0-9]{4,}");
        nameMatcher = namePattern.matcher(txtAddress.getText());

        if (!nameMatcher.matches()) {
            txtAddress.requestFocus();
            lblAddress.setText("Invalid Name");
        }
    }

    public void txtContactKeyTypeOnAction(KeyEvent keyEvent) {
        lblContact.setText("");

        Pattern contactPattern = Pattern.compile(".*(?:7|0|(?:\\\\+94))[0-9]{9,10}");
        contactMatcher = contactPattern.matcher(txtContact.getText());

        if (!contactMatcher.matches()) {
            txtContact.requestFocus();
            lblContact.setText("Invalid Name");
        }
    }
}
