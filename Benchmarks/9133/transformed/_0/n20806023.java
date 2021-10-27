class n20806023 {
	public static void copyFile(File JXDtGRxe, File SJV2Hmbv) throws IOException {
		FileChannel r1EdffAj = new FileInputStream(JXDtGRxe).getChannel();
		FileChannel d69Jtsdy = new FileOutputStream(SJV2Hmbv).getChannel();
		try {
			r1EdffAj.transferTo(0, r1EdffAj.size(), d69Jtsdy);
		} catch (IOException R6TcmI94) {
			throw R6TcmI94;
		} finally {
			if (r1EdffAj != null)
				r1EdffAj.close();
			if (d69Jtsdy != null)
				d69Jtsdy.close();
		}
	}

}