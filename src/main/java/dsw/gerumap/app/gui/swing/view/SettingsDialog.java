package dsw.gerumap.app.gui.swing.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class SettingsDialog extends JDialog {


    public SettingsDialog(Frame owner, String title) {
        super(owner, title);

        setBounds(0, 0, 700, 500);
        setLocationRelativeTo(null);
        setResizable(true);
        Container dialogContent = getContentPane();
        FlowLayout flowLayout = new FlowLayout();
        flowLayout.setHgap(10);
        dialogContent.setLayout(flowLayout);
        ProjectView pv = (ProjectView) MainFrame.getInstance().getSplit().getRightComponent();
        MapView mv = (MapView)pv.getMapsTabbedPane().getSelectedComponent();

        JLabel lblStroke = new JLabel("Stroke ");
        JSlider strokeSlider = new JSlider(0,10,mv.getStroke());
        strokeSlider.setMajorTickSpacing(5);
        strokeSlider.setMinorTickSpacing(1);
        strokeSlider.setPaintTicks(true);
        strokeSlider.setPaintLabels(true);

        JButton saveBtn = new JButton("Save");
        JButton closeBtn = new JButton("Close");
        JColorChooser colorChooser;
        colorChooser = new JColorChooser(new Color(mv.getColor()));
        colorChooser.setColor(mv.getColor());
        saveBtn.setAction(new AbstractAction("Save") {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                mv.setColor(colorChooser.getColor().getRGB());
                mv.setStroke(strokeSlider.getValue());
            }
        });

        closeBtn.setAction(new AbstractAction("Close") {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                dispose();
            }
        });

        add(lblStroke);
        add(strokeSlider);
        add(saveBtn);
        add(closeBtn);
        add(colorChooser);
    }
}
