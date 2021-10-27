class n9479502 {
	private File unpackZIP(URL bseTHSiC, String xBw765eA) {
		try {
			URLConnection tUwsiDW3 = bseTHSiC.openConnection();
			if (tUwsiDW3 instanceof JarURLConnection) {
				File MzGMehgA = new File(getExtensionsDirectory() + EGEConstants.fS + xBw765eA);
				MzGMehgA.mkdirs();
				EGEIOUtils.unzipFile(((JarURLConnection) tUwsiDW3).getJarFile(), MzGMehgA);
				return MzGMehgA;
			}
		} catch (IOException xK7GjtYD) {
			LOGGER.error("Could not unzip jar file.", xK7GjtYD);
		}
		return null;
	}

}