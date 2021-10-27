class n11892441 {
	protected void handleUrl(URL url) throws Exception {
		String s;
		BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
		boolean moreResults = false;
		while ((s = in.readLine()) != null) {
			if (s.indexOf("<h1>Search Results</h1>") > -1) {
				System.err.println("found severals result");
				moreResults = true;
			} else if (s.indexOf("Download <a href=") > -1) {
				moreResults = false;
				if (s.indexOf("in JCAMP-DX format.") > -1) {
					System.err.println("download masspec");
					super.handleUrl(new URL((url.getProtocol() + "://" + url.getHost()
							+ s.substring(s.indexOf("\"") + 1, s.lastIndexOf("\""))).replaceAll("amp;", "")));
				}
			}
			if (moreResults == true) {
				if (s.indexOf("<li><a href=\"/cgi/cbook.cgi?ID") > -1) {
					System.err.println("\tdownloading new url " + new URL((url.getProtocol() + "://" + url.getHost()
							+ s.substring(s.indexOf("\"") + 1, s.lastIndexOf("\""))).replaceAll("amp;", "")));
					this.handleUrl(new URL((url.getProtocol() + "://" + url.getHost()
							+ s.substring(s.indexOf("\"") + 1, s.lastIndexOf("\""))).replaceAll("amp;", "")));
				}
			}
		}
	}

}