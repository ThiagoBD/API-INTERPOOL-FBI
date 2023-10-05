package br.com.idwall.ChallegerIdWall.controller;

import br.com.idwall.ChallegerIdWall.objeto.ProcuradoOB;
import br.com.idwall.ChallegerIdWall.objeto.ProcuradosInterpoolOB;
import br.com.idwall.ChallegerIdWall.repository.ProcuradoInterpoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Resource da API procuradoInterpool
@RestController
@RequestMapping("procuradoInterpool")
public class ProcuradoInterpoolResource {
    @Autowired
    private ProcuradoInterpoolRepository procuradoInterpoolRepository;
    @ResponseStatus(HttpStatus.CREATED)
    public ProcuradosInterpoolOB create(@RequestBody ProcuradosInterpoolOB procurado) {return procuradoInterpoolRepository.save(procurado);}
    @GetMapping
    public List<ProcuradosInterpoolOB> listar(){return procuradoInterpoolRepository.findAll();}
    @GetMapping("{name}")
    public List<ProcuradosInterpoolOB> buscarName(@PathVariable String name){return  procuradoInterpoolRepository.findByName(name);}

}
