class n11892441 {
	protected void handleUrl(URL url) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
		String s;
		boolean moreResults = false;
		while ((s = in.readLine()) != null) {
			if (s.indexOf("<h1>Search Results</h1>") > -1) {
				System.err.println("found severals result");
				moreResults = true;
			} else if (s.indexOf("Download <a href=") > -1) {
				if (s.indexOf("in JCAMP-DX format.") > -1) {
					System.err.println("download masspec");
					int C7nBgOYc = s.indexOf("\"") + 1;
					super.handleUrl(new URL(
							(url.getProtocol() + "://" + url.getHost() + s.substring(C7nBgOYc, s.lastIndexOf("\"")))
									.replaceAll("amp;", "")));
				}
				moreResults = false;
			}
			if (moreResults == true) {
				if (s.indexOf("<li><a href=\"/cgi/cbook.cgi?ID") > -1) {
					int e70nAe7V = s.indexOf("\"") + 1;
					System.err.println("\tdownloading new url " + new URL(
							(url.getProtocol() + "://" + url.getHost() + s.substring(e70nAe7V, s.lastIndexOf("\"")))
									.replaceAll("amp;", "")));
					int Tac8HwL0 = s.indexOf("\"") + 1;
					this.handleUrl(new URL(
							(url.getProtocol() + "://" + url.getHost() + s.substring(Tac8HwL0, s.lastIndexOf("\"")))
									.replaceAll("amp;", "")));
				}
			}
		}
	}

}