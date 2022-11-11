package dsw.gerumap.app.gui.swing.view;

import dsw.gerumap.app.mapRepository.implementation.Project;
import dsw.gerumap.app.observer.ISubscriber;

import javax.swing.*;
import java.awt.*;

public class ProjectView extends JPanel implements ISubscriber {

    private JLabel projName;
    private JLabel autor;

    private Project project;

    private MyTabbedPane mapsTabbedPane;

    public ProjectView() {
        this.project = (Project) MainFrame.getInstance().getMapTree().getSelectedNode().getMapNode();
        this.project.addSubcriber(this);
        //project = new Project(this.projName.getText(), project.getParent());
        this.projName = new JLabel(this.project.getName());
        this.autor = new JLabel(this.project.getAuthor());
        this.mapsTabbedPane = new MyTabbedPane(SwingConstants.TOP, JTabbedPane.SCROLL_TAB_LAYOUT);
        add(projName);
        add(autor);
        add(mapsTabbedPane);
    }

    @Override
    public void update(Object notification) {
        if(notification instanceof Project) {
            this.projName.setText(((Project) notification).getName());
            this.autor.setText(((Project) notification).getAuthor());
        }
    }

    public Project getProject() {
        return project;
    }

    public JLabel getAutor() {
        return autor;
    }

    public JLabel getProjName() {
        return projName;
    }

    public MyTabbedPane getMapsTabbedPane() {
        return mapsTabbedPane;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
