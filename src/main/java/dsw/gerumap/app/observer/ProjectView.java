package dsw.gerumap.app.observer;

import javax.swing.*;

public class ProjectView implements ISubscriber{

    private JLabel name;

    public ProjectView() {
        name = new JLabel();
    }

    @Override
    public void update(Object notification) {

    }
}
