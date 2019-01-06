import intro.PhoneNumberPhone;
import undecorated.ComponentResizerAbstract;
import undecorated.Decoration;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyFrame extends JFrame
    {
        private Decoration undecoratedFrame = new Decoration(this, ComponentResizerAbstract.KEEP_RATIO_CENTER);
        private Component panel = new JScrollPane();
        private PhoneNumberPhone phoneNumberPhone = new PhoneNumberPhone();

        {
            setSize(800, 600);
            undecoratedFrame.setContentPanel(panel);
            undecoratedFrame.addActionListenerForMinimize(e -> setState(ICONIFIED));
            undecoratedFrame.setContentPanel(phoneNumberPhone);
            closeWindow();

        }

        private void closeWindow()
            {

                // ВАРИАНТ 1 (сведение к windowClosed)
                setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                undecoratedFrame.addActionListenerForClose(e -> dispose());
                addWindowListener(new WindowAdapter()
                    {
                        @Override
                        public void windowClosed(WindowEvent windowEvent)
                            {
                                super.windowClosed(windowEvent);
                                close();
                            }
                    });
            }

        private void close()
            {
                System.out.println("Closed!");
                System.exit(0);
            }

    }
