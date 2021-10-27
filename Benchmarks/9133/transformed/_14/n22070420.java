class n22070420 {
	private static String getTemplatePluginsXML(CommandLine commandLine) {
		String urlString = commandLine.getOptionValue(CMD_LINE_PLUGINSXMLTEMPLATE_OPTION);
		URL url = null;
		try {
			url = new URL(urlString);
		} catch (MalformedURLException ex) {
			throw new RuntimeException("Could not convert to URL: '" + urlString + "'", ex);
		}
		String templatePluginsXML = null;
		try {
			InputStream in = null;
			try {
				in = url.openStream();
				templatePluginsXML = IOUtils.toString(in);
			} finally {
				if (in != null) {
					in.close();
				}
			}
		} catch (IOException ex) {
			throw new RuntimeException("Could not load plugins metadata from: " + url.toExternalForm(), ex);
		}
		if (null == templatePluginsXML || 0 == templatePluginsXML.trim().length()) {
			throw new RuntimeException("Template plugins.xml has no content: " + url.toExternalForm());
		}
		System.out.println("Template plugins XML:\t" + url.toExternalForm());
		return templatePluginsXML;
	}

}