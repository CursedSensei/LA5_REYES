package ItemListener;

import FoodOrderingSystem.FoodOrderingSystem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ItemListener extends JFrame {
    private JPanel pName;
    private JCheckBox cCheckBox;
    private JCheckBox cppCheckBox;
    private JCheckBox cSharpCheckBox;
    private JCheckBox javaCheckBox;
    private JCheckBox pythonCheckBox;
    private JComboBox proficiencyComboBox;
    private JLabel proficiencyLabel;
    private JLabel languageLabel;

    public ItemListener() {
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JCheckBox self = (JCheckBox) e.getSource();
                String[] languageText = languageLabel.getText().split(": ");
                if (languageText.length == 1) {
                    languageLabel.setText("My Favorite Languages: " + self.getText());
                    return;
                }

                languageText = languageText[1].split(", ");
                if (self.isSelected()) {
                    languageLabel.setText(languageLabel.getText() + ", " + self.getText());
                } else {
                    String[] newLanguage = new String[languageText.length - 1];
                    int idx = 0;

                    for (String s : languageText) {
                        if (!s.equals(self.getText())) newLanguage[idx++] = s;
                    }

                    languageLabel.setText("My Favorite Languages: " + String.join(", ", newLanguage));
                }
            }
        };
        cCheckBox.addActionListener(listener);
        cppCheckBox.addActionListener(listener);
        cSharpCheckBox.addActionListener(listener);
        javaCheckBox.addActionListener(listener);
        pythonCheckBox.addActionListener(listener);
        proficiencyComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                proficiencyLabel.setText("Proficiency: " + proficiencyComboBox.getSelectedItem());
            }
        });
    }

    public static void main(String[] args) {
        ItemListener s = new ItemListener();
        s.setContentPane(s.pName);
        s.setSize(320, 290);
        s.setTitle("Item Listener");
        s.setDefaultCloseOperation(EXIT_ON_CLOSE);
        s.setVisible(true);
    }
}
