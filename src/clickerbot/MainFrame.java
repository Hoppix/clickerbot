package clickerbot;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MainFrame implements ActionListener
{

    private JFrame frmClickerbot;
    static clicker clicker;
    public JButton btnStart;
    public JButton btnStop;
    public JLabel isActive;

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
                    window.frmClickerbot.setVisible(true);
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
        frmClickerbot = new JFrame();
        frmClickerbot.getContentPane()
            .setBackground(Color.GRAY);
        frmClickerbot.setTitle("Clickerbot");
        frmClickerbot.setBounds(100, 100, 300, 180);
        frmClickerbot.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmClickerbot.getContentPane()
            .setLayout(null);

        btnStart = new JButton("Start");
        btnStart.setForeground(Color.GRAY);
        btnStart.setBackground(Color.DARK_GRAY);
        btnStart.setBounds(20, 91, 110, 39);
        frmClickerbot.getContentPane()
            .add(btnStart);

        btnStop = new JButton("Stop");
        btnStop.setForeground(Color.GRAY);
        btnStop.setBackground(Color.DARK_GRAY);
        btnStop.setBounds(158, 91, 96, 39);
        frmClickerbot.getContentPane()
            .add(btnStop);

        btnStart.addActionListener(this);
        btnStop.addActionListener(this);
        frmClickerbot.setAlwaysOnTop(true);
        frmClickerbot.getRootPane()
            .setDefaultButton(btnStop);

        isActive = new JLabel("Bot is inactive");
        isActive.setForeground(Color.LIGHT_GRAY);
        isActive.setBounds(24, 11, 106, 39);
        frmClickerbot.getContentPane()
            .add(isActive);
        frmClickerbot.setDefaultLookAndFeelDecorated(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == this.btnStart)
        {
            btnStart.setEnabled(false);
            btnStop.setEnabled(true);
            isActive.setText("Bot is active");
            clicker.startSpam();
        }
        if (e.getSource() == this.btnStop)
        {
            btnStop.setEnabled(false);
            btnStart.setEnabled(true);
            isActive.setText("Bot is inactive");
            clicker.stopSpam();
        }
    }
}
