package dsw.gerumap.app.gui.swing.view.rightWorkspace;

import dsw.gerumap.app.gui.swing.view.ProjectView;

public class WorkSpaceImplementation implements IWorkspace{

    ProjectView projectView;

    @Override
    public ProjectView generateWorkspace() {
        projectView = new ProjectView();
        return projectView;
    }

    public ProjectView getProjectView() {
        return projectView;
    }
}
