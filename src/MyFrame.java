import fake.TelegramApiBridge;
import intro.PhoneNumberForm;
import intro.RegistrationForm;
import intro.SmsCodeForm;
import org.javagram.response.AuthCheckedPhone;
import undecorated.ComponentResizerAbstract;
import undecorated.Decoration;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

public class MyFrame extends JFrame
    {
        private Decoration undecoratedFrame = new Decoration(this, ComponentResizerAbstract.KEEP_RATIO_CENTER);
        private Component panel = new JScrollPane();
        private PhoneNumberForm phoneNumberForm = new PhoneNumberForm();
        private SmsCodeForm smsCodeForm = new SmsCodeForm();
        private RegistrationForm registrationForm = new RegistrationForm();
        private TelegramApiBridge bridge = new TelegramApiBridge("", 1, "");

        public MyFrame() throws IOException
            {
            setSize(800, 600);
            undecoratedFrame.setContentPanel(panel);
            undecoratedFrame.addActionListenerForMinimize(e -> setState(ICONIFIED));
            undecoratedFrame.setContentPanel(phoneNumberForm);

            phoneNumberForm.addNextButtonListener(new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                        {
                            String phone = phoneNumberForm.getPhone();
                            System.out.println(phone);
                            if(phone == null)
                                {
                                    JOptionPane.showConfirmDialog(MyFrame.this, "Номер введен неверно", "Ошибка", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE);
                                }
                            else
                                {
                                    try
                                        {
                                            AuthCheckedPhone checkedPhone = bridge.authCheckPhone(phone);
                                            if(checkedPhone.isRegistered())
                                                setContentPanel(registrationForm);
                                                //setContentPanel(smsCodeForm);
                                        }
                                    catch(IOException e1)
                                        {
                                            e1.printStackTrace();
                                        }
                                }
                        }
                });

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

        protected void setContentPanel(Container container)
            {
                undecoratedFrame.setContentPanel(container);
                getContentPane().revalidate();
                getContentPane().repaint();
            }

    }
