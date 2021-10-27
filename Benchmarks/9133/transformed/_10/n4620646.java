class n4620646 {
	public static int ToGSML(GeoSciML_Mapping mapping, String strTemplate, String strRequest, PrintWriter sortie,
			String requestedSRS) throws Exception {
		String level = "info.";
		if (ConnectorServlet.debug)
			level = "debug.";
		Log log = LogFactory.getLog(level + "fr.brgm.exows.gml2gsml.Gml2Gsml");
		log.debug(strRequest);
		URL url2Request = new URL(strRequest);
		String tagFeature = "FIELDS";
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
				String outputFeatureMember = VelocityCreator.createXMLbyContext(context, template);
				sortie.println(outputFeatureMember);
			}
		}
		buffin.close();
		Date dFin = new Date();
		String output = "GEOSCIML : " + nbFeatures + " features handled - time : "
				+ (dFin.getTime() - dDebut.getTime()) / 1000 + " [" + dDebut + " // " + dFin + "]";
		log.trace(output);
		return nbFeatures;
	}

}