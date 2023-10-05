package br.com.idwall.ChallegerIdWall;

import br.com.idwall.ChallegerIdWall.controller.DataBaseManipulator;
import br.com.idwall.ChallegerIdWall.controller.ProcuradoInterpoolResource;
import br.com.idwall.ChallegerIdWall.controller.ProcuradoResource;
import br.com.idwall.ChallegerIdWall.model.FbiFactoryAPI;
import br.com.idwall.ChallegerIdWall.model.InterpoolFactoryApi;
import br.com.idwall.ChallegerIdWall.objeto.ItensInterpoolOB;
import br.com.idwall.ChallegerIdWall.objeto.ItensOB;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import java.io.IOException;


@EnableScheduling
@SpringBootApplication
public class ChallegerIdWallApplication {
	//Calcula o valor total de itens que vem da API do fbi assim, passando
	// para o insereDados, quantas paginas ele precisa ler
	public static int valorTotalItens() throws IOException, InterruptedException {
		ItensOB itensTotal = FbiFactoryAPI.newProcurados(1);
		int valorTotal = Integer.parseInt(itensTotal.getTotalItems()) / 50;
        return valorTotal;
    }
	//Manipula a base de dados limpando as sequencas e os dados das tables
	public static void manipuladorSql(ConfigurableApplicationContext cxtx){
		DataBaseManipulator databaseManipulator = cxtx.getBean(DataBaseManipulator.class);
		databaseManipulator.deleteAllDataFromTable("PROCURADO");
		databaseManipulator.resetSequence("SQ_PROCURADO");
		databaseManipulator.deleteAllDataFromTable("PROCURADO_INTERPOOL");
		databaseManipulator.resetSequence("SQ_PROCURADO_INTERPOOL");
	}
	//Insere todos os dados da api do fbi e da interpool no banco de dados
	public static void insereDados(ProcuradoInterpoolResource procuradoInterpoolResource, ProcuradoResource procuradoResource ,int valorTotal) throws IOException, InterruptedException{
		ItensInterpoolOB procuradoInterpool = InterpoolFactoryApi.newProcuradosInterpool();
		for (int i = 0; i <= procuradoInterpool.getListaProcurados().getListaProcurados().size() - 1; i++) {
			System.out.println(i);
			procuradoInterpoolResource.create(procuradoInterpool.getListaProcurados().getListaProcurados().get(i));
		}
		for (int index = 1; index <= valorTotal; index++) {
			ItensOB procurados = FbiFactoryAPI.newProcurados(index);
			for (int i = 0; i <= procurados.getListItems().size() - 1; i++) {
				System.out.println(i);
				procuradoResource.create(procurados.getListItems().get(i));
			}
		}
	}
	public static void main(String[] args) throws IOException, InterruptedException {ConfigurableApplicationContext cxtx = SpringApplication.run(ChallegerIdWallApplication.class, args);
		// Instancias
		ProcuradoResource procuradoResource = cxtx.getBean(ProcuradoResource.class);
		ProcuradoInterpoolResource procuradoInterpoolResource = cxtx.getBean(ProcuradoInterpoolResource.class);
		int valorItens = valorTotalItens();

	// Manipula o banco de dados para limpar a sequence e a table
		manipuladorSql(cxtx);
		// Pede para inserir os dados vindo da api do FBI no banco de dados oracle
		try{
			insereDados(procuradoInterpoolResource, procuradoResource , valorItens);
		}catch(Exception e){
			System.out.println("Ocorreu um erro na inserção de dados");
			cxtx.close();
		}














	}

}
