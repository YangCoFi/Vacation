package com.yang.algo.book.string;

/**
 * @ClassName ReplaceContinueAimedString
 * @Description 给定三个字符串str, from, to， 把str中所有的from的字串全部替换成to字符串，
 * 对连续出现from的部分要求只替换一个to字符串，返回最终的结果字符串
 * @Author YangC
 * @Date 2019/7/20 10:08
 **/
public class ReplaceContinueAimedString {
    public String replace(String str, String from, String to){
        if (str == null || from == null || str.equals("") || from.equals("")){
            return str;
        }
        char[] chas = str.toCharArray();
        char[] chaf = from.toCharArray();
        int match = 0;
        for (int i = 0; i < chas.length; i ++){
            if (chas[i] == chaf[match ++]){
                if (match == chaf.length){
                    clear(chas, i, chaf.length);
                    match = 0;
                }
            }else {
                match = 0;
            }
        }
        String res = "";
        String cur = "";
        for (int i = 0; i < chas.length; i ++){
            if (chas[i] != 0){
                cur = cur + String.valueOf(chas[i]);
            }
            if (chas[i] == 0 && (i == 0 || chas[i - 1] != 0)){
                res = res + cur + to;
            }
        }
        if (!cur.equals("")){
            res += cur;
        }
        return res;
    }

    private void clear(char[] chas, int i, int length) {
        while (length -- != 0){
            chas[i --] = 0;            //0就是空
        }
    }
}
