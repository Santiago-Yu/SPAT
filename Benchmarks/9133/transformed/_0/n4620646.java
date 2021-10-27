class n4620646 {
	public static int ToGSML(GeoSciML_Mapping MnknZ5Os, String M3sfpVBa, String s35hs9D7, PrintWriter pr9RhpFX,
			String IVNqVfYb) throws Exception {
		String mcm77BBN = "info.";
		if (ConnectorServlet.debug)
			mcm77BBN = "debug.";
		Log VepYWbL5 = LogFactory.getLog(mcm77BBN + "fr.brgm.exows.gml2gsml.Gml2Gsml");
		VepYWbL5.debug(s35hs9D7);
		String dsniFd4P = "FIELDS";
		URL Yg0cir2K = new URL(s35hs9D7);
		URLConnection BTzRFege = Yg0cir2K.openConnection();
		Date BOEkHsdX = new Date();
		BufferedReader ImqNJwMj = new BufferedReader(new InputStreamReader(BTzRFege.getInputStream()));
		String mm54vJf1 = null;
		int QNDnS5ja = 0;
		Template f6DoBp0z = VelocityCreator.createTemplate("/fr/brgm/exows/gml2gsml/templates/" + M3sfpVBa);
		while ((mm54vJf1 = ImqNJwMj.readLine()) != null) {
			if (mm54vJf1.indexOf(dsniFd4P) != -1) {
				QNDnS5ja++;
				GSMLFeatureGeneric LP7D88wO = createGSMLFeatureFromGMLFeatureString(MnknZ5Os, mm54vJf1);
				VelocityContext n6AkqmZO = new VelocityContext();
				n6AkqmZO.put("feature", LP7D88wO);
				String Pl1FVZzz = VelocityCreator.createXMLbyContext(n6AkqmZO, f6DoBp0z);
				pr9RhpFX.println(Pl1FVZzz);
			}
		}
		ImqNJwMj.close();
		Date g8O2lVCj = new Date();
		String XyxYDGa9 = "GEOSCIML : " + QNDnS5ja + " features handled - time : "
				+ (g8O2lVCj.getTime() - BOEkHsdX.getTime()) / 1000 + " [" + BOEkHsdX + " // " + g8O2lVCj + "]";
		VepYWbL5.trace(XyxYDGa9);
		return QNDnS5ja;
	}

}