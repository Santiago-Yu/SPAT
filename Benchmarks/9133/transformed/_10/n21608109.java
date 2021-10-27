class n21608109 {
	public static boolean loadContentFromURL(String fromURL, String toFile) {
		try {
			File file = new File(toFile);
			URL url = new URL("http://bible-desktop.com/xml" + fromURL);
			URLConnection ucon = url.openConnection();
			InputStream is = ucon.getInputStream();
			ByteArrayBuffer baf = new ByteArrayBuffer(50);
			BufferedInputStream bis = new BufferedInputStream(is);
			int current = 0;
			FileOutputStream fos = new FileOutputStream(file);
			while ((current = bis.read()) != -1) {
				baf.append((byte) current);
			}
			fos.write(baf.toByteArray());
			fos.close();
		} catch (IOException e) {
			Log.e(TAG, e);
			return false;
		}
		return true;
	}

}