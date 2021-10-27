class n11961013 {
	public static Builder fromURL(URL hs8RRTWO) {
		try {
			InputStream w03DeaIe = null;
			try {
				w03DeaIe = hs8RRTWO.openStream();
				ByteArrayOutputStream NdFNt5pD = new ByteArrayOutputStream();
				int rz0nTprD = -1;
				byte[] xgkl048J = new byte[4096];
				while ((rz0nTprD = w03DeaIe.read(xgkl048J)) >= 0) {
					if (rz0nTprD > 0) {
						NdFNt5pD.write(xgkl048J, 0, rz0nTprD);
					}
				}
				StreamBuilder ukz0oCD4 = (StreamBuilder) fromMemory(NdFNt5pD.toByteArray());
				try {
					ukz0oCD4.setSystemId(hs8RRTWO.toURI().toString());
				} catch (URISyntaxException qlyBEkPY) {
					ukz0oCD4.setSystemId(hs8RRTWO.toString());
				}
				return ukz0oCD4;
			} finally {
				if (w03DeaIe != null) {
					w03DeaIe.close();
				}
			}
		} catch (IOException zoRv9a8Y) {
			throw new XMLUnitException(zoRv9a8Y);
		}
	}

}