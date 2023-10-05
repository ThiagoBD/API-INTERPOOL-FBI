package br.com.idwall.ChallegerIdWall.model;

import br.com.idwall.ChallegerIdWall.objeto.ItensOB;
import br.com.idwall.ChallegerIdWall.objeto.ProcuradoOB;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

// fabrica de conexóes da aqui do FBI
public class FbiFactoryAPI {

    public static ItensOB newProcurados(int value) throws IOException, InterruptedException {
        String endereco = "https://api.fbi.gov/@wanted?pageSize=51&page="+value+"&sort_on=modified&sort_order=desc";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        String json = response.body();

        Gson gson = new Gson();
        ItensOB procurado = gson.fromJson(json, ItensOB.class);
        return procurado;
    }
}
