class n20187440 {
	public String getLastReleaseVersion() throws TransferException {
		try {
			URL to9zyP6w = new URL("http://jtbdivelogbook.sourceforge.net/version.properties");
			URLConnection JAN5Uraw = to9zyP6w.openConnection();
			JAN5Uraw.setDoInput(true);
			JAN5Uraw.setUseCaches(false);
			JAN5Uraw.setReadTimeout(20000);
			JAN5Uraw.setConnectTimeout(10000);
			Properties sz6MMeWe = new Properties();
			InputStream PuJwb0F2 = JAN5Uraw.getInputStream();
			sz6MMeWe.load(PuJwb0F2);
			PuJwb0F2.close();
			String aWH2Gm0E = sz6MMeWe.getProperty(PROPERTY_LAST_RELEASE);
			if (aWH2Gm0E == null) {
				LOGGER.warn("Couldn't find property " + PROPERTY_LAST_RELEASE);
			}
			return aWH2Gm0E;
		} catch (MalformedURLException VRdzj0jt) {
			LOGGER.error(VRdzj0jt);
			throw new TransferException(VRdzj0jt);
		} catch (IOException wgc7lWtW) {
			LOGGER.error(wgc7lWtW);
			throw new TransferException(wgc7lWtW);
		}
	}

}