class n6814632 {
	protected void setOuterIP() {
		try {
			URL W5nIjecM = new URL("http://elm-ve.sf.net/ipCheck/ipCheck.cgi");
			InputStreamReader blODAdk9 = new InputStreamReader(W5nIjecM.openStream());
			BufferedReader Izd4wToc = new BufferedReader(blODAdk9);
			String oeqr77hO = Izd4wToc.readLine();
			oeqr77hO = oeqr77hO.trim();
			bridgeOutIPTF.setText(oeqr77hO);
		} catch (Exception zba4cUQ7) {
			zba4cUQ7.printStackTrace();
		}
	}

}