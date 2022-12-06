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
        drawWhileDragging(g, selectorModel.x, selectorModel.y, selectorModel.getCurrentPoint().x, selectorModel.getCurrentPoint().y);
    }

    public void drawWhileDragging(Graphics g, int x, int y, int x2, int y2) {
        if (selectorModel.getCurrentPoint() != null) {
            int rx = Math.min(x, x2);
            int ry = Math.min(y, y2);
            int rheight = Math.abs(x-x2);
            int rwidth = Math.abs(y-y2);
            g.drawRect(rx, ry, rheight, rwidth);
            System.out.println("Start x, y: " + selectorModel.getStartPoint().x + " " + selectorModel.getStartPoint().y);
            System.out.println("Current x, y: " + selectorModel.getCurrentPoint().x + " " + selectorModel.getCurrentPoint().y);
        }
    }
}
