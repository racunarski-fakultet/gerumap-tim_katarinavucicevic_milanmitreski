package dsw.gerumap.app.mapRepository.implementation;

import dsw.gerumap.app.gui.swing.view.MainFrame;
import dsw.gerumap.app.gui.swing.view.ProjectView;
import dsw.gerumap.app.mapRepository.composite.MapNode;
import dsw.gerumap.app.mapRepository.composite.MapNodeComposite;

import javax.swing.*;

public class ProjectExplorer extends MapNodeComposite {

    public ProjectExplorer(String name) {
        super(name, null);
    }

    @Override
    public void addChild(MapNode child) {
        if(child instanceof Project){
            Project project = (Project) child;
            if(!this.getChildren().contains(project)) {
                this.getChildren().add(project);
            }
        }
    }

    public void removeChild(MapNode child) {
        if(child instanceof Project) {
            Project element = (Project) child;
            this.getChildren().remove(element);
            if(MainFrame.getInstance().getSplit().getRightComponent() instanceof ProjectView) {
                if(((ProjectView) MainFrame.getInstance().getSplit().getRightComponent()).getProject().equals(element)) {
                    MainFrame.getInstance().getSplit().setRightComponent(new JPanel());
                }
            } /* IDEJA: Implementirati MySplitPane koji je observer */
        }
    }

}
