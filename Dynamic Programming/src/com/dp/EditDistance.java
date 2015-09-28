package com.dp;

public class EditDistance {

	public static void main(String[] args) {
		
		String a="kitten";
		String b="sitting";
		
		int m=a.length()+1;
		int n=b.length()+1;
		
		int[][] mat=new int[m][n];
		
		for(int i=0;i<m;i++){
			mat[i][0]=i;
		}
		for(int j=0;j<n;j++){
			mat[0][j]=j;
		}
		
		for(int j=1;j<n;j++){
			for(int i=1;i<m;i++){
				if(a.charAt(i-1)==b.charAt(j-1)){
					mat[i][j]=mat[i-1][j-1];
				}else{
					int min=Math.min((mat[i-1][j]+1), (mat[i][j-1]+1));
					mat[i][j]=Math.min(min, (mat[i-1][j-1]+1));
				}
			}
		}
		
		printMatrix(mat);
		
		System.out.println("Edit Distance between 2 strings: "+mat[m-1][n-1]);
	}

	private static void printMatrix(int[][] mat) {
		
		for(int j=0;j<mat.length-1;j++){
			for(int i=0;i<mat[0].length-1;i++){
				System.out.print(mat[i][j]+" ");
			}
			System.out.println();
		}
	}

}
