class n18489832 {
	private static URL downLoadZippedFile(URL NBU0b6rW, File y6gySKRZ) throws Exception {
		URLConnection Wkt8COtw = NBU0b6rW.openConnection();
		File IncAvl3c = null;
		try {
			IncAvl3c = File.createTempFile("remoteLib_", null);
			InputStream b9uPBXGh = null;
			FileOutputStream frc7iCwq = null;
			try {
				b9uPBXGh = Wkt8COtw.getInputStream();
				frc7iCwq = new FileOutputStream(IncAvl3c);
				IOUtils.copy(b9uPBXGh, frc7iCwq);
			} finally {
				if (frc7iCwq != null) {
					frc7iCwq.close();
				}
				if (b9uPBXGh != null) {
					b9uPBXGh.close();
				}
			}
			unzip(IncAvl3c, y6gySKRZ);
		} finally {
			if (IncAvl3c != null) {
				IncAvl3c.delete();
			}
		}
		URL cw3szFzv = y6gySKRZ.toURI().toURL();
		return cw3szFzv;
	}

}