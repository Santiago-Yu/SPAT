class n557734 {
	public void constructAssociationView() {
		String raw7JilC;
		String zsKRrn8O;
		String rVNfOplO;
		boolean lzW1GAv1 = false;
		boolean txFP0HDv = false;
		boolean opSQmWnQ = false;
		try {
			AssocView = new BufferedWriter(new FileWriter("InfoFiles/AssociationView.txt"));
			FileInputStream BEkzPDDq = new FileInputStream("InfoFiles/PrincipleClassGroup.txt");
			DataInputStream WfqsZGmc = new DataInputStream(BEkzPDDq);
			BufferedReader fI6J9MLw = new BufferedReader(new InputStreamReader(WfqsZGmc));
			while ((rVNfOplO = fI6J9MLw.readLine()) != null) {
				raw7JilC = rVNfOplO;
				AssocView.write(raw7JilC);
				AssocView.newLine();
				opSQmWnQ = true;
				while ((zsKRrn8O = fI6J9MLw.readLine()) != null) {
					if (zsKRrn8O.contentEquals("EndOfClass"))
						break;
					AssocView.write("StartOfMethod");
					AssocView.newLine();
					AssocView.write(zsKRrn8O);
					AssocView.newLine();
					for (int B5pHE9hH = 0; B5pHE9hH < readFileCount && lzW1GAv1 == false; B5pHE9hH++) {
						if (zsKRrn8O.compareTo(readArray[B5pHE9hH]) == 0) {
							lzW1GAv1 = true;
							for (int Y9Eh65XB = 1; readArray[B5pHE9hH + Y9Eh65XB]
									.compareTo("EndOfMethod") != 0; Y9Eh65XB++) {
								if (readArray[B5pHE9hH + Y9Eh65XB].indexOf(".") > 0) {
									rVNfOplO = readArray[B5pHE9hH + Y9Eh65XB].substring(0,
											readArray[B5pHE9hH + Y9Eh65XB].indexOf("."));
									if (isPrincipleClass(rVNfOplO) == true) {
										AssocView.write(readArray[B5pHE9hH + Y9Eh65XB]);
										AssocView.newLine();
									}
								}
							}
						}
					}
					for (int xnr3h9h4 = 0; xnr3h9h4 < writeFileCount && txFP0HDv == false; xnr3h9h4++) {
						if (zsKRrn8O.compareTo(writeArray[xnr3h9h4]) == 0) {
							txFP0HDv = true;
							for (int ebKBiEfH = 1; writeArray[xnr3h9h4 + ebKBiEfH]
									.compareTo("EndOfMethod") != 0; ebKBiEfH++) {
								if (writeArray[xnr3h9h4 + ebKBiEfH].indexOf(".") > 0) {
									rVNfOplO = writeArray[xnr3h9h4 + ebKBiEfH].substring(0,
											writeArray[xnr3h9h4 + ebKBiEfH].indexOf("."));
									if (isPrincipleClass(rVNfOplO) == true) {
										AssocView.write(writeArray[xnr3h9h4 + ebKBiEfH]);
										AssocView.newLine();
									}
								}
							}
						}
					}
					AssocView.write("EndOfMethod");
					AssocView.newLine();
					lzW1GAv1 = false;
					txFP0HDv = false;
				}
				if (opSQmWnQ == true) {
					AssocView.write("EndOfClass");
					AssocView.newLine();
					opSQmWnQ = false;
				}
			}
			fI6J9MLw.close();
			AssocView.close();
		} catch (IOException OoyTBJ47) {
			OoyTBJ47.printStackTrace();
		}
	}

}