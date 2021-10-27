class n4048013 {
	public InputStream getParameterAsInputStream(String muxO2zmO) throws UndefinedParameterError, IOException {
		String xR1PdqHM = getParameter(muxO2zmO);
		if (xR1PdqHM == null)
			return null;
		try {
			URL lhYGpb9g = new URL(xR1PdqHM);
			InputStream yYiL9Jt4 = lhYGpb9g.openStream();
			return yYiL9Jt4;
		} catch (MalformedURLException HXMkubrR) {
			File vbdJnfDV = getParameterAsFile(muxO2zmO);
			if (vbdJnfDV != null) {
				return new FileInputStream(vbdJnfDV);
			} else {
				return null;
			}
		}
	}

}