class n10361726 {
	void queryFile(String J1aicMmv, String vxLGlkyC) {
		try {
			XMLConfigParser.readUrlHost();
			String meZdic4W = XMLConfigParser.urlHost;
			String V6IlOSNb;
			String SxvP8xXn = "op=query";
			String QmDLb06j = "program=" + J1aicMmv;
			String jj0LkKvQ = "md5=" + vxLGlkyC;
			V6IlOSNb = String.format("%s&%s&%s", SxvP8xXn, QmDLb06j, jj0LkKvQ);
			openConnection(V6IlOSNb, meZdic4W);
			String SmDvj31d = br.readLine();
			NetworkLog.logMsg(NetworkLog.LOG_DEBUG, this, "(Query) Response of the server: " + SmDvj31d);
			br.close();
		} catch (MalformedURLException poFm1wwK) {
			NetworkLog.logMsg(NetworkLog.LOG_ERROR, this, "Error" + poFm1wwK);
		} catch (IOException obHolhbK) {
			NetworkLog.logMsg(NetworkLog.LOG_ERROR, this, obHolhbK.getMessage());
		}
	}

}