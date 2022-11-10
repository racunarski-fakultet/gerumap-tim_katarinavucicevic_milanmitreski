package dsw.gerumap.app.gui.swing.view;

import dsw.gerumap.app.AppCore;
import dsw.gerumap.app.gui.swing.controller.ActionManager;
import dsw.gerumap.app.core.MapTree;
import dsw.gerumap.app.gui.swing.controller.MyMouseListener;
import dsw.gerumap.app.gui.swing.tree.MapTreeImplementation;
import dsw.gerumap.app.gui.swing.tree.view.MapTreeView;
import dsw.gerumap.app.gui.swing.view.rightWorkspace.WorkSpaceImplementation;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private static MainFrame instance = null;

    private ActionManager actionManager;
    private MyMenuBar menu;
    private Toolbar toolBar;
    private MapTree mapTree;
    private MyTabbedPane tabbedPane;

    private WorkSpaceImplementation workspace;

    private JPanel desktop;

    private JSplitPane split;

    private MainFrame() {

    }

    private void initialise() {
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
        setSize(screenWidth / 2, screenHeight / 2);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("GeRuMap app");


        menu = new MyMenuBar();
        setJMenuBar(menu);

        toolBar = new Toolbar();
        add(toolBar, BorderLayout.NORTH);

        JTree projectExplorer = mapTree.generateTree(AppCore.getInstance().getMapRepository().getProjectExplorer());
        projectExplorer.addMouseListener(new MyMouseListener());

        workspace = new WorkSpaceImplementation();
        desktop = new JPanel();

        //tabbedPane = new MyTabbedPane(JTabbedPane.TOP, JTabbedPane.WRAP_TAB_LAYOUT);
        //desktop.add(tabbedPane);

        JScrollPane scroll = new JScrollPane(projectExplorer);
        scroll.setMinimumSize(new Dimension(200, 150));
        split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, scroll, desktop);

        getContentPane().add(split, BorderLayout.CENTER);
        split.setDividerLocation(250);
        split.setOneTouchExpandable(true);

    }

    public static MainFrame getInstance() {
        if (instance == null) {
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

    public WorkSpaceImplementation getWorkspace() {
        return workspace;
    }

    public JPanel getDesktop() {
        return desktop;
    }

    public JSplitPane getSplit() {
        return split;
    }
}
