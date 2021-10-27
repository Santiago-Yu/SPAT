class n6147227 {
	public static String[] putFECSplitFile(String r1tnRiHJ, File Ly2ckHmt, int ERSgfwjA, boolean oSakTwVU) {
		FcpFECUtils BUUP8tMO = null;
		Vector RT9QLWgw = null;
		Vector DKWQLYg5 = new Vector();
		Vector Ub2J3P4d = new Vector();
		Vector IGzDdzCj = new Vector();
		Vector j53KgEIs = new Vector();
		int WjDtBlay = (int) Ly2ckHmt.length();
		String CVV7DGf5 = new String();
		int T0nbah8z = frame1.frostSettings.getIntValue("splitfileUploadThreads");
		Thread[] bOoMK7Pr = null;
		String[][] XCyqVaNd = null;
		Thread[] dByQQ5j2 = null;
		String[][] fRwHeAJv = null;
		int aa0m5g3f = 0;
		String SACTQQ8Y = getBoard(Ly2ckHmt);
		{
			BUUP8tMO = new FcpFECUtils(frame1.frostSettings.getValue("nodeAddress"),
					frame1.frostSettings.getIntValue("nodePort"));
			synchronized (BUUP8tMO.getClass()) {
				try {
					RT9QLWgw = BUUP8tMO.FECSegmentFile("OnionFEC_a_1_2", WjDtBlay);
				} catch (Exception lM7dMptn) {
				}
			}
			int OJiRcQ29 = 0;
			int T8ZPHMPQ = 0;
			synchronized (BUUP8tMO.getClass()) {
				try {
					Socket hZWehOj0;
					BufferedInputStream WpI5bYlv;
					PrintStream oODyAvcO;
					for (int u0LeeIC1 = 0; u0LeeIC1 < RT9QLWgw.size(); u0LeeIC1++) {
						int JODSVJow = (int) ((FcpFECUtilsSegmentHeader) RT9QLWgw.get(u0LeeIC1)).BlockCount;
						int zdlzH4fh = 0;
						hZWehOj0 = new Socket(InetAddress.getByName(frame1.frostSettings.getValue("nodeAddress")),
								frame1.frostSettings.getIntValue("nodePort"));
						hZWehOj0.setSoTimeout(1800000);
						oODyAvcO = new PrintStream(hZWehOj0.getOutputStream());
						WpI5bYlv = new BufferedInputStream(hZWehOj0.getInputStream());
						FileInputStream MUskxQF2 = new FileInputStream(Ly2ckHmt);
						File[] J5xUM9O8 = new File[JODSVJow];
						{
							System.out.println("Processing segment " + u0LeeIC1);
							MUskxQF2.skip(((FcpFECUtilsSegmentHeader) RT9QLWgw.get(u0LeeIC1)).Offset);
							long fB4Qrw8e = ((FcpFECUtilsSegmentHeader) RT9QLWgw.get(u0LeeIC1)).BlockCount
									* ((FcpFECUtilsSegmentHeader) RT9QLWgw.get(u0LeeIC1)).BlockSize;
							System.out.println("segLength = " + Long.toHexString(fB4Qrw8e));
							String mO5sCX2P = "SegmentHeader\n"
									+ ((FcpFECUtilsSegmentHeader) RT9QLWgw.get(u0LeeIC1)).reconstruct()
									+ "EndMessage\n";
							String QMgMsmQn = "\0\0\0\2FECEncodeSegment\nMetadataLength="
									+ Long.toHexString(mO5sCX2P.length()) + "\nDataLength="
									+ Long.toHexString(mO5sCX2P.length() + fB4Qrw8e) + "\nData\n" + mO5sCX2P;
							System.out.print(QMgMsmQn);
							oODyAvcO.print(QMgMsmQn);
							long mtxIGRH9 = 0;
							while (mtxIGRH9 < fB4Qrw8e) {
								byte[] j5rTZmCo = new byte[(int) ((FcpFECUtilsSegmentHeader) RT9QLWgw
										.get(u0LeeIC1)).BlockSize];
								System.out.println(Long.toHexString(
										((FcpFECUtilsSegmentHeader) RT9QLWgw.get(u0LeeIC1)).Offset + mtxIGRH9));
								int uyOlZ2Ol = MUskxQF2.read(j5rTZmCo);
								if (uyOlZ2Ol < 0) {
									System.out.println("End of input file - no data");
									for (int XcxvmgQg = 0; XcxvmgQg < j5rTZmCo.length; XcxvmgQg++)
										j5rTZmCo[XcxvmgQg] = 0;
									uyOlZ2Ol = j5rTZmCo.length;
								}
								if (uyOlZ2Ol < j5rTZmCo.length) {
									System.out.println("End of input file - not enough data");
									for (int fXql34PJ = uyOlZ2Ol; fXql34PJ < j5rTZmCo.length; fXql34PJ++)
										j5rTZmCo[fXql34PJ] = 0;
									uyOlZ2Ol = j5rTZmCo.length;
								}
								if (uyOlZ2Ol > fB4Qrw8e - mtxIGRH9)
									uyOlZ2Ol = (int) (fB4Qrw8e - mtxIGRH9);
								oODyAvcO.write(j5rTZmCo);
								File K5geizQN = new File(frame1.keypool + String.valueOf(System.currentTimeMillis())
										+ "-" + OJiRcQ29 + ".tmp");
								J5xUM9O8[zdlzH4fh] = K5geizQN;
								K5geizQN.deleteOnExit();
								FileOutputStream BInCCXrU = new FileOutputStream(K5geizQN);
								BInCCXrU.write(j5rTZmCo, 0, (int) uyOlZ2Ol);
								BInCCXrU.close();
								mtxIGRH9 += uyOlZ2Ol;
								OJiRcQ29++;
								;
								zdlzH4fh++;
								if (zdlzH4fh >= JODSVJow)
									break;
							}
							DKWQLYg5.add(J5xUM9O8);
							oODyAvcO.flush();
							MUskxQF2.close();
						}
						int GhyXFhgQ = 0;
						int mOBvXX9Z = (int) ((FcpFECUtilsSegmentHeader) RT9QLWgw.get(u0LeeIC1)).CheckBlockCount;
						File[] aq1uFNma = new File[mOBvXX9Z];
						File LapIOa7c = null;
						FileOutputStream lUsWClRL = null;
						{
							String mDVF0b2X;
							long Ktq5KBDg = ((FcpFECUtilsSegmentHeader) RT9QLWgw.get(u0LeeIC1)).CheckBlockSize;
							int e6AEiOFt = 0;
							int o9NHaDdc = 0;
							do {
								boolean n6y0E2F4 = false;
								mDVF0b2X = BUUP8tMO.getLine(WpI5bYlv).trim();
								if (mDVF0b2X.equals("DataChunk")) {
									n6y0E2F4 = true;
								}
								if (mDVF0b2X.startsWith("Length=")) {
									o9NHaDdc = Integer.parseInt((mDVF0b2X.split("="))[1], 16);
								}
								if (mDVF0b2X.equals("Data")) {
									int douhSYUQ;
									byte[] H9yOergI = new byte[(int) o9NHaDdc];
									if (LapIOa7c == null) {
										LapIOa7c = new File(frame1.keypool + String.valueOf(System.currentTimeMillis())
												+ "-chk-" + T8ZPHMPQ + ".tmp");
										LapIOa7c.deleteOnExit();
										lUsWClRL = new FileOutputStream(LapIOa7c);
									}
									douhSYUQ = WpI5bYlv.read(H9yOergI);
									while (douhSYUQ < o9NHaDdc) {
										douhSYUQ += WpI5bYlv.read(H9yOergI, douhSYUQ, o9NHaDdc - douhSYUQ);
									}
									lUsWClRL.write(H9yOergI);
									e6AEiOFt += douhSYUQ;
									if (e6AEiOFt == Ktq5KBDg) {
										lUsWClRL.close();
										aq1uFNma[GhyXFhgQ] = LapIOa7c;
										LapIOa7c = null;
										GhyXFhgQ++;
										T8ZPHMPQ++;
										e6AEiOFt = 0;
									}
								}
							} while (mDVF0b2X.length() > 0);
							Ub2J3P4d.add(aq1uFNma);
						}
						oODyAvcO.close();
						WpI5bYlv.close();
						hZWehOj0.close();
					}
				} catch (Exception D3pAx9qA) {
					System.out.println("putFECSplitFile NOT GOOD " + D3pAx9qA.toString());
				}
			}
			int pMujhl0m = 0;
			int npMPgcel = 0;
			for (int tgiBYN3K = 0; tgiBYN3K < DKWQLYg5.size(); tgiBYN3K++) {
				File[] vyN7VGsz = (File[]) DKWQLYg5.get(tgiBYN3K);
				bOoMK7Pr = new Thread[vyN7VGsz.length];
				XCyqVaNd = new String[vyN7VGsz.length][2];
				aa0m5g3f = 0;
				for (int u7UrftNq = 0; u7UrftNq < vyN7VGsz.length; u7UrftNq++) {
					if (DEBUG)
						System.out.println("Chunk: " + pMujhl0m);
					while (getActiveThreads(bOoMK7Pr) >= T0nbah8z)
						mixed.wait(5000);
					bOoMK7Pr[aa0m5g3f] = new putKeyThread("CHK@", vyN7VGsz[u7UrftNq], ERSgfwjA, XCyqVaNd, aa0m5g3f,
							oSakTwVU);
					bOoMK7Pr[aa0m5g3f].start();
					aa0m5g3f++;
					npMPgcel += vyN7VGsz[u7UrftNq].length();
					updateUploadTable(Ly2ckHmt, npMPgcel, oSakTwVU);
					mixed.wait(1000);
					pMujhl0m++;
				}
				while (getActiveThreads(bOoMK7Pr) > 0) {
					if (DEBUG)
						System.out.println("Active Splitfile inserts remaining: " + getActiveThreads(bOoMK7Pr));
					mixed.wait(3000);
				}
				IGzDdzCj.add(XCyqVaNd);
			}
			int VQtk348i = 0;
			for (int px21BPIh = 0; px21BPIh < Ub2J3P4d.size(); px21BPIh++) {
				File[] VDmbakFe = (File[]) Ub2J3P4d.get(px21BPIh);
				dByQQ5j2 = new Thread[VDmbakFe.length];
				fRwHeAJv = new String[VDmbakFe.length][2];
				aa0m5g3f = 0;
				for (int HDQAr63N = 0; HDQAr63N < VDmbakFe.length; HDQAr63N++) {
					if (DEBUG)
						System.out.println("Check: " + VQtk348i);
					while (getActiveThreads(dByQQ5j2) >= T0nbah8z)
						mixed.wait(5000);
					dByQQ5j2[aa0m5g3f] = new putKeyThread("CHK@", VDmbakFe[HDQAr63N], ERSgfwjA, fRwHeAJv, aa0m5g3f,
							oSakTwVU);
					dByQQ5j2[aa0m5g3f].start();
					aa0m5g3f++;
					npMPgcel += VDmbakFe[HDQAr63N].length();
					updateUploadTable(Ly2ckHmt, npMPgcel, oSakTwVU);
					mixed.wait(1000);
					VQtk348i++;
				}
				while (getActiveThreads(dByQQ5j2) > 0) {
					if (DEBUG)
						System.out.println("Active Checkblock inserts remaining: " + getActiveThreads(dByQQ5j2));
					mixed.wait(3000);
				}
				j53KgEIs.add(fRwHeAJv);
			}
			dByQQ5j2 = null;
		}
		String UTkMmSiW = null;
		{
			synchronized (BUUP8tMO.getClass()) {
				try {
					UTkMmSiW = BUUP8tMO.FECMakeMetadata(RT9QLWgw, IGzDdzCj, j53KgEIs, "Frost");
				} catch (Exception niAME2Dj) {
					System.out.println("putFECSplitFile NOT GOOD " + niAME2Dj.toString());
				}
			}
			String[] iMOVoAf0 = UTkMmSiW.split("\n");
			for (int gqaWKQoh = 0; gqaWKQoh < iMOVoAf0.length; gqaWKQoh++)
				System.out.println(iMOVoAf0[gqaWKQoh]);
			int NF3lN6hT = -1;
			int chzGdfpS = -1;
			for (int hzKpjBfB = 0; hzKpjBfB < iMOVoAf0.length; hzKpjBfB++) {
				if (iMOVoAf0[hzKpjBfB].equals("Document")) {
					NF3lN6hT = hzKpjBfB + 1;
					break;
				}
			}
			for (int A2YQp5el = NF3lN6hT; A2YQp5el < iMOVoAf0.length; A2YQp5el++) {
				if (iMOVoAf0[A2YQp5el].equals("End")) {
					chzGdfpS = A2YQp5el;
					break;
				}
			}
			System.out.println("sortStart " + NF3lN6hT + " sortEnd " + chzGdfpS);
			if (NF3lN6hT < chzGdfpS)
				Arrays.sort(iMOVoAf0, NF3lN6hT, chzGdfpS);
			UTkMmSiW = new String();
			for (int MWiXwQdi = 0; MWiXwQdi < iMOVoAf0.length; MWiXwQdi++)
				UTkMmSiW += iMOVoAf0[MWiXwQdi] + "\n";
			System.out.println(UTkMmSiW);
		}
		int voqyLrhe = 0;
		String[] aVdd1N5x = { "Error", "Error" };
		while (!aVdd1N5x[0].equals("Success") && !aVdd1N5x[0].equals("KeyCollision") && voqyLrhe < 8) {
			voqyLrhe++;
			try {
				FcpConnection tkg1tFrl = new FcpConnection(frame1.frostSettings.getValue("nodeAddress"),
						frame1.frostSettings.getValue("nodePort"));
				CVV7DGf5 = tkg1tFrl.putKeyFromFile(r1tnRiHJ, null, UTkMmSiW.getBytes(), ERSgfwjA, oSakTwVU);
			} catch (FcpToolsException eQA7efzV) {
				if (DEBUG)
					System.out.println("FcpToolsException " + eQA7efzV);
				frame1.displayWarning(eQA7efzV.toString());
			} catch (UnknownHostException Woaw1MXD) {
				if (DEBUG)
					System.out.println("UnknownHostException");
				frame1.displayWarning(Woaw1MXD.toString());
			} catch (IOException gOSaDUM4) {
				if (DEBUG)
					System.out.println("IOException");
				frame1.displayWarning(gOSaDUM4.toString());
			}
			aVdd1N5x = result(CVV7DGf5);
			mixed.wait(3000);
			if (DEBUG)
				System.out.println("*****" + aVdd1N5x[0] + " " + aVdd1N5x[1] + " ");
		}
		if ((aVdd1N5x[0].equals("Success") || aVdd1N5x[0].equals("KeyCollision")) && oSakTwVU) {
			try {
				GregorianCalendar bswcXOJ2 = new GregorianCalendar();
				bswcXOJ2.setTimeZone(TimeZone.getTimeZone("GMT"));
				String qcm9hmWh = bswcXOJ2.get(Calendar.YEAR) + ".";
				qcm9hmWh += bswcXOJ2.get(Calendar.MONTH) + 1 + ".";
				qcm9hmWh += bswcXOJ2.get(Calendar.DATE);
				String Om2hOKnP = System.getProperty("file.separator");
				String ooifb4EM = frame1.keypool + SACTQQ8Y + Om2hOKnP + qcm9hmWh + Om2hOKnP;
				FcpConnection illvcEgU = new FcpConnection(frame1.frostSettings.getValue("nodeAddress"),
						frame1.frostSettings.getValue("nodePort"));
				String taceiNfD = result(
						illvcEgU.putKeyFromFile(r1tnRiHJ, null, UTkMmSiW.getBytes(), ERSgfwjA, false))[1];
				String pjaKeMJZ = new String("freenet:");
				if (taceiNfD.startsWith(pjaKeMJZ))
					taceiNfD = taceiNfD.substring(pjaKeMJZ.length());
				FileAccess.writeFile("Already uploaded today", ooifb4EM + taceiNfD + ".lck");
			} catch (Exception wLsnbxDM) {
			}
		}
		return aVdd1N5x;
	}

}