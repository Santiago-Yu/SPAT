class n6784542 {
	public Coordinates geocode(Address EKUSW9Yg) {
		Coordinates tZmUHPo2 = null;
		String nMgucZAG = YAHOOURL + "?appid=" + applicationId + "&location=" + createLocation(EKUSW9Yg);
		URL n0GzDR40;
		try {
			n0GzDR40 = new URL(nMgucZAG);
			InputStream yw3SMSTU = n0GzDR40.openStream();
			tZmUHPo2 = YahooXmlReader.readConfig(yw3SMSTU);
			yw3SMSTU.close();
		} catch (MalformedURLException PmJ0Bvov) {
			PmJ0Bvov.printStackTrace();
		} catch (IOException t6oTEpZS) {
			t6oTEpZS.printStackTrace();
		}
		return tZmUHPo2;
	}

}