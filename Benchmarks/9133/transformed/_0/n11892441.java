class n11892441 {
	protected void handleUrl(URL jX1gGTlA) throws Exception {
		BufferedReader qWOGUIwX = new BufferedReader(new InputStreamReader(jX1gGTlA.openStream()));
		String ShTSr8EW;
		boolean fwZuFEQo = false;
		while ((ShTSr8EW = qWOGUIwX.readLine()) != null) {
			if (ShTSr8EW.indexOf("<h1>Search Results</h1>") > -1) {
				System.err.println("found severals result");
				fwZuFEQo = true;
			} else if (ShTSr8EW.indexOf("Download <a href=") > -1) {
				if (ShTSr8EW.indexOf("in JCAMP-DX format.") > -1) {
					System.err.println("download masspec");
					super.handleUrl(new URL((jX1gGTlA.getProtocol() + "://" + jX1gGTlA.getHost()
							+ ShTSr8EW.substring(ShTSr8EW.indexOf("\"") + 1, ShTSr8EW.lastIndexOf("\"")))
									.replaceAll("amp;", "")));
				}
				fwZuFEQo = false;
			}
			if (fwZuFEQo == true) {
				if (ShTSr8EW.indexOf("<li><a href=\"/cgi/cbook.cgi?ID") > -1) {
					System.err.println(
							"\tdownloading new url " + new URL((jX1gGTlA.getProtocol() + "://" + jX1gGTlA.getHost()
									+ ShTSr8EW.substring(ShTSr8EW.indexOf("\"") + 1, ShTSr8EW.lastIndexOf("\"")))
											.replaceAll("amp;", "")));
					this.handleUrl(new URL((jX1gGTlA.getProtocol() + "://" + jX1gGTlA.getHost()
							+ ShTSr8EW.substring(ShTSr8EW.indexOf("\"") + 1, ShTSr8EW.lastIndexOf("\"")))
									.replaceAll("amp;", "")));
				}
			}
		}
	}

}