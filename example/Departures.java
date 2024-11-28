package example;

public class Departures extends Thread
{
    private CarparkControl control;
    private Integer waitTime;

    public Departures(CarparkControl control) 
    {
        this.control = control;
        this.waitTime = (int)(Math.random() * 3000);
    }

    @Override
    public void run()
    {
        while (true) 
        {
            try
            {
                Thread.sleep(waitTime);
                control.depart();
            } 
            catch (InterruptedException e) 
            {
                e.printStackTrace();
            }
        }
    }
}
