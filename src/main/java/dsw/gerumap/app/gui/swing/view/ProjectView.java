package dsw.gerumap.app.gui.swing.view;

import dsw.gerumap.app.mapRepository.composite.MapNode;
import dsw.gerumap.app.mapRepository.implementation.MindMap;
import dsw.gerumap.app.mapRepository.implementation.Project;
import dsw.gerumap.app.observer.ISubscriber;

import javax.swing.*;

public class ProjectView extends JPanel implements ISubscriber {

    private final JLabel projName;
    private final JLabel autor;

    private Project project;

    private MyTabbedPane mapsTabbedPane;

    public ProjectView() {
        this.project = (Project) MainFrame.getInstance().getMapTree().getSelectedNode().getMapNode();
        this.project.addSubcriber(this);
        this.projName = new JLabel(this.project.getName());
        this.autor = new JLabel(this.project.getAuthor());
        this.mapsTabbedPane = new MyTabbedPane(SwingConstants.TOP, JTabbedPane.SCROLL_TAB_LAYOUT);
        for(MapNode m : project.getChildren()) {
            revalidateTabbedPane((MindMap) m);
        }
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(projName);
        add(autor);
        add(mapsTabbedPane);
    }

    @Override
    public void update(Object notification) {
        if(notification instanceof Project) {
            projName.setText(project.getName());
            autor.setText(project.getAuthor());
        } else if(notification instanceof MindMap) {
            revalidateTabbedPane((MindMap) notification);
        }
    }

    private void revalidateTabbedPane(MindMap m) {
        if(project.getChildren().contains(m)) {
            this.mapsTabbedPane.addTab(m.getName(), new MapView(m));
        } else {
            System.out.println(mapsTabbedPane);
            for(int i = 0; i < mapsTabbedPane.getTabCount(); i++) {
                MapView mv = (MapView) mapsTabbedPane.getComponentAt(i);
                if(mv.getMindMap().equals(m))
                    mapsTabbedPane.remove(mv);
            }
        }
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

}
