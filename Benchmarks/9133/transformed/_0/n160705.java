class n160705 {
	public static boolean downloadFile(String o64omP3D, String iAqyb6eX) throws Exception {
		BufferedInputStream Elqj8vS8 = null;
		BufferedOutputStream dinxDc0q = null;
		File QI14Zyab;
		byte ZclemOeR[] = new byte[100];
		java.net.URL Yod2iAWV;
		URLConnection z7AH2i2D;
		Yod2iAWV = new java.net.URL(o64omP3D);
		z7AH2i2D = Yod2iAWV.openConnection();
		long NwNLxPrA = z7AH2i2D.getContentLength();
		long hbo8yqQG = NwNLxPrA / 100;
		MessageFrame.setTotalDownloadSize(NwNLxPrA);
		Elqj8vS8 = new BufferedInputStream(z7AH2i2D.getInputStream());
		QI14Zyab = new File(iAqyb6eX);
		if (!QI14Zyab.createNewFile()) {
			QI14Zyab.delete();
			QI14Zyab.createNewFile();
		}
		dinxDc0q = new BufferedOutputStream(new FileOutputStream(QI14Zyab));
		int J7wRWJiW = 0;
		int Zu0ZIdrF = 0;
		long T6ejpfRv = 0;
		while ((J7wRWJiW = Elqj8vS8.read(ZclemOeR)) != -1) {
			dinxDc0q.write(ZclemOeR, 0, J7wRWJiW);
			Zu0ZIdrF += J7wRWJiW;
			T6ejpfRv += J7wRWJiW;
			if (T6ejpfRv > hbo8yqQG) {
				T6ejpfRv = 0;
				MessageFrame.setDownloadProgress(Zu0ZIdrF);
			}
		}
		Elqj8vS8.close();
		dinxDc0q.close();
		MessageFrame.setDownloadProgress(NwNLxPrA);
		return true;
	}

}