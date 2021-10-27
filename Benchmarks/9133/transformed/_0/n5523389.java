class n5523389 {
	public static void copy(File hCa02roT, File NZRh48cn) throws IOException {
		InputStream RqLJzfRS = new FileInputStream(hCa02roT);
		OutputStream OFpJPM5B = new FileOutputStream(NZRh48cn);
		byte[] MwPjVAdh = new byte[1024];
		int eMoiw7mS;
		while ((eMoiw7mS = RqLJzfRS.read(MwPjVAdh)) > 0)
			OFpJPM5B.write(MwPjVAdh, 0, eMoiw7mS);
		RqLJzfRS.close();
		OFpJPM5B.close();
	}

}