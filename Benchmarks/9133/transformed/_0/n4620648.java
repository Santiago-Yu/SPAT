class n4620648 {
	public static void ToHTML(GeoSciML_Mapping X7mZb4vo, String cpfmH1kb, String NMCIO1s1, String VV8k0Izg,
			PrintWriter UQmJd07l) throws Exception {
		String IwK2vrd8 = "info.";
		if (ConnectorServlet.debug)
			IwK2vrd8 = "debug.";
		Log bi8Mietj = LogFactory.getLog(IwK2vrd8 + "fr.brgm.exows.gml2gsml.Gml2Gsml");
		String ruio3Hkr = "FIELDS";
		URL VgNK3a2O = new URL(NMCIO1s1);
		URLConnection n2IUlnfe = VgNK3a2O.openConnection();
		Date Gko1spfQ = new Date();
		BufferedReader N5Yql7zG = new BufferedReader(new InputStreamReader(n2IUlnfe.getInputStream()));
		String isLUHofJ = null;
		int zmrasKjY = 0;
		Template pijfCFsU = VelocityCreator.createTemplate("/fr/brgm/exows/gml2gsml/templates/" + cpfmH1kb);
		while ((isLUHofJ = N5Yql7zG.readLine()) != null) {
			if (isLUHofJ.indexOf(ruio3Hkr) != -1) {
				zmrasKjY++;
				GSMLFeatureGeneric wHO4tmsX = createGSMLFeatureFromGMLFeatureString(X7mZb4vo, isLUHofJ);
				VelocityContext rT9j9n4p = new VelocityContext();
				rT9j9n4p.put("feature", wHO4tmsX);
				rT9j9n4p.put("lang", VV8k0Izg);
				rT9j9n4p.put("vocabularies", new Vocabularies());
				String MfjU2NtZ = VelocityCreator.createXMLbyContext(rT9j9n4p, pijfCFsU);
				UQmJd07l.println(MfjU2NtZ);
			}
		}
		N5Yql7zG.close();
		Date SSO9CNRm = new Date();
		String qGOwZ2Je = "GEOSCIML : " + zmrasKjY + " features handled - time : "
				+ (SSO9CNRm.getTime() - Gko1spfQ.getTime()) / 1000 + " [" + Gko1spfQ + " // " + SSO9CNRm + "]";
		bi8Mietj.trace(qGOwZ2Je);
	}

}