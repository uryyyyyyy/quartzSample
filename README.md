
# usage of quartz-scheduler

## 概要

JobDetailとTriggerによって定期実行を行う。


## JobDetail

JobBuilderによって作られる。

newJob -> どのJobクラスを実行するか選ぶ（匿名クラスでは動かなかった。）
storeDurably -> Triggerに参照されなくても存在し続けるか否か
requestRecovery -> 失敗時に再実行するか否か
setJobData -> Job実行時に使える変数群をsetする。
withIdentity -> 名前を付ける。


## TODO
即時実行
平日（休日の考慮）
毎週末の平日
月末（休日を含む/除く）
特定の日のみ
特定の日を除外
例外時の復旧
spring上で実行
読み込みと書き込みの分散（DB上）
あるジョブが終わったタイミングで別のジョブを実行
