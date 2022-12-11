package dsw.gerumap.app.gui.swing.view;

import dsw.gerumap.app.mapRepository.implementation.Term;
import dsw.gerumap.app.observer.ISubscriber;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class TermView extends ElementView {

    public TermView(Term term) {
        super(term);
        shape = new Ellipse2D.Double(term.getXCoordinate()-75, term.getYCoordinate()-50, 150, 100);
    }

    @Override
    public void paint(Graphics2D g) {
        Ellipse2D.Double ellipse = (Ellipse2D.Double) shape;

        g.setStroke(new BasicStroke(element.getStroke()));
        g.setPaint(new Color(255, 255, 255));
        g.fill(shape);
        g.setPaint(new Color(element.getColor()));
        g.draw(shape);
        FontMetrics metrics = g.getFontMetrics(g.getFont());
        float x = (float) (ellipse.x + (ellipse.width - metrics.stringWidth(element.getName())) / 2);
        float y = (float) (ellipse.y + ((ellipse.height - metrics.getHeight()) / 2) + metrics.getAscent());
        g.drawString(element.getName(), x, y);
    }

    @Override
    public void paintSelected(Graphics2D g) {
        Ellipse2D.Double ellipse = (Ellipse2D.Double) shape;

        g.setStroke(new BasicStroke(element.getStroke()));
        g.setPaint(Color.PINK);
        g.fill(shape);
        g.setPaint(new Color(element.getColor()));
        g.draw(shape);
        FontMetrics metrics = g.getFontMetrics(g.getFont());
        float x = (float) (ellipse.x + (ellipse.width - metrics.stringWidth(element.getName())) / 2);
        float y = (float) (ellipse.y + ((ellipse.height - metrics.getHeight()) / 2) + metrics.getAscent());
        g.drawString(element.getName(), x, y);
    }

}
