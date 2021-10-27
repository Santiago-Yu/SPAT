class n11475527 {
	void addDataFromURL(URL theurl) {
		InputStream in = null;
		String line;
		try {
			in = theurl.openStream();
			BufferedReader data = new BufferedReader(new InputStreamReader(in));
			while ((line = data.readLine()) != null) {
				thetext.append(line + "\n");
			}
		} catch (Exception e) {
			System.out.println(e.toString());
			thetext.append(theurl.toString());
		}
		try {
			in.close();
		} catch (Exception e) {
		}
	}

}