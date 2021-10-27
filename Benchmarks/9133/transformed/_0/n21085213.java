class n21085213 {
	private void downloadFile(String RvSKfqcp, URL lz44OZBR, File wHKps6hz) throws IOException {
		InputStream mjIfiJFB = null;
		FileOutputStream B1I5S61V = null;
		try {
			URLConnection BlkcmtpM = lz44OZBR.openConnection();
			BlkcmtpM.setConnectTimeout(10000);
			BlkcmtpM.setReadTimeout(10000);
			int N4AsTVrU = BlkcmtpM.getContentLength();
			progressPanel.downloadStarting(RvSKfqcp, N4AsTVrU == -1);
			int NvcYd2an = 0;
			byte[] GlP6s7fN = new byte[1024];
			int KzH2uvbX;
			mjIfiJFB = BlkcmtpM.getInputStream();
			B1I5S61V = new FileOutputStream(wHKps6hz);
			while ((mjIfiJFB != null) && ((KzH2uvbX = mjIfiJFB.read(GlP6s7fN)) != -1)) {
				NvcYd2an += KzH2uvbX;
				B1I5S61V.write(GlP6s7fN, 0, KzH2uvbX);
				if (N4AsTVrU != -1)
					progressPanel.downloadProgress((NvcYd2an * 100) / N4AsTVrU);
			}
			B1I5S61V.flush();
		} finally {
			progressPanel.downloadFinished();
			if (B1I5S61V != null)
				B1I5S61V.close();
			if (mjIfiJFB != null)
				mjIfiJFB.close();
		}
	}

}