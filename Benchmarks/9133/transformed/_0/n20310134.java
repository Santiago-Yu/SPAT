class n20310134 {
	public static void copyFile(File Hmg4jLUZ, File oK7F1jmJ) throws IOException {
		FileChannel qiw0oUW6 = new FileInputStream(Hmg4jLUZ).getChannel();
		FileChannel b2DdcOZA = new FileOutputStream(oK7F1jmJ).getChannel();
		try {
			qiw0oUW6.transferTo(0, qiw0oUW6.size(), b2DdcOZA);
		} catch (IOException pMqQNm8F) {
			throw pMqQNm8F;
		} finally {
			if (qiw0oUW6 != null)
				qiw0oUW6.close();
			if (b2DdcOZA != null)
				b2DdcOZA.close();
		}
	}

}