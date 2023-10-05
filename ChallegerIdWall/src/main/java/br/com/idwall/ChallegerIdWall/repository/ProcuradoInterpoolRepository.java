package br.com.idwall.ChallegerIdWall.repository;

import br.com.idwall.ChallegerIdWall.objeto.ProcuradosInterpoolOB;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
//Repostory JPA da API INTERPOOL
public interface ProcuradoInterpoolRepository extends JpaRepository<ProcuradosInterpoolOB, Integer> {

    List<ProcuradosInterpoolOB> findByName (String proc);
}
