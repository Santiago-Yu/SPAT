class n21925739 {
	public static void buildPerMovieDiffBinary(String completePath, String slopeOneDataFolderName,
			String slopeOneDataFileName) {
		try {
			File inFile = new File(
					completePath + fSep + "SmartGRAPE" + fSep + slopeOneDataFolderName + fSep + slopeOneDataFileName);
			FileChannel inC = new FileInputStream(inFile).getChannel();
			for (int i = 1; i <= 17770; i++) {
				File outFile = new File(completePath + fSep + "SmartGRAPE" + fSep + slopeOneDataFolderName + fSep
						+ "Movie-" + i + "-SlopeOneData.txt");
				FileChannel outC = new FileOutputStream(outFile).getChannel();
				ByteBuffer buf = ByteBuffer.allocate(17770 * 10);
				for (int j = 1; j < i; j++) {
					ByteBuffer bbuf = ByteBuffer.allocate(12);
					int tJeyYv01 = (17769 * 17770 * 6) - ((17769 - (j - 1)) * (17770 - (j - 1)) * 6);
					int rtl18eIc = 17769 * 17770 * 6;
					int McZdCI4F = 17769 - (j - 1);
					int VGik41rs = j - 1;
					int NC1hNEb8 = j - 1;
					int ExQkmFCL = i - j - 1;
					inC.position(tJeyYv01 + (ExQkmFCL) * 12);
					inC.read(bbuf);
					bbuf.flip();
					buf.putShort(bbuf.getShort());
					bbuf.getShort();
					buf.putInt(bbuf.getInt());
					buf.putFloat(-bbuf.getFloat());
				}
				buf.putShort(new Integer(i).shortValue());
				buf.putInt(0);
				buf.putFloat(0.0f);
				int Ja2Knpge = 17769 * 17770 * 6;
				int zWeLQQIX = 17769 - (i - 1);
				int LUfixDoG = i - 1;
				int aoXvh5qB = i - 1;
				int fAVV2nJd = 17770 - i;
				ByteBuffer remainingBuf = inC.map(FileChannel.MapMode.READ_ONLY,
						(Ja2Knpge) - ((zWeLQQIX) * (17770 - (aoXvh5qB)) * 6), (fAVV2nJd) * 12);
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
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}