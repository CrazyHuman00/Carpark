### 取扱説明 (コンパイル&実行方法)

#### ディレクトリ構成
```
CARPARK
|--Makefile
|--README.md
|--classes
|  |--example
|  |  |--Arrivals.class
|  |  |--Carpark.class
|  |  |--CarparkControl.class
|  |  |--Departures.class
|--example
|  |--Arrivals.java
|  |--Carpark.java
|  |--CarparkControl.java
|  |--Departures.java
|--g2253037_CARPARK.lts
```

#### チャラ
このディレクトリ元で下記のコマンドを入力してください。このコマンドを入力するとクラスファイルが削除されチャラになります。

```
$ make clean
```

#### コンパイル
下記のコマンドを入力してください。これによってjavaファイルがコンパイルされます。

```
$ make compile
```

#### 実行
下記のコマンドを入力すると、シュミレータが起動します。引数を与えない場合はデフォルトで制限台数10個とシミュレーション時間10秒が入ります。

```
$ make test
```


引数を与えたい場合には`capacity=###`, `time=###`という感じで引数を与えてください。

```
20個、60秒の場合
$ make test capacity=20 time=60
100個、15秒の場合
$ make test capacity=100 time=15
```

### 実装したプログラムの説明（どの部分がモニタの実装かなど）
　まずプログラムを実行するとCarparkクラスが実行され、CarparkControlクラスおよびArrivalsクラス、Departureクラスのインスランスが生成されます（後者2つはスレッド）。そのあとは、それぞれのスレッドが動き、`space`が加減されていきます。CarparkControlクラスの`arrive()`メソッドと、`departure()`メソッドがモニタ部分となっています。互いに`synchronized`がついており、実行できるスレッドを一つだけに制限しています。`arrive()`メソッドが呼び出されても、空きがないと中のロジックが実行されません。また`departure()`メソッドが呼び出されても、車が1台も止まっていなかったら実行されません。


### 拡張した点などがあれば，記載すること
- 駐車台数の制限数とシュミレーション時間をコマンドラインで自分で設定できるようにした。
- makeファイルを使った実行方法を試した。
- 出力をなるべくわかりやすくした。