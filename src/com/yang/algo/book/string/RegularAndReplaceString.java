package com.yang.algo.book.string;

/**
 * @ClassName RegularAndReplaceString
 * @Description Now Have a char chas[], which consists of nunber and '*'. I want to
 * put all '*' to the left of chas, and num right.
 * @Author YangC
 * @Date 2019/7/20 9:34
 **/
public class RegularAndReplaceString {
    //Question1
    public void replace(char[] chas){
        if (chas == null || chas.length == 0){
            return;
        }
        int num = 0;    //左半区空格数
        int len = 0;    //左半区大小
        for (len = 0; len < chas.length && chas[len] != 0; len ++){
            if (chas[len] == ' '){
                num ++;
            }
        }
        int j = len + 2 * num - 1;      //chas要扩到这么多
        for (int i = len - 1; i > -1; i --){
            if (chas[i] != ' '){
                chas[j --] = chas[i];
            }else {
                chas[j --] = '0';
                chas[j --] = '2';
                chas[j --] = '%';
            }
        }
    }
    //Question2  This question has one point that is the length of chas is not change
    public void modify(char[] chas){
        if (chas == null || chas.length == 0){
            return;
        }
        int j = chas.length - 1;
        for (int i = chas.length - 1; i > -1; i --){
            if (chas[i] != '*'){
                chas[j --] = chas[i];
            }
        }
        for (; j > -1;){
            chas[j --] = '*';
        }
    }

}
