package dsw.gerumap.app.MapRepository;

public class Project extends MapNodeComposite{

    private String ime;
    private String autor;
    private String putanja;

    public Project(String ime, String autor, String putanja) {
        this.ime = ime;
        this.autor = autor;
        this.putanja = putanja;
    }
}
