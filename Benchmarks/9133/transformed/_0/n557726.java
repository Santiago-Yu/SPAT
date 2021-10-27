class n557726 {
	public void extractPrincipalClasses(String[] bhT4L9p7, int S8dNm9UA) {
		String ClS6zG47 = "";
		String GI2Hd7G1 = "";
		String zfpP8ga1;
		String Qt4MGMZG;
		String I78sC6Gq;
		int[] hKohyUw3 = new int[S8dNm9UA];
		int[] ucvx1XMv = new int[S8dNm9UA];
		int[] aWbfKFrr = new int[S8dNm9UA];
		int LNc0CLWv;
		int K8wZsvFN;
		int Xjgto7qM;
		int Jh8m8KEK;
		int M5tBweUA = 0;
		int AVckgcra = 0;
		int W7vBE653;
		int RHHvjV1D = 0;
		try {
			MethodsDestClass = new BufferedWriter(new FileWriter("InfoFiles/MethodsDestclass.txt"));
			FileInputStream m3k3IwyE = new FileInputStream("InfoFiles/WriteAttributes.txt");
			DataInputStream r3dVa8xc = new DataInputStream(m3k3IwyE);
			BufferedReader A51nnpqK = new BufferedReader(new InputStreamReader(r3dVa8xc));
			FileInputStream KwhJExnD = new FileInputStream("InfoFiles/MethodsCalled.txt");
			DataInputStream GM5O3Q0N = new DataInputStream(KwhJExnD);
			BufferedReader eSZnx7UN = new BufferedReader(new InputStreamReader(GM5O3Q0N));
			FileInputStream YwDIuonG = new FileInputStream("InfoFiles/ReadAttributes.txt");
			DataInputStream rhc1Itrd = new DataInputStream(YwDIuonG);
			BufferedReader rezaLnxM = new BufferedReader(new InputStreamReader(rhc1Itrd));
			while ((zfpP8ga1 = A51nnpqK.readLine()) != null && (I78sC6Gq = rezaLnxM.readLine()) != null
					&& (Qt4MGMZG = eSZnx7UN.readLine()) != null) {
				zfpP8ga1 = A51nnpqK.readLine();
				I78sC6Gq = rezaLnxM.readLine();
				Qt4MGMZG = eSZnx7UN.readLine();
				while (zfpP8ga1.compareTo("EndOfClass") != 0 && I78sC6Gq.compareTo("EndOfClass") != 0
						&& Qt4MGMZG.compareTo("EndOfClass") != 0) {
					ClS6zG47 = A51nnpqK.readLine();
					rezaLnxM.readLine();
					eSZnx7UN.readLine();
					zfpP8ga1 = A51nnpqK.readLine();
					Qt4MGMZG = eSZnx7UN.readLine();
					I78sC6Gq = rezaLnxM.readLine();
					while (true) {
						if (zfpP8ga1.compareTo("EndOfMethod") == 0 && I78sC6Gq.compareTo("EndOfMethod") == 0
								&& Qt4MGMZG.compareTo("EndOfMethod") == 0) {
							break;
						}
						if (zfpP8ga1.compareTo("EndOfMethod") != 0) {
							if (zfpP8ga1.indexOf(".") > 0) {
								zfpP8ga1 = zfpP8ga1.substring(0, zfpP8ga1.indexOf("."));
							}
						}
						if (I78sC6Gq.compareTo("EndOfMethod") != 0) {
							if (I78sC6Gq.indexOf(".") > 0) {
								I78sC6Gq = I78sC6Gq.substring(0, I78sC6Gq.indexOf("."));
							}
						}
						if (Qt4MGMZG.compareTo("EndOfMethod") != 0) {
							if (Qt4MGMZG.indexOf(".") > 0) {
								Qt4MGMZG = Qt4MGMZG.substring(0, Qt4MGMZG.indexOf("."));
							}
						}
						for (int fnbLVmXa = 0; fnbLVmXa < S8dNm9UA && bhT4L9p7[fnbLVmXa] != null; fnbLVmXa++) {
							if (bhT4L9p7[fnbLVmXa].compareTo(zfpP8ga1) == 0) {
								ucvx1XMv[fnbLVmXa]++;
							}
							if (bhT4L9p7[fnbLVmXa].compareTo(I78sC6Gq) == 0) {
								hKohyUw3[fnbLVmXa]++;
							}
							if (bhT4L9p7[fnbLVmXa].compareTo(Qt4MGMZG) == 0) {
								aWbfKFrr[fnbLVmXa]++;
							}
						}
						if (zfpP8ga1.compareTo("EndOfMethod") != 0) {
							zfpP8ga1 = A51nnpqK.readLine();
						}
						if (Qt4MGMZG.compareTo("EndOfMethod") != 0) {
							Qt4MGMZG = eSZnx7UN.readLine();
						}
						if (I78sC6Gq.compareTo("EndOfMethod") != 0) {
							I78sC6Gq = rezaLnxM.readLine();
						}
					}
					zfpP8ga1 = A51nnpqK.readLine();
					Qt4MGMZG = eSZnx7UN.readLine();
					I78sC6Gq = rezaLnxM.readLine();
					LNc0CLWv = ucvx1XMv[0];
					AVckgcra = 0;
					for (int oXqMkfzo = 1; oXqMkfzo < S8dNm9UA; oXqMkfzo++) {
						if (ucvx1XMv[oXqMkfzo] > LNc0CLWv) {
							LNc0CLWv = ucvx1XMv[oXqMkfzo];
							AVckgcra = oXqMkfzo;
						}
					}
					ucvx1XMv[AVckgcra] = 0;
					K8wZsvFN = ucvx1XMv[0];
					W7vBE653 = 0;
					for (int Zca0wgje = 1; Zca0wgje < S8dNm9UA; Zca0wgje++) {
						if (ucvx1XMv[Zca0wgje] > K8wZsvFN) {
							K8wZsvFN = ucvx1XMv[Zca0wgje];
							W7vBE653 = Zca0wgje;
						}
					}
					Xjgto7qM = hKohyUw3[0];
					M5tBweUA = 0;
					for (int CHS6Bb6e = 1; CHS6Bb6e < S8dNm9UA; CHS6Bb6e++) {
						if (hKohyUw3[CHS6Bb6e] > Xjgto7qM) {
							Xjgto7qM = hKohyUw3[CHS6Bb6e];
							M5tBweUA = CHS6Bb6e;
						}
					}
					Jh8m8KEK = aWbfKFrr[0];
					RHHvjV1D = 0;
					for (int DTI83mfG = 1; DTI83mfG < S8dNm9UA; DTI83mfG++) {
						if (aWbfKFrr[DTI83mfG] > Jh8m8KEK) {
							Jh8m8KEK = aWbfKFrr[DTI83mfG];
							RHHvjV1D = DTI83mfG;
						}
					}
					boolean L432Gqro = false;
					if (LNc0CLWv > 0 && K8wZsvFN == 0) {
						GI2Hd7G1 = bhT4L9p7[AVckgcra];
						L432Gqro = true;
					} else if (LNc0CLWv == 0) {
						if (Xjgto7qM != 0) {
							GI2Hd7G1 = bhT4L9p7[M5tBweUA];
							L432Gqro = true;
						} else if (Jh8m8KEK != 0) {
							GI2Hd7G1 = bhT4L9p7[RHHvjV1D];
							L432Gqro = true;
						}
					}
					if (L432Gqro == true) {
						MethodsDestClass.write(ClS6zG47);
						MethodsDestClass.newLine();
						MethodsDestClass.write(GI2Hd7G1);
						MethodsDestClass.newLine();
						L432Gqro = false;
					}
					for (int l15hnHoD = 0; l15hnHoD < S8dNm9UA; l15hnHoD++) {
						hKohyUw3[l15hnHoD] = 0;
						ucvx1XMv[l15hnHoD] = 0;
						aWbfKFrr[l15hnHoD] = 0;
					}
				}
			}
			A51nnpqK.close();
			eSZnx7UN.close();
			rezaLnxM.close();
			MethodsDestClass.close();
			int DJB9BtBu = 0;
			DJB9BtBu = infoArraySize();
			boolean wIF8jc6c = false;
			principleClass = new String[100];
			principleMethod = new String[100];
			principleMethodsClass = new String[100];
			String kgnxQBWu[] = new String[DJB9BtBu];
			String N1JqkaGi;
			int JiNEiYJ0 = 0;
			FileInputStream YrKW6mHT = new FileInputStream("InfoFiles/MethodsDestclass.txt");
			DataInputStream NxBoPGnK = new DataInputStream(YrKW6mHT);
			BufferedReader xgic07sM = new BufferedReader(new InputStreamReader(NxBoPGnK));
			PrincipleClassGroup = new BufferedWriter(new FileWriter("InfoFiles/PrincipleClassGroup.txt"));
			while ((N1JqkaGi = xgic07sM.readLine()) != null) {
				kgnxQBWu[JiNEiYJ0] = N1JqkaGi;
				JiNEiYJ0++;
			}
			for (int tfVEchiR = 0; tfVEchiR < S8dNm9UA; tfVEchiR++) {
				for (int AcObXcud = 0; AcObXcud < JiNEiYJ0 - 1 && bhT4L9p7[tfVEchiR] != null; AcObXcud++) {
					if (kgnxQBWu[AcObXcud + 1].compareTo(bhT4L9p7[tfVEchiR]) == 0) {
						if (wIF8jc6c == false) {
							PrincipleClassGroup.write(kgnxQBWu[AcObXcud + 1]);
							PrincipleClassGroup.newLine();
							principleClass[principleClassCount] = kgnxQBWu[AcObXcud + 1];
							principleClassCount++;
							wIF8jc6c = true;
						}
						PrincipleClassGroup.write(kgnxQBWu[AcObXcud]);
						principleMethod[principleMethodCount] = kgnxQBWu[AcObXcud];
						principleMethodsClass[principleMethodCount] = kgnxQBWu[AcObXcud + 1];
						principleMethodCount++;
						PrincipleClassGroup.newLine();
					}
				}
				if (wIF8jc6c == true) {
					PrincipleClassGroup.write("EndOfClass");
					PrincipleClassGroup.newLine();
					wIF8jc6c = false;
				}
			}
			xgic07sM.close();
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
		} catch (IOException xu1nQvjp) {
			xu1nQvjp.printStackTrace();
		}
	}

}