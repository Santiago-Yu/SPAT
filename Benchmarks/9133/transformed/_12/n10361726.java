class n10361726 {
	void queryFile(String rendezvousProgram, String rendezvousMD5) {
		try {
			XMLConfigParser.readUrlHost();
			String url = XMLConfigParser.urlHost, query;
			String param1 = "op=query", param2 = "program=" + rendezvousProgram;
			String param3 = "md5=" + rendezvousMD5;
			query = String.format("%s&%s&%s", param1, param2, param3);
			openConnection(query, url);
			String line = br.readLine();
			NetworkLog.logMsg(NetworkLog.LOG_DEBUG, this, "(Query) Response of the server: " + line);
			br.close();
		} catch (MalformedURLException e) {
			NetworkLog.logMsg(NetworkLog.LOG_ERROR, this, "Error" + e);
		} catch (IOException e) {
			NetworkLog.logMsg(NetworkLog.LOG_ERROR, this, e.getMessage());
		}
	}

}