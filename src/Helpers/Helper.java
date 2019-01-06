package Helpers;

import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

public class Helper
    {
        public static void centerAlignText(JTextPane textPane)
            {
                SimpleAttributeSet attribs = new SimpleAttributeSet();
                StyleConstants.setAlignment(attribs, StyleConstants.ALIGN_CENTER);
                textPane.setParagraphAttributes(attribs, false);
            }
    }
