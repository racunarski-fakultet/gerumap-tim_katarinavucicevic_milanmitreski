package dsw.gerumap.app.MapRepository;

public class MindMap extends MapNodeComposite{

    private String ime;
    private boolean template;

    public MindMap(String ime, boolean template) {
        this.ime = ime;
        this.template = template;
    }
}
