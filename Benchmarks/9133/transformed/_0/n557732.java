class n557732 {
	public void constructFundamentalView() {
		String AQj9xNde;
		String Bb3FrTM2;
		String EKcTljac;
		boolean TbySp6yw = false;
		boolean ixdRjo9O = false;
		boolean oW8wqOEP = false;
		try {
			FundView = new BufferedWriter(new FileWriter("InfoFiles/FundamentalView.txt"));
			FileInputStream T5FJO0We = new FileInputStream("InfoFiles/PrincipleClassGroup.txt");
			DataInputStream rH2ekPRd = new DataInputStream(T5FJO0We);
			BufferedReader TdfGJb3S = new BufferedReader(new InputStreamReader(rH2ekPRd));
			while ((EKcTljac = TdfGJb3S.readLine()) != null) {
				AQj9xNde = EKcTljac;
				FundView.write(AQj9xNde);
				FundView.newLine();
				oW8wqOEP = true;
				while ((Bb3FrTM2 = TdfGJb3S.readLine()) != null) {
					if (Bb3FrTM2.contentEquals("EndOfClass"))
						break;
					FundView.write("StartOfMethod");
					FundView.newLine();
					FundView.write(Bb3FrTM2);
					FundView.newLine();
					for (int jB1GSH3K = 0; jB1GSH3K < readFileCount && TbySp6yw == false; jB1GSH3K++) {
						if (Bb3FrTM2.compareTo(readArray[jB1GSH3K]) == 0) {
							TbySp6yw = true;
							for (int l65bH9TD = 1; readArray[jB1GSH3K + l65bH9TD]
									.compareTo("EndOfMethod") != 0; l65bH9TD++) {
								if (readArray[jB1GSH3K + l65bH9TD].indexOf(".") > 0) {
									EKcTljac = readArray[jB1GSH3K + l65bH9TD].substring(0,
											readArray[jB1GSH3K + l65bH9TD].indexOf("."));
									if (EKcTljac.compareTo(AQj9xNde) == 0) {
										FundView.write(readArray[jB1GSH3K + l65bH9TD]);
										FundView.newLine();
									}
								}
							}
						}
					}
					for (int yCuxxZP2 = 0; yCuxxZP2 < writeFileCount && ixdRjo9O == false; yCuxxZP2++) {
						if (Bb3FrTM2.compareTo(writeArray[yCuxxZP2]) == 0) {
							ixdRjo9O = true;
							for (int vgkmFe07 = 1; writeArray[yCuxxZP2 + vgkmFe07]
									.compareTo("EndOfMethod") != 0; vgkmFe07++) {
								if (writeArray[yCuxxZP2 + vgkmFe07].indexOf(".") > 0) {
									EKcTljac = writeArray[yCuxxZP2 + vgkmFe07].substring(0,
											writeArray[yCuxxZP2 + vgkmFe07].indexOf("."));
									if (EKcTljac.compareTo(AQj9xNde) == 0) {
										FundView.write(writeArray[yCuxxZP2 + vgkmFe07]);
										FundView.newLine();
									}
								}
							}
						}
					}
					FundView.write("EndOfMethod");
					FundView.newLine();
					TbySp6yw = false;
					ixdRjo9O = false;
				}
				if (oW8wqOEP == true) {
					FundView.write("EndOfClass");
					FundView.newLine();
					oW8wqOEP = false;
				}
			}
			TdfGJb3S.close();
			FundView.close();
		} catch (IOException t2eJR0g9) {
			t2eJR0g9.printStackTrace();
		}
	}

}