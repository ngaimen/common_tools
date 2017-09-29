# 常用命令
## vimgrep
vimgrep 字串 %             在当前打开文件中查找 <br>
vimgrep 字串 *             在当前目录下查找所有<br>
vimgrep 字串 **            在当前目录及子目录下查找所有<br>
vimgrep 字串 *.c           查找当前目录下所有.c文件<br>
vimgrep 字串 **/*.c        查找当前目录及子目录下所有.c文件<br>
vimgrep 字串 **/*          只查找子目录<br>

cn                查找下一个<br>
cp                查找上一个<br>
copen             打开quickfix<br>
cw                打开quickfix<br>
cclose            关闭qucikfix<br>
help vimgrep      查看vimgrep帮助<br>

## 窗口命令
### 打开窗口
:split或new 打开一个新窗口，光标停在顶层的窗口上<br>
:split file或:new file 用新窗口打开文件<br>
:vsplit 纵向打开窗口。<br>
### 移动到窗口
Ctrl+w+w 移动到下一个窗口<br>
Ctrl+w+j 移动到下方的窗口<br>
Ctrl+w+k 移动到上方的窗口<br>
Ctrl+w+l 移动到右侧的窗口<br>
Ctrl+w+h 移动到左侧的窗口<br>

### 关闭窗口
:close 最后一个窗口不能使用此命令，可以防止意外退出vim。<br>
:q 如果是最后一个被关闭的窗口，那么将退出vim。<br>
:only 关闭所有窗口，只保留当前窗口<br>
