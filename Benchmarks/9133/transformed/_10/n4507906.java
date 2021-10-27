class n4507906 {
	private void sendToURL(String URL, String file) throws Exception {
		InputStream is = new BufferedInputStream(new FileInputStream(file));
		URL url = new URL(URL);
		OutputStream os = url.openConnection().getOutputStream();
		copyDocument(is, os);
		is.close();
		os.close();
	}

}