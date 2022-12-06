package dsw.gerumap.app.gui.swing.view;

import dsw.gerumap.app.mapRepository.implementation.Element;
import dsw.gerumap.app.mapRepository.implementation.MindMap;
import dsw.gerumap.app.mapRepository.implementation.Relation;
import dsw.gerumap.app.mapRepository.implementation.Term;
import dsw.gerumap.app.observer.ISubscriber;
import dsw.gerumap.app.state.SelectorModel;
import dsw.gerumap.app.state.SelectorView;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.List;

public class MapView extends JPanel implements ISubscriber {

    private MindMap mindMap;
    private List<ElementView> elementViews;
    private ElementView selected;
    private int stroke;
    private int color;

    private SelectorView selectorView;

    private List<ElementView>  selectedElements;

    private AffineTransform transform; // na tabbedPane se dodaje ScrollPane koji ce imati mapView


    public MapView(MindMap mindMap) {
        this.mindMap = mindMap;
        this.mindMap.addSubscriber(this);
        this.elementViews = new ArrayList<>();
        this.addMouseListener(MainFrame.getInstance().getActionManager().getStateMouseListener());
        this.stroke = 2;
        this.color = 0x000000;
        transform = new AffineTransform();
        selectedElements = new ArrayList<>();
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
        } else if (notification instanceof SelectorModel) {
            //if(selectedElements.isEmpty()){
                selectorView = new SelectorView((SelectorModel) notification);
                System.out.println("SelectorView u update: " + selectorView);

            //}
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
            if(elementView.equals(selected)) elementView.paintSelected(g2);
            else elementView.paint(g2);
        }
        if(selectorView != null){
            System.out.println("Ulazi u repaint: " + selectorView);
            selectorView.repaint(g2);
        }
    }

    private ElementView containsElementView(Element element) {
        for(ElementView elementView : elementViews) {
            if(elementView.element.equals(element))
                return elementView;
        }
        return null;
    }

    public List<ElementView> getElementViews() {
        return elementViews;
    }

    public void setSelected(ElementView selected) {
        this.selected = selected;
        repaint();
    }

    public ElementView getSelected() {
        return selected;
    }

    public int getColor() {
        return color;
    }

    public int getStroke() {
        return stroke;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public void setStroke(int stroke) {
        this.stroke = stroke;
    }

    public List<ElementView> getSelectedElements() {
        return selectedElements;
    }

    public SelectorView getSelectorView() {
        return selectorView;
    }

    public void setSelectorView(SelectorView selectorView) {
        this.selectorView = selectorView;
    }
}
