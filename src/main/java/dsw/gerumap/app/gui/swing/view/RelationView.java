package dsw.gerumap.app.gui.swing.view;

import dsw.gerumap.app.mapRepository.implementation.Relation;

import java.awt.*;
import java.awt.geom.GeneralPath;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

public class RelationView extends ElementView{

    public RelationView(Relation relation) {
        super(relation);
        //shape = new GeneralPath();
        double x = relation.getxCoordinate();
        double y = relation.getyCoordinate();
        shape = new Line2D.Double(new Point2D.Double(x-75, y-50), new Point2D.Double(x+75, y+50));
    }

    @Override
    public void paint(Graphics2D g) {

        //GeneralPath generalPath = (GeneralPath) shape;

        Line2D.Double line = (Line2D.Double) shape;
        g.setStroke(new BasicStroke(element.getStroke()));
        g.setColor(new Color(element.getColor()));
        //g.fill(shape);

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

        /*
        generalPath.moveTo(xCoordinateFrom, yCoordinateFrom);
        generalPath.lineTo(xCoordinateTo, yCoordinateTo);
        generalPath.closePath();
        g.draw(generalPath);
        g.fill(generalPath);

         */
        g.drawLine((int)xCoordinateFrom, (int)yCoordinateFrom, (int)xCoordinateTo, (int)yCoordinateTo);
    }

    @Override
    public void paintSelected(Graphics2D g) {

    }
}
