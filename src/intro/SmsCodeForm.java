package intro;

import Helpers.Helper;

import javax.swing.*;
import java.awt.event.ActionListener;

public class SmsCodeForm extends JPanel
    {
        private JPanel rootPanel;
        private JTextPane textPane;
        private JPasswordField passwordField;
        private JButton nextButton;

        {
            Helper.centerAlignText(textPane);
        }

        private void createUIComponents()
            {
                // TODO: place custom component creation code here
                rootPanel = this;
            }

        public String getSmsCode()
            {
                return new String(passwordField.getPassword());
            }

        public void addNextButtonListener(ActionListener listener)
            {
                nextButton.addActionListener(listener);
                passwordField.addActionListener(listener);
            }

        public void removeNextButtonListener(ActionListener listener)
            {
                nextButton.removeActionListener(listener);
                passwordField.removeActionListener(listener);
            }
    }
