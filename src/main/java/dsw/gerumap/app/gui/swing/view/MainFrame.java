package dsw.gerumap.app.gui.swing.view;

import dsw.gerumap.app.AppCore;
import dsw.gerumap.app.gui.swing.controller.ActionManager;
import dsw.gerumap.app.core.MapTree;
import dsw.gerumap.app.gui.swing.tree.MapTreeImplementation;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private static MainFrame instance = null;

    private ActionManager actionManager;
    private MyMenuBar menu;
    private Toolbar toolBar;
    private MapTree mapTree;
    private MyTabbedPane tabbedPane;

    private MainFrame() {

    }

    private void initialise(){
        actionManager = new ActionManager();
        mapTree = new MapTreeImplementation();
        initialiseGUI();
    }

    public void initialiseGUI() {

        // Toolkit, Dimension instance sluze za definisanje velicine
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;

        // Definisanje velicina
        setSize(screenWidth/2, screenHeight/2);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("GeRuMap app");

        /// stvari za TabbedPane
        tabbedPane = new MyTabbedPane(SwingConstants.TOP, JTabbedPane.SCROLL_TAB_LAYOUT);
        add(tabbedPane, BorderLayout.EAST);



        menu = new MyMenuBar();
        setJMenuBar(menu);

        toolBar = new Toolbar();
        add(toolBar, BorderLayout.NORTH);

        JTree projectExplorer = mapTree.generateTree(AppCore.getInstance().getMapRepository().getProjectExplorer());
        JPanel desktop = new JPanel();

        JScrollPane scroll = new JScrollPane(projectExplorer);
        scroll.setMinimumSize(new Dimension(200, 150));
        JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, scroll, tabbedPane);
        getContentPane().add(split,BorderLayout.CENTER);
        split.setDividerLocation(250);
        split.setOneTouchExpandable(true);

    }

    public static MainFrame getInstance() {
        if(instance == null) {
            instance = new MainFrame();
            instance.initialise();
        }
        return instance;
    }

    public MapTree getMapTree() {
        return mapTree;
    }

    public MyTabbedPane getTabbedPane() {
        return tabbedPane;
    }

    public ActionManager getActionManager() {
        return actionManager;
    }
}
