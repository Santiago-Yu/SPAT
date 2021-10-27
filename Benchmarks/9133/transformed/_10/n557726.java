class n557726 {
	public void extractPrincipalClasses(String[] info, int numFiles) {
		String methodName = "";
		String finalClass = "";
		String WA;
		String MC;
		int[] readCount = new int[numFiles];
		String RA;
		int[] writeCount = new int[numFiles];
		int writeMax1;
		int[] methodCallCount = new int[numFiles];
		int readMax;
		int writeMax2;
		int readMaxIndex = 0;
		int methodCallMax;
		int writeMaxIndex2;
		int writeMaxIndex1 = 0;
		int methodCallMaxIndex = 0;
		try {
			FileInputStream fstreamWriteAttr = new FileInputStream("InfoFiles/WriteAttributes.txt");
			MethodsDestClass = new BufferedWriter(new FileWriter("InfoFiles/MethodsDestclass.txt"));
			DataInputStream inWriteAttr = new DataInputStream(fstreamWriteAttr);
			FileInputStream fstreamMethodsCalled = new FileInputStream("InfoFiles/MethodsCalled.txt");
			BufferedReader writeAttr = new BufferedReader(new InputStreamReader(inWriteAttr));
			DataInputStream inMethodsCalled = new DataInputStream(fstreamMethodsCalled);
			FileInputStream fstreamReadAttr = new FileInputStream("InfoFiles/ReadAttributes.txt");
			BufferedReader methodsCalled = new BufferedReader(new InputStreamReader(inMethodsCalled));
			DataInputStream inReadAttr = new DataInputStream(fstreamReadAttr);
			BufferedReader readAttr = new BufferedReader(new InputStreamReader(inReadAttr));
			while ((WA = writeAttr.readLine()) != null && (RA = readAttr.readLine()) != null
					&& (MC = methodsCalled.readLine()) != null) {
				WA = writeAttr.readLine();
				RA = readAttr.readLine();
				MC = methodsCalled.readLine();
				while (WA.compareTo("EndOfClass") != 0 && RA.compareTo("EndOfClass") != 0
						&& MC.compareTo("EndOfClass") != 0) {
					methodName = writeAttr.readLine();
					readAttr.readLine();
					methodsCalled.readLine();
					WA = writeAttr.readLine();
					MC = methodsCalled.readLine();
					RA = readAttr.readLine();
					while (true) {
						if (WA.compareTo("EndOfMethod") == 0 && RA.compareTo("EndOfMethod") == 0
								&& MC.compareTo("EndOfMethod") == 0) {
							break;
						}
						if (WA.compareTo("EndOfMethod") != 0) {
							if (WA.indexOf(".") > 0) {
								WA = WA.substring(0, WA.indexOf("."));
							}
						}
						if (RA.compareTo("EndOfMethod") != 0) {
							if (RA.indexOf(".") > 0) {
								RA = RA.substring(0, RA.indexOf("."));
							}
						}
						if (MC.compareTo("EndOfMethod") != 0) {
							if (MC.indexOf(".") > 0) {
								MC = MC.substring(0, MC.indexOf("."));
							}
						}
						for (int i = 0; i < numFiles && info[i] != null; i++) {
							if (info[i].compareTo(WA) == 0) {
								writeCount[i]++;
							}
							if (info[i].compareTo(RA) == 0) {
								readCount[i]++;
							}
							if (info[i].compareTo(MC) == 0) {
								methodCallCount[i]++;
							}
						}
						if (WA.compareTo("EndOfMethod") != 0) {
							WA = writeAttr.readLine();
						}
						if (MC.compareTo("EndOfMethod") != 0) {
							MC = methodsCalled.readLine();
						}
						if (RA.compareTo("EndOfMethod") != 0) {
							RA = readAttr.readLine();
						}
					}
					WA = writeAttr.readLine();
					MC = methodsCalled.readLine();
					writeMax1 = writeCount[0];
					RA = readAttr.readLine();
					writeMaxIndex1 = 0;
					for (int i = 1; i < numFiles; i++) {
						if (writeCount[i] > writeMax1) {
							writeMax1 = writeCount[i];
							writeMaxIndex1 = i;
						}
					}
					writeCount[writeMaxIndex1] = 0;
					writeMaxIndex2 = 0;
					writeMax2 = writeCount[0];
					readMax = readCount[0];
					for (int i = 1; i < numFiles; i++) {
						if (writeCount[i] > writeMax2) {
							writeMax2 = writeCount[i];
							writeMaxIndex2 = i;
						}
					}
					readMaxIndex = 0;
					methodCallMax = methodCallCount[0];
					for (int i = 1; i < numFiles; i++) {
						if (readCount[i] > readMax) {
							readMax = readCount[i];
							readMaxIndex = i;
						}
					}
					methodCallMaxIndex = 0;
					boolean isNotEmpty = false;
					for (int i = 1; i < numFiles; i++) {
						if (methodCallCount[i] > methodCallMax) {
							methodCallMax = methodCallCount[i];
							methodCallMaxIndex = i;
						}
					}
					if (writeMax1 > 0 && writeMax2 == 0) {
						isNotEmpty = true;
						finalClass = info[writeMaxIndex1];
					} else if (writeMax1 == 0) {
						if (readMax != 0) {
							isNotEmpty = true;
							finalClass = info[readMaxIndex];
						} else if (methodCallMax != 0) {
							isNotEmpty = true;
							finalClass = info[methodCallMaxIndex];
						}
					}
					for (int j = 0; j < numFiles; j++) {
						readCount[j] = 0;
						writeCount[j] = 0;
						methodCallCount[j] = 0;
					}
					if (isNotEmpty == true) {
						MethodsDestClass.write(methodName);
						MethodsDestClass.newLine();
						MethodsDestClass.write(finalClass);
						MethodsDestClass.newLine();
						isNotEmpty = false;
					}
				}
			}
			writeAttr.close();
			methodsCalled.close();
			readAttr.close();
			MethodsDestClass.close();
			int sizeInfoArray = 0;
			boolean classWritten = false;
			sizeInfoArray = infoArraySize();
			principleClass = new String[100];
			principleMethod = new String[100];
			principleMethodsClass = new String[100];
			String infoArray[] = new String[sizeInfoArray];
			int counter = 0;
			String field;
			FileInputStream fstreamDestMethod = new FileInputStream("InfoFiles/MethodsDestclass.txt");
			DataInputStream inDestMethod = new DataInputStream(fstreamDestMethod);
			PrincipleClassGroup = new BufferedWriter(new FileWriter("InfoFiles/PrincipleClassGroup.txt"));
			BufferedReader destMethod = new BufferedReader(new InputStreamReader(inDestMethod));
			while ((field = destMethod.readLine()) != null) {
				infoArray[counter] = field;
				counter++;
			}
			for (int i = 0; i < numFiles; i++) {
				for (int j = 0; j < counter - 1 && info[i] != null; j++) {
					if (infoArray[j + 1].compareTo(info[i]) == 0) {
						if (classWritten == false) {
							PrincipleClassGroup.write(infoArray[j + 1]);
							PrincipleClassGroup.newLine();
							principleClass[principleClassCount] = infoArray[j + 1];
							classWritten = true;
							principleClassCount++;
						}
						PrincipleClassGroup.write(infoArray[j]);
						principleMethod[principleMethodCount] = infoArray[j];
						principleMethodsClass[principleMethodCount] = infoArray[j + 1];
						principleMethodCount++;
						PrincipleClassGroup.newLine();
					}
				}
				if (classWritten == true) {
					PrincipleClassGroup.write("EndOfClass");
					PrincipleClassGroup.newLine();
					classWritten = false;
				}
			}
			destMethod.close();
			PrincipleClassGroup.close();
			readFileCount = readFileCount();
			writeFileCount = writeFileCount();
			methodCallFileCount = methodCallFileCount();
			readArray = new String[readFileCount];
			writeArray = new String[writeFileCount];
			callArray = new String[methodCallFileCount];
			initializeArrays();
			constructFundamentalView();
			constructInteractionView();
			constructAssociationView();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}