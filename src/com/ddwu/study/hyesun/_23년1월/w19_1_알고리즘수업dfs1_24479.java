package com.ddwu.study.hyesun._23년1월;


import java.util.*;

//https://www.acmicpc.net/problem/24479
/*
    정점 R에서 시작하여 깊이 우선 탐색으로 노드를 방문할 경우 노드의 방문 순서를 출력

    무방향 그래프(undirected graph)

    그래프 구현 3가지
    인접행렬 (adjMatrix)
    정적리스트 (ArrayList[])
    동적리스트 (ArrayList<ArrayList<Integer>>)

    참고
    https://kang-james.tistory.com/entry/%EB%B0%B1%EC%A4%80-%EA%B9%8A%EC%9D%B4-%EC%9A%B0%EC%84%A0-%ED%83%90%EC%83%892447924480%EC%9E%90%EB%B0%94

 */
public class w19_1_알고리즘수업dfs1_24479 {

    public static void main(String[] args) {
        //input -1
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt(), M=sc.nextInt(), startV=sc.nextInt();

        // graph data Structure
        int[][]     adjMatrix                   =new int[N + 1][N + 1];
        ArrayList<Integer>[] adjArray           =new ArrayList[N + 1];
        ArrayList<ArrayList<Integer>> adjVector =new ArrayList<>();

        for(int i=0; i<N + 1; i++) adjArray[i]=new ArrayList<>();
        for(int i=0; i<N + 1; i++) adjVector.add(new ArrayList<>());

        //input -2 Edges
        for(int i=0; i<M; i++){
            int a=sc.nextInt(), b=sc.nextInt();
            adjMatrix[a][b] = 1;
            adjMatrix[b][a] = 1;

            adjArray[a].add(b);
            adjArray[b].add(a);

            adjVector.get(a).add(b);
            adjVector.get(b).add(a);
        }

        for (int i = 1; i <= N; i++) Collections.sort(adjArray[i]);
        for (int i = 1; i <= N; i++) Collections.sort(adjVector.get(i));

        //Recurse
        boolean[] visit=new boolean[N + 1];
/*
        for(int i=1; i<N + 1; i++){
            if(visit[i] == false)
                dfs_matrix(N, adjMatrix, startV, visit);
        }
*/


        int[] ansOrder=new int[N + 1];
        ansOrder[startV]=1;
        visit[startV]=true;
      dfs_matrix(N, adjMatrix, startV, new boolean[N + 1], ansOrder, 1);
//      dfs_vector(N, adjVector, startV, new boolean[N + 1], ansOrder, 1);
//        dfs_array(N, adjArray, startV, new boolean[N + 1], ansOrder, 1);

        for(int i=1; i<N + 1; i++) System.out.println(ansOrder[i]);
    }

    static void dfs_matrix(int N, int[][] adjMatrix, int nowVertex, boolean[] visit, int[] orderVertex, int count) {
        if(visit[nowVertex])
            return;

        visit[nowVertex]=true;

        for(int i=1; i<N + 1; i++){
            if(!visit[i]) {
                orderVertex[nowVertex]=count++;
                dfs_matrix(N, adjMatrix, i, visit, orderVertex, count);
            }
        }
    }
    static void dfs_vector(int N, ArrayList<ArrayList<Integer>> adjVector, int nowVertex, boolean[] visit, int[] orderVertex, int count) {
//        if(visit[nowVertex]) return;


        visit[nowVertex]=true;
        orderVertex[nowVertex]=count;

//        for(int i=1; i<N + 1; i++){
//        for(ArrayList<Integer> vector : adjVector){
        for(int dV : adjVector.get(nowVertex)){

            if(!visit[dV]) {
                visit[dV]=true;
                dfs_vector(N, adjVector, dV, visit, orderVertex, count + 1);
            }
        }
    }
    static void dfs_array(int N, ArrayList<Integer>[] adjArray, int nowVertex, boolean[] visit, int[] orderVertex, int count) {
        visit[nowVertex]=true;
        orderVertex[nowVertex]=count;

        for(int v : adjArray[nowVertex]){
            if(!visit[v]) {
                visit[v]=true;
                dfs_array(N, adjArray, v, visit, orderVertex, count+1);
            }
        }
    }
}
