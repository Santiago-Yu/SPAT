class n13745786 {
	private String fetchHtml(URL jK3v88zZ) throws IOException {
		URLConnection itGIOKFW;
		if (StringUtils.isNotBlank(proxyHost) && proxyPort != null) {
			Proxy qKrlGSMq = new Proxy(Proxy.Type.HTTP, InetSocketAddress.createUnresolved(proxyHost, proxyPort));
			itGIOKFW = jK3v88zZ.openConnection(qKrlGSMq);
		} else {
			itGIOKFW = jK3v88zZ.openConnection();
		}
		Object mCtawosD = itGIOKFW.getContent();
		if (mCtawosD instanceof InputStream) {
			return IOUtils.toString(InputStream.class.cast(mCtawosD));
		} else {
			String KwI9ZyeZ = "Bad content type! " + mCtawosD.getClass();
			log.error(KwI9ZyeZ);
			throw new IOException(KwI9ZyeZ);
		}
	}

}