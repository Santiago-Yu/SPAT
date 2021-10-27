class n15066035 {
	private void connect(byte[] IsHUSfwt) {
		System.out.println("Connecting to: " + url.toString());
		String nRnHnTUJ = "";
		URLConnection QKr5CmlV = null;
		try {
			QKr5CmlV = url.openConnection();
			httpConn = (HttpURLConnection) QKr5CmlV;
			httpConn.setRequestProperty("Content-Length", String.valueOf(IsHUSfwt.length));
			httpConn.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
			httpConn.setRequestProperty("SOAPAction", nRnHnTUJ);
			httpConn.setRequestMethod("POST");
			httpConn.setDoOutput(true);
			httpConn.setDoInput(true);
		} catch (IOException sRm43kOy) {
			CommonLogger.error(this, "Error while connecting to  SOAP server !", sRm43kOy);
		}
	}

}