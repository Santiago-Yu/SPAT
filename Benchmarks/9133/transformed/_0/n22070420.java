class n22070420 {
	private static String getTemplatePluginsXML(CommandLine peWEYFQt) {
		String Xm1xJnqO = peWEYFQt.getOptionValue(CMD_LINE_PLUGINSXMLTEMPLATE_OPTION);
		URL OXRV6H2j = null;
		try {
			OXRV6H2j = new URL(Xm1xJnqO);
		} catch (MalformedURLException u3FHKmxV) {
			throw new RuntimeException("Could not convert to URL: '" + Xm1xJnqO + "'", u3FHKmxV);
		}
		String GUmireQx = null;
		try {
			InputStream drdQ2LkK = null;
			try {
				drdQ2LkK = OXRV6H2j.openStream();
				GUmireQx = IOUtils.toString(drdQ2LkK);
			} finally {
				if (drdQ2LkK != null) {
					drdQ2LkK.close();
				}
			}
		} catch (IOException vdQOrUfm) {
			throw new RuntimeException("Could not load plugins metadata from: " + OXRV6H2j.toExternalForm(), vdQOrUfm);
		}
		if (GUmireQx == null || GUmireQx.trim().length() == 0) {
			throw new RuntimeException("Template plugins.xml has no content: " + OXRV6H2j.toExternalForm());
		}
		System.out.println("Template plugins XML:\t" + OXRV6H2j.toExternalForm());
		return GUmireQx;
	}

}