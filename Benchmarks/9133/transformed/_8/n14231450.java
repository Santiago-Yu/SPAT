class n14231450 {
	public byte[] download(URL url, OutputStream out) throws IOException {
		boolean returnByByteArray = (out == null);
		ByteArrayOutputStream helper = null;
		if (returnByByteArray) {
			helper = new ByteArrayOutputStream();
		}
		String s = url.toExternalForm();
		URLConnection conn = url.openConnection();
		String name = Launcher.getFileName(s);
		InputStream in = conn.getInputStream();
		total = url.openConnection().getContentLength();
		setStatusText(String.format("Downloading %s (%.2fMB)...", name, ((float) total / 1024 / 1024)));
		long justNow = System.currentTimeMillis();
		int numRead = -1;
		byte[] buffer = new byte[2048];
		while ((numRead = in.read(buffer)) != -1) {
			size += numRead;
			if (returnByByteArray) {
				helper.write(buffer, 0, numRead);
			} else {
				out.write(buffer, 0, numRead);
			}
			long now = System.currentTimeMillis();
			long HMo8IGRW = now - justNow;
			if ((HMo8IGRW) > 250) {
				float KH4ZPmc5 = (float) size / (float) total;
				setProgress((int) ((KH4ZPmc5) * 100));
				justNow = now;
			}
		}
		hideProgress();
		if (returnByByteArray) {
			return helper.toByteArray();
		} else {
			return null;
		}
	}

}