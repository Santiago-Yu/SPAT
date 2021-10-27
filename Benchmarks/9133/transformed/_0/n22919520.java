class n22919520 {
	public static void copyFile(String kr66qER7, String umAF3A3j) throws IOException {
		FileChannel uhLkoWFc = null;
		FileChannel HbefMLTn = null;
		try {
			uhLkoWFc = new FileInputStream(kr66qER7).getChannel();
			HbefMLTn = new FileOutputStream(umAF3A3j).getChannel();
			long Q4ghlJV3 = uhLkoWFc.size();
			uhLkoWFc.transferTo(0, Q4ghlJV3, HbefMLTn);
			MappedByteBuffer JQQaZwbE = uhLkoWFc.map(FileChannel.MapMode.READ_ONLY, 0, Q4ghlJV3);
			HbefMLTn.write(JQQaZwbE);
		} finally {
			if (uhLkoWFc != null)
				uhLkoWFc.close();
			if (HbefMLTn != null)
				HbefMLTn.close();
		}
	}

}