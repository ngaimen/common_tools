# 常用命令
## vimgrep
```
vimgrep 字串 %             在当前打开文件中查找 
vimgrep 字串 *             在当前目录下查找所有
vimgrep 字串 **            在当前目录及子目录下查找所有
vimgrep 字串 *.c           查找当前目录下所有.c文件
vimgrep 字串 **/*.c        查找当前目录及子目录下所有.c文件
vimgrep 字串 **/*          只查找子目录

cn                查找下一个
cp                查找上一个
copen             打开quickfix
cw                打开quickfix
cclose            关闭qucikfix
help vimgrep      查看vimgrep帮助
```

## 窗口命令
### 打开窗口
```
:split或new                 打开一个新窗口，光标停在顶层的窗口上
:split file或:new file      用新窗口打开文件
:vsplit                    纵向打开窗口。
```
### 移动到窗口
```
Ctrl+w+w                   移动到下一个窗口
Ctrl+w+j                   移动到下方的窗口
Ctrl+w+k                   移动到上方的窗口
Ctrl+w+l                   移动到右侧的窗口
Ctrl+w+h                   移动到左侧的窗口
```
### 关闭窗口
```
:close          最后一个窗口不能使用此命令，可以防止意外退出vim。
:q              如果是最后一个被关闭的窗口，那么将退出vim。
:only           关闭所有窗口，只保留当前窗口
```
# Tagbar
```
命令              描述        
F1                关闭/显示帮助信息；
q                 关闭Tagbar窗口；
x                 放大/缩小Tagbar窗口； 
s                 项目排序切换；  
+, <kPlus>, zo    展开折叠；  
-, <kMinus>, zc   收起折叠；
o, za             折叠收起\展开切换；   
*, <kMultiply>, zR展开所有折叠； 
=, zM             收起所有折叠；
回车              转到标签定义处，并且光标跳转到标签定义处；    
p                 转到标签定义处，但光标停留在Tagbar的窗口； 
P                 在预览窗口显示标签；
<C-N>             跳到下一个上级标签；
<C-P>             跳到上一个上级标签； 
<Space>           显示标签定义；
 ```
