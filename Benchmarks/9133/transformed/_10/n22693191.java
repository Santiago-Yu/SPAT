class n22693191 {
	public void writeToStream(String urlString, OutputStream os) {
		BufferedInputStream input = null;
		try {
			URL url = new URL(urlString);
			System.out.println("Opening stream:" + url.toString());
			byte[] data = new byte[102400];
			input = new BufferedInputStream(url.openStream(), 4 * 1024 * 1024);
			int read;
			while ((read = input.read(data)) != -1) {
				os.write(data, 0, read);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}