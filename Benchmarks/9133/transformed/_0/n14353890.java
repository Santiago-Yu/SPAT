class n14353890 {
	private void getXMLData() {
		String gXnie8NR = null;
		URL wgyx2h3j = null;
		URLConnection PGl9HodW = null;
		BufferedReader yq1M9dH5 = null;
		StringBuffer gvRIVBjQ = new StringBuffer();
		String WpX5F0zI;
		try {
			wgyx2h3j = new URL(this.url);
			PGl9HodW = wgyx2h3j.openConnection();
			yq1M9dH5 = new BufferedReader(new InputStreamReader(PGl9HodW.getInputStream()));
			while ((WpX5F0zI = yq1M9dH5.readLine()) != null) {
				gvRIVBjQ.append(WpX5F0zI + "\n");
			}
			yq1M9dH5.close();
			gXnie8NR = gvRIVBjQ.toString();
		} catch (MalformedURLException bpeuaoSd) {
			log.error("URL was malformed: {}", wgyx2h3j, bpeuaoSd);
		} catch (IOException UnR52LBM) {
			log.error("IOException thrown: {}", wgyx2h3j, UnR52LBM);
		}
		this.xmlString = gXnie8NR;
	}

}