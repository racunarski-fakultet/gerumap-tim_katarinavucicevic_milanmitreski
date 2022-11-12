package dsw.gerumap.app.gui.swing.view;

import dsw.gerumap.app.mapRepository.NotificationType;
import dsw.gerumap.app.mapRepository.composite.MapNode;
import dsw.gerumap.app.mapRepository.implementation.MindMap;
import dsw.gerumap.app.mapRepository.implementation.Project;
import dsw.gerumap.app.observer.ISubscriber;

import javax.swing.*;
import java.util.List;

public class ProjectView extends JPanel implements ISubscriber {

    private final JLabel projName;
    private final JLabel autor;

    private Project project;

    private final MyTabbedPane mapsTabbedPane;

    public ProjectView() {
        this.project = (Project) MainFrame.getInstance().getMapTree().getSelectedNode().getMapNode();
        this.project.addSubcriber(this);
        //project = new Project(this.projName.getText(), project.getParent());
        this.projName = new JLabel(this.project.getName());
        this.autor = new JLabel(this.project.getAuthor());
        this.mapsTabbedPane = new MyTabbedPane(SwingConstants.TOP, JTabbedPane.SCROLL_TAB_LAYOUT);
        revalidateTabbedPane();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(projName);
        add(autor);
        add(mapsTabbedPane);
    }

    @Override
    public void update(Object notification) {
        if(notification instanceof NotificationType) {
            switch((NotificationType)notification) {
                case NAME_CHANGED:
                    projName.setText(project.getName());
                    break;
                case AUTHOR_CHANGED:
                    autor.setText(project.getAuthor());
                    break;
                case NODE_DELETED:
                case NODE_CREATED:
                    revalidateTabbedPane();
                    break;
                default:
                    break;
            }

        }
    }

    private void revalidateTabbedPane() {
        mapsTabbedPane.removeAll();
        for(MapNode m : getMaps()) {
            mapsTabbedPane.addTab(m.getName(), new MapView((MindMap)m));
        }
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    private List<MapNode> getMaps() {
        return project.getChildren();
    }
}
