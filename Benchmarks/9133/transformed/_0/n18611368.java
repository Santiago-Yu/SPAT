class n18611368 {
	private static void downloadFile(URL b3Jf77MZ, File sXr7JU9R) throws Exception {
		try {
			URLConnection R1zaGYzT = b3Jf77MZ.openConnection();
			File ciFsg4Mp = null;
			try {
				ciFsg4Mp = File.createTempFile("remoteLib_", null);
				InputStream KCVnQTHr = null;
				FileOutputStream dukmX7BG = null;
				try {
					KCVnQTHr = R1zaGYzT.getInputStream();
					dukmX7BG = new FileOutputStream(ciFsg4Mp);
					IOUtils.copy(KCVnQTHr, dukmX7BG);
				} finally {
					if (dukmX7BG != null) {
						dukmX7BG.close();
					}
					if (KCVnQTHr != null) {
						KCVnQTHr.close();
					}
				}
				FileUtils.copyFile(ciFsg4Mp, sXr7JU9R);
			} finally {
				if (ciFsg4Mp != null) {
					ciFsg4Mp.delete();
				}
			}
		} catch (Exception W5LZEfUq) {
			throw new RuntimeException("Could not download URL: " + b3Jf77MZ, W5LZEfUq);
		}
	}

}