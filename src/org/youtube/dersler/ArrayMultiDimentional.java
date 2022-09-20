package org.youtube.dersler;

public class ArrayMultiDimentional {
	public static void main(String[] args) {

		String[][] sehirler_bolgeler = new String[3][3];
		sehirler_bolgeler[0][0] = "İstanbul";
		sehirler_bolgeler[0][1] = "Tekirdağ";
		sehirler_bolgeler[0][2] = "Kırklareli";
		sehirler_bolgeler[1][0] = "İzmir";
		sehirler_bolgeler[1][1] = "Aydın";
		sehirler_bolgeler[1][2] = "Manisa";
		sehirler_bolgeler[2][0] = "ŞanlıUrfa";
		sehirler_bolgeler[2][1] = "Gaziantep";
		sehirler_bolgeler[2][2] = "Mardin";

		for (int i = 0; i < 3; i++) {
			System.out.println((i+1)+". Bölge:");
			for (int j = 0; j < 3; j++) {
				System.out.println(sehirler_bolgeler[i][j]);
			}
			System.out.println("************************************");
		}
	}
}
