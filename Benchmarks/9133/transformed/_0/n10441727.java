class n10441727 {
	private void downloadFile(String PBEx9dej, File oufeQ0cG) {
		try {
			System.out.println("Downloading " + PBEx9dej + " to " + oufeQ0cG + "...");
			oufeQ0cG.getParentFile().mkdirs();
			OutputStream fwKYHtVz = new FileOutputStream(oufeQ0cG);
			URLConnection apJaO2Cy = new URL(PBEx9dej).openConnection();
			InputStream tSBPIyNQ = apJaO2Cy.getInputStream();
			int lsZbha1B = apJaO2Cy.getContentLength(), BN7J601Q = 0, Hg1g0QDc;
			byte[] qACRLkko = new byte[32768];
			ProgressMonitor giE4ioTi = new ProgressMonitor(null, "Downloading " + PBEx9dej, "", 0, lsZbha1B);
			giE4ioTi.setMillisToDecideToPopup(100);
			giE4ioTi.setMillisToPopup(500);
			boolean sR7ZaiYu = false;
			while ((Hg1g0QDc = tSBPIyNQ.read(qACRLkko)) > 0 && !(sR7ZaiYu = giE4ioTi.isCanceled())) {
				fwKYHtVz.write(qACRLkko, 0, Hg1g0QDc);
				giE4ioTi.setProgress(BN7J601Q += Hg1g0QDc);
				giE4ioTi.setNote((100 * BN7J601Q / lsZbha1B) + "% finished");
			}
			tSBPIyNQ.close();
			fwKYHtVz.close();
			if (sR7ZaiYu) {
				oufeQ0cG.delete();
				fatalError("Starting canceled", "Downloading canceled. Exiting...");
			}
			giE4ioTi.close();
		} catch (IOException Y7Tle3s9) {
			Y7Tle3s9.printStackTrace();
			oufeQ0cG.delete();
			fatalError("Download Error", "Couldn't download file " + PBEx9dej + ": " + Y7Tle3s9);
		}
	}

}