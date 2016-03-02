package br.com.fcv.javafx.juniormiqueletti.controller;

import br.com.fcv.javafx.juniormiqueletti.model.Contato;
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

import java.net.URL;
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

        String data = dpDataNasc.getValue().format(DateTimeFormatter.ISO_DATE);

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
                        data,
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
                "18/02/1987",
                883));

        dados.add(new Contato("Ninja da Escuridao",
                "(44)9999-9999",
                "Maringa",
                "PR",
                "juniormiqueletti@gmail.com",
                "Dados Iniciais2",
                "Masculino",
                "18/02/1987",
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

      /*  tfPesquisar.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                dadosFiltrados.setPredicate(p-> p.getNome().contains(newValue)
                                                ||  p.getEmail().contains(newValue)
                                                ||  p.getTelefone().contains(newValue));
            }
        });*/

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

       /* tvContatos.selectionModelProperty().addListener(new ChangeListener<TableView.TableViewSelectionModel<Contato>>() {
            @Override
            public void changed(ObservableValue<? extends TableView.TableViewSelectionModel<Contato>> observable, TableView.TableViewSelectionModel<Contato> oldValue, TableView.TableViewSelectionModel<Contato> newValue) {
                tfNome.setText(newValue.getSelectedItem().getNome());
                tfEmail.setText(newValue.getSelectedItem().getEmail());
                tfTelefone.setText(newValue.getSelectedItem().getTelefone());
                tfNumero.setText(newValue.getSelectedItem().getNumero() + "");
                tfObersavao.setText(newValue.getSelectedItem().getObservacao());
                tfMunicipio.setText(newValue.getSelectedItem().getMunicipio());
            }
        });*/


        tvContatos.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            tfNome.setText(newValue.getNome());
            tfEmail.setText(newValue.getEmail());
            tfTelefone.setText(newValue.getTelefone());
            tfNumero.setText(String.valueOf(newValue.getNumero()));
            taObservacao.setText(newValue.getObservacao());
            tfMunicipio.setText(newValue.getMunicipio());

        });
    }


}
