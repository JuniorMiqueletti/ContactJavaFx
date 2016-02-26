package br.com.fcv.javafx.juniormiqueletti.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by Junior-Pc on 25/02/2016.
 */
public class Contato {

    StringProperty nomeProperty, telefoneProperty, municipioProperty, emailProperty, observacaoProperty, sexoProperty, dataNascimentoProperty;
    IntegerProperty numeroProperty;

    public String getNomeProperty() {
        return nomeProperty.get();
    }

    public StringProperty nomePropertyProperty() {
        return nomeProperty;
    }

    public void setNomeProperty(String nomeProperty) {
        this.nomeProperty.set(nomeProperty);
    }

    public String getTelefoneProperty() {
        return telefoneProperty.get();
    }

    public StringProperty telefonePropertyProperty() {
        return telefoneProperty;
    }

    public void setTelefoneProperty(String telefoneProperty) {
        this.telefoneProperty.set(telefoneProperty);
    }

    public String getMunicipioProperty() {
        return municipioProperty.get();
    }

    public StringProperty municipioPropertyProperty() {
        return municipioProperty;
    }

    public void setMunicipioProperty(String municipioProperty) {
        this.municipioProperty.set(municipioProperty);
    }

    public String getEmailProperty() {
        return emailProperty.get();
    }

    public StringProperty emailPropertyProperty() {
        return emailProperty;
    }

    public void setEmailProperty(String emailProperty) {
        this.emailProperty.set(emailProperty);
    }

    public String getObservacaoProperty() {
        return observacaoProperty.get();
    }

    public StringProperty observacaoPropertyProperty() {
        return observacaoProperty;
    }

    public void setObservacaoProperty(String observacaoProperty) {
        this.observacaoProperty.set(observacaoProperty);
    }

    public String getSexoProperty() {
        return sexoProperty.get();
    }

    public StringProperty sexoPropertyProperty() {
        return sexoProperty;
    }

    public void setSexoProperty(String sexoProperty) {
        this.sexoProperty.set(sexoProperty);
    }

    public String getDataNascimentoProperty() {
        return dataNascimentoProperty.get();
    }

    public StringProperty dataNascimentoPropertyProperty() {
        return dataNascimentoProperty;
    }

    public void setDataNascimentoProperty(String dataNascimentoProperty) {
        this.dataNascimentoProperty.set(dataNascimentoProperty);
    }

    public int getNumeroProperty() {
        return numeroProperty.get();
    }

    public IntegerProperty numeroPropertyProperty() {
        return numeroProperty;
    }

    public void setNumeroProperty(int numeroProperty) {
        this.numeroProperty.set(numeroProperty);
    }
}
