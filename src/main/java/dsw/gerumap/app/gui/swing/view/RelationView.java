package dsw.gerumap.app.gui.swing.view;

import dsw.gerumap.app.mapRepository.implementation.Relation;

import java.awt.*;
import java.awt.geom.GeneralPath;
import java.awt.geom.Path2D;

public class RelationView extends ElementView{

    public RelationView(Relation relation) {
        super(relation);
        shape = new GeneralPath(Path2D.WIND_EVEN_ODD);
    }

    @Override
    public void paint(Graphics2D g) {
        GeneralPath generalPath = (GeneralPath) shape;
        generalPath.reset();
        Relation r = (Relation) element;

        double xFrom = r.getTermFrom().getXCoordinate();
        double yFrom = r.getTermFrom().getYCoordinate();

        double xTo = r.getTermTo().getXCoordinate();
        double yTo = r.getTermTo().getYCoordinate();

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
        g.setStroke(new BasicStroke(element.getStroke()));
        g.setColor(new Color(element.getColor()));
        g.draw(shape);
        g.fill(shape);
    }

    @Override
    public void paintSelected(Graphics2D g) {
        GeneralPath generalPath = (GeneralPath) shape;
        generalPath.reset();
        Relation r = (Relation) element;

        double xFrom = r.getTermFrom().getXCoordinate();
        double yFrom = r.getTermFrom().getYCoordinate();

        double xTo = r.getTermTo().getXCoordinate();
        double yTo = r.getTermTo().getYCoordinate();

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
        g.setStroke(new BasicStroke(element.getStroke()));
        g.setColor(Color.PINK);
        g.draw(shape);
        g.fill(shape);
    }
}
