class n21925739 {
	public static void buildPerMovieDiffBinary(String y155f9Vi, String I5BA3fgW, String vWpeg6kt) {
		try {
			File cqvVw9T0 = new File(y155f9Vi + fSep + "SmartGRAPE" + fSep + I5BA3fgW + fSep + vWpeg6kt);
			FileChannel VbStYayr = new FileInputStream(cqvVw9T0).getChannel();
			for (int pfS2jY6p = 1; pfS2jY6p <= 17770; pfS2jY6p++) {
				File lqVsSkJJ = new File(y155f9Vi + fSep + "SmartGRAPE" + fSep + I5BA3fgW + fSep + "Movie-" + pfS2jY6p
						+ "-SlopeOneData.txt");
				FileChannel nBpVi6jg = new FileOutputStream(lqVsSkJJ).getChannel();
				ByteBuffer l7RJ73vz = ByteBuffer.allocate(17770 * 10);
				for (int MDpaozSt = 1; MDpaozSt < pfS2jY6p; MDpaozSt++) {
					ByteBuffer mOKJqyme = ByteBuffer.allocate(12);
					VbStYayr.position((17769 * 17770 * 6) - ((17769 - (MDpaozSt - 1)) * (17770 - (MDpaozSt - 1)) * 6)
							+ (pfS2jY6p - MDpaozSt - 1) * 12);
					VbStYayr.read(mOKJqyme);
					mOKJqyme.flip();
					l7RJ73vz.putShort(mOKJqyme.getShort());
					mOKJqyme.getShort();
					l7RJ73vz.putInt(mOKJqyme.getInt());
					l7RJ73vz.putFloat(-mOKJqyme.getFloat());
				}
				l7RJ73vz.putShort(new Integer(pfS2jY6p).shortValue());
				l7RJ73vz.putInt(0);
				l7RJ73vz.putFloat(0.0f);
				ByteBuffer AxCK26O4 = VbStYayr.map(FileChannel.MapMode.READ_ONLY,
						(17769 * 17770 * 6) - ((17769 - (pfS2jY6p - 1)) * (17770 - (pfS2jY6p - 1)) * 6),
						(17770 - pfS2jY6p) * 12);
				while (AxCK26O4.hasRemaining()) {
					AxCK26O4.getShort();
					l7RJ73vz.putShort(AxCK26O4.getShort());
					l7RJ73vz.putInt(AxCK26O4.getInt());
					l7RJ73vz.putFloat(AxCK26O4.getFloat());
				}
				l7RJ73vz.flip();
				nBpVi6jg.write(l7RJ73vz);
				l7RJ73vz.clear();
				nBpVi6jg.close();
			}
		} catch (Exception iQGOxwoW) {
			iQGOxwoW.printStackTrace();
		}
	}

}