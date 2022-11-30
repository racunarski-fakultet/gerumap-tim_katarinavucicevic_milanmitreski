package dsw.gerumap.app.gui.swing.view;

import dsw.gerumap.app.mapRepository.implementation.Element;
import dsw.gerumap.app.mapRepository.implementation.MindMap;
import dsw.gerumap.app.mapRepository.implementation.Relation;
import dsw.gerumap.app.mapRepository.implementation.Term;
import dsw.gerumap.app.observer.ISubscriber;
import dsw.gerumap.app.state.StateMouseListener;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MapView extends JPanel implements ISubscriber {

    private MindMap mindMap;
    private List<ElementView> elementViews;


    public MapView(MindMap mindMap) {
        this.mindMap = mindMap;
        this.mindMap.addSubcriber(this);
        this.elementViews = new ArrayList<>();
        this.addMouseListener(new StateMouseListener());
    }

    @Override
    public void update(Object notification) {
        if(notification instanceof MindMap) {
            setName(((MindMap) notification).getName());
            ((MyTabbedPane)this.getParent()).setTitleAt(((MyTabbedPane)this.getParent()).indexOfComponent(this), this.getName());
        } else if(notification instanceof Element) {
            ElementView contains = containsElementView((Element) notification);
            if(notification instanceof Relation) {
                if(contains == null) elementViews.add(new RelationView((Relation) notification));
                else elementViews.remove(contains);
            } else {
                if(contains == null) elementViews.add(new TermView((Term) notification));
                else elementViews.remove(contains);
            }
            repaint();
        }
    }

    public MindMap getMindMap() {
        return mindMap;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.8f));
        for(ElementView elementView : elementViews) {
            elementView.paint(g2);
        }
    }

    private ElementView containsElementView(Element element) {
        for(ElementView elementView : elementViews) {
            if(elementView.element.equals(element))
                return elementView;
        }
        return null;
    }
}
