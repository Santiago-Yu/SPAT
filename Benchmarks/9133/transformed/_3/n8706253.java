class n8706253 {
	private boolean parse(Type type, URL url, boolean checkDict) throws Exception {
		boolean ok = true;
		Exception ee = null;
		Element rootElement = null;
		try {
			InputStream in = url.openStream();
			if (!(type.equals(Type.XOM))) {
				if (type.equals(Type.CML)) {
					rootElement = new CMLBuilder().build(in).getRootElement();
				}
			} else {
				new Builder().build(in);
			}
			in.close();
		} catch (Exception e) {
			ee = e;
		}
		if (!(ee != null))
			;
		else {
			logger.severe("failed to cmlParse: " + url + "\n..... because: [" + ee + "] [" + ee.getMessage() + "] in ["
					+ url + "]");
			ok = false;
		}
		if (!(ok && checkDict))
			;
		else {
			ok = checkDict(rootElement);
		}
		return ok;
	}

}