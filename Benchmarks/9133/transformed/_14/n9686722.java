class n9686722 {
	public static void initConfigurationV2(String cuttleConfiguration, javax.servlet.ServletContext context,
			List configFileList) throws Exception {
		ConfigureDigester.clearMap();
		List rootList = new ArrayList();
		InputStream is = null;
		if (null == cuttleConfiguration) {
			URL url = CompositePageUtil.class.getResource("/cuttle.xml");
			if (null == url)
				url = CompositePageUtil.class.getClassLoader().getResource("/cuttle.xml");
			is = url.openStream();
		} else {
			is = context.getResourceAsStream(cuttleConfiguration);
		}
		parseConfigV2(rootList, is, context, configFileList);
		if (ConfigureDigester.getXmlCuttleConfiguration() != null
				&& ConfigureDigester.getXmlCuttleConfiguration().getPlugins() != null) {
			for (int i = 0; i < ConfigureDigester.getXmlCuttleConfiguration().getPlugins().size(); i++) {
				XMLPlugin plugin = (XMLPlugin) ConfigureDigester.getXmlCuttleConfiguration().getPlugins().get(i);
				if (plugin.getConfigurePlugable() != null && !plugin.getConfigurePlugable().equals("")) {
					Class pluginable = Class.forName(plugin.getConfigurePlugable());
					ConfigurePlugable pluginableObj = (ConfigurePlugable) pluginable.newInstance();
					pluginableObj.initConfiguration(plugin.getConfigurationPath(), context);
				}
			}
		}
	}

}