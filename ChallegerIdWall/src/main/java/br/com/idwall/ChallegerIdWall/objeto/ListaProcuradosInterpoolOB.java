package br.com.idwall.ChallegerIdWall.objeto;

import com.google.gson.annotations.SerializedName;

import java.util.List;
//essa classe e a lista de Procurados vindos da api da INTERPOOL
public class ListaProcuradosInterpoolOB {
    @SerializedName("notices")
    private List<ProcuradosInterpoolOB> listaProcurados;

    public List<ProcuradosInterpoolOB> getListaProcurados() {
        return listaProcurados;
    }

    public void setListaProcurados(List<ProcuradosInterpoolOB> listaProcurados) {
        this.listaProcurados = listaProcurados;
    }
}
