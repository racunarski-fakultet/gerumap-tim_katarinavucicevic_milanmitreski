package dsw.gerumap.app.state;

import java.awt.*;

public class SelectorView{

    private SelectorModel selectorModel;

    public SelectorView(SelectorModel selectorModel) {
        this.selectorModel = selectorModel;

    }

    public SelectorModel getSelectorModel() {
        return selectorModel;
    }


    public void repaint(Graphics2D g) {
        g.setPaint(Color.BLUE);
        g.fill(selectorModel);
        g.draw(selectorModel);
    }
}
