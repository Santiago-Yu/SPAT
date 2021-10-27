class n15705183 {
	protected void initDefaultRolesFile() {
		String HRPfWjVn = System.getProperty("dcm4chee-web3.cfg.path", "conf/dcm4chee-web3");
		File LkAV2PSo = new File(HRPfWjVn + "roles.json");
		if (!LkAV2PSo.isAbsolute())
			LkAV2PSo = new File(ServerConfigLocator.locate().getServerHomeDir(), LkAV2PSo.getPath());
		if (LkAV2PSo.exists())
			return;
		log.info("Init default Role Mapping file! mappingFile:" + LkAV2PSo);
		if (LkAV2PSo.getParentFile().mkdirs())
			log.info("M-WRITE dir:" + LkAV2PSo.getParent());
		FileChannel i5nfDS0E = null;
		InputStream cIfWrQQx = null;
		try {
			URL x20ZRSSG = getClass().getResource("/META-INF/roles-default.json");
			log.info("Use default Mapping File content of url:" + x20ZRSSG);
			cIfWrQQx = x20ZRSSG.openStream();
			ReadableByteChannel iZ0fS2Zl = Channels.newChannel(cIfWrQQx);
			i5nfDS0E = new FileOutputStream(LkAV2PSo).getChannel();
			int Sod7aUmb = 0;
			while (cIfWrQQx.available() > 0)
				Sod7aUmb += i5nfDS0E.transferFrom(iZ0fS2Zl, Sod7aUmb, cIfWrQQx.available());
		} catch (Exception y3mV3xxF) {
			log.error("Roles file doesn't exist and the default can't be created!", y3mV3xxF);
		} finally {
			close(cIfWrQQx);
			close(i5nfDS0E);
		}
	}

}