package dsw.gerumap.app.gui.swing.view;

import dsw.gerumap.app.mapRepository.implementation.Relation;

import java.awt.*;
import java.awt.geom.GeneralPath;

public class RelationView extends ElementView{

    public RelationView(Relation relation) {
        super(relation);
        shape = new GeneralPath();
    }

    @Override
    public void paint(Graphics2D g) {
        GeneralPath generalPath = (GeneralPath) shape;
        g.setStroke(new BasicStroke(element.getStroke()));
        g.setColor(new Color(element.getColor()));

        Relation r = (Relation) element;

        double xFrom = r.getTermFrom().getxCoordinate();
        double yFrom = r.getTermFrom().getyCoordinate();

        double xTo = r.getTermTo().getxCoordinate();
        double yTo = r.getTermTo().getyCoordinate();

        double A = (yTo-yFrom)/(xTo-xFrom);
        double B = 150/(Math.sqrt(4+9*A*A));

        double xCoordinateFrom;
        double yCoordinateFrom;

        double xCoordinateTo;
        double yCoordinateTo;

        if(xTo > xFrom) {
            xCoordinateFrom = xFrom + B;
            yCoordinateFrom = yFrom + A * B;

            xCoordinateTo = xTo - B;
            yCoordinateTo = yTo - A * B;
        } else {
            xCoordinateFrom = xFrom - B;
            yCoordinateFrom = yFrom - A * B;

            xCoordinateTo = xTo + B;
            yCoordinateTo = yTo + A * B;
        }

        generalPath.moveTo(xCoordinateFrom, yCoordinateFrom);
        generalPath.lineTo(xCoordinateTo, yCoordinateTo);
        generalPath.closePath();
        g.draw(generalPath);
        g.fill(generalPath);
    }

    @Override
    public void paintSelected(Graphics2D g) {

    }
}
