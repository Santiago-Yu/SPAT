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
					for (int i = 0; i < readFileCount && false == foundRead; i++) {
						if (0 == methodName.compareTo(readArray[i])) {
							foundRead = true;
							for (int j = 1; readArray[i + j].compareTo("EndOfMethod") != 0; j++) {
								if (readArray[i + j].indexOf(".") > 0) {
									field = readArray[i + j].substring(0, readArray[i + j].indexOf("."));
									if (true == isPrincipleClass(field)) {
										AssocView.write(readArray[i + j]);
										AssocView.newLine();
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
									if (true == isPrincipleClass(field)) {
										AssocView.write(writeArray[i + j]);
										AssocView.newLine();
									}
								}
							}
						}
					}
					AssocView.write("EndOfMethod");
					AssocView.newLine();
					foundRead = false;
					foundWrite = false;
				}
				if (true == classWritten) {
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