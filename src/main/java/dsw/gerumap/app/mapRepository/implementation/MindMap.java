package dsw.gerumap.app.mapRepository.implementation;

import dsw.gerumap.app.mapRepository.composite.MapNodeComposite;

public class MindMap extends MapNodeComposite {

    private String ime;
    private boolean template;

    public MindMap(String ime, boolean template) {
        this.ime = ime;
        this.template = template;
    }
}
