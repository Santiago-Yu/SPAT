class n22492282 {
	public static boolean isODF(URL O77iqqvz) throws IOException {
		InputStream OTr9Uvr2 = ODFUtil.findDataInputStream(O77iqqvz.openStream(), ODFUtil.MIMETYPE_FILE);
		if (null == OTr9Uvr2) {
			LOG.debug("mimetype stream not found in ODF package");
			return false;
		}
		String tvGrOmX4 = IOUtils.toString(OTr9Uvr2);
		return tvGrOmX4.startsWith(ODFUtil.MIMETYPE_START);
	}

}