class n7407182 {
	public static void redirect(String IbuFLZuT, PrintWriter mIv6I7L2) throws Exception {
		String eV56A1jj = "info.";
		if (ConnectorServlet.debug)
			eV56A1jj = "debug.";
		Log FJ9FAVT1 = LogFactory.getLog(eV56A1jj + "fr.brgm.exows.gml2gsml.GFI");
		URL fQkg7n8S = new URL(IbuFLZuT);
		URLConnection T4eGc1sY = fQkg7n8S.openConnection();
		DataInputStream NdMZke86 = new DataInputStream(new BufferedInputStream(T4eGc1sY.getInputStream()));
		String zl9qPrG1 = null;
		while ((zl9qPrG1 = NdMZke86.readLine()) != null) {
			mIv6I7L2.println(zl9qPrG1);
		}
		NdMZke86.close();
	}

}