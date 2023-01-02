package dsw.gerumap.app.gui.swing.view;

import dsw.gerumap.app.mapRepository.implementation.Element;

import java.awt.*;

public abstract class ElementView {

    protected Element element;
    protected Shape shape;

    public ElementView(Element element) {
        this.element = element;
    }

    public abstract void paint(Graphics2D g);

    public abstract void paintSelected(Graphics2D g);

    public boolean elementAt(Point pos) {
        return shape.contains(pos) || shape.getBounds().contains(pos);
    }

    public Element getElement() {
        return element;
    }

    public Shape getShape() {
        return shape;
    }
}
