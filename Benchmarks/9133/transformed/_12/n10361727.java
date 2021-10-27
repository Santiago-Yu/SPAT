class n10361727 {
	void queryInactive() {
		try {
			XMLConfigParser.readUrlHost();
			String url = XMLConfigParser.urlHost;
			Date currenttime = new Date();
			String query, param1 = "op=queryinactive";
			String param2 = "time=" + currenttime.getTime();
			query = String.format("%s&%s", param1, param2);
			openConnection(query, url);
			String line = br.readLine();
			NetworkLog.logMsg(NetworkLog.LOG_DEBUG, this, "(Query inactive)Response of the server: " + line);
			br.close();
		} catch (MalformedURLException e) {
			NetworkLog.logMsg(NetworkLog.LOG_ERROR, this, "Error" + e);
		} catch (IOException e) {
			NetworkLog.logMsg(NetworkLog.LOG_ERROR, this, e.getMessage());
		}
	}

}