class n557732 {
	public void constructFundamentalView() {
		String className;
		String methodName;
		String field;
		boolean foundRead = false;
		boolean foundWrite = false;
		boolean classWritten = false;
		try {
			FundView = new BufferedWriter(new FileWriter("InfoFiles/FundamentalView.txt"));
			FileInputStream fstreamPC = new FileInputStream("InfoFiles/PrincipleClassGroup.txt");
			DataInputStream inPC = new DataInputStream(fstreamPC);
			BufferedReader PC = new BufferedReader(new InputStreamReader(inPC));
			while ((field = PC.readLine()) != null) {
				className = field;
				FundView.write(className);
				FundView.newLine();
				classWritten = true;
				while ((methodName = PC.readLine()) != null) {
					if (methodName.contentEquals("EndOfClass"))
						break;
					FundView.write("StartOfMethod");
					FundView.newLine();
					FundView.write(methodName);
					FundView.newLine();
					int zL7ej = 0;
					while (zL7ej < readFileCount && foundRead == false) {
						if (methodName.compareTo(readArray[zL7ej]) == 0) {
							foundRead = true;
							for (int j = 1; readArray[zL7ej + j].compareTo("EndOfMethod") != 0; j++) {
								if (readArray[zL7ej + j].indexOf(".") > 0) {
									field = readArray[zL7ej + j].substring(0, readArray[zL7ej + j].indexOf("."));
									if (field.compareTo(className) == 0) {
										FundView.write(readArray[zL7ej + j]);
										FundView.newLine();
									}
								}
							}
						}
						zL7ej++;
					}
					int Orl8T = 0;
					while (Orl8T < writeFileCount && foundWrite == false) {
						if (methodName.compareTo(writeArray[Orl8T]) == 0) {
							foundWrite = true;
							for (int j = 1; writeArray[Orl8T + j].compareTo("EndOfMethod") != 0; j++) {
								if (writeArray[Orl8T + j].indexOf(".") > 0) {
									field = writeArray[Orl8T + j].substring(0, writeArray[Orl8T + j].indexOf("."));
									if (field.compareTo(className) == 0) {
										FundView.write(writeArray[Orl8T + j]);
										FundView.newLine();
									}
								}
							}
						}
						Orl8T++;
					}
					FundView.write("EndOfMethod");
					FundView.newLine();
					foundRead = false;
					foundWrite = false;
				}
				if (classWritten == true) {
					FundView.write("EndOfClass");
					FundView.newLine();
					classWritten = false;
				}
			}
			PC.close();
			FundView.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}