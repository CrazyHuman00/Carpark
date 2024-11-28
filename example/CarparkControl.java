package example;

public class CarparkControl 
{
    private Integer spaces;
    private Integer capacity;

    public CarparkControl(Integer capacity) 
    {
        this.spaces = capacity;
        this.capacity = capacity;
    }

    public synchronized void arrive() 
    {
        if (spaces > 0)
        {
            spaces--;
            System.out.println("車が到着しました。残りスペースは" + spaces + "個です。");
        }
    }

    public synchronized void depart() 
    {
        if (spaces < capacity)
        {
            spaces++;
            System.out.println("車が出発しました。残りスペースは" + spaces + "個です。");
        }
    }
}
