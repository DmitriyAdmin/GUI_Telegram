package intro;

import Helpers.Helper;

import javax.swing.*;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import java.text.ParseException;

public class PhoneNumberPhone extends JPanel
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
    }
