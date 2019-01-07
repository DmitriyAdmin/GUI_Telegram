package intro;

import Helpers.Helper;

import javax.swing.*;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import java.awt.event.ActionListener;
import java.text.ParseException;

public class PhoneNumberForm extends JPanel
    {
        private JPanel rootPanel;
        private JButton nextButton;
        private JTextPane textPane;
        private JFormattedTextField phoneTextField;

        {
            Helper.centerAlignText(textPane);
            try
                {
                    MaskFormatter maskFormatter = new MaskFormatter("+38(###) ###-##-##");
                    maskFormatter.setPlaceholderCharacter('_');

                    phoneTextField.setFormatterFactory(new DefaultFormatterFactory(maskFormatter));
                }
            catch(ParseException e)
                {
                    e.printStackTrace();
                }

        }

        private void createUIComponents()
            {
                // TODO: place custom component creation code here
                rootPanel = this;
            }

        public String getPhone()
            {
                try
                    {
                        phoneTextField.commitEdit();
                        return phoneTextField.getValue().toString().replaceAll("[^0-9+]", "");
                    }
                catch(ParseException e)
                    {
                        return null;
                    }
            }

        public void addNextButtonListener(ActionListener listener)
            {
                nextButton.addActionListener(listener);
                phoneTextField.addActionListener(listener);
            }

        public void removeNextButtonListener(ActionListener listener)
            {
                nextButton.removeActionListener(listener);
                phoneTextField.removeActionListener(listener);
            }
    }
