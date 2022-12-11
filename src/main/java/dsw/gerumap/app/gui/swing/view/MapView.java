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
    private int stroke;
    private int color;
    private List<ElementView>  selectedElements;
    private SelectorView selectorView;
    private AffineTransform transform; // na tabbedPane se dodaje ScrollPane koji ce imati mapView
    private double scalingFactor;
    private double xTranslate;
    private double yTranslate;


    public MapView(MindMap mindMap) {
        this.mindMap = mindMap;
        this.mindMap.addSubscriber(this);
        this.elementViews = new ArrayList<>();
        this.addMouseListener(MainFrame.getInstance().getActionManager().getStateMouseListener());
        this.addMouseMotionListener(MainFrame.getInstance().getActionManager().getStateMouseListener());
        this.stroke = 2;
        this.color = 0x000000;
        transform = new AffineTransform();
        this.scalingFactor = 1;
        this.xTranslate = 0;
        this.yTranslate = 0;
        selectedElements = new ArrayList<>();
    }
    @Override
    public void update(Object notification) {
        MyTabbedPane myTabbedPane = (MyTabbedPane) this.getParent();
        if(notification instanceof MindMap) {
            setName(((MindMap) notification).getName());
            myTabbedPane.setTitleAt(myTabbedPane.indexOfComponent(this), this.getName());
        } else if(notification instanceof Element) {
            ElementView contains = containsElementView((Element) notification);
            if(notification instanceof Relation) {
                if(contains == null) {
                    RelationView r = new RelationView((Relation) notification);
                    elementViews.add(r);
                }
                else{
                    elementViews.remove(contains);
                }
            } else {
                if(contains == null) {
                    TermView tv = new TermView((Term) notification);
                    elementViews.add(tv);
                    System.out.println("Posle add-a " + elementViews);
                }
                /*

                else {
                    elementViews.remove(contains);
                    TermView tv = new TermView((Term) notification);
                    elementViews.add(tv);
                }

                 */

                else if (getSelectedElements().contains(contains)){
                    //System.out.println("DODAJE");
                    elementViews.remove(contains);
                    this.removeSelected(contains);
                    TermView tv = new TermView((Term) notification);
                    elementViews.add(tv);
                    this.addSelected(tv);
                } else {
                    System.out.println("SAMO BRISE");
                    elementViews.remove(contains);
                    this.removeSelected(contains);

                    repaint();
                }




            }
            repaint();
        } else if (notification instanceof SelectorModel) {
            selectorView = new SelectorView((SelectorModel) notification);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return this.getSize();
    }

    public MindMap getMindMap() {
        return mindMap;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.8f));
        g2.transform(transform);
        for(ElementView elementView : elementViews) {
            if(selectedElements.contains(elementView))
                elementView.paintSelected(g2);
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
        setupTransform();
    }

    public void zoomOut() {
        scalingFactor /= 1.2;
        if(scalingFactor < 0.2) {
            scalingFactor = 0.2;
        }
        System.out.println(scalingFactor);
        setupTransform();
    }

    public void translate(double xTranslate, double yTranslate) {
        this.xTranslate += xTranslate;
        this.yTranslate += yTranslate;
        setupTransform();
    }

    private void setupTransform() {
        transform.setToIdentity();
        transform.translate(xTranslate, yTranslate);
        transform.scale(scalingFactor, scalingFactor);
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

    public void addSelected(ElementView selected) {
        if(!selectedElements.contains(selected))
            selectedElements.add(selected);
        repaint();
    }

    public void removeSelected(ElementView selected){
        selectedElements.remove(selected);
        repaint();
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

    public double getScalingFactor() {
        return scalingFactor;
    }

    public double getxTranslate() {
        return xTranslate;
    }

    public double getyTranslate() {
        return yTranslate;
    }

    public SelectorView getSelectorView() {
        return selectorView;
    }

    public void setSelectorView(SelectorView selectorView) {
        this.selectorView = selectorView;
    }
}
