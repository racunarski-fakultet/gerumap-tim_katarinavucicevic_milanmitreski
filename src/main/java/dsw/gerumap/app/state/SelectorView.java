package dsw.gerumap.app.state;

import dsw.gerumap.app.observer.ISubscriber;

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
        drawWhileDragging(g);
    }

    public void drawWhileDragging(Graphics g) {
        if (selectorModel.getCurrentPoint() != null) {
            g.drawRect(selectorModel.getStartPoint().x, selectorModel.getStartPoint().y, selectorModel.getCurrentPoint().x, selectorModel.getCurrentPoint().y);
            System.out.println("grafika: " + g);
        }
    }
}
