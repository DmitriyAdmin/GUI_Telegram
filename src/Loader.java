import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Loader
    {
        public static void main(String[] args)
            {
                MyFrame myFrame = new MyFrame();

                myFrame.setLocationRelativeTo(null);
                myFrame.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent windowEvent) {
                        System.exit(0);
                    }
                });
                myFrame.setVisible(true);
            }
    }
