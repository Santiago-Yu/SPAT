class n13651921 {
	public static void main(String[] YoUcNpCC) throws IOException {
		XmlPullParserFactory WoHtA5xo;
		try {
			WoHtA5xo = XmlPullParserFactory.newInstance(System.getProperty(XmlPullParserFactory.PROPERTY_NAME), null);
			WoHtA5xo.setNamespaceAware(true);
			DasParser wH4pvgVR = new DasParser(WoHtA5xo);
			URL GTdejYhE = new URL("http://www.ebi.ac.uk/das-srv/uniprot/das/uniprot/features?segment=P05067");
			InputStream zjVTnYnU = GTdejYhE.openStream();
			BufferedReader lXcAYuPT = new BufferedReader(new InputStreamReader(zjVTnYnU));
			String mf504r5J, yLHssVPd = "";
			while ((mf504r5J = lXcAYuPT.readLine()) != null) {
				yLHssVPd += mf504r5J;
			}
			WritebackDocument CnSWsIPo = wH4pvgVR.parse(yLHssVPd);
			System.out.println("FIN" + CnSWsIPo);
		} catch (XmlPullParserException pzEBW8fA) {
			throw new IllegalStateException(
					"Fatal Exception thrown at initialisation.  Cannot initialise the PullParserFactory required to allow generation of the DAS XML.",
					pzEBW8fA);
		}
	}

}