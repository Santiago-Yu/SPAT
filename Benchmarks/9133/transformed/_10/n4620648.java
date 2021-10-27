class n4620648 {
	public static void ToHTML(GeoSciML_Mapping mapping, String strTemplate, String strRequest, String lang,
			PrintWriter sortie) throws Exception {
		String level = "info.";
		if (ConnectorServlet.debug)
			level = "debug.";
		String tagFeature = "FIELDS";
		Log log = LogFactory.getLog(level + "fr.brgm.exows.gml2gsml.Gml2Gsml");
		URL url2Request = new URL(strRequest);
		Date dDebut = new Date();
		URLConnection conn = url2Request.openConnection();
		String strLine = null;
		BufferedReader buffin = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		Template template = VelocityCreator.createTemplate("/fr/brgm/exows/gml2gsml/templates/" + strTemplate);
		int nbFeatures = 0;
		while ((strLine = buffin.readLine()) != null) {
			if (strLine.indexOf(tagFeature) != -1) {
				GSMLFeatureGeneric feature = createGSMLFeatureFromGMLFeatureString(mapping, strLine);
				nbFeatures++;
				VelocityContext context = new VelocityContext();
				context.put("feature", feature);
				context.put("lang", lang);
				context.put("vocabularies", new Vocabularies());
				String outputFeatureMember = VelocityCreator.createXMLbyContext(context, template);
				sortie.println(outputFeatureMember);
			}
		}
		buffin.close();
		Date dFin = new Date();
		String output = "GEOSCIML : " + nbFeatures + " features handled - time : "
				+ (dFin.getTime() - dDebut.getTime()) / 1000 + " [" + dDebut + " // " + dFin + "]";
		log.trace(output);
	}

}