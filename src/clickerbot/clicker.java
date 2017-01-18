package clickerbot;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;

public class clicker extends Thread
{
    public static Robot robot;
    public static boolean running;

    public clicker()
    {
        try
        {
            robot = new Robot();
        }
        catch (AWTException e)
        {
            e.printStackTrace();
        }
        running = false;
    }

    public static void MouseClick()
    {
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.delay(5);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
        robot.delay(5);
    }

    public void startSpam()
    {
        Thread thread = new Thread(new Runnable()
        {

            @Override
            public void run()
            {
                running = true;
                loopSpam();
            }

        });
        thread.start();
    }

    public void stopSpam()
    {
        running = false;
    }

    private void intervallSpam(int count)
    {
        for (int i = 0; i < count; i++)
        {
            MouseClick();
        }
    }

    private void loopSpam()
    {
        while (running)
        {
            MouseClick();
        }
    }

}
