package dsw.gerumap.app.gui.swing.controller;

import dsw.gerumap.app.gui.swing.view.MapView;
import dsw.gerumap.app.gui.swing.view.MyTabbedPane;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

public class AddTabAction extends AbstractGeRuMapAction{

    // na dvoklik necega sto je instanceof MindMap treba da otvori novi Tab

    private MyTabbedPane myTabbedPane;

    @Override
    public void actionPerformed(ActionEvent e) {

        myTabbedPane.addTab("mapa", new MapView());

        //myTabbedPane.addTab();

        ///int i = myTabbedPane.indexOfTabComponent(ButtonTabComponent.this);
        //if (i != -1) {
        //    myTabbedPane.add(i);
         //   myTabbedPane.remove(i);
        //}



    }
}
