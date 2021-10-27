class n21925741 {
	public static boolean predictDataSet(String XEKskiAU, String PgdMU5Jh, String Ra62QIyD, String dyc5Bc0x) {
		try {
			if (PgdMU5Jh.equalsIgnoreCase("Qualifying")) {
				File QcTybiUx = new File(
						XEKskiAU + fSep + "SmartGRAPE" + fSep + "CompleteQualifyingDataInByteFormat.txt");
				FileChannel FbOL0HQZ = new FileInputStream(QcTybiUx).getChannel();
				int ffzWcZTL = (int) FbOL0HQZ.size();
				TShortObjectHashMap n2Z6Rndt = new TShortObjectHashMap(17770, 1);
				ByteBuffer PkM7GmIj = FbOL0HQZ.map(FileChannel.MapMode.READ_ONLY, 0, ffzWcZTL);
				while (PkM7GmIj.hasRemaining()) {
					short QlBcVDc9 = PkM7GmIj.getShort();
					int DcF82VbG = PkM7GmIj.getInt();
					if (n2Z6Rndt.containsKey(QlBcVDc9)) {
						TIntArrayList uvPjJ3rP = (TIntArrayList) n2Z6Rndt.get(QlBcVDc9);
						uvPjJ3rP.add(DcF82VbG);
						n2Z6Rndt.put(QlBcVDc9, uvPjJ3rP);
					} else {
						TIntArrayList cwku55uz = new TIntArrayList();
						cwku55uz.add(DcF82VbG);
						n2Z6Rndt.put(QlBcVDc9, cwku55uz);
					}
				}
				System.out.println("Populated qualifying hashmap");
				File qrv1oVlH = new File(XEKskiAU + fSep + "SmartGRAPE" + fSep + Ra62QIyD);
				FileChannel F7GNCeps = new FileOutputStream(qrv1oVlH).getChannel();
				ByteBuffer FExnHzKu;
				TShortObjectHashMap VBABqp2v;
				double z557aADw;
				short[] RravoxIy = n2Z6Rndt.keys();
				Arrays.sort(RravoxIy);
				for (int KFhCMQee = 0; KFhCMQee < RravoxIy.length; KFhCMQee++) {
					short BApry2UM = RravoxIy[KFhCMQee];
					VBABqp2v = loadMovieDiffStats(XEKskiAU, BApry2UM, dyc5Bc0x);
					System.out.println(VBABqp2v.size());
					TIntArrayList HXk3bkuo = (TIntArrayList) n2Z6Rndt.get(BApry2UM);
					for (int tTkhEOvH = 0; tTkhEOvH < HXk3bkuo.size(); tTkhEOvH++) {
						int Mz9MFdbW = HXk3bkuo.getQuick(tTkhEOvH);
						z557aADw = predictSlopeOneRating(Mz9MFdbW, VBABqp2v);
						if (z557aADw == z557aADw) {
							if (z557aADw < 1.0)
								z557aADw = 1.0;
							else if (z557aADw > 5.0)
								z557aADw = 5.0;
						} else
							z557aADw = GetAveragePrediction(BApry2UM);
						FExnHzKu = ByteBuffer.allocate(10);
						FExnHzKu.putShort(BApry2UM);
						FExnHzKu.putInt(Mz9MFdbW);
						FExnHzKu.putFloat(new Double(z557aADw).floatValue());
						FExnHzKu.flip();
						F7GNCeps.write(FExnHzKu);
					}
				}
				F7GNCeps.close();
				return true;
			} else if (PgdMU5Jh.equalsIgnoreCase("Probe")) {
				File p8EKtC7q = new File(XEKskiAU + fSep + "SmartGRAPE" + fSep + "CompleteProbeDataInByteFormat.txt");
				FileChannel y26F2yez = new FileInputStream(p8EKtC7q).getChannel();
				int CsRSdhp5 = (int) y26F2yez.size();
				TShortObjectHashMap bryoqgf1 = new TShortObjectHashMap(17770, 1);
				ByteBuffer uJS97efW = y26F2yez.map(FileChannel.MapMode.READ_ONLY, 0, CsRSdhp5);
				while (uJS97efW.hasRemaining()) {
					short n3dNqprj = uJS97efW.getShort();
					int FWXlagti = uJS97efW.getInt();
					byte hCVSk7nw = uJS97efW.get();
					if (bryoqgf1.containsKey(n3dNqprj)) {
						TIntByteHashMap kOZMkE2Y = (TIntByteHashMap) bryoqgf1.get(n3dNqprj);
						kOZMkE2Y.put(FWXlagti, hCVSk7nw);
						bryoqgf1.put(n3dNqprj, kOZMkE2Y);
					} else {
						TIntByteHashMap cN1KdrDn = new TIntByteHashMap();
						cN1KdrDn.put(FWXlagti, hCVSk7nw);
						bryoqgf1.put(n3dNqprj, cN1KdrDn);
					}
				}
				System.out.println("Populated probe hashmap");
				File kgCFma1c = new File(XEKskiAU + fSep + "SmartGRAPE" + fSep + Ra62QIyD);
				FileChannel s1lj3roZ = new FileOutputStream(kgCFma1c).getChannel();
				ByteBuffer mWBwRboY;
				double CCIaWteX;
				TShortObjectHashMap D1cIUhuQ;
				short[] BQZumrIP = bryoqgf1.keys();
				Arrays.sort(BQZumrIP);
				for (int MDUMNEGS = 0; MDUMNEGS < BQZumrIP.length; MDUMNEGS++) {
					short KlJ6bC4F = BQZumrIP[MDUMNEGS];
					D1cIUhuQ = loadMovieDiffStats(XEKskiAU, KlJ6bC4F, dyc5Bc0x);
					TIntByteHashMap yjxahmUe = (TIntByteHashMap) bryoqgf1.get(KlJ6bC4F);
					TIntArrayList QjXPdyZz = new TIntArrayList(yjxahmUe.keys());
					for (int qVBIzrdP = 0; qVBIzrdP < QjXPdyZz.size(); qVBIzrdP++) {
						int OSI5Uxas = QjXPdyZz.getQuick(qVBIzrdP);
						byte ZpBGuSXa = yjxahmUe.get(OSI5Uxas);
						CCIaWteX = predictSlopeOneRating(OSI5Uxas, D1cIUhuQ);
						if (CCIaWteX == CCIaWteX) {
							if (CCIaWteX < 1.0)
								CCIaWteX = 1.0;
							else if (CCIaWteX > 5.0)
								CCIaWteX = 5.0;
						} else
							CCIaWteX = GetAveragePrediction(KlJ6bC4F);
						mWBwRboY = ByteBuffer.allocate(11);
						mWBwRboY.putShort(KlJ6bC4F);
						mWBwRboY.putInt(OSI5Uxas);
						mWBwRboY.put(ZpBGuSXa);
						mWBwRboY.putFloat(new Double(CCIaWteX).floatValue());
						mWBwRboY.flip();
						s1lj3roZ.write(mWBwRboY);
					}
				}
				s1lj3roZ.close();
				return true;
			} else
				return false;
		} catch (Exception cpr13B73) {
			cpr13B73.printStackTrace();
			return false;
		}
	}

}