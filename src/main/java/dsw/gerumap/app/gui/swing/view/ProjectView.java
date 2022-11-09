package dsw.gerumap.app.gui.swing.view;

import dsw.gerumap.app.mapRepository.implementation.Project;
import dsw.gerumap.app.observer.ISubscriber;

import javax.swing.*;

public class ProjectView extends JPanel implements ISubscriber {

    private JLabel name;
    private JLabel autor;

    private Project project;

    private MyTabbedPane mapsTabbedPane;

    public ProjectView(Project project) {
        this.project = project;
        this.name = new JLabel(this.project.getName());
        this.autor = new JLabel(this.project.getAuthor());
        this.mapsTabbedPane = new MyTabbedPane(SwingConstants.TOP, JTabbedPane.SCROLL_TAB_LAYOUT);
    }

    @Override
    public void update(Object notification) {
        if(notification instanceof Project) {
            this.name.setText(((Project) notification).getName());
            this.autor.setText(((Project) notification).getAuthor());
        }
    }
}
