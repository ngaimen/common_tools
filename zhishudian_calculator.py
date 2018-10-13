#!/usr/bin/python3
if __name__ == '__main__':
    select = int(input('1.计算进入指数点\n'))
    
    if select == 1:
        zongtourujine = float(input('总投入金额:\n'))
        meifenjine = float(input('每份金额\n'))
        yujizuidizhishudian = float(input('最低估计指数点\n'))
        mairujiange = float(input('买入间隔比率\n'))

        mairucishu = zongtourujine / 10 / meifenjine / 2

        jieshoudiefu = mairucishu * mairujiange

        jinruzhishudian = yujizuidizhishudian / (1 - jieshoudiefu / 2)

        print('进入指数点 %f' % jinruzhishudian)

