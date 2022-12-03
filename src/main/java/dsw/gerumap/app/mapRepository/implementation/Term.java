package dsw.gerumap.app.mapRepository.implementation;

import dsw.gerumap.app.mapRepository.composite.MapNode;

public class Term extends Element{
    public Term(String ime, MapNode parent, int stroke, int color, double x_coordinate, double y_coordinate) {
        super(ime, parent, stroke, color, x_coordinate, y_coordinate);
    }
}
