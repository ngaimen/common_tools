### 编译服务器编译源码出现JACK错误
错误： Communication error with Jack server (52）<br><br>
主要原因： 同一个编译服务器上都绑定了同一个jack server 端口， 导致有些用户不能启动jack server<br>
方法： 修改~/.jack  ~/.jack-settings  ~/.jack-server/config.properties这几个文件，哪个存在改哪个，可能同时存在多个。 把端口改成其他， 然后编译<br>
如果还是不行重启jack ，重启方法 jack-admin start-server<br>
如果出现 JACK_JAR: unbound variable ， 则 export JACK_JAR=./out/host/linux-x86/framework/jack.jar<br>
直接运行jack-admin 可以查看jack-admin命令的其他帮助。 例如可以看log listserver等<br>

### 出现Java堆错误
错误  ：Try increasing heap size with java option '-Xmx<size>'. <br>
修改build/make/core/config.mk<br>
APICHECK_COMMAND := $(APICHECK) -JXmx2048m -J"classpath $(APICHECK_CLASSPATH)"<br>
或者：<br>
export JACK_SERVER_VM_ARGUMENTS="-Dfile.encoding=UTF-8 -XX:+TieredCompilation -Xmx4g"<br>
然后重启javck server<br>
./prebuilts/sdk/tools/jack-admin kill-server<br>
./prebuilts/sdk/tools/jack-admin start-server<br>