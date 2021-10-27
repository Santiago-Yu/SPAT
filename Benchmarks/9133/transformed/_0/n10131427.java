class n10131427 {
	public static void copyFile(File rLUcUM6h, File Q8RZ3TAw) throws IOException {
		FileChannel vQrHA795 = new FileInputStream(rLUcUM6h).getChannel();
		FileChannel sYnPvLSK = new FileOutputStream(Q8RZ3TAw).getChannel();
		vQrHA795.transferTo(0, vQrHA795.size(), sYnPvLSK);
		vQrHA795.close();
		sYnPvLSK.close();
	}

}