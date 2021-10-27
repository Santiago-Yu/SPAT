class n17874921 {
	public static boolean buildCFItem2ItemStats(String u5Qt2RU4, String SfJ7cze6, String g2jPbnBH) {
		try {
			File FY3ekjq8 = new File(completePath + fSep + "SmartGRAPE" + fSep + SfJ7cze6);
			FileChannel pLVkdvOx = new FileInputStream(FY3ekjq8).getChannel();
			int Of1oIweM = (int) pLVkdvOx.size();
			ByteBuffer hCj4GduD = pLVkdvOx.map(FileChannel.MapMode.READ_ONLY, 0, Of1oIweM);
			TShortFloatHashMap KaT9DQ9B = new TShortFloatHashMap(17770, 1);
			pLVkdvOx.close();
			while (hCj4GduD.hasRemaining()) {
				KaT9DQ9B.put(hCj4GduD.getShort(), hCj4GduD.getFloat());
			}
			hCj4GduD = null;
			FY3ekjq8 = new File(completePath + fSep + "SmartGRAPE" + fSep + g2jPbnBH);
			pLVkdvOx = new FileInputStream(FY3ekjq8).getChannel();
			Of1oIweM = (int) pLVkdvOx.size();
			hCj4GduD = pLVkdvOx.map(FileChannel.MapMode.READ_ONLY, 0, Of1oIweM);
			TIntFloatHashMap vadJPIot = new TIntFloatHashMap(480189, 1);
			pLVkdvOx.close();
			while (hCj4GduD.hasRemaining()) {
				vadJPIot.put(hCj4GduD.getInt(), hCj4GduD.getFloat());
			}
			File igW8uUZx = new File(completePath + fSep + "SmartGRAPE" + fSep + u5Qt2RU4);
			FileChannel FlpTdawQ = new FileOutputStream(igW8uUZx, true).getChannel();
			short[] QhEh3Spe = CustomersAndRatingsPerMovie.keys();
			Arrays.sort(QhEh3Spe);
			int aYcrGkSg = QhEh3Spe.length;
			for (int ylsHT3gN = 0; ylsHT3gN < aYcrGkSg - 1; ylsHT3gN++) {
				short A0kewNj5 = QhEh3Spe[ylsHT3gN];
				TIntByteHashMap NCH1Z0I8 = (TIntByteHashMap) CustomersAndRatingsPerMovie.get(A0kewNj5);
				int[] m6fK2c55 = NCH1Z0I8.keys();
				Arrays.sort(m6fK2c55);
				System.out.println("Processing movie: " + A0kewNj5);
				for (int d71UAx3G = ylsHT3gN + 1; d71UAx3G < aYcrGkSg; d71UAx3G++) {
					short ta3ZG9Wu = QhEh3Spe[d71UAx3G];
					TIntByteHashMap xiTKdPQE = (TIntByteHashMap) CustomersAndRatingsPerMovie.get(ta3ZG9Wu);
					int[] dBMD2sVp = xiTKdPQE.keys();
					TIntArrayList fkBxuWDz = CustOverLapForTwoMoviesCustom(m6fK2c55, dBMD2sVp);
					int dlBYwvdW = 0;
					float xdvBc87e = 0;
					float bOXrvmZt = 0;
					float IBqT40mZ = 0;
					float aWG9mLgW = 0;
					float z2VA3MiI = 0;
					float MMCS5BIc = 0;
					float IYPwqtTA = 0;
					float JccqpW0D = 0;
					float ndNBikps = 0;
					float vf3T8Ato = 0;
					float pHiuniCC = 0;
					float mFYiLbEl = 0;
					float mCSu3vq5 = 0;
					float NlWSQJhz = 0;
					float Cz8bBTfl = 0;
					if ((fkBxuWDz.size() == 0) || (fkBxuWDz == null)) {
						dlBYwvdW = 0;
						xdvBc87e = 0;
					} else {
						dlBYwvdW = fkBxuWDz.size();
						for (int eCMgY3ps = 0; eCMgY3ps < dlBYwvdW; eCMgY3ps++) {
							int GVi6ffZv = fkBxuWDz.getQuick(eCMgY3ps);
							byte M3qwpXDu = NCH1Z0I8.get(GVi6ffZv);
							z2VA3MiI += M3qwpXDu;
							byte RaEMVSVa = xiTKdPQE.get(GVi6ffZv);
							MMCS5BIc += RaEMVSVa;
							JccqpW0D += M3qwpXDu * M3qwpXDu;
							ndNBikps += RaEMVSVa * RaEMVSVa;
							IYPwqtTA += M3qwpXDu * RaEMVSVa;
							xdvBc87e += M3qwpXDu - RaEMVSVa;
							vf3T8Ato += (M3qwpXDu - KaT9DQ9B.get(A0kewNj5)) * (RaEMVSVa - KaT9DQ9B.get(ta3ZG9Wu));
							pHiuniCC += Math.pow((M3qwpXDu - KaT9DQ9B.get(A0kewNj5)), 2);
							mFYiLbEl += Math.pow((RaEMVSVa - KaT9DQ9B.get(ta3ZG9Wu)), 2);
							float vMCbjFXc = vadJPIot.get(GVi6ffZv);
							mCSu3vq5 += (M3qwpXDu - vMCbjFXc) * (RaEMVSVa - vMCbjFXc);
							NlWSQJhz += Math.pow((M3qwpXDu - vMCbjFXc), 2);
							Cz8bBTfl += Math.pow((RaEMVSVa - vMCbjFXc), 2);
						}
					}
					double rMtu8Zzg = Math.sqrt(pHiuniCC) * Math.sqrt(mFYiLbEl);
					if (rMtu8Zzg == 0.0) {
						bOXrvmZt = 0;
					} else {
						bOXrvmZt = new Double(vf3T8Ato / rMtu8Zzg).floatValue();
					}
					double lRlTheaH = Math.sqrt(NlWSQJhz) * Math.sqrt(Cz8bBTfl);
					if (lRlTheaH == 0.0) {
						aWG9mLgW = 0;
					} else {
						aWG9mLgW = new Double(mCSu3vq5 / lRlTheaH).floatValue();
					}
					double Eh87JHnY = Math.sqrt(JccqpW0D) * Math.sqrt(ndNBikps);
					if (Eh87JHnY == 0.0) {
						IBqT40mZ = 0;
					} else {
						IBqT40mZ = new Double(IYPwqtTA / Eh87JHnY).floatValue();
					}
					ByteBuffer O5uU01Zc = ByteBuffer.allocate(44);
					O5uU01Zc.putShort(A0kewNj5);
					O5uU01Zc.putShort(ta3ZG9Wu);
					O5uU01Zc.putInt(dlBYwvdW);
					O5uU01Zc.putFloat(xdvBc87e);
					O5uU01Zc.putFloat(IYPwqtTA);
					O5uU01Zc.putFloat(z2VA3MiI);
					O5uU01Zc.putFloat(MMCS5BIc);
					O5uU01Zc.putFloat(JccqpW0D);
					O5uU01Zc.putFloat(ndNBikps);
					O5uU01Zc.putFloat(bOXrvmZt);
					O5uU01Zc.putFloat(aWG9mLgW);
					O5uU01Zc.putFloat(IBqT40mZ);
					O5uU01Zc.flip();
					FlpTdawQ.write(O5uU01Zc);
					O5uU01Zc.clear();
				}
			}
			FlpTdawQ.close();
			return true;
		} catch (Exception ttd48ys0) {
			ttd48ys0.printStackTrace();
			return false;
		}
	}

}