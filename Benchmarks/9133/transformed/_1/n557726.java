class n557726 {
	public void extractPrincipalClasses(String[] info, int numFiles) {
		String methodName = "";
		String finalClass = "";
		String WA;
		String MC;
		String RA;
		int[] readCount = new int[numFiles];
		int[] writeCount = new int[numFiles];
		int[] methodCallCount = new int[numFiles];
		int writeMax1;
		int writeMax2;
		int readMax;
		int methodCallMax;
		int readMaxIndex = 0;
		int writeMaxIndex1 = 0;
		int writeMaxIndex2;
		int methodCallMaxIndex = 0;
		try {
			MethodsDestClass = new BufferedWriter(new FileWriter("InfoFiles/MethodsDestclass.txt"));
			FileInputStream fstreamWriteAttr = new FileInputStream("InfoFiles/WriteAttributes.txt");
			DataInputStream inWriteAttr = new DataInputStream(fstreamWriteAttr);
			BufferedReader writeAttr = new BufferedReader(new InputStreamReader(inWriteAttr));
			FileInputStream fstreamMethodsCalled = new FileInputStream("InfoFiles/MethodsCalled.txt");
			DataInputStream inMethodsCalled = new DataInputStream(fstreamMethodsCalled);
			BufferedReader methodsCalled = new BufferedReader(new InputStreamReader(inMethodsCalled));
			FileInputStream fstreamReadAttr = new FileInputStream("InfoFiles/ReadAttributes.txt");
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
						int l8CLX = 0;
						while (l8CLX < numFiles && info[l8CLX] != null) {
							if (info[l8CLX].compareTo(WA) == 0) {
								writeCount[l8CLX]++;
							}
							if (info[l8CLX].compareTo(RA) == 0) {
								readCount[l8CLX]++;
							}
							if (info[l8CLX].compareTo(MC) == 0) {
								methodCallCount[l8CLX]++;
							}
							l8CLX++;
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
					RA = readAttr.readLine();
					writeMax1 = writeCount[0];
					writeMaxIndex1 = 0;
					int Z5dqI = 1;
					while (Z5dqI < numFiles) {
						if (writeCount[Z5dqI] > writeMax1) {
							writeMax1 = writeCount[Z5dqI];
							writeMaxIndex1 = Z5dqI;
						}
						Z5dqI++;
					}
					writeCount[writeMaxIndex1] = 0;
					writeMax2 = writeCount[0];
					writeMaxIndex2 = 0;
					int I8YKL = 1;
					while (I8YKL < numFiles) {
						if (writeCount[I8YKL] > writeMax2) {
							writeMax2 = writeCount[I8YKL];
							writeMaxIndex2 = I8YKL;
						}
						I8YKL++;
					}
					readMax = readCount[0];
					readMaxIndex = 0;
					int FzpkK = 1;
					while (FzpkK < numFiles) {
						if (readCount[FzpkK] > readMax) {
							readMax = readCount[FzpkK];
							readMaxIndex = FzpkK;
						}
						FzpkK++;
					}
					methodCallMax = methodCallCount[0];
					methodCallMaxIndex = 0;
					int RF76k = 1;
					while (RF76k < numFiles) {
						if (methodCallCount[RF76k] > methodCallMax) {
							methodCallMax = methodCallCount[RF76k];
							methodCallMaxIndex = RF76k;
						}
						RF76k++;
					}
					boolean isNotEmpty = false;
					if (writeMax1 > 0 && writeMax2 == 0) {
						finalClass = info[writeMaxIndex1];
						isNotEmpty = true;
					} else if (writeMax1 == 0) {
						if (readMax != 0) {
							finalClass = info[readMaxIndex];
							isNotEmpty = true;
						} else if (methodCallMax != 0) {
							finalClass = info[methodCallMaxIndex];
							isNotEmpty = true;
						}
					}
					if (isNotEmpty == true) {
						MethodsDestClass.write(methodName);
						MethodsDestClass.newLine();
						MethodsDestClass.write(finalClass);
						MethodsDestClass.newLine();
						isNotEmpty = false;
					}
					int L39JT = 0;
					while (L39JT < numFiles) {
						readCount[L39JT] = 0;
						writeCount[L39JT] = 0;
						methodCallCount[L39JT] = 0;
						L39JT++;
					}
				}
			}
			writeAttr.close();
			methodsCalled.close();
			readAttr.close();
			MethodsDestClass.close();
			int sizeInfoArray = 0;
			sizeInfoArray = infoArraySize();
			boolean classWritten = false;
			principleClass = new String[100];
			principleMethod = new String[100];
			principleMethodsClass = new String[100];
			String infoArray[] = new String[sizeInfoArray];
			String field;
			int counter = 0;
			FileInputStream fstreamDestMethod = new FileInputStream("InfoFiles/MethodsDestclass.txt");
			DataInputStream inDestMethod = new DataInputStream(fstreamDestMethod);
			BufferedReader destMethod = new BufferedReader(new InputStreamReader(inDestMethod));
			PrincipleClassGroup = new BufferedWriter(new FileWriter("InfoFiles/PrincipleClassGroup.txt"));
			while ((field = destMethod.readLine()) != null) {
				infoArray[counter] = field;
				counter++;
			}
			int BM7J1 = 0;
			while (BM7J1 < numFiles) {
				for (int j = 0; j < counter - 1 && info[BM7J1] != null; j++) {
					if (infoArray[j + 1].compareTo(info[BM7J1]) == 0) {
						if (classWritten == false) {
							PrincipleClassGroup.write(infoArray[j + 1]);
							PrincipleClassGroup.newLine();
							principleClass[principleClassCount] = infoArray[j + 1];
							principleClassCount++;
							classWritten = true;
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
				BM7J1++;
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