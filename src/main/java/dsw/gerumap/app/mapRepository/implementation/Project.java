package dsw.gerumap.app.mapRepository.implementation;

import dsw.gerumap.app.mapRepository.composite.MapNodeComposite;

public class Project extends MapNodeComposite {

    private String ime;
    private String autor;
    private String putanja;

    public Project(String ime, String autor, String putanja) {
        this.ime = ime;
        this.autor = autor;
        this.putanja = putanja;
    }
}
