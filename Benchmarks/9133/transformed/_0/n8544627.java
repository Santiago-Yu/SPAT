class n8544627 {
	@Override
	protected void copyContent(String tIiLmPXe) throws IOException {
		InputStream S9PKM8XH = null;
		try {
			S9PKM8XH = LOADER.getResourceAsStream(RES_PKG + tIiLmPXe);
			ByteArrayOutputStream qqxbwo8k = new ByteArrayOutputStream();
			IOUtils.copy(S9PKM8XH, qqxbwo8k);
			setResponseData(qqxbwo8k.toByteArray());
		} finally {
			if (S9PKM8XH != null) {
				S9PKM8XH.close();
			}
		}
	}

}