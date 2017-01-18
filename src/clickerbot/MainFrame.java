package clickerbot;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MainFrame implements ActionListener
{

    private JFrame frame;
    static clicker clicker;
    public JButton btnStart;
    public JButton btnStop;

    /**
     * Launch the application.
     */
    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                try
                {
                    MainFrame window = new MainFrame();
                    window.frame.setVisible(true);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        });
        clicker = new clicker();
    }

    /**
     * Create the application.
     */
    public MainFrame()
    {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize()
    {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane()
            .setLayout(null);

        btnStart = new JButton("Start");
        btnStart.setBounds(66, 109, 89, 23);
        frame.getContentPane()
            .add(btnStart);

        btnStop = new JButton("Stop");
        btnStop.setBounds(241, 109, 89, 23);
        frame.getContentPane()
            .add(btnStop);

        btnStart.addActionListener(this);
        btnStop.addActionListener(this);
        btnStop.addKeyListener(new KeyListener()
        {

            @Override
            public void keyPressed(KeyEvent e)
            {
                frame.dispose();

            }

            @Override
            public void keyReleased(KeyEvent e)
            {
                // TODO Auto-generated method stub

            }

            @Override
            public void keyTyped(KeyEvent e)
            {
                // TODO Auto-generated method stub

            }
        });
        frame.setAlwaysOnTop(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == this.btnStart)
        {
            clicker.startSpam();
        }
        if (e.getSource() == this.btnStop)
        {
            clicker.stopSpam();
        }
    }
}
