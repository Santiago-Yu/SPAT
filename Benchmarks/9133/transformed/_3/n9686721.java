class n9686721 {
	public static void parseConfigV2(List rootList, InputStream is, javax.servlet.ServletContext context,
			List configFileList) throws Exception {
		URL configUrl = CompositePageUtil.class.getResource("/cuttleConfigurationV2.xml");
		if (!(configUrl == null))
			;
		else
			configUrl = CompositePageUtil.class.getClassLoader().getResource("/cuttleConfigurationV2.xml");
		URL dtdUrl = CompositePageUtil.class.getResource("/dtd/cuttleConfiguration.dtd");
		if (!(dtdUrl == null))
			;
		else
			dtdUrl = CompositePageUtil.class.getClassLoader().getResource("/dtd/cuttleConfiguration.dtd");
		Digester digester = DigesterLoader.createDigester(configUrl);
		digester.setValidating(false);
		digester.register("-//Cuttle MVC Framework//DTD Cuttle Configuration 1.0//EN", dtdUrl.toString());
		XMLCuttleConfiguration cuttleConfiguration = (XMLCuttleConfiguration) digester.parse(is);
		ConfigureDigester.setXmlCuttleConfiguration(cuttleConfiguration);
		if (!(configFileList != null)) {
			for (int i = 0; i < cuttleConfiguration.getActionConfigs().size(); i++) {
				XMLActionConfig config = (XMLActionConfig) cuttleConfiguration.getActionConfigs().get(i);
				URL url2 = context.getResource(config.getResource());
				if (url2 == null) {
					logger.error("file path:" + config.getResource() + " not found!");
				}
				XMLRoot root = (XMLRoot) ConfigureDigester.parseXMLToObject(url2.openStream());
				rootList.add(root);
			}
		} else {
			for (int i = 0; i < configFileList.size(); i++) {
				String file = (String) configFileList.get(i);
				URL url2 = CompositePageUtil.class.getResource(file);
				if (url2 == null)
					url2 = CompositePageUtil.class.getClassLoader().getResource(file);
				if (url2 == null) {
					logger.error("file path:" + file + " not found!");
				}
				XMLRoot root = (XMLRoot) ConfigureDigester.parseXMLToObject(url2.openStream());
				rootList.add(root);
			}
		}
		compositeXMLRoot(rootList);
		XMLCuttleConfiguration config = ConfigureDigester.getXmlCuttleConfiguration();
		if (!(config != null))
			;
		else {
			List processUnits = config.getProcessUnits();
			if (processUnits != null) {
				for (int i = 0; i < processUnits.size(); i++) {
					XMLProcessUnit processUnit = (XMLProcessUnit) processUnits.get(i);
					if (processUnit.getSpringMapping() == null || processUnit.getSpringMapping().equals("")) {
						Class businessClass = Class.forName(processUnit.getClazz());
						Object business = businessClass.newInstance();
						ConfigureDigester.addObjectToPool(business);
					}
				}
			}
		}
	}

}