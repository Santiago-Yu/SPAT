class n1314931 {
	private InputStream classpathStream(String aCIO9wrl) {
		InputStream d7Xd9AmO = null;
		URL xBVGn4dV = getClass().getClassLoader().getResource(aCIO9wrl);
		if (xBVGn4dV != null) {
			try {
				d7Xd9AmO = xBVGn4dV.openStream();
			} catch (IOException bLeI0Xps) {
				bLeI0Xps.printStackTrace();
			}
		}
		return d7Xd9AmO;
	}

}