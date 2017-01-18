package clickerbot;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;

public class clicker
{
    public static Robot robot;
    public static boolean set;

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
        set = true;
    }

    /** helper method to send the given key to the active application */
    public static void sendKey(int keyCode)
    {
        robot.keyPress(keyCode);
        robot.keyRelease(keyCode);
        robot.delay(500); // for you to see the keystroke
    }

    /** helper method to send a mouse-click to the active application */
    public static void sendMouseClick(int x, int y)
    {
        robot.mouseMove(x, y);
        robot.delay(1000); // for you to see the move
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
    }

    /**click without x and y coords*/
    public static void startSpam()
    {
        while (set)
        {
            robot.delay(10);
            robot.mousePress(InputEvent.BUTTON1_MASK);
            robot.delay(10);
            robot.mouseRelease(InputEvent.BUTTON1_MASK);
        }
    }

    public static void stopSpam()
    {
        set = false;
    }

}
