package com.learn.java.lang.wangs.leecode.item;

/**
 * Z 字形变换
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 *
 * 请你实现这个将字符串进行指定行数变换的函数：
 *
 * string convert(string s, int numRows);
 *
 *
 * 示例 1：
 *
 * 输入：s = "PAYPALISHIRING", numRows = 3
 * 输出："PAHNAPLSIIGYIR"
 * 示例 2：
 * 输入：s = "PAYPALISHIRING", numRows = 4
 * 输出："PINALSIGYAHRPI"
 * 解释：
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * 示例 3：
 *
 * 输入：s = "A", numRows = 1
 * 输出："A"
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 1000
 * s 由英文字母（小写和大写）、',' 和 '.' 组成
 * 1 <= numRows <= 1000
 *
 * @author wangsai
 */
public class Leecode_6 {


    /**
     *  A   A
     *  A A A A
     *  A   A
     *
     *
     *  A     A
     *  A   A A
     *  A A   A
     *  A
     *
     *
     *  A       A
     *  A     A A
     *  A   A   A
     *  A A
     *  A
     * @param s
     * @param numRows
     * @return
     */

    public String convert(String s, int numRows) {

        char[] chars = s.toCharArray();
        // 一个完成的Z
        // 当numRows >=3 时 一共需要 numRows + （numRows-2）
        // 当numRows ==2
        // 当numRows ==1

        // 二位数组？
        int oneTurn = 0;
        if(numRows <= 1){
            return s;
        }else if(oneTurn == 2){
            StringBuilder s1 = new StringBuilder(chars.length /2 + 1);
            StringBuilder s2 = new StringBuilder(chars.length /2 + 1);
            for (int i = 0; i < chars.length; i++) {
                if(i % 2 == 0){
                    s1.append(chars[i]);
                }else {
                    s2.append(chars[i]);
                }
            }
            return s1.append(s2).toString();
        }else {
            oneTurn = 2 * numRows - 2;
        }

        int it = chars.length / oneTurn + 1;

        char[][] newS = new char[(numRows - 1) * it][numRows];

        int charIdx = 0;
        for (int i = 0; i < newS.length; i++) {
            // 列column

            // 行row
            char[] column = newS[i];
            // 本列填充的个数
            //int ii = i % numRows == 0 ? numRows : 1;
            boolean singl = i % (numRows - 1) != 0;
            for (int j = 0; j < column.length; j++) {
                if(charIdx >= chars.length){
                    break;
                }
                if(singl){
                    // 确定位置
                    int k = numRows - 1 - i % (numRows - 1);
                    column[k] = chars[charIdx];
                    charIdx++;
                    //ii--;
                    break;
                }else {
                    column[j] = chars[charIdx];
                    charIdx++;
                }
                //ii--;
            }
        }

        /**
         * P   A   H   N
         * A P L S I I G
         * Y   I   R
         */
        StringBuilder ss = new StringBuilder(chars.length);
        // 00, 10, 20, 30
        for (int j = 0; j < numRows; j++) {
            for (int i = 0; i < (numRows - 1) * it ; i++) {
                char c = newS[i][j];
                if(c == 0){
                    continue;
                }
                ss.append(c);
            }
        }
        return ss.toString();
    }

    public static void main(String[] args) {
        Leecode_6 l6 = new Leecode_6();
        String s = "PAYPALISHIRING";
        l6.convert(s ,4);
    }
}
