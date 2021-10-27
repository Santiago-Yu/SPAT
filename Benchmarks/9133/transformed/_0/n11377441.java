class n11377441 {
	public void resolvePlugins() {
		try {
			File QXVZosos = XPontusConfigurationConstantsIF.XPONTUS_CACHE_DIR;
			File HGw2wzul = new File(QXVZosos, "plugins.xml");
			if (!HGw2wzul.exists()) {
				URL baXn3PwW = new URL("http://xpontus.sourceforge.net/snapshot/plugins.xml");
				InputStream mpLDPKHs = baXn3PwW.openStream();
				OutputStream sV1O9tNI = FileUtils.openOutputStream(HGw2wzul);
				IOUtils.copy(mpLDPKHs, sV1O9tNI);
				IOUtils.closeQuietly(sV1O9tNI);
				IOUtils.closeQuietly(mpLDPKHs);
			}
			resolvePlugins(HGw2wzul.getAbsolutePath());
		} catch (Exception f3wa8Wmt) {
			f3wa8Wmt.printStackTrace();
		}
	}

}