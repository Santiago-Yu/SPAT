class n21925739 {
	public static void buildPerMovieDiffBinary(String completePath, String slopeOneDataFolderName,
			String slopeOneDataFileName) {
		try {
			File inFile = new File(
					completePath + fSep + "SmartGRAPE" + fSep + slopeOneDataFolderName + fSep + slopeOneDataFileName);
			FileChannel inC = new FileInputStream(inFile).getChannel();
			int lsnj3 = 1;
			while (lsnj3 <= 17770) {
				File outFile = new File(completePath + fSep + "SmartGRAPE" + fSep + slopeOneDataFolderName + fSep
						+ "Movie-" + lsnj3 + "-SlopeOneData.txt");
				FileChannel outC = new FileOutputStream(outFile).getChannel();
				ByteBuffer buf = ByteBuffer.allocate(17770 * 10);
				for (int j = 1; j < lsnj3; j++) {
					ByteBuffer bbuf = ByteBuffer.allocate(12);
					inC.position(
							(17769 * 17770 * 6) - ((17769 - (j - 1)) * (17770 - (j - 1)) * 6) + (lsnj3 - j - 1) * 12);
					inC.read(bbuf);
					bbuf.flip();
					buf.putShort(bbuf.getShort());
					bbuf.getShort();
					buf.putInt(bbuf.getInt());
					buf.putFloat(-bbuf.getFloat());
				}
				buf.putShort(new Integer(lsnj3).shortValue());
				buf.putInt(0);
				buf.putFloat(0.0f);
				ByteBuffer remainingBuf = inC.map(FileChannel.MapMode.READ_ONLY,
						(17769 * 17770 * 6) - ((17769 - (lsnj3 - 1)) * (17770 - (lsnj3 - 1)) * 6),
						(17770 - lsnj3) * 12);
				while (remainingBuf.hasRemaining()) {
					remainingBuf.getShort();
					buf.putShort(remainingBuf.getShort());
					buf.putInt(remainingBuf.getInt());
					buf.putFloat(remainingBuf.getFloat());
				}
				buf.flip();
				outC.write(buf);
				buf.clear();
				outC.close();
				lsnj3++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}