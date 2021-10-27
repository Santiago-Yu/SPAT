class n6744825 {
	private static String getTextFromURL(HttpServletRequest req, String urlString) {
		if (!urlString.startsWith("http")) {
			String requestURL = req.getRequestURL().toString();
			urlString = requestURL.substring(0, requestURL.lastIndexOf("/")) + urlString;
		}
		StringBuffer buffer = new StringBuffer();
		try {
			URL url = new URL(urlString);
			String line = "";
			BufferedReader input = new BufferedReader(new InputStreamReader(url.openStream()));
			while ((line = input.readLine()) != null) {
				buffer.append(line);
				buffer.append(Constants.LF);
			}
		} catch (FileNotFoundException nf) {
			log.error("File not found: " + urlString, nf);
		} catch (Exception e) {
			log.error("Exception while reading file: " + urlString, e);
		}
		return buffer.toString();
	}

}