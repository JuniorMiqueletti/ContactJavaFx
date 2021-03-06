package br.com.fcv.javafx.juniormiqueletti.controller;

import br.com.fcv.javafx.juniormiqueletti.model.Contato;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.StringConverter;

import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.ResourceBundle;

public class ContatoController implements Initializable {


    ObservableList<Contato> dados;

    FilteredList<Contato> dadosFiltrados;

    SortedList<Contato> dadosOrdenados;

    @FXML
    private TableView<Contato> tvContatos;
    @FXML
    private TableColumn<Contato, String> tcNome;

    @FXML
    private TableColumn<Contato, String> tcTelefone;
    @FXML
    private TableColumn<Contato, String> tcEmail;

    @FXML
    private TableColumn<Contato, String> tcDataNasc;

    @FXML
    private TextField tfNome;

    @FXML
    private DatePicker dpDataNasc;

    @FXML
    private TextField tfEndereco;

    @FXML
    private TextField tfNumero;

    @FXML
    private TextField tfMunicipio;

    @FXML
    private ComboBox<String> cbEstado;

    @FXML
    private TextField tfTelefone;

    @FXML
    private TextField tfEmail;

    @FXML
    private TextArea taObservacao;

    @FXML
    private RadioButton rbMasculino;

    @FXML
    private ToggleGroup tgSexo;

    @FXML
    private RadioButton rbFeminino;

    @FXML
    private TextField tfPesquisar;

    public ContatoController() {
        dados = FXCollections.observableArrayList();
    }

    @FXML
    void novoAction(ActionEvent event) {

        VBox root = new VBox();
        Scene scene = new Scene(root,300,200);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Titulo do novo cenario");
        stage.show();

        limparCampos();
    }

    private void limparCampos() {
        tfNome.clear();
        tfEmail.clear();
        tfEndereco.clear();
        tfMunicipio.clear();
        tfNumero.clear();
        tfTelefone.clear();
        taObservacao.clear();
        cbEstado.getSelectionModel().select(0);
    }

    @FXML
    void removerAction(ActionEvent event) {
        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
        alerta.setHeaderText("Atenção");
        alerta.setContentText("Tem certeza que quer remover este registro ?");

        Optional<ButtonType> resultado = alerta.showAndWait();
        if(resultado.get()==ButtonType.OK){
            dados.remove(tvContatos.getSelectionModel().getSelectedItem());
        }

    }

    @FXML
    void salvarAction(ActionEvent event) {

        String sexo = new String();
        sexo = rbMasculino.isSelected() ? "M" : "F";

        int numero = 0;

        numero = tfNumero.getText().length() > 0 ? Integer.valueOf(tfNumero.getText()) : numero;

                dados.add(new Contato(
                        tfNome.getText(),
                        tfTelefone.getText(),
                        tfMunicipio.getText(),
                        cbEstado.getSelectionModel().getSelectedItem(),
                        tfEmail.getText(),
                        taObservacao.getText(),
                        sexo,
                        dpDataNasc.getValue(),
                        numero)
                );

        limparCampos();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        dados.add(new Contato("Junior Miqueletti",
                "(44)9998-6889",
                "Maringa",
                "PR",
                "juniormiqueletti@gmail.com",
                "Dados Iniciais",
                "Masculino",
                LocalDate.of(1987, Month.FEBRUARY,18),
                883));

        dados.add(new Contato("Ninja da Escuridao",
                "(44)9999-9999",
                "Maringa",
                "PR",
                "juniormiqueletti@gmail.com",
                "Dados Iniciais2",
                "Masculino",
                LocalDate.of(1987, Month.FEBRUARY,18),
                883));


        tcNome.setCellValueFactory(c -> c.getValue().nomeProperty());
        tcTelefone.setCellValueFactory(c -> c.getValue().telefoneProperty());
        tcEmail.setCellValueFactory(c -> c.getValue().emailProperty());

        dadosFiltrados = new FilteredList<Contato>(dados);

        dadosOrdenados = new SortedList<>(dadosFiltrados);

        tfPesquisar.textProperty().addListener((observable, oldValue, newValue) -> {
            dadosFiltrados.setPredicate(p-> p.getNome().contains(newValue)
                    ||  p.getEmail().contains(newValue)
                    ||  p.getTelefone().contains(newValue));
        });

        tcDataNasc.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Contato, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Contato, String> param) {
                return new SimpleStringProperty(param.getValue().getDataNascimento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            }
        });

        tvContatos.setItems(dadosOrdenados);

        cbEstado.getItems().add("PR");
        cbEstado.getItems().add("RS");
        cbEstado.getItems().add("SP");
        cbEstado.getItems().add("RJ");
        cbEstado.getItems().add("MG");
        cbEstado.getItems().add("PA");
        cbEstado.getItems().add("SE");
        cbEstado.getItems().add("PE");
        cbEstado.getItems().add("AC");
        cbEstado.getItems().add("AL");
        cbEstado.getItems().add("GO");
        cbEstado.getItems().add("TO");

        tvContatos.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            tfNome.setText(newValue.getNome());
            tfEmail.setText(newValue.getEmail());
            tfTelefone.setText(newValue.getTelefone());
            tfNumero.setText(String.valueOf(newValue.getNumero()));
            taObservacao.setText(newValue.getObservacao());
            tfMunicipio.setText(newValue.getMunicipio());

        });

        tfNumero.setTextFormatter(new TextFormatter<Integer>(new StringConverter<Integer>() {
            @Override
            public String toString(Integer object) {
                if (object !=null){
                    return object.toString();
                }else{
                    return "";
                }
            }

            @Override
            public Integer fromString(String string) {
                if(string.length()>0){
                    return Integer.parseInt(string);
                }else{
                    return null;
                }
            }
        }));
    }


}
