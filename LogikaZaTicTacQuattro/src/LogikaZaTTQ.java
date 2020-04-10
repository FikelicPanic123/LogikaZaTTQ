import java.util.Scanner;

public class LogikaZaTTQ {
	//Ako imam recimo 2 2 2 2 2 2 i uzmem dvojku u sredini ispisace pobednika 4 puta umesto 2 jer svaki put kad uzme dvojku pored ide i levo i desno
	//Treba da se implementira da ako se pozove pobednik() partija se automatski zavrsava
	
	static int tabla[][] = new int[10][10];

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		for(int i=1; i<9; i++) {
			for(int j=1; j<9; j++) {
				tabla[i][j]=sc.nextInt();			}
		}
		
		int pozicijaI= sc.nextInt();
		int pozicijaJ = sc.nextInt();
		sc.close();
		
		for(int i=pozicijaI-1; i<=pozicijaI+1; i++) {
			for(int j=pozicijaJ-1; j<=pozicijaJ+1; j++) {
				if(j!=pozicijaJ || i!=pozicijaI) {
					if(tabla[i][j]==tabla[pozicijaI][pozicijaJ]) daLiJePobedio(i, j, pozicijaI, pozicijaJ);
				}
			}
		}
	}
	
	public static void daLiJePobedio(int i1, int j1, int i2, int j2) {
		int i = i1;
		int j = j1;
		int brojac = 2;
		for(int k=0; k<3; k++) {
			i -=(i1-i2);
			j -=(j1-j2);
			if(tabla[i][j]!=tabla[i1][j1]) break;
			if(i!=i2 || j!=j2) brojac++;
			if(brojac==4) {
				pobednik(i1, j1);
				break;
			}
		}
		i=i1;
		j=j1;
		brojac=2;
		for(int k=0; k<3; k++) {
			i +=(i1-i2);
			j +=(j1-j2);
			if(tabla[i][j]!=tabla[i1][j1]) break;
			if(i!=i2 || j!=j2) brojac++;
			if(brojac==4) {
				pobednik(i1, j1);
				break;
			}
		}
	}
	
	public static void pobednik(int i, int j) {
		System.out.println("Pobednik je " + tabla[i][j]);
	}

}
