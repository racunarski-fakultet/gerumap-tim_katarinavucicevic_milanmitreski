package dsw.gerumap.app.gui.swing.view;

import dsw.gerumap.app.mapRepository.implementation.Term;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class TermView extends ElementView{


    public TermView(Term term) {
        super(term);
        shape = new Ellipse2D.Double(term.getxCoordinate(), term.getyCoordinate(), 150, 100);
    }

    @Override
    public void paint(Graphics2D g) {
        g.setPaint(Color.RED);

        g.setStroke(new BasicStroke(element.getStroke()));
        g.draw(shape);
        g.setPaint(new Color(element.getColor()));

        g.fill(shape);
    }
}
