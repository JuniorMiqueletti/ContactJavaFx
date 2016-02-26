package br.com.fcv.javafx.juniormiqueletti.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class ContatoController {

    @FXML
    private TableView<?> tvContatos;

    @FXML
    private TextField tfNome;

    @FXML
    private DatePicker dtDataNascimento;

    @FXML
    private TextField tfEndereco;

    @FXML
    private TextField tfNumero;

    @FXML
    private TextField tfMunicipio;

    @FXML
    private ComboBox<?> cbEstado;

    @FXML
    private TextField tfTelefone;

    @FXML
    private TextField tfEmail;

    @FXML
    private TextArea tfObersavao;

    @FXML
    private RadioButton rbMasculino;

    @FXML
    private ToggleGroup tgSexo;

    @FXML
    private RadioButton rbFeminino;

    @FXML
    void novoAction(ActionEvent event) {

    }

    @FXML
    void removeAction(ActionEvent event) {

    }

    @FXML
    void salvarAction(ActionEvent event) {

    }

}
