package intro;

import Helpers.Helper;

import javax.swing.*;

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
    }
