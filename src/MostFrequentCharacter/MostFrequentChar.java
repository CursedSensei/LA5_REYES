package MostFrequentCharacter;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class MostFrequentChar extends JFrame {
    private JPanel pName;
    private JTextArea textArea;
    private JLabel frequentCharLabel;

    private void checkText() {
        String text = String.join("", textArea.getText().split(" ")).toLowerCase();
        char chara = ' ';
        int charaLen = 0;
        while (text.length() > 0) {
            char curChar = text.charAt(0);
            int len = text.length();

            text = text.replace(String.valueOf(curChar), "");
            len -= text.length();
            if (charaLen < len) {
                charaLen = len;
                chara = curChar;
            }
        }

        frequentCharLabel.setText("The most frequent character is: " + chara);
    }

    public MostFrequentChar() {
        textArea.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                checkText();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                checkText();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                checkText();
            }
        });
    }

    public static void main(String[] args) {
        MostFrequentChar s = new MostFrequentChar();
        s.setContentPane(s.pName);
        s.setSize(600, 300);
        s.setDefaultCloseOperation(EXIT_ON_CLOSE);
        s.setVisible(true);
        s.setTitle("Most Frequent Char");
    }
}
