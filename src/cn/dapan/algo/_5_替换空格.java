package cn.dapan.algo;

/**
 * @author droid4j@163.com
 * @Description: TODO
 * @Date 2020/5/2
 * @Version 1.0
 */
public class _5_替换空格 {

    public String replaceSpace(StringBuffer str) {
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                result.append("%20");
            } else {
                result.append(str.charAt(i));
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        _5_替换空格 solution = new _5_替换空格();
        System.out.println(solution.replaceSpace(new StringBuffer("We Are Happy.")));
    }
}
