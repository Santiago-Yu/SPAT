class n12215548 {
	protected void initDefaultRolesFile() {
		String lVLC5ETi = System.getProperty("dcm4chee-web3.cfg.path", "conf/dcm4chee-web3");
		File YvvIvfYL = new File(lVLC5ETi + "roles.json");
		if (!YvvIvfYL.isAbsolute())
			YvvIvfYL = new File(ServerConfigLocator.locate().getServerHomeDir(), YvvIvfYL.getPath());
		if (YvvIvfYL.exists())
			return;
		log.info("Init default Role Mapping file! mappingFile:" + YvvIvfYL);
		if (YvvIvfYL.getParentFile().mkdirs())
			log.info("M-WRITE dir:" + YvvIvfYL.getParent());
		FileChannel siclOMxd = null;
		InputStream t7R5EF1g = null;
		try {
			URL BsBRD9zK = getClass().getResource("/META-INF/roles-default.json");
			log.info("Use default Mapping File content of url:" + BsBRD9zK);
			t7R5EF1g = BsBRD9zK.openStream();
			ReadableByteChannel EZD6zsJM = Channels.newChannel(t7R5EF1g);
			siclOMxd = new FileOutputStream(YvvIvfYL).getChannel();
			int DfQmv4V9 = 0;
			while (t7R5EF1g.available() > 0)
				DfQmv4V9 += siclOMxd.transferFrom(EZD6zsJM, DfQmv4V9, t7R5EF1g.available());
		} catch (Exception gVnsYN3n) {
			log.error("Roles file doesn't exist and the default can't be created!", gVnsYN3n);
		} finally {
			close(t7R5EF1g);
			close(siclOMxd);
		}
	}

}