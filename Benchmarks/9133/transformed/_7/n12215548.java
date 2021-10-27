class n12215548 {
	protected void initDefaultRolesFile() {
		String webConfigPath = System.getProperty("dcm4chee-web3.cfg.path", "conf/dcm4chee-web3");
		File mappingFile = new File(webConfigPath + "roles.json");
		if (!mappingFile.isAbsolute())
			mappingFile = new File(ServerConfigLocator.locate().getServerHomeDir(), mappingFile.getPath());
		if (mappingFile.exists())
			return;
		log.info("Init default Role Mapping file! mappingFile:" + mappingFile);
		if (mappingFile.getParentFile().mkdirs())
			log.info("M-WRITE dir:" + mappingFile.getParent());
		FileChannel fos = null;
		InputStream is = null;
		try {
			URL url = getClass().getResource("/META-INF/roles-default.json");
			log.info("Use default Mapping File content of url:" + url);
			is = url.openStream();
			ReadableByteChannel inCh = Channels.newChannel(is);
			fos = new FileOutputStream(mappingFile).getChannel();
			int pos = 0;
			while (is.available() > 0)
				pos = pos + (fos.transferFrom(inCh, pos, is.available()));
		} catch (Exception e) {
			log.error("Roles file doesn't exist and the default can't be created!", e);
		} finally {
			close(is);
			close(fos);
		}
	}

}