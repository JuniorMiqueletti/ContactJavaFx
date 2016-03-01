package br.com.fcv.javafx.juniormiqueletti.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by Junior-Pc on 25/02/2016.
 */
public class Contato {

    StringProperty nome, telefone, municipio, email, observacao, sexo, dataNascimento;
    IntegerProperty numero;

    public Contato(String nome, String telefone, String municipio, String email, String observacao, String sexo, String dataNascimento, Integer numero) {
        this.nome = new SimpleStringProperty(nome);
        this.telefone = new SimpleStringProperty(telefone);
        this.municipio = new SimpleStringProperty(municipio);
        this.email = new SimpleStringProperty(email);
        this.observacao = new SimpleStringProperty(observacao);
        this.sexo = new SimpleStringProperty(sexo);
        this.dataNascimento = new SimpleStringProperty(dataNascimento);
        this.numero = new SimpleIntegerProperty(numero);
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

    public StringProperty emailProperty() {
        return email;
    }

    public StringProperty observacaoProperty() {
        return observacao;
    }

    public StringProperty sexoProperty() {
        return sexo;
    }

    public StringProperty dataNascProperty() {
        return dataNascimento;
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

    public String getDataNascimento() {
        return dataNascimento.get();
    }

    public StringProperty dataNascimentoProperty() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento.set(dataNascimento);
    }

    public int getNumero() {
        return numero.get();
    }

    public void setNumero(int numero) {
        this.numero.set(numero);
    }
}
