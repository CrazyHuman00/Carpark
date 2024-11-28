package example;

public class Arrivals extends Thread 
{
    private CarparkControl control;
    private Integer waitTime;

    public Arrivals(CarparkControl control) 
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
                control.arrive();
            } 
            catch (InterruptedException e) 
            {
                e.printStackTrace();
            }
        }
    }
}
