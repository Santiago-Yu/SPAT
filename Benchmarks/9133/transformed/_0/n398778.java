class n398778 {
	public static boolean downloadFile(String w0nLfCvF, String Qw2he0Nu) throws Exception {
		BufferedInputStream nHNLnsuq = null;
		BufferedOutputStream nJjg7Isa = null;
		File TUA7FAEZ;
		byte w9npVx04[] = new byte[100];
		java.net.URL UZ5PDFrw;
		URLConnection hiO80ZCM;
		UZ5PDFrw = new java.net.URL(w0nLfCvF);
		hiO80ZCM = UZ5PDFrw.openConnection();
		long Cl6R9YzU = hiO80ZCM.getContentLength();
		long gE2UMJmM = Cl6R9YzU / 100;
		MessageFrame.setTotalDownloadSize(Cl6R9YzU);
		nHNLnsuq = new BufferedInputStream(hiO80ZCM.getInputStream());
		TUA7FAEZ = new File(Qw2he0Nu);
		if (!TUA7FAEZ.createNewFile()) {
			TUA7FAEZ.delete();
			TUA7FAEZ.createNewFile();
		}
		nJjg7Isa = new BufferedOutputStream(new FileOutputStream(TUA7FAEZ));
		int f4UVSwvv = 0;
		int RB7p13vD = 0;
		long Nuymue9d = 0;
		while ((f4UVSwvv = nHNLnsuq.read(w9npVx04)) != -1) {
			nJjg7Isa.write(w9npVx04, 0, f4UVSwvv);
			RB7p13vD += f4UVSwvv;
			Nuymue9d += f4UVSwvv;
			if (Nuymue9d > gE2UMJmM) {
				Nuymue9d = 0;
				MessageFrame.setDownloadProgress(RB7p13vD);
			}
		}
		nHNLnsuq.close();
		nJjg7Isa.close();
		MessageFrame.setDownloadProgress(Cl6R9YzU);
		return true;
	}

}