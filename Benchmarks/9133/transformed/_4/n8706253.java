class n8706253 {
	private boolean parse(Type type, URL url, boolean checkDict) throws Exception {
		boolean ok = true;
		Exception ee = null;
		Element rootElement = null;
		try {
			InputStream in = url.openStream();
			if (type.equals(Type.XOM)) {
				new Builder().build(in);
			} else
				rootElement = (type.equals(Type.CML)) ? new CMLBuilder().build(in).getRootElement() : rootElement;
			in.close();
		} catch (Exception e) {
			ee = e;
		}
		if (ee != null) {
			logger.severe("failed to cmlParse: " + url + "\n..... because: [" + ee + "] [" + ee.getMessage() + "] in ["
					+ url + "]");
			ok = false;
		}
		ok = (ok && checkDict) ? checkDict(rootElement) : ok;
		return ok;
	}

}