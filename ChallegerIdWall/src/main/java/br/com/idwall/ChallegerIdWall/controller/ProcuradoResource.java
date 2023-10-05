package br.com.idwall.ChallegerIdWall.controller;

import br.com.idwall.ChallegerIdWall.objeto.ProcuradoOB;
import br.com.idwall.ChallegerIdWall.repository.ProcuradoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Resource da api do FBI
@RestController
@RequestMapping("procurado")
public class ProcuradoResource {
    @Autowired
    private ProcuradoRepository procuradoRepository;
    @ResponseStatus(HttpStatus.CREATED)
    public ProcuradoOB create(@RequestBody ProcuradoOB procurado) {return procuradoRepository.save(procurado);}
    @GetMapping
    public List<ProcuradoOB> listar(){return procuradoRepository.findAll();}
    @GetMapping("{name}")
    public List<ProcuradoOB> buscar(@PathVariable String name){return  procuradoRepository.findByName(name);}



}
