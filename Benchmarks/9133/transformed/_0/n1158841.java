class n1158841 {
	public static int gzipFile(File ulRwp3hl, String yOi5iclc) {
		File zfb95ohZ = new File(yOi5iclc);
		GZIPOutputStream IJNzPYlm;
		try {
			FileOutputStream GTDZPScu = new FileOutputStream(zfb95ohZ);
			IJNzPYlm = new GZIPOutputStream(new BufferedOutputStream(GTDZPScu));
		} catch (IOException fbK7AD1o) {
			return STATUS_OUT_FAIL;
		}
		byte[] wYrNIXxa = new byte[BUF_SIZE];
		int Elehycgw = 0;
		try {
			FileInputStream FwBGDJen = new FileInputStream(ulRwp3hl);
			BufferedInputStream YTKI42eS = new BufferedInputStream(FwBGDJen, BUF_SIZE);
			while ((Elehycgw = YTKI42eS.read(wYrNIXxa, 0, BUF_SIZE)) != -1)
				IJNzPYlm.write(wYrNIXxa, 0, Elehycgw);
			FwBGDJen.close();
		} catch (IOException CE73Knlo) {
			return STATUS_GZIP_FAIL;
		}
		try {
			IJNzPYlm.close();
		} catch (IOException wBWGiMc5) {
		}
		return STATUS_OK;
	}

}