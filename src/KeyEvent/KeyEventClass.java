package KeyEvent;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class KeyEventClass extends JFrame {
    private JPanel pName;
    private JTextArea editableTextArea;
    private JTextArea nonEditableTextArea;

    private void getText() {
        String s = editableTextArea.getText().toLowerCase();
        s = s.replace('a', 'A');
        s = s.replace('e', 'E');
        s = s.replace('i', 'I');
        s = s.replace('o', 'O');
        s = s.replace('u', 'U');

        nonEditableTextArea.setText(s);
    }

    public KeyEventClass() {
        editableTextArea.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                getText();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                getText();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                getText();
            }
        });
    }

    public static void main(String[] args) {
        KeyEventClass s = new KeyEventClass();
        s.setContentPane(s.pName);
        s.setSize(600, 300);
        s.setDefaultCloseOperation(EXIT_ON_CLOSE);
        s.setVisible(true);
        s.setTitle("Key Event Class");
    }
}
