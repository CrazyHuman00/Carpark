package example;

public class Carpark 
{
    CarparkControl control;
    public static void main(String[] args) 
    {
        // コマンドライン引数から駐車場の容量を取得
        Integer capacity = Integer.parseInt(args[0]);
        Integer simulationTime = Integer.parseInt(args[1]);
        System.out.println("駐車場の容量は: " + capacity + "個です。");
        System.out.println("シミュレーション時間は: " + simulationTime + "秒です。");

        // CarparkControlオブジェクトを生成
        CarparkControl control = new CarparkControl(capacity);

        // ArrivalsとDeparturesのスレッドを生成
        Arrivals arrivals = new Arrivals(control);
        Departures departures = new Departures(control);

        // スレッドを開始
        arrivals.start();
        departures.start();

        try
        {
            // 30秒間スレッドを実行
            arrivals.join(simulationTime * 1000);
            departures.join(simulationTime * 1000);

            // スレッドが終了したらプログラムを終了
            System.out.println("シミュレーションを終了します。");
            System.exit(0);
        } 
        catch (InterruptedException e) 
        {
            e.printStackTrace();
        }
    }
}
