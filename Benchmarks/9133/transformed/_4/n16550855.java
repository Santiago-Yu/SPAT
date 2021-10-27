class n16550855 {
	public String readPage(boolean ignoreComments) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
		String inputLine;
		String html = "";
		if (ignoreComments) {
			while ((inputLine = in.readLine()) != null) {
				if (inputLine.length() > 0) {
					html = (inputLine.substring(0, 1).compareTo("#") != 0) ? html + inputLine + "\n" : html;
				}
			}
		} else {
			while ((inputLine = in.readLine()) != null) {
				html = html + inputLine + "\n";
			}
		}
		in.close();
		return html;
	}

}