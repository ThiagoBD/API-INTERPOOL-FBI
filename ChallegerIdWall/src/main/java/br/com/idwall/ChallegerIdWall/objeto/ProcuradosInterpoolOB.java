package br.com.idwall.ChallegerIdWall.objeto;

import jakarta.persistence.*;

//Classe objeto que mapeia os procurados da Interpool
@Entity
@SequenceGenerator(name="procurado_interpool", sequenceName = "SQ_PROCURADO_INTERPOOL", allocationSize = 1)
@Table(name="procurado_interpool")
public class ProcuradosInterpoolOB {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "procurado_interpool")
    @Column(name="PROCURADOINTERPOOL_ID")
    private int id;
    @Column(name="PROCURADOINTERPOOL_FORENAME")
    private String forename;
    @Column(name="PROCURADOINTERPOOL_NAME")
    private String name;
    @Column(name= "PROCURADOINTERPOOL_DATE_OF_BIRTH")
    private String date_of_birth;

    public String getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getForename() {
        return forename;
    }

    public void setForename(String forename) {
        this.forename = forename;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
