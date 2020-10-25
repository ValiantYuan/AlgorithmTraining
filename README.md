# AlgorithmTraining
记录一些面试算法题的实现

git config --global user.name [username]
git config --global user.email [email]
git clone git@github.com:ValiantYuan/AlgorithmTraining.git


递归和迭代的区别：
1.递归表示自己中包含自己，自己调用自己
用程序表述：void f(int n){f(n - 1) + f(n -2)}
典型例子：斐波那契数列计算
递归可以理解为一个树形结构，可以画出递归树

2.迭代是把输出作为输入，再次处理
用程序表述：for (int i=0; i < 100; i++) n = f(n);
一个典型的例子：
long[] statistic = getMod3CountInRange(l, r);
long[] result = new long[3];
long[] preResult = new long[3];
copyValue(statistic, result);
for (int i = 1; i < n; i++) {
    copyValue(result, preResult);
    result[0] = ((preResult[0] * statistic[0]) + (preResult[1] * statistic[2]) + (preResult[2] * statistic[1])) % (1000000000L + 7);
    result[1] = ((preResult[0] * statistic[1]) + (preResult[1] * statistic[0]) + (preResult[2] * statistic[2])) % (1000000000L + 7);
    result[2] = ((preResult[0] * statistic[2]) + (preResult[1] * statistic[1]) + (preResult[2] * statistic[0])) % (1000000000L + 7);
}


所有迭代都可以表示成递归，但不是所有递归都能表示成迭代
