class n15515730 {
	public void delete(String ZYejrn8a) throws IOException {
		log.debug("deleting: " + ZYejrn8a);
		URL kHpVrgVs = new URL(this.endpointURL + "?operation=delete&filename=" + ZYejrn8a);
		URLConnection CfPs2Xai = kHpVrgVs.openConnection();
		CfPs2Xai.setDoOutput(false);
		CfPs2Xai.setDoInput(true);
		CfPs2Xai.setUseCaches(false);
		CfPs2Xai.getInputStream();
	}

}