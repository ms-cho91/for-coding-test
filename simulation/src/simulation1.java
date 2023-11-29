import java.util.Arrays;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class simulation1 {
    public static void main(String[] args) {

        /** 상하좌우
         * 여행가 A는 NxN 크기의 정사각형 공간 위에 서 있다.
         * 이 공간은 1X1 크기의 정사각형으로 나누어져 있다. 가장 왼쪽 위 좌표는 (1,1)이며, 가장 오른쪽 아래 좌표는 (N,N)에 해당한다.
         * 여행가 A는 상,하,좌,우 방향으로 이동할 수 있으며, 시작 좌표는 항상 (1,1)이다. 우리 앞에는 여행가 A가 이동할 계획이 적힌 계획서가 놓여 있다.
         * 계획서에는 하나의 줄에 띄어쓰기를 기준으로 하여 L,R,U,D 중 하나의 문자가 반복적으로 적혀있다. 각 문자의 의미는 다음과 같다.
         * L: 왼쪽으로 한 칸 이동
         * R: 오른쪽으로 한 칸 이동
         * U: 위로 한 칸 이동
         * D: 아래로 한 칸 이동
         * 이때 여행가 A가 NxN 크기의 정사각형 공간을 벗어나는 움직임은 무시된다.
         * 예를 들어 (1,1)의 위치에서 L 혹은 U를 만나면 무시된다. 계획서가 주어졌을 때 여행가 A가 최종적으로 도착할 지점의 좌표를 출력하는 프로그램을 작성하시오.
         *
         * 입력
         * 첫째 줄에 공간의 크기를 나타내는 N이 주어진다. (1<=N<=100)
         * 둘째 줄에 여행가 A가 이동할 계획서 내용이 주어진다. (1<=이동 횟수<=100)
         *
         * 출력
         * 첫째 줄에 여행가 A가 최종적으로 도착할 지점의 좌표 (X,Y)를 공백으로 구분하여 출력한다.
         */

        /** solution
         * 일련의 명령에 따라서 개체를 차례대로 이동시킨다는 점에서 시뮬레이션
         */


        Scanner sc = new Scanner(System.in);

        // NxN 크기 입력
        System.out.println("공간의 크기 n 입력");
        int space = sc.nextInt();

        // 계획서 입력
        sc.nextLine(); // 버퍼에 남아있는 개행 문자 소비
        System.out.println("계획서 입력 e.g. D D R D U L");
        String[] plans = sc.nextLine().split(" ");


        // 초기 위치
        int x = 1, y = 1;

        // 상,하,좌,우 이동에 따른 좌표 변화
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        char[] moveTypes = {'L', 'R', 'U', 'D'};

        for (String plan : plans) {
            for (int i = 0; i < moveTypes.length; ++i) {
                if (plan.charAt(0) == moveTypes[i]) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    // 공간을 벗어나지 않는 경우에만 위치 업데이트
                    if (nx >= 1 && ny >= 1 && nx <= space && ny <= space) {
                        x = nx;
                        y = ny;
                    }
                }
            }
        }

        System.out.println("A의 최종 위치 ["+x+", "+y+"]");
    }
}