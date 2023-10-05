package br.com.idwall.ChallegerIdWall.model;

import br.com.idwall.ChallegerIdWall.objeto.ItensInterpoolOB;
import br.com.idwall.ChallegerIdWall.objeto.ItensOB;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

//fabrica de conexões da api da Interpool
public class InterpoolFactoryApi {
    public static ItensInterpoolOB newProcuradosInterpool() throws IOException, InterruptedException {
        String endereco = "https://ws-public.interpol.int/notices/v1/red?resultPerPage=200&page=1";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
        String json = response.body();
        Gson gson = new Gson();
        ItensInterpoolOB procurado = gson.fromJson(json, ItensInterpoolOB.class);
        return procurado;
    }

}
