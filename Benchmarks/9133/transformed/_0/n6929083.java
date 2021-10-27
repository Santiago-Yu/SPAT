class n6929083 {
	public InputStream getResource(String pvNBIdKw) throws IOException {
		if (!pvNBIdKw.startsWith("/")) {
			pvNBIdKw += "/";
		}
		URL HAGrvopl = bc.getBundle().getResource(COOS_CONFIG_PATH + pvNBIdKw);
		InputStream vZ4SIpSU = null;
		try {
			FileInputStream xF2ZNZED = new FileInputStream(configDir + pvNBIdKw);
			vZ4SIpSU = substitute(xF2ZNZED);
		} catch (Exception kehJcv4S) {
		}
		if (vZ4SIpSU == null) {
			vZ4SIpSU = HAGrvopl.openStream();
			vZ4SIpSU = substitute(vZ4SIpSU);
		}
		return vZ4SIpSU;
	}

}