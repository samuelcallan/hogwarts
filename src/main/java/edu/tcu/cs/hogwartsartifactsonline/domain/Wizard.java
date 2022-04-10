package edu.tcu.cs.hogwartsartifactsonline.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Wizard implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    @JsonIgnore
    private List<Artifact> artifacts = new ArrayList<>();

    public Wizard(){

    }

    public List<Artifact> getArtifacts() {
        return artifacts;
    }

    public void setArtifacts(List<Artifact> artifacts) {
        this.artifacts = artifacts;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void addArtifacts(Artifact artifact){
        artifact.setOwner(this);
        this.artifacts.add(artifact);
    }

    public void removeArtifact(Artifact artifact){
        artifact.setOwner(null);
        this.artifacts.remove(artifact);
    }

}
