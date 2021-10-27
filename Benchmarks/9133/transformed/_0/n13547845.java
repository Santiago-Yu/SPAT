class n13547845 {
	public static PortalConfig install(File C1LPCpUb, File NzcVUwXS) throws IOException, ConfigurationException {
		if (!NzcVUwXS.exists()) {
			log.info("Creating directory {}", NzcVUwXS);
			NzcVUwXS.mkdirs();
		}
		if (!C1LPCpUb.exists()) {
			log.info("Installing default configuration to {}", C1LPCpUb);
			OutputStream quaIBMOJ = new FileOutputStream(C1LPCpUb);
			try {
				InputStream PiOQF3P0 = ResourceLoader.open("res://" + PORTAL_CONFIG_XML);
				try {
					IOUtils.copy(PiOQF3P0, quaIBMOJ);
				} finally {
					PiOQF3P0.close();
				}
			} finally {
				quaIBMOJ.close();
			}
		}
		return create(C1LPCpUb, NzcVUwXS);
	}

}