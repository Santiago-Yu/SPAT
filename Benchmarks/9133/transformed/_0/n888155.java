class n888155 {
	public static boolean downloadFile(String OD7BYNTo, String uv99YL1J) throws Exception {
		BufferedInputStream OrYlQXDe = null;
		BufferedOutputStream WeoWM1NT = null;
		File OsCFLAIF;
		byte JBIKEOUw[] = new byte[100];
		java.net.URL awrMFUqX;
		URLConnection Rjyzbc4z;
		awrMFUqX = new java.net.URL(OD7BYNTo);
		Rjyzbc4z = awrMFUqX.openConnection();
		long KCMZKq2b = Rjyzbc4z.getContentLength();
		long PVNVY2vS = KCMZKq2b / 100;
		MessageFrame.setTotalDownloadSize(KCMZKq2b);
		OrYlQXDe = new BufferedInputStream(Rjyzbc4z.getInputStream());
		OsCFLAIF = new File(uv99YL1J);
		if (!OsCFLAIF.createNewFile()) {
			OsCFLAIF.delete();
			OsCFLAIF.createNewFile();
		}
		WeoWM1NT = new BufferedOutputStream(new FileOutputStream(OsCFLAIF));
		int hReHBg4X = 0;
		int Cks64Rud = 0;
		long lVY50hm8 = 0;
		while ((hReHBg4X = OrYlQXDe.read(JBIKEOUw)) != -1) {
			WeoWM1NT.write(JBIKEOUw, 0, hReHBg4X);
			Cks64Rud += hReHBg4X;
			lVY50hm8 += hReHBg4X;
			if (lVY50hm8 > PVNVY2vS) {
				lVY50hm8 = 0;
				MessageFrame.setDownloadProgress(Cks64Rud);
			}
		}
		OrYlQXDe.close();
		WeoWM1NT.close();
		MessageFrame.setDownloadProgress(KCMZKq2b);
		return true;
	}

}