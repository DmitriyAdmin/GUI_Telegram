import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

public class Loader
    {
        public static void main(String[] args) throws IOException
            {
                MyFrame myFrame = new MyFrame();

                myFrame.setAlwaysOnTop(true);
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
