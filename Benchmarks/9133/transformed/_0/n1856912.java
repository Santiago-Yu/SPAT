class n1856912 {
	public static boolean predictDataSet(String njZMmIWH, String yWvxDgNb, String jY6vslGA, String fqOtpBeI) {
		try {
			if (yWvxDgNb.equalsIgnoreCase("Qualifying")) {
				File wrB0JsLx = new File(
						njZMmIWH + fSep + "SmartGRAPE" + fSep + "CompleteQualifyingDataInByteFormat.txt");
				FileChannel JyRmUjQ8 = new FileInputStream(wrB0JsLx).getChannel();
				int AODAswzf = (int) JyRmUjQ8.size();
				TShortObjectHashMap deKp22as = new TShortObjectHashMap(17770, 1);
				ByteBuffer DqBiQMjZ = JyRmUjQ8.map(FileChannel.MapMode.READ_ONLY, 0, AODAswzf);
				while (DqBiQMjZ.hasRemaining()) {
					short x5jN5ALG = DqBiQMjZ.getShort();
					int y4x8XR6E = DqBiQMjZ.getInt();
					if (deKp22as.containsKey(x5jN5ALG)) {
						TIntArrayList ziNegOzB = (TIntArrayList) deKp22as.get(x5jN5ALG);
						ziNegOzB.add(y4x8XR6E);
						deKp22as.put(x5jN5ALG, ziNegOzB);
					} else {
						TIntArrayList JJGnKTyY = new TIntArrayList();
						JJGnKTyY.add(y4x8XR6E);
						deKp22as.put(x5jN5ALG, JJGnKTyY);
					}
				}
				System.out.println("Populated qualifying hashmap");
				File OR8VzIPD = new File(njZMmIWH + fSep + "SmartGRAPE" + fSep + jY6vslGA);
				FileChannel FVb9h1Tq = new FileOutputStream(OR8VzIPD).getChannel();
				ByteBuffer MFLrZZ1P;
				TShortObjectHashMap VxpLkK44;
				double u9OpRONf;
				short[] HZdv7U9q = deKp22as.keys();
				Arrays.sort(HZdv7U9q);
				for (int jhl7GyXV = 0; jhl7GyXV < HZdv7U9q.length; jhl7GyXV++) {
					short dTVlb8JH = HZdv7U9q[jhl7GyXV];
					VxpLkK44 = loadMovieDiffStats(njZMmIWH, dTVlb8JH, fqOtpBeI);
					TIntArrayList WHyHHCzE = (TIntArrayList) deKp22as.get(dTVlb8JH);
					for (int niKbUhof = 0; niKbUhof < WHyHHCzE.size(); niKbUhof++) {
						int MUliq1st = WHyHHCzE.getQuick(niKbUhof);
						u9OpRONf = predictPearsonWeightedSlopeOneRating(knn, dTVlb8JH, MUliq1st, VxpLkK44);
						if (u9OpRONf == u9OpRONf) {
							if (u9OpRONf < 1.0)
								u9OpRONf = 1.0;
							else if (u9OpRONf > 5.0)
								u9OpRONf = 5.0;
						} else
							u9OpRONf = movieAverages.get(dTVlb8JH);
						MFLrZZ1P = ByteBuffer.allocate(10);
						MFLrZZ1P.putShort(dTVlb8JH);
						MFLrZZ1P.putInt(MUliq1st);
						MFLrZZ1P.putFloat(new Double(u9OpRONf).floatValue());
						MFLrZZ1P.flip();
						FVb9h1Tq.write(MFLrZZ1P);
					}
				}
				FVb9h1Tq.close();
				return true;
			} else if (yWvxDgNb.equalsIgnoreCase("Probe")) {
				File lZAbNYi3 = new File(njZMmIWH + fSep + "SmartGRAPE" + fSep + "CompleteProbeDataInByteFormat.txt");
				FileChannel dSUT9RLi = new FileInputStream(lZAbNYi3).getChannel();
				int Hrxiq0iO = (int) dSUT9RLi.size();
				TShortObjectHashMap mezfbrhu = new TShortObjectHashMap(17770, 1);
				ByteBuffer RGrlLONY = dSUT9RLi.map(FileChannel.MapMode.READ_ONLY, 0, Hrxiq0iO);
				while (RGrlLONY.hasRemaining()) {
					short a8UtJDr1 = RGrlLONY.getShort();
					int KROE85rw = RGrlLONY.getInt();
					byte OfkUIg9N = RGrlLONY.get();
					if (mezfbrhu.containsKey(a8UtJDr1)) {
						TIntByteHashMap fi29bLXM = (TIntByteHashMap) mezfbrhu.get(a8UtJDr1);
						fi29bLXM.put(KROE85rw, OfkUIg9N);
						mezfbrhu.put(a8UtJDr1, fi29bLXM);
					} else {
						TIntByteHashMap ivaCQpvr = new TIntByteHashMap();
						ivaCQpvr.put(KROE85rw, OfkUIg9N);
						mezfbrhu.put(a8UtJDr1, ivaCQpvr);
					}
				}
				System.out.println("Populated probe hashmap");
				File DPWJcJvN = new File(njZMmIWH + fSep + "SmartGRAPE" + fSep + jY6vslGA);
				FileChannel ArbnIk1s = new FileOutputStream(DPWJcJvN).getChannel();
				ByteBuffer uasbNN5h;
				double EYJ4ql4H;
				TShortObjectHashMap cEOxnLEr;
				short[] MBr7G7d2 = mezfbrhu.keys();
				Arrays.sort(MBr7G7d2);
				for (int fOjpSa3H = 0; fOjpSa3H < MBr7G7d2.length; fOjpSa3H++) {
					short ZY9vaxxb = MBr7G7d2[fOjpSa3H];
					cEOxnLEr = loadMovieDiffStats(njZMmIWH, ZY9vaxxb, fqOtpBeI);
					TIntByteHashMap dkjB0RCI = (TIntByteHashMap) mezfbrhu.get(ZY9vaxxb);
					TIntArrayList BuEfkIL6 = new TIntArrayList(dkjB0RCI.keys());
					for (int ooKPJllu = 0; ooKPJllu < BuEfkIL6.size(); ooKPJllu++) {
						int EbaCMJ7s = BuEfkIL6.getQuick(ooKPJllu);
						byte LenVwLVv = dkjB0RCI.get(EbaCMJ7s);
						EYJ4ql4H = predictPearsonWeightedSlopeOneRating(knn, ZY9vaxxb, EbaCMJ7s, cEOxnLEr);
						if (EYJ4ql4H == EYJ4ql4H) {
							if (EYJ4ql4H < 1.0)
								EYJ4ql4H = 1.0;
							else if (EYJ4ql4H > 5.0)
								EYJ4ql4H = 5.0;
						} else {
							EYJ4ql4H = movieAverages.get(ZY9vaxxb);
							System.out.println("NaN Prediction");
						}
						uasbNN5h = ByteBuffer.allocate(11);
						uasbNN5h.putShort(ZY9vaxxb);
						uasbNN5h.putInt(EbaCMJ7s);
						uasbNN5h.put(LenVwLVv);
						uasbNN5h.putFloat(new Double(EYJ4ql4H).floatValue());
						uasbNN5h.flip();
						ArbnIk1s.write(uasbNN5h);
					}
				}
				ArbnIk1s.close();
				return true;
			} else
				return false;
		} catch (Exception AdVUM7Rf) {
			AdVUM7Rf.printStackTrace();
			return false;
		}
	}

}