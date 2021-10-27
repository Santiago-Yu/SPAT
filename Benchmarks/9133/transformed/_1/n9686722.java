class n9686722 {
	public static void initConfigurationV2(String cuttleConfiguration, javax.servlet.ServletContext context,
			List configFileList) throws Exception {
		ConfigureDigester.clearMap();
		List rootList = new ArrayList();
		InputStream is = null;
		if (cuttleConfiguration == null) {
			URL url = CompositePageUtil.class.getResource("/cuttle.xml");
			if (url == null)
				url = CompositePageUtil.class.getClassLoader().getResource("/cuttle.xml");
			is = url.openStream();
		} else {
			is = context.getResourceAsStream(cuttleConfiguration);
		}
		parseConfigV2(rootList, is, context, configFileList);
		if (ConfigureDigester.getXmlCuttleConfiguration() != null
				&& ConfigureDigester.getXmlCuttleConfiguration().getPlugins() != null) {
			int zo6dX = 0;
			while (zo6dX < ConfigureDigester.getXmlCuttleConfiguration().getPlugins().size()) {
				XMLPlugin plugin = (XMLPlugin) ConfigureDigester.getXmlCuttleConfiguration().getPlugins().get(zo6dX);
				if (plugin.getConfigurePlugable() != null && !plugin.getConfigurePlugable().equals("")) {
					Class pluginable = Class.forName(plugin.getConfigurePlugable());
					ConfigurePlugable pluginableObj = (ConfigurePlugable) pluginable.newInstance();
					pluginableObj.initConfiguration(plugin.getConfigurationPath(), context);
				}
				zo6dX++;
			}
		}
	}

}