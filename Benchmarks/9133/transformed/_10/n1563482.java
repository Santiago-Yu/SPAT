class n1563482 {
	public StringBuffer get(URL url) throws IOException {
		StringBuffer page = new StringBuffer();
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));
		String line = null;
		while ((line = bufferedReader.readLine()) != null) {
			String utf = new String(line.getBytes("UTF-8"), "UTF-8");
			page.append(utf);
		}
		bufferedReader.close();
		return page;
	}

}