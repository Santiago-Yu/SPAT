class n7872668 {
	private static boolean computeCustomerAverages(String FKaI1r3V, String yrGZ812z, String bC5OBVtf) {
		try {
			File IlFWMFua = new File(FKaI1r3V + fSep + "SmartGRAPE" + fSep + bC5OBVtf);
			FileChannel hbzH8fJO = new FileInputStream(IlFWMFua).getChannel();
			int cku3az1S = (int) hbzH8fJO.size();
			ByteBuffer ZRkM6lb8 = hbzH8fJO.map(FileChannel.MapMode.READ_ONLY, 0, cku3az1S);
			TIntObjectHashMap b7KsF9la = new TIntObjectHashMap(480189, 1);
			int PwWxgqRb, HBsOx84s;
			TIntArrayList gXPMrcv7;
			int J3JXZUaK;
			while (ZRkM6lb8.hasRemaining()) {
				J3JXZUaK = ZRkM6lb8.getInt();
				PwWxgqRb = ZRkM6lb8.getInt();
				HBsOx84s = ZRkM6lb8.getInt();
				gXPMrcv7 = new TIntArrayList(2);
				gXPMrcv7.add(PwWxgqRb);
				gXPMrcv7.add(HBsOx84s);
				b7KsF9la.put(J3JXZUaK, gXPMrcv7);
			}
			hbzH8fJO.close();
			ZRkM6lb8 = null;
			System.out.println("Loaded customer index hash");
			File ItoXCIli = new File(FKaI1r3V + fSep + "SmartGRAPE" + fSep + yrGZ812z);
			FileChannel KKsd1GIz = new FileOutputStream(ItoXCIli, true).getChannel();
			int EMOCvB8s = b7KsF9la.size();
			File nbBayodJ = new File(FKaI1r3V + fSep + "SmartGRAPE" + fSep + "MovieRatingBinaryFile.txt");
			hbzH8fJO = new FileInputStream(nbBayodJ).getChannel();
			int[] lWF41Ic4 = b7KsF9la.keys();
			PwWxgqRb = 0;
			HBsOx84s = 0;
			gXPMrcv7 = null;
			ByteBuffer o3Z80J7Z;
			for (int SO8aRPbi = 0; SO8aRPbi < EMOCvB8s; SO8aRPbi++) {
				int Zvmypyps = lWF41Ic4[SO8aRPbi];
				gXPMrcv7 = (TIntArrayList) b7KsF9la.get(Zvmypyps);
				PwWxgqRb = gXPMrcv7.get(0);
				HBsOx84s = gXPMrcv7.get(1);
				if (HBsOx84s > PwWxgqRb) {
					o3Z80J7Z = ByteBuffer.allocate((HBsOx84s - PwWxgqRb + 1) * 3);
					hbzH8fJO.read(o3Z80J7Z, (PwWxgqRb - 1) * 3);
				} else {
					o3Z80J7Z = ByteBuffer.allocate(3);
					hbzH8fJO.read(o3Z80J7Z, (PwWxgqRb - 1) * 3);
				}
				o3Z80J7Z.flip();
				int Y4iE0ytj = o3Z80J7Z.capacity() / 3;
				float gonjULkF = 0;
				for (int yT5wY3JQ = 0; yT5wY3JQ < Y4iE0ytj; yT5wY3JQ++) {
					o3Z80J7Z.getShort();
					gonjULkF += o3Z80J7Z.get();
				}
				ByteBuffer iW5hmsq8 = ByteBuffer.allocate(8);
				iW5hmsq8.putInt(Zvmypyps);
				iW5hmsq8.putFloat(gonjULkF / Y4iE0ytj);
				iW5hmsq8.flip();
				KKsd1GIz.write(iW5hmsq8);
				o3Z80J7Z.clear();
				o3Z80J7Z = null;
				gXPMrcv7.clear();
				gXPMrcv7 = null;
			}
			hbzH8fJO.close();
			KKsd1GIz.close();
			return true;
		} catch (Exception Qzy1FwFb) {
			Qzy1FwFb.printStackTrace();
			return false;
		}
	}

}