class n17874922 {
	public static boolean buildPerMovieDiffBinary(String bkFYzQhh) {
		try {
			File xG8oK1oH = new File(completePath + fSep + "SmartGRAPE" + fSep + bkFYzQhh);
			FileChannel TOXQ0qe0 = new FileInputStream(xG8oK1oH).getChannel();
			System.out.println(TOXQ0qe0.size());
			short dQqELM17, m5Tj2jL3;
			int DaSK6qvh;
			float FriH5ndK, HDLD0JRE, yGEpPi4j, YY83V3xX, lmVU4QnS, dGyYNo8r, Wfmv7LJO, lz8OowAn, GiXB7BXy;
			long kcYayRnh;
			for (long ZmUHwJ1m = 1; ZmUHwJ1m < 17770; ZmUHwJ1m++) {
				File G9W5t1NU = new File("C:\\NetflixData\\download\\SmartGrape\\CFItemToItemStats\\Movie--" + ZmUHwJ1m
						+ "-MatrixData.txt");
				FileChannel R2AERXL4 = new FileOutputStream(G9W5t1NU, true).getChannel();
				ByteBuffer zpwrukXc = ByteBuffer.allocate(17770 * 44);
				for (long rbD09Nci = 1; rbD09Nci < ZmUHwJ1m; rbD09Nci++) {
					ByteBuffer I8KfGzSN = ByteBuffer.allocate(44);
					kcYayRnh = 0;
					kcYayRnh += new Long(17769).longValue() * new Long(17770).longValue() * new Long(22).longValue();
					kcYayRnh -= new Long((17769 - (rbD09Nci - 1))).longValue()
							* new Long((17770 - (rbD09Nci - 1))).longValue() * new Long(22).longValue();
					kcYayRnh += new Long((ZmUHwJ1m - rbD09Nci - 1) * 44).longValue();
					TOXQ0qe0.position(kcYayRnh);
					TOXQ0qe0.read(I8KfGzSN);
					I8KfGzSN.flip();
					zpwrukXc.putShort(I8KfGzSN.getShort());
					I8KfGzSN.getShort();
					zpwrukXc.putInt(I8KfGzSN.getInt());
					zpwrukXc.putFloat(-I8KfGzSN.getInt());
					zpwrukXc.putFloat(I8KfGzSN.getFloat());
					zpwrukXc.putFloat(I8KfGzSN.getFloat());
					zpwrukXc.putFloat(I8KfGzSN.getFloat());
					zpwrukXc.putFloat(I8KfGzSN.getFloat());
					zpwrukXc.putFloat(I8KfGzSN.getFloat());
					zpwrukXc.putFloat(I8KfGzSN.getFloat());
					zpwrukXc.putFloat(I8KfGzSN.getFloat());
					zpwrukXc.putFloat(I8KfGzSN.getFloat());
				}
				zpwrukXc.putShort(new Long(ZmUHwJ1m).shortValue());
				zpwrukXc.putInt(0);
				zpwrukXc.putFloat(0);
				zpwrukXc.putFloat(0);
				zpwrukXc.putFloat(0);
				zpwrukXc.putFloat(0);
				zpwrukXc.putFloat(0);
				zpwrukXc.putFloat(0);
				zpwrukXc.putFloat(0);
				zpwrukXc.putFloat(0);
				zpwrukXc.putFloat(0);
				kcYayRnh = 0;
				kcYayRnh += new Long(17769).longValue() * new Long(17770).longValue() * new Long(22).longValue();
				kcYayRnh -= new Long((17769 - (ZmUHwJ1m - 1))).longValue()
						* new Long((17770 - (ZmUHwJ1m - 1))).longValue() * new Long(22).longValue();
				ByteBuffer Ya6AbMk8 = TOXQ0qe0.map(FileChannel.MapMode.READ_ONLY, kcYayRnh, (17770 - ZmUHwJ1m) * 44);
				while (Ya6AbMk8.hasRemaining()) {
					Ya6AbMk8.getShort();
					zpwrukXc.putShort(Ya6AbMk8.getShort());
					zpwrukXc.putInt(Ya6AbMk8.getInt());
					zpwrukXc.putFloat(Ya6AbMk8.getFloat());
					zpwrukXc.putFloat(Ya6AbMk8.getFloat());
					zpwrukXc.putFloat(Ya6AbMk8.getFloat());
					zpwrukXc.putFloat(Ya6AbMk8.getFloat());
					zpwrukXc.putFloat(Ya6AbMk8.getFloat());
					zpwrukXc.putFloat(Ya6AbMk8.getFloat());
					zpwrukXc.putFloat(Ya6AbMk8.getFloat());
					zpwrukXc.putFloat(Ya6AbMk8.getFloat());
					zpwrukXc.putFloat(Ya6AbMk8.getFloat());
				}
				zpwrukXc.flip();
				R2AERXL4.write(zpwrukXc);
				zpwrukXc.clear();
				R2AERXL4.close();
			}
			return true;
		} catch (Exception zWN1fcRT) {
			zWN1fcRT.printStackTrace();
			return false;
		}
	}

}