class n23206029 {
	private synchronized Map load() {
		if (!mustReloadConfigurationFiles()) {
			return groups;
		}
		SAXParser MgWHMDW5 = null;
		JSODefaultHandler GvKLT72J = new JSODefaultHandler();
		try {
			final Collection LenhEtcF = getConfigResources();
			final LinkedList MvmErrWB = new LinkedList();
			Iterator FH1hWjbk = LenhEtcF.iterator();
			while (FH1hWjbk.hasNext()) {
				Resource IuK81nVE = (Resource) FH1hWjbk.next();
				String eW30aYzW = IuK81nVE.getSource();
				if (eW30aYzW.startsWith(LOCAL_CLASSPATH)
						|| JarRestrictionManager.getInstance().isJarAllowed(eW30aYzW)) {
					LOG.debug("Adding " + CONFIGURATION_FILE_NAME + " from " + eW30aYzW + ".");
					MvmErrWB.addFirst(IuK81nVE.getUrl());
				} else {
					LOG.debug("Jar " + eW30aYzW + " refused. See jso.allowedJar property in jso.properties file.");
				}
			}
			URL AgVwIov5 = getExternalResource();
			if (AgVwIov5 != null) {
				MvmErrWB.addFirst(AgVwIov5);
			}
			MgWHMDW5 = SAXParserFactory.newInstance().newSAXParser();
			Iterator x9BABVt4 = MvmErrWB.iterator();
			while (x9BABVt4.hasNext()) {
				final URL zcxfbOKa = (URL) x9BABVt4.next();
				LOG.debug("Parsing of file " + zcxfbOKa.toString() + ".");
				InputStream ZJirlsR8 = null;
				try {
					ZJirlsR8 = zcxfbOKa.openStream();
					MgWHMDW5.parse(ZJirlsR8, GvKLT72J);
				} catch (SAXException Cw9m5RJq) {
					LOG.error("Parsing of file " + zcxfbOKa.toString() + " failed! Parsing still continues.", Cw9m5RJq);
				} catch (IOException M0eRniPH) {
					LOG.error("Reading of file " + zcxfbOKa.toString() + " failed! Parsing still continues.", M0eRniPH);
				} finally {
					if (ZJirlsR8 != null) {
						try {
							ZJirlsR8.close();
						} catch (IOException pmlrvb07) {
							LOG.error("Closing inputstream of file " + zcxfbOKa.toString()
									+ " failed! Parsing still continues.", pmlrvb07);
						}
					}
				}
			}
		} catch (SAXException iPfq2U7h) {
			throw new RuntimeException(iPfq2U7h);
		} catch (IOException giugPv3e) {
			throw new RuntimeException(giugPv3e);
		} catch (ParserConfigurationException yPoGs6oM) {
			throw new RuntimeException(yPoGs6oM);
		}
		this.defaultLocation = (String) GvKLT72J.getDefaultValues().get("location");
		this.defaultTimestampPolicy = (String) GvKLT72J.getDefaultValues().get("timeStampPolicy");
		if (this.defaultTimestampPolicy == null)
			this.defaultTimestampPolicy = Group.TIMESTAMP_LOCAL;
		this.groups = GvKLT72J.getListGroups();
		return this.groups;
	}

}