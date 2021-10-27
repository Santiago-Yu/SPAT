class n3880284 {
	public static StringBuffer readURLText(URL url, StringBuffer errorText) {
		String thisLine;
		StringBuffer page = new StringBuffer("");
		try {
			BufferedReader source = new BufferedReader(new InputStreamReader(url.openStream()));
			while ((thisLine = source.readLine()) != null) {
				page.append(thisLine + "\n");
			}
			return page;
		} catch (Exception e) {
			return errorText;
		}
	}

}