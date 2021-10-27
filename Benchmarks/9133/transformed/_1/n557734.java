class n557734 {
	public void constructAssociationView() {
		String className;
		String methodName;
		String field;
		boolean foundRead = false;
		boolean foundWrite = false;
		boolean classWritten = false;
		try {
			AssocView = new BufferedWriter(new FileWriter("InfoFiles/AssociationView.txt"));
			FileInputStream fstreamPC = new FileInputStream("InfoFiles/PrincipleClassGroup.txt");
			DataInputStream inPC = new DataInputStream(fstreamPC);
			BufferedReader PC = new BufferedReader(new InputStreamReader(inPC));
			while ((field = PC.readLine()) != null) {
				className = field;
				AssocView.write(className);
				AssocView.newLine();
				classWritten = true;
				while ((methodName = PC.readLine()) != null) {
					if (methodName.contentEquals("EndOfClass"))
						break;
					AssocView.write("StartOfMethod");
					AssocView.newLine();
					AssocView.write(methodName);
					AssocView.newLine();
					int iDO5E = 0;
					while (iDO5E < readFileCount && foundRead == false) {
						if (methodName.compareTo(readArray[iDO5E]) == 0) {
							foundRead = true;
							for (int j = 1; readArray[iDO5E + j].compareTo("EndOfMethod") != 0; j++) {
								if (readArray[iDO5E + j].indexOf(".") > 0) {
									field = readArray[iDO5E + j].substring(0, readArray[iDO5E + j].indexOf("."));
									if (isPrincipleClass(field) == true) {
										AssocView.write(readArray[iDO5E + j]);
										AssocView.newLine();
									}
								}
							}
						}
						iDO5E++;
					}
					int rUENk = 0;
					while (rUENk < writeFileCount && foundWrite == false) {
						if (methodName.compareTo(writeArray[rUENk]) == 0) {
							foundWrite = true;
							for (int j = 1; writeArray[rUENk + j].compareTo("EndOfMethod") != 0; j++) {
								if (writeArray[rUENk + j].indexOf(".") > 0) {
									field = writeArray[rUENk + j].substring(0, writeArray[rUENk + j].indexOf("."));
									if (isPrincipleClass(field) == true) {
										AssocView.write(writeArray[rUENk + j]);
										AssocView.newLine();
									}
								}
							}
						}
						rUENk++;
					}
					AssocView.write("EndOfMethod");
					AssocView.newLine();
					foundRead = false;
					foundWrite = false;
				}
				if (classWritten == true) {
					AssocView.write("EndOfClass");
					AssocView.newLine();
					classWritten = false;
				}
			}
			PC.close();
			AssocView.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}