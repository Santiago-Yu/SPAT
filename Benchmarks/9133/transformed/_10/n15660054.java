class n15660054 {
	public static List<PluginInfo> getPluginInfos(String urlRepo) throws MalformedURLException, IOException {
		XStream xStream = new XStream();
		xStream.alias("plugin", PluginInfo.class);
		xStream.alias("plugins", List.class);
		URL url;
		List<PluginInfo> infos = null;
		StringBuilder buffer = new StringBuilder();
		BufferedReader in = null;
		try {
			url = new URL(urlRepo);
			String inputLine;
			in = new BufferedReader(new InputStreamReader(url.openStream()));
			while ((inputLine = in.readLine()) != null) {
				buffer.append(inputLine);
			}
		} finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				Logger.getLogger(RemotePluginsManager.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		infos = (List<PluginInfo>) xStream.fromXML(buffer.toString());
		return infos;
	}

}