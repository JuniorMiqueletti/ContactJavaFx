package br.com.fcv.javafx.juniormiqueletti.model;

import javafx.beans.property.*;

import java.time.LocalDate;

/**
 * Created by Junior-Pc on 25/02/2016.
 */
public class Contato {

    StringProperty nome, telefone, municipio, email, observacao, sexo,  estado;
    IntegerProperty numero;
  ObjectProperty <LocalDate> dataNascimento;

    public Contato(String nome, String telefone, String municipio,String estado, String email, String observacao, String sexo, LocalDate dataNascimento, Integer numero) {
        this.nome = new SimpleStringProperty(nome);
        this.telefone = new SimpleStringProperty(telefone);
        this.municipio = new SimpleStringProperty(municipio);
        this.estado = new SimpleStringProperty(estado);
        this.email = new SimpleStringProperty(email);
        this.observacao = new SimpleStringProperty(observacao);
        this.sexo = new SimpleStringProperty(sexo);
        this.dataNascimento = new SimpleObjectProperty(dataNascimento);
        this.numero = new SimpleIntegerProperty(numero);
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento.set(dataNascimento);
    }

    public LocalDate getDataNascimento() {
        return dataNascimento.get();
    }

    public ObjectProperty<LocalDate> dataNascimentoProperty() {
        return dataNascimento;
    }

    public StringProperty nomeProperty() {
        return nome;
    }

    public StringProperty telefoneProperty() {
        return telefone;
    }

    public StringProperty municipioProperty() {
        return municipio;
    }

    public StringProperty estadoProperty() {
        return estado;
    }
    public StringProperty emailProperty() {
        return email;
    }

    public StringProperty observacaoProperty() {
        return observacao;
    }

    public StringProperty sexoProperty() {
        return sexo;
    }

    public IntegerProperty numeroProperty() {
        return numero;
    }

    public String getNome() {
        return nome.get();
    }

    public void setNome(String nome) {
        this.nome.set(nome);
    }

    public String getTelefone() {
        return telefone.get();
    }

    public void setTelefone(String telefone) {
        this.telefone.set(telefone);
    }

    public String getMunicipio() {
        return municipio.get();
    }

    public void setMunicipio(String municipio) {
        this.municipio.set(municipio);
    }
    public String getEstado() {
        return estado.get();
    }

    public void setEstado(String estado) {
        this.estado.set(estado);
    }
    public String getEmail() {
        return email.get();
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public String getObservacao() {
        return observacao.get();
    }

    public void setObservacao(String observacao) {
        this.observacao.set(observacao);
    }

    public String getSexo() {
        return sexo.get();
    }

    public void setSexo(String sexo) {
        this.sexo.set(sexo);
    }

    public int getNumero() {
        return numero.get();
    }

    public void setNumero(int numero) {
        this.numero.set(numero);
    }
}
