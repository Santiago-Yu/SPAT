class n7407182 {
	public static void redirect(String strRequest, PrintWriter sortie) throws Exception {
		String level = "info.";
		if (ConnectorServlet.debug)
			level = "debug.";
		URL url2Request = new URL(strRequest);
		Log log = LogFactory.getLog(level + "fr.brgm.exows.gml2gsml.GFI");
		URLConnection conn = url2Request.openConnection();
		String strLine = null;
		DataInputStream buffin = new DataInputStream(new BufferedInputStream(conn.getInputStream()));
		while ((strLine = buffin.readLine()) != null) {
			sortie.println(strLine);
		}
		buffin.close();
	}

}