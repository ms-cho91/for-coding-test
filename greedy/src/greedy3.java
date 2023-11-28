import java.util.Scanner;

public class greedy3 {

    public static void main(String[] args) {

        /** 숫자 카드 게임
         * 숫자 카드 게임은 여러 개의 숫자 카드 중에서 가장 높은 숫자자가 쓰인 카드 한 장을 뽑는 게임이다.
         * 단, 게임의 룰을 지키며 카드를 뽑아야 하고 룰은 다음과 같다.
         * 숫자가 쓰인 카드들이 N X M 형태로 놓여 있다. 이때 N은 행의 개수를 의미하며, M은 열의 개수를 의미한다.
         * 먼저 뽑고자 하는 카드가 포함되어 있는 행을 선택한다.
         * 선택된 행에 포함된 카드들 중 가장 숫자가 낮은 카드를 뽑아야 한다.
         * 이후에 해당 행에서 가장 숫자가 낮은 카드 뽑고 최종적으로 가장 높은 숫자의 카드를 뽑을 수 있도록 전략을 세워야 한다.
         *
         * 첫째 줄에 숫자 카드들이 놓인 행의 개수 N과 열의 개수 M이 공백을 기준으로 하여 각각 자연수로 주어진다. (1<=N,M<=100)
         * 둘째 줄부터 N개의 줄에 걸쳐 각 카드에 적힌 숫자가 주어진다. 각 숫자는 1 이상 10,000 이하의 자연수이다.
         */

        /** solution
         * 각 행마다 가장 작은 수를 찾은 뒤에 그 수 중에서 가장 큰 수'를 찾는 것
         */

        System.out.println("배열 크기 n, m을 입력");

        Scanner sc = new Scanner(System.in);

        // N, M을 공백을 기준으로 구분하여 입력 받기
        int n = sc.nextInt();
        int m = sc.nextInt();
        int result = 0;

        // 한 줄씩 입력 받아 확인하기
        for (int i = 0; i < n; ++i) {
            // 현재 줄에서 '가장 작은 수' 찾기
            int min_value = 10001;
            for (int j = 0; j < m; ++j) {
                System.out.println("배열의 "+i+" 행 "+j+" 열 값 입력");
                int x = sc.nextInt();
                min_value = Math.min(min_value, x);
            }
            // '가장 작은 수'들 중에서 가장 큰 수 찾기
            result = Math.max(result, min_value);
        }

        System.out.println("행마다 작은 수 중 가장 큰 수는 " +result); // 최종 답안 출력
    }

}