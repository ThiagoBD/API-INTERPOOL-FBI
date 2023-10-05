package br.com.idwall.ChallegerIdWall.repository;

import br.com.idwall.ChallegerIdWall.objeto.ProcuradoOB;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
//Repository da api FBI
public interface ProcuradoRepository extends JpaRepository<ProcuradoOB,Integer> {
    List<ProcuradoOB> findByName (String proc);




}
