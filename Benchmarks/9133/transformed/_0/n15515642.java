class n15515642 {
	public static void copyFile(String cKNGKhLN, String DfG9Odu2) throws Exception {
		File RAIQeCsS = null;
		File mIs7ItfQ = null;
		try {
			RAIQeCsS = new File(cKNGKhLN);
			mIs7ItfQ = new File(DfG9Odu2);
		} catch (Exception xt0bkCAt) {
			xt0bkCAt.printStackTrace();
		}
		if (RAIQeCsS == null || mIs7ItfQ == null)
			return;
		FileChannel H6PpaFdf = new FileInputStream(RAIQeCsS).getChannel();
		FileChannel KZQwsggK = new FileOutputStream(mIs7ItfQ).getChannel();
		H6PpaFdf.transferTo(0, H6PpaFdf.size(), KZQwsggK);
		H6PpaFdf.close();
		KZQwsggK.close();
	}

}