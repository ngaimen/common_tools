## 硬件信息查看      
CPU：     
型号：grep "model name" /proc/cpuinfo |awk -F ':' '{print $NF}'         
数量：lscpu |grep "CPU socket" |awk '{print $NF}' 或 lscpu |grep "Socket" |awk '{print $NF}'             
每个CPU的核数：lscpu |grep "Core(s) per socket" |awk '{print $NF}'      
             
内存：                     
卡槽数量：sudo dmidecode -t memory |grep "Number Of Devices" |awk '{print $NF}'或sudo dmidecode -t memory |grep "Associated Memory Slots" |awk '{print $NF}'              
内存数量：sudo dmidecode -t memory |grep -A16 "Memory Device$" |grep 'Size:.*MB' |wc -l               
             
内存型号：             
内存支持类型：sudo dmidecode -t memory |grep -A16 "Memory Device$" |grep "Type:"            
每个内存频率：sudo dmidecode -t memory |grep -A16 "Memory Device$" |grep "Speed:"                 
每个内存大小：sudo dmidecode -t memory |grep -A16 "Memory Device$" |grep "Size:"               
              
硬盘：            
硬盘数量、大小：sudo fdisk -l |grep "Disk /dev/sd"            
硬盘型号：sudo hdparm -i /dev/sda |grep "Model"         

## 查找IP冲突
arping -I 网卡名（如eth0）冲突地址


