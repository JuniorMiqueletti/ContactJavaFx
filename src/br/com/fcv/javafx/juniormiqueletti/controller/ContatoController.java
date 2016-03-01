package br.com.fcv.javafx.juniormiqueletti.controller;

import br.com.fcv.javafx.juniormiqueletti.model.Contato;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;

import java.net.URL;
import java.util.ResourceBundle;

public class ContatoController implements Initializable {


    ObservableList<Contato> dados;

    @FXML
    private TableView<Contato> tvContatos;
    @FXML
    private TableColumn<Contato,String> tcNome;

    @FXML
    private TableColumn<Contato,String>  tcTelefone;
    @FXML
    private TableColumn<Contato,String>  tcEmail;

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
    void removerAction(ActionEvent event) {

    }

    @FXML
    void salvarAction(ActionEvent event) {

    }

    public ContatoController() {
        dados = FXCollections.observableArrayList();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        dados.add(new Contato("Junior Miqueletti",
                "(44)9998-6889",
                "Maringa",
                "juniormiqueletti@gmail.com",
                "Dados Iniciais",
                "Masculino",
                "18/02/1987",
                883));

        dados.add(new Contato("Ninja da Escuridao",
                "(44)9999-9999",
                "Maringa",
                "juniormiqueletti@gmail.com",
                "Dados Iniciais",
                "Masculino",
                "18/02/1987",
                883));


        tcNome.setCellValueFactory(c -> c.getValue().nomeProperty());
        tcTelefone.setCellValueFactory(c -> c.getValue().telefoneProperty());
        tcEmail.setCellValueFactory(c -> c.getValue().emailProperty());

        tvContatos.setItems(dados);

    }
}
