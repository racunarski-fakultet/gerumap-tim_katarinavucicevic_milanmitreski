package dsw.gerumap.app.gui.swing.view;

import dsw.gerumap.app.AppCore;
import dsw.gerumap.app.message.MessageType;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class RefactorDialog extends JDialog {

    private boolean toggled = false;
    public RefactorDialog(Frame owner, String title) {

        super(owner, title);

        setBounds(0, 0, 700, 500);
        setLocationRelativeTo(null);
        setResizable(true);
        Container dialogContent = getContentPane();
        FlowLayout flowLayout = new FlowLayout();
        flowLayout.setHgap(10);
        dialogContent.setLayout(flowLayout); /// ako se promeni ovaj FlowLayout onda moze da se menja raspored komponenti
        ProjectView pv = (ProjectView) MainFrame.getInstance().getSplit().getRightComponent();
        MapView mv = (MapView)pv.getMapsTabbedPane().getSelectedComponent();
        ElementView current = mv.getSelected();

        JLabel lblStroke = new JLabel("Stroke ");
        JSlider strokeSlider = new JSlider(0,10, mv.getStroke());
        strokeSlider.setMajorTickSpacing(5);
        strokeSlider.setMinorTickSpacing(1);
        strokeSlider.setPaintTicks(true);
        strokeSlider.setPaintLabels(true);

        JButton saveBtn = new JButton("Save");
        JButton closeBtn = new JButton("Close");
        JColorChooser colorChooser;
        colorChooser = new JColorChooser(Color.BLACK); // defaultna boja je crna
        colorChooser.setColor(mv.getColor());

        // promena imena elementa
        JLabel renameLbl = new JLabel("Insert new name: ");
        JTextField renameTf = new JTextField();
        JButton renameBtn = new JButton("Rename");
        renameTf.setColumns(20);

        renameBtn.setAction(new AbstractAction("Rename") {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(renameTf.getText().equals("")) {
                    AppCore.getInstance().getMessageGenerator().getMessage("Name can't be empty", MessageType.NAME_CANNOT_BE_EMPTY);
                    return;
                }
                current.getElement().setName(renameTf.getText());
            }
        });

        saveBtn.setAction(new AbstractAction("Save") {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                current.getElement().setColor(colorChooser.getColor().getRGB());
                current.getElement().setStroke(strokeSlider.getValue());
                mv.setSelected(null);
                repaint();
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
        add(renameLbl);
        add(renameTf);
        add(renameBtn);
    }

}
