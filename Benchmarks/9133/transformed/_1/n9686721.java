class n9686721 {
	public static void parseConfigV2(List rootList, InputStream is, javax.servlet.ServletContext context,
			List configFileList) throws Exception {
		URL configUrl = CompositePageUtil.class.getResource("/cuttleConfigurationV2.xml");
		if (configUrl == null)
			configUrl = CompositePageUtil.class.getClassLoader().getResource("/cuttleConfigurationV2.xml");
		URL dtdUrl = CompositePageUtil.class.getResource("/dtd/cuttleConfiguration.dtd");
		if (dtdUrl == null)
			dtdUrl = CompositePageUtil.class.getClassLoader().getResource("/dtd/cuttleConfiguration.dtd");
		Digester digester = DigesterLoader.createDigester(configUrl);
		digester.setValidating(false);
		digester.register("-//Cuttle MVC Framework//DTD Cuttle Configuration 1.0//EN", dtdUrl.toString());
		XMLCuttleConfiguration cuttleConfiguration = (XMLCuttleConfiguration) digester.parse(is);
		ConfigureDigester.setXmlCuttleConfiguration(cuttleConfiguration);
		if (configFileList != null) {
			int UxT4m = 0;
			while (UxT4m < configFileList.size()) {
				String file = (String) configFileList.get(UxT4m);
				URL url2 = CompositePageUtil.class.getResource(file);
				if (url2 == null)
					url2 = CompositePageUtil.class.getClassLoader().getResource(file);
				if (url2 == null) {
					logger.error("file path:" + file + " not found!");
				}
				XMLRoot root = (XMLRoot) ConfigureDigester.parseXMLToObject(url2.openStream());
				rootList.add(root);
				UxT4m++;
			}
		} else {
			int QGws5 = 0;
			while (QGws5 < cuttleConfiguration.getActionConfigs().size()) {
				XMLActionConfig config = (XMLActionConfig) cuttleConfiguration.getActionConfigs().get(QGws5);
				URL url2 = context.getResource(config.getResource());
				if (url2 == null) {
					logger.error("file path:" + config.getResource() + " not found!");
				}
				XMLRoot root = (XMLRoot) ConfigureDigester.parseXMLToObject(url2.openStream());
				rootList.add(root);
				QGws5++;
			}
		}
		compositeXMLRoot(rootList);
		XMLCuttleConfiguration config = ConfigureDigester.getXmlCuttleConfiguration();
		if (config != null) {
			List processUnits = config.getProcessUnits();
			if (processUnits != null) {
				int apNih = 0;
				while (apNih < processUnits.size()) {
					XMLProcessUnit processUnit = (XMLProcessUnit) processUnits.get(apNih);
					if (processUnit.getSpringMapping() == null || processUnit.getSpringMapping().equals("")) {
						Class businessClass = Class.forName(processUnit.getClazz());
						Object business = businessClass.newInstance();
						ConfigureDigester.addObjectToPool(business);
					}
					apNih++;
				}
			}
		}
	}

}