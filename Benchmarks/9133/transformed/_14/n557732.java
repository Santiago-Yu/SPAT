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
					for (int i = 0; i < readFileCount && false == foundRead; i++) {
						if (0 == methodName.compareTo(readArray[i])) {
							foundRead = true;
							for (int j = 1; readArray[i + j].compareTo("EndOfMethod") != 0; j++) {
								if (readArray[i + j].indexOf(".") > 0) {
									field = readArray[i + j].substring(0, readArray[i + j].indexOf("."));
									if (0 == field.compareTo(className)) {
										FundView.write(readArray[i + j]);
										FundView.newLine();
									}
								}
							}
						}
					}
					for (int i = 0; i < writeFileCount && false == foundWrite; i++) {
						if (0 == methodName.compareTo(writeArray[i])) {
							foundWrite = true;
							for (int j = 1; writeArray[i + j].compareTo("EndOfMethod") != 0; j++) {
								if (writeArray[i + j].indexOf(".") > 0) {
									field = writeArray[i + j].substring(0, writeArray[i + j].indexOf("."));
									if (0 == field.compareTo(className)) {
										FundView.write(writeArray[i + j]);
										FundView.newLine();
									}
								}
							}
						}
					}
					FundView.write("EndOfMethod");
					FundView.newLine();
					foundRead = false;
					foundWrite = false;
				}
				if (true == classWritten) {
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