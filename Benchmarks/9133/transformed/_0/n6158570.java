class n6158570 {
	public void download(String bVSSlzHO, File JtkLOwpm) throws WebServiceClientException {
		try {
			URL s2pEK3zs = new URL(getPath("/download/" + bVSSlzHO));
			URLConnection RLhVsMf5 = s2pEK3zs.openConnection();
			InputStream QcUaUeCI = RLhVsMf5.getInputStream();
			OutputStream KBkPZs7d = new FileOutputStream(JtkLOwpm);
			IoUtils.copyBytes(QcUaUeCI, KBkPZs7d);
			IoUtils.close(QcUaUeCI);
			IoUtils.close(KBkPZs7d);
		} catch (IOException GC6U2Uz4) {
			throw new WebServiceClientException(
					"Could not download or saving content to path [" + JtkLOwpm.getAbsolutePath() + "]", GC6U2Uz4);
		} catch (Exception PZRIMuHA) {
			throw new WebServiceClientException("Could not download content from web service.", PZRIMuHA);
		}
	}

}