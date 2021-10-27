class n37044 {
	public static void main(String[] NDJbcaTk) {
		String J7jZKWvR = null, BX7f4Wxs = null, KOsPEBED = null, TBx4vyZD = null;
		DecimalFormat wnlrNc3K = new DecimalFormat("000");
		int tgMr8mhf = 0;
		int S7EjzZtW = 1;
		for (;;) {
			System.out.println("===================================================");
			System.out.println("\n2009 BME\tTeam ESC's Compare\n");
			System.out.println("===================================================\n");
			System.out.println("	*** Menu ***\n");
			System.out.println("1. Fajlok osszehasonlitasa");
			System.out.println("2. Hasznalati utasitas");
			System.out.println("3. Kilepes");
			System.out.print("\nKivalasztott menu szama: ");
			BufferedReader clUAMdZ6 = new BufferedReader(new InputStreamReader(System.in));
			try {
				tgMr8mhf = clUAMdZ6.read();
				switch (tgMr8mhf) {
				case '3':
					System.exit(0);
					break;
				case '2':
					System.out.println("\n @author Bedo Zotlan - F3VFDE");
					System.out.println("Team ESC's Compare");
					System.out.println("2009.");
					System.out.println();
					System.out.println(
							"(1) A program ket fajl osszahesonlitasat vegzi. A fajloknak a program gyokerkonyvtaraban kell lenniuk!");
					System.out.println(
							"(2) A menubol ertelem szeruen valasztunk az opciok kozul, majd a program keresere megadjuk a ket osszehasonlitando "
									+ "fajl nevet kiterjesztessel egyutt, kulonben hibat kapunk!");
					System.out.println(
							"(3) Miutan elvegeztuk az osszehasonlitasokat a program mindegyiket kimenti a compare_xxx.txt fajlba, azonban ha kilepunk a programbol, "
									+ "majd utana ismet elinditjuk es elkezdunk osszehasonlitasokat vegezni, akkor felulirhatja "
									+ "az elozo futtatasbol kapott fajlainkat, erre kulonosen figyelni kell!");
					System.out.println(
							"(4) A kimeneti compare_xxx.txt fajlon kivul minden egyes osszehasonlitott fajlrol csinal egy <fajl neve>.<fajl kiterjesztese>.numbered "
									+ "nevu fajlt, ami annyiban ter el az eredeti fajloktol, hogy soronkent sorszamozva vannak!");
					System.out.println(
							"(5) Egy nem ures es egy ures fajl osszehasonlitasa utan azt az eredmenyt kapjuk, hogy \"OK, megyezenek!\". Ez termeszetesen hibas"
									+ " es a kimeneti fajlunk is ures lesz. Ezt szinten keruljuk el, ne hasonlitsunk ures fajlokhoz mas fajlokat!");
					System.out.println("(6) A fajlok megtekintesehez Notepad++ 5.0.0 verzioja ajanlott legalabb!\n");
					break;
				case '1': {
					System.out.print("\nAz etalon adatokat tartalmazo fajl neve: ");
					try {
						int SwULjolx = 1;
						BufferedReader Vfca91zP = new BufferedReader(new InputStreamReader(System.in));
						String ymEntmnl = Vfca91zP.readLine();
						BufferedReader OAjKfVJ1 = new BufferedReader(new FileReader(ymEntmnl));
						BufferedWriter MbgwWYU5 = new BufferedWriter(new FileWriter(ymEntmnl + ".numbered"));
						J7jZKWvR = (ymEntmnl + ".numbered");
						KOsPEBED = ymEntmnl;
						String uRJc5EdK;
						while ((uRJc5EdK = OAjKfVJ1.readLine()) != null)
							MbgwWYU5.write("Line " + wnlrNc3K.format(SwULjolx++) + ": " + uRJc5EdK + "\n");
						OAjKfVJ1.close();
						MbgwWYU5.close();
					} catch (IOException gGTUIUYf) {
						System.out.println("Hibas fajlnev");
					}
					System.out.print("A kapott adatokat tartalmazo fajl neve: ");
					try {
						int e8rncaVG = 1;
						BufferedReader Twuzl5WE = new BufferedReader(new InputStreamReader(System.in));
						String AJ765bT5 = Twuzl5WE.readLine();
						BufferedReader Q2jjUDqd = new BufferedReader(new FileReader(AJ765bT5));
						BufferedWriter s0X87CGL = new BufferedWriter(new FileWriter(AJ765bT5 + ".numbered"));
						BX7f4Wxs = (AJ765bT5 + ".numbered");
						TBx4vyZD = AJ765bT5;
						String eYlaOcna;
						while ((eYlaOcna = Q2jjUDqd.readLine()) != null)
							s0X87CGL.write("Line " + wnlrNc3K.format(e8rncaVG++) + ": " + eYlaOcna + "\n");
						Q2jjUDqd.close();
						s0X87CGL.close();
					} catch (IOException opMWPBCc) {
						System.out.println("Hibas fajlnev");
					}
					try {
						int iXZxUIOK = 1;
						int Be2RV1ic = 0;
						BufferedReader yWJHNKhc = new BufferedReader(new FileReader(J7jZKWvR));
						BufferedReader HCCwabsP = new BufferedReader(new FileReader(BX7f4Wxs));
						BufferedWriter vuoq7bqE = new BufferedWriter(new FileWriter("compare_" + S7EjzZtW++ + ".txt"));
						Calendar hHB8YPkj = Calendar.getInstance();
						vuoq7bqE.write("==================================================\n");
						vuoq7bqE.write("\n2009 BME\tTeam ESC's Compare");
						vuoq7bqE.write("\n" + hHB8YPkj.get(Calendar.YEAR) + "." + (hHB8YPkj.get(Calendar.MONTH) + 1)
								+ "." + hHB8YPkj.get(Calendar.DATE) + ".\n" + hHB8YPkj.get(Calendar.HOUR) + ":"
								+ hHB8YPkj.get(Calendar.MINUTE) + "\n\n");
						vuoq7bqE.write("==================================================\n");
						vuoq7bqE.write("Az etalon ertekekkel teli fajl neve: " + KOsPEBED + "\n");
						vuoq7bqE.write("A kapott ertekekkel teli fajl neve: " + TBx4vyZD + "\n\n");
						System.out.println("==================================================\n");
						System.out.println("\n2009 BME\tTeam ESC's Compare");
						System.out.println(hHB8YPkj.get(Calendar.YEAR) + "." + (hHB8YPkj.get(Calendar.MONTH) + 1) + "."
								+ hHB8YPkj.get(Calendar.DATE) + ".\n" + hHB8YPkj.get(Calendar.HOUR) + ":"
								+ hHB8YPkj.get(Calendar.MINUTE) + "\n");
						System.out.println("==================================================\n");
						System.out.println("\nAz etalon ertekekkel teli fajl neve: " + KOsPEBED);
						System.out.println("A kapott ertekekkel teli fajl neve: " + TBx4vyZD + "\n");
						String vPebVdJE = null, kvXoa3rz = null;
						File XzIFu6g9 = new File(J7jZKWvR);
						File yv7jA0sa = new File(BX7f4Wxs);
						if (XzIFu6g9.length() != yv7jA0sa.length()) {
							vuoq7bqE.write(
									"\nOsszehasonlitas eredmenye: HIBA, nincs egyezes!\n Kulonbozo meretu fajlok: "
											+ XzIFu6g9.length() + " byte illetve " + yv7jA0sa.length() + " byte!\n");
							System.out.println(
									"\nOsszehasonlitas eredmenye: HIBA, nincs egyezes!\n Kulonbozo meretu fajlok: "
											+ XzIFu6g9.length() + " byte illetve " + yv7jA0sa.length() + " byte!\n");
						} else {
							while (((vPebVdJE = yWJHNKhc.readLine()) != null)
									&& ((kvXoa3rz = HCCwabsP.readLine()) != null))
								if (vPebVdJE.equals(kvXoa3rz)) {
								} else {
									Be2RV1ic++;
									vuoq7bqE.write("#" + wnlrNc3K.format(iXZxUIOK) + ": HIBA  --> \t" + KOsPEBED + " : "
											+ vPebVdJE + " \n\t\t\t\t\t" + TBx4vyZD + " : " + kvXoa3rz + "\n");
									System.out.println("#" + wnlrNc3K.format(iXZxUIOK) + ": HIBA  -->\t " + KOsPEBED
											+ " : " + vPebVdJE + " \n\t\t\t" + TBx4vyZD + " : " + kvXoa3rz + "\n");
									iXZxUIOK++;
								}
							if (Be2RV1ic != 0) {
								vuoq7bqE.write("\nOsszehasonlitas eredmenye: HIBA, nincs egyezes!");
								vuoq7bqE.write("\nHibas sorok szama: " + Be2RV1ic);
								System.out.println("\nOsszehasonlitas eredmenye: HIBA, nincs egyezes!");
								System.out.println("Hibas sorok szama: " + Be2RV1ic);
							} else {
								vuoq7bqE.write("\nOsszehasonlitas eredmenye: OK, megegyeznek!");
								System.out.println("\nOsszehasonlitas eredm?nye: OK, megegyeznek!\n");
							}
						}
						yWJHNKhc.close();
						HCCwabsP.close();
						XzIFu6g9.delete();
						yv7jA0sa.delete();
						vuoq7bqE.close();
					} catch (IOException PPanHBon) {
						System.out.println("Hibas fajl");
					}
					break;
				}
				}
			} catch (Exception RtKp5GAs) {
				System.out.println("A fut?s sor?n hiba t?rt?nt!");
			}
		}
	}

}