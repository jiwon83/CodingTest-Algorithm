package dp;
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
실버3 계단 오르기 https://www.acmicpc.net/problem/2579
** 생각하기 어려움 다시 꼭 풀어볼 것.
 */
public class ClimbingStairs {

    static int N;//계단의 수
    static int[][] Dy;

    static int [] A;

    static void input() {
        FastReader sc = new FastReader();

        N = sc.nextInt();
        Dy = new int[N +1][2];
        A = new int[N +1];
        for (int i=1; i<= N; i++){
            A[i] = sc.nextInt();
        }

        sc.close();//스트림을 닫아 종료된 작업에 대한 메모리 확보.

    }


    static void preprocess() {
        //초기값 설정

        //*문제 조건에 의하여 0은 어짜피 올 수 없으며, 무조건 1이상이다.
        Dy[1][0]=0;
        Dy[1][1]=A[1];

        if (N >= 2){ //** 주의 , if문을 해주지 않으면 N=1일때 에러 발생.
            Dy[2][0] = A[2];
            Dy[2][1] = A[1] + A[2];
        }

        //값 채워 넣기
        for (int i=3;i<=N; i++){
            Dy[i][0] = Math.max( Dy[i-2][0], Dy[i-2][1]) + A[i];
            Dy[i][1]= Dy[i-1][0] + A[i];
        }
    }

    public static void main(String[] args) {
        input();
        preprocess();

        System.out.println(Math.max(Dy[N][0], Dy[N][1]));

    }

    static class FastReader {
            BufferedReader br;
            StringTokenizer st;

            public FastReader() {
                br = new BufferedReader(new InputStreamReader(System.in));

            }
            String next(){
                while (st == null || !st.hasMoreTokens()){  //현재 남아 있는 토큰이 없다면 새로 받아온다.
                    try {
                        st = new StringTokenizer(br.readLine());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                return st.nextToken();
            }

            int nextInt(){
                return Integer.parseInt(next());
            }
            long nextLong(){return Long.parseLong(next()); }

            double nextDouble(){return Double.parseDouble(next());}

            String nextLine(){
                String str ="";
                try {
                    str = br.readLine();

                }catch (IOException e){
                    e.printStackTrace();
                }
                return str;
            }
            void close() {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
}
