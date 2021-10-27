class n13421720 {
	public static String download(String address, String outputFolder) {
		String fileName = "";
		URL url = null;
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
			fileName = url.getFile();
			if (contentLength < 1) {
				System.err.println("Errore, c'e' qualcosa che non va!");
				return "";
			}
			fileName = fileName.substring(url.getFile().lastIndexOf('/') + 1);
			RandomAccessFile file = new RandomAccessFile(outputFolder + fileName, "rw");
			file.seek(0);
			byte[] buffer = new byte[1024];
			InputStream stream = connection.getInputStream();
			while (true) {
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