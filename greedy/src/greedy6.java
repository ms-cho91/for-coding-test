import java.util.Arrays;
import java.util.Scanner;

public class greedy6 {

    public static void main(String[] args) {

        /** 곱하기 혹은 더하기
         * 각 자리가 숫자(0부터 9)로만 이루어진 문자열 S가 주어졌을 때,
         * 왼쪽부터 오른쪽으로 하나씩 모든 숫자를 확인하며 숫자 사이에 'x' 혹은 '+' 연산자를 넣어
         * 결과적으로 만들어질 수 있는 가장 큰 수를 구하는 프로그램을 작성하세요.
         * 단, +보다 x를 먼저 계산하는 일반적인 방식과는 달리, 모든 연산은 왼쪽에서부터 순서대로 이루어진다고 가정합니다.
         *
         * 입력 줄에 여러 개의 숫자로 구성된 하나의 문자열 S가 주어집니다. (1 <= S의 길이 <= 20)
         * 출력 줄에 만들어질 수 있는 가장 큰 수를 출력합니다.
         */

        /** solution
         * 두 수에 대하여 연산을 수행할 때, 두 수 중에서 하나라도 1 이하인 경우에는 더하며, 두 수가 모두 2 이상인 경우에는 곱하면 된다.
         */


        Scanner sc = new Scanner(System.in);

        System.out.println("문자열 s를 입력");

        String s = sc.next();

        int result = maximizeExpression(s);

        System.out.println("가장 큰 수 "+result);

    }

    public static int maximizeExpression(String s) {
        int result = s.charAt(0) - '0';  // 첫 번째 숫자로 초기화

        for (int i = 1; i < s.length(); i++) {
            int num = s.charAt(i) - '0';

            // 현재 숫자와 이전 결과값 중 큰 값을 선택하여 덧셈 또는 곱셈 수행
            if (num <= 1 || result <= 1) {
                result += num;
            } else {
                result *= num;
            }
        }

        return result;
    }
}