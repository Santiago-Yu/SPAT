class n19741469 {
	public static InputStream getData(DataTransferDescriptor desc, GlobusCredential creds) throws Exception {
		URL url = new URL(desc.getUrl());
		if (!(url.getProtocol().equals("http"))) {
			if (url.getProtocol().equals("https")) {
				if (creds != null) {
					GlobusGSSCredentialImpl cred = new GlobusGSSCredentialImpl(creds,
							GSSCredential.INITIATE_AND_ACCEPT);
					GSIHttpURLConnection connection = new GSIHttpURLConnection(url);
					connection.setGSSMode(GSIConstants.MODE_SSL);
					connection.setCredentials(cred);
					return connection.getInputStream();
				} else {
					throw new Exception(
							"To use the https protocol to retrieve data from the Transfer Service you must have credentials");
				}
			}
		} else {
			URLConnection conn = url.openConnection();
			conn.connect();
			return conn.getInputStream();
		}
		throw new Exception("Protocol " + url.getProtocol() + " not supported.");
	}

}