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
import java.awt.geom.NoninvertibleTransformException;
import java.util.ArrayList;
import java.util.List;

public class MapView extends JPanel implements ISubscriber {

    private MindMap mindMap;
    private List<ElementView> elementViews;
    private ElementView selected;
    private int stroke;
    private int color;

    private double scalingFactor;
    private double xTranslate;
    private double yTranslate;

    private SelectorView selectorView;

    private List<ElementView>  selectedElements;

    private AffineTransform transform; // na tabbedPane se dodaje ScrollPane koji ce imati mapView


    public MapView(MindMap mindMap) {
        this.mindMap = mindMap;
        this.mindMap.addSubscriber(this);
        this.elementViews = new ArrayList<>();
        this.addMouseListener(MainFrame.getInstance().getActionManager().getStateMouseListener());
        this.addMouseMotionListener(MainFrame.getInstance().getActionManager().getStateMouseListener());
        this.stroke = 2;
        this.color = 0x000000;
        this.setBounds(0, 0,200, 300);
        transform = new AffineTransform();
        this.scalingFactor = 1;
        this.xTranslate = 0;
        this.yTranslate = 0;
        selectedElements = new ArrayList<>();
    }
    @Override
    public void update(Object notification) {
        JScrollPane scrollPane = (JScrollPane)this.getParent().getParent();
        MyTabbedPane myTabbedPane = (MyTabbedPane) scrollPane.getParent();
        if(notification instanceof MindMap) {
            setName(((MindMap) notification).getName());
            myTabbedPane.setTitleAt(myTabbedPane.indexOfComponent(scrollPane), this.getName());
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
        g2.setTransform(transform);
        for(ElementView elementView : elementViews) {
            if(elementView.equals(selected)) elementView.paintSelected(g2);
            else elementView.paint(g2);
        }
        if(selectorView != null){
            selectorView.repaint(g2);
        }
    }

    public void zoomIn() {
        scalingFactor *= 1.2;
        if(scalingFactor > 5) {
            scalingFactor = 5;
        }
        System.out.println(scalingFactor);
        xTranslate = 0;
        yTranslate = 0;
        setupTransform();
    }

    public void zoomOut() {
        scalingFactor /= 1.2;
        if(scalingFactor < 0.2) {
            scalingFactor = 0.2;
        }
        System.out.println(scalingFactor);
        xTranslate = 0;
        yTranslate = 0;
        setupTransform();
    }

    private void setupTransform() {
        transform.setToIdentity();
        transform.scale(scalingFactor, scalingFactor);
        transform.translate(xTranslate, yTranslate);
        repaint();
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
