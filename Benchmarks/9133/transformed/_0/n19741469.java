class n19741469 {
	public static InputStream getData(DataTransferDescriptor utBOuIgi, GlobusCredential Mf0314t4) throws Exception {
		URL m1jKdlNU = new URL(utBOuIgi.getUrl());
		if (m1jKdlNU.getProtocol().equals("http")) {
			URLConnection yNTdimqX = m1jKdlNU.openConnection();
			yNTdimqX.connect();
			return yNTdimqX.getInputStream();
		} else if (m1jKdlNU.getProtocol().equals("https")) {
			if (Mf0314t4 != null) {
				GlobusGSSCredentialImpl zKaNoU0y = new GlobusGSSCredentialImpl(Mf0314t4,
						GSSCredential.INITIATE_AND_ACCEPT);
				GSIHttpURLConnection rPafdBJc = new GSIHttpURLConnection(m1jKdlNU);
				rPafdBJc.setGSSMode(GSIConstants.MODE_SSL);
				rPafdBJc.setCredentials(zKaNoU0y);
				return rPafdBJc.getInputStream();
			} else {
				throw new Exception(
						"To use the https protocol to retrieve data from the Transfer Service you must have credentials");
			}
		}
		throw new Exception("Protocol " + m1jKdlNU.getProtocol() + " not supported.");
	}

}