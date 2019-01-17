package intro;

import Helpers.Helper;

import javax.swing.*;
import java.awt.event.ActionListener;

public class RegistrationForm extends JPanel
    {
        private JPanel rootPanel;
        private JTextPane textPane;
        private JTextField nameTextField;
        private JTextField surnameTextField;
        private JButton nextButton;

        {
            Helper.centerAlignText(textPane);
        }

        private void createUIComponents()
            {
                // TODO: place custom component creation code here
                rootPanel = this;
            }

        public void addNextButtonListener(ActionListener listener)
            {
                nextButton.addActionListener(listener);
            }

        public void removeNextButtonListener(ActionListener listener)
            {
                nextButton.removeActionListener(listener);
            }
    }
