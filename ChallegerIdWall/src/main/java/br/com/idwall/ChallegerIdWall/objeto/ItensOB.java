package br.com.idwall.ChallegerIdWall.objeto;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

//essa classe contem o Total de Itens na base de dados do FBI e o Array com de procurados
public class ItensOB {
    @SerializedName("total")
    private String TotalItems;
    @SerializedName("items")
    private ArrayList<ProcuradoOB> ListItems;

    public String getTotalItems() {
        return TotalItems;
    }
    public void setTotalItems(String totalItems) {
        TotalItems = totalItems;
    }
    public ArrayList<ProcuradoOB> getListItems() {
        return ListItems;
    }
    public void setListItems(ArrayList<ProcuradoOB> listItems) {
        ListItems = listItems;
    }


}
