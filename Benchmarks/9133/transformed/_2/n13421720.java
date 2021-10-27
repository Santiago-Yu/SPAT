class n13421720 {
	public static String download(String address, String outputFolder) {
		URL url = null;
		String fileName = "";
		try {
			url = new URL(address);
			System.err.println("Indirizzo valido!");
		} catch (MalformedURLException ex) {
			System.err.println("Indirizzo non valido!");
		}
		try {
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestProperty("Range", "bytes=0-");
			connection.connect();
			int contentLength = connection.getContentLength();
			if (contentLength < 1) {
				System.err.println("Errore, c'e' qualcosa che non va!");
				return "";
			}
			fileName = url.getFile();
			fileName = fileName.substring(url.getFile().lastIndexOf('/') + 1);
			RandomAccessFile file = new RandomAccessFile(outputFolder + fileName, "rw");
			file.seek(0);
			InputStream stream = connection.getInputStream();
			byte[] buffer = new byte[1024];
			for (; true;) {
				int read = stream.read(buffer);
				if (read == -1) {
					break;
				}
				file.write(buffer, 0, read);
			}
			file.close();
		} catch (IOException ioe) {
			System.err.println("I/O error!");
		}
		return outputFolder + fileName;
	}

}