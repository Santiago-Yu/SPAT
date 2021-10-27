class n3151940 {
	String readRss(URL rFqiWJuT) {
		String V14cWIbq = "<html><body><h2>No data</h2></body></html>";
		try {
			mLogger.info("URL is:" + rFqiWJuT.toString());
			BufferedReader dzM0cVug = new BufferedReader(new InputStreamReader(rFqiWJuT.openStream()), 1024);
			String jqhDDZO6;
			StringBuilder XTsoElpM = new StringBuilder();
			while ((jqhDDZO6 = dzM0cVug.readLine()) != null) {
				XTsoElpM.append(jqhDDZO6);
			}
			V14cWIbq = XTsoElpM.toString();
		} catch (IOException rB4L8EHu) {
			mLogger.warning("Couldn't open an RSS stream");
		}
		return V14cWIbq;
	}

}