class n14129929 {
	public static void copy(String FWxGCUla, String GMIaifgX) throws IOException {
		FileChannel fHzCR5Ak = new FileInputStream(FWxGCUla).getChannel();
		FileChannel HpYgY04L = new FileOutputStream(GMIaifgX).getChannel();
		HpYgY04L.transferFrom(fHzCR5Ak, 0, fHzCR5Ak.size());
		fHzCR5Ak.close();
		HpYgY04L.close();
	}

}