package dsw.gerumap.app.gui.swing.view;

import dsw.gerumap.app.AppCore;
import dsw.gerumap.app.gui.swing.controller.ActionManager;
import dsw.gerumap.app.core.MapTree;
import dsw.gerumap.app.gui.swing.tree.MapTreeImplementation;
import dsw.gerumap.app.gui.swing.view.rightWorkspace.WorkSpaceImplementation;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MainFrame extends JFrame {

    private static MainFrame instance = null;
    private ActionManager actionManager;
    private MapTree mapTree;
    private WorkSpaceImplementation workspace;
    private JSplitPane split;
    private List<ProjectView> projectViews;

    private MainFrame() {

    }

    private void initialise() {
        actionManager = new ActionManager();
        mapTree = new MapTreeImplementation();
        projectViews = new ArrayList<>();
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


        MyMenuBar menu = new MyMenuBar();
        setJMenuBar(menu);

        Toolbar toolBar = new Toolbar();
        add(toolBar, BorderLayout.NORTH);

        SideToolbar sideToolbar = new SideToolbar();
        add(sideToolbar, BorderLayout.EAST);

        JTree projectExplorer = mapTree.generateTree(AppCore.getInstance().getMapRepository().getProjectExplorer());
        projectExplorer.addMouseListener(actionManager.getMyMouseListener());

        workspace = new WorkSpaceImplementation();

        JScrollPane scroll = new JScrollPane(projectExplorer);
        scroll.setMinimumSize(new Dimension(200, 150));

        split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, scroll, new JPanel());

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

    public ActionManager getActionManager() {
        return actionManager;
    }

    public WorkSpaceImplementation getWorkspace() {
        return workspace;
    }

    public JSplitPane getSplit() {
        return split;
    }

    public List<ProjectView> getProjectViews() {
        return projectViews;
    }
}
