package br.com.idwall.ChallegerIdWall.objeto;

import com.google.gson.annotations.SerializedName;
import jakarta.persistence.*;
import org.hibernate.annotations.JdbcType;
import org.hibernate.annotations.JdbcTypeRegistration;

import java.util.ArrayList;
import java.util.List;

//classe objeto que mapeia os procurados da API do FBI
@Entity
@SequenceGenerator(name="procurado", sequenceName = "SQ_PROCURADO", allocationSize = 1)
@Table(name="procurado")
public class ProcuradoOB {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "procurado")
    @Column(name="PROCURADO_ID")
    private int id;
    @SerializedName("title")
    @Column(name="PROCURADO_NAME")
    private String name;
    @SerializedName("description")
    @Column(name="PROCURADO_DESCRIPTION")
    private String description;
    @SerializedName("sex")
    @Column(name="procurado_sex")
    private String sex;
    @SerializedName("nationality")
    @Column(name="PROCURADO_NATIONALITY")
    private String nationality;
    @SerializedName("eyes")
    @Column(name="PROCURADO_EYES")
    private String eyes;
    @SerializedName("hair")
    @Column(name="PROCURADO_HAIR")
    private String hair;
    @SerializedName("age_max")
    @Column(name="PROCURADO_AGE_MAX")
    private int age_max;
    @SerializedName("caution")
    @Column(name="PROCURADO_CAUTION")
    private String caution;
    @SerializedName("race_raw")
    @Column(name="PROCURADO_RACE_RAW")
    private String race_raw;
    @SerializedName("age_min")
    @Column(name="PROCURADO_AGE_MIN")
    private int age_min;
    @SerializedName("weight")
    @Column(name="PROCURADO_WEIGHT")
    private String weight;
    @SerializedName("reward_text")
    @Column(name="PROCURADO_REWARD_TEXT")
    private String reward_text;

    public String getWeight() {
        return weight;
    }
    public String getReward_text() {
        return reward_text;
    }

    public void setReward_text(String reward_text) {
        this.reward_text = reward_text;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getRace_raw() {
        return race_raw;
    }

    public void setRace_raw(String race_raw) {
        this.race_raw = race_raw;
    }

    public int getAge_min() {
        return age_min;
    }

    public void setAge_min(int age_min) {
        this.age_min = age_min;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }



    public String getEyes() {
        return eyes;
    }

    public void setEyes(String eyes) {
        this.eyes = eyes;
    }

    public String getHair() {
        return hair;
    }

    public void setHair(String hair) {
        this.hair = hair;
    }

    public int getAge_max() {
        return age_max;
    }

    public void setAge_max(int age_max) {
        this.age_max = age_max;
    }

    public String getCaution() {
        return caution;
    }

    public void setCaution(String caution) {
        this.caution = caution;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
}
