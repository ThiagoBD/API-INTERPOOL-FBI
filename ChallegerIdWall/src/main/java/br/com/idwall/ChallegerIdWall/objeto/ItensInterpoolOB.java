package br.com.idwall.ChallegerIdWall.objeto;

import com.google.gson.annotations.SerializedName;

import java.util.List;

//Essa classe e um objeto que recebe a lista dos itens vindos da API da interpool
public class ItensInterpoolOB {
    @SerializedName("_embedded")
    private ListaProcuradosInterpoolOB listaProcurados;
    public ListaProcuradosInterpoolOB getListaProcurados() {
        return listaProcurados;
    }
    public void setListaProcurados(ListaProcuradosInterpoolOB listaProcurados) {
        this.listaProcurados = listaProcurados;
    }

}
