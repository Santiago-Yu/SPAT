class n15660054 {
	public static List<PluginInfo> getPluginInfos(String mbzOPQSn) throws MalformedURLException, IOException {
		XStream OBExsSSw = new XStream();
		OBExsSSw.alias("plugin", PluginInfo.class);
		OBExsSSw.alias("plugins", List.class);
		List<PluginInfo> YesT5E5f = null;
		URL kS1jrVMb;
		BufferedReader NufUC9AL = null;
		StringBuilder OeI3oW4J = new StringBuilder();
		try {
			kS1jrVMb = new URL(mbzOPQSn);
			NufUC9AL = new BufferedReader(new InputStreamReader(kS1jrVMb.openStream()));
			String y0Oj5SmN;
			while ((y0Oj5SmN = NufUC9AL.readLine()) != null) {
				OeI3oW4J.append(y0Oj5SmN);
			}
		} finally {
			try {
				if (NufUC9AL != null) {
					NufUC9AL.close();
				}
			} catch (IOException g4qksuXb) {
				Logger.getLogger(RemotePluginsManager.class.getName()).log(Level.SEVERE, null, g4qksuXb);
			}
		}
		YesT5E5f = (List<PluginInfo>) OBExsSSw.fromXML(OeI3oW4J.toString());
		return YesT5E5f;
	}

}