class n13741605 {
	public static boolean copy(String source, String dest) {
		byte array[] = new byte[BUFFER_LEN];
		int bytes;
		try {
			OutputStream os = new FileOutputStream(dest);
			InputStream is = new FileInputStream(source);
			while ((bytes = is.read(array, 0, BUFFER_LEN)) > 0)
				os.write(array, 0, bytes);
			is.close();
			os.close();
			return true;
		} catch (IOException e) {
			return false;
		}
	}

}