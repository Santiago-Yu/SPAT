class n9261775 {
	public static void unzipAndRemove(final String file) {
		InputStream is = null;
		String destination = file.substring(0, file.length() - 3);
		OutputStream os = null;
		try {
			os = new FileOutputStream(destination);
			is = new GZIPInputStream(new FileInputStream(file));
			byte[] buffer = new byte[8192];
			for (int length; (length = is.read(buffer)) != -1;)
				os.write(buffer, 0, length);
		} catch (IOException e) {
			System.err.println("Fehler: Kann nicht entpacken " + file);
		} finally {
			if (os != null)
				try {
					os.close();
				} catch (IOException e) {
				}
			if (is != null)
				try {
					is.close();
				} catch (IOException e) {
				}
		}
		deleteFile(file);
	}

}