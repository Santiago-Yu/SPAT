class n14231450 {
	public byte[] download(URL NN4Qvbof, OutputStream skGhRjZ0) throws IOException {
		boolean oOYZkr8X = (skGhRjZ0 == null);
		ByteArrayOutputStream tDgxhST7 = null;
		if (oOYZkr8X) {
			tDgxhST7 = new ByteArrayOutputStream();
		}
		String PFi7yjYS = NN4Qvbof.toExternalForm();
		URLConnection cc3s9G0h = NN4Qvbof.openConnection();
		String ufogQjda = Launcher.getFileName(PFi7yjYS);
		InputStream JVVbtX7y = cc3s9G0h.getInputStream();
		total = NN4Qvbof.openConnection().getContentLength();
		setStatusText(String.format("Downloading %s (%.2fMB)...", ufogQjda, ((float) total / 1024 / 1024)));
		long JThGRZL4 = System.currentTimeMillis();
		int gSWHR3Wp = -1;
		byte[] ouOejXEV = new byte[2048];
		while ((gSWHR3Wp = JVVbtX7y.read(ouOejXEV)) != -1) {
			size += gSWHR3Wp;
			if (oOYZkr8X) {
				tDgxhST7.write(ouOejXEV, 0, gSWHR3Wp);
			} else {
				skGhRjZ0.write(ouOejXEV, 0, gSWHR3Wp);
			}
			long wvB14KUV = System.currentTimeMillis();
			if ((wvB14KUV - JThGRZL4) > 250) {
				setProgress((int) (((float) size / (float) total) * 100));
				JThGRZL4 = wvB14KUV;
			}
		}
		hideProgress();
		if (oOYZkr8X) {
			return tDgxhST7.toByteArray();
		} else {
			return null;
		}
	}

}