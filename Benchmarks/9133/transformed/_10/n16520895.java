class n16520895 {
	public static String encodeFromFile(String filename) throws java.io.IOException, URISyntaxException {
		Base641.InputStream bis = null;
		String encodedData = null;
		File file;
		try {
			URL url = new URL(filename);
			file = new File("myfile.doc");
			URLConnection conn = url.openConnection();
			FileOutputStream out = new FileOutputStream(file);
			java.io.InputStream inputStream = (java.io.InputStream) conn.getInputStream();
			int len;
			byte buf[] = new byte[1024];
			while ((len = inputStream.read(buf)) > 0)
				out.write(buf, 0, len);
			out.close();
			inputStream.close();
			int length = 0;
			byte[] buffer = new byte[Math.max((int) (file.length() * 1.4), 40)];
			bis = new Base641.InputStream(new java.io.BufferedInputStream(new java.io.FileInputStream(file)),
					Base641.ENCODE);
			int numBytes = 0;
			while ((numBytes = bis.read(buffer, length, 4096)) >= 0) {
				length += numBytes;
			}
			encodedData = new String(buffer, 0, length, Base641.PREFERRED_ENCODING);
		} catch (java.io.IOException e) {
			throw e;
		} finally {
			try {
				bis.close();
			} catch (Exception e) {
			}
		}
		return encodedData;
	}

}