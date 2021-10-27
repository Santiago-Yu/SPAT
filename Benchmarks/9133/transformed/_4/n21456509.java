class n21456509 {
	private HashMap<String, GCVote> getVotes(ArrayList<String> waypoints, boolean blnSleepBeforeDownload) {
		if (blnSleepBeforeDownload) {
			try {
				Thread.sleep(PACKET_SLEEP_TIME);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		final String strWaypoints = this.join(waypoints, ",");
		try {
			String strParameters = URLEncoder.encode("waypoints", "UTF-8") + "="
					+ URLEncoder.encode(strWaypoints, "UTF-8");
			if (this.mstrUsername.length() > 0) {
				strParameters += "&" + URLEncoder.encode("userName", "UTF-8") + "="
						+ URLEncoder.encode(this.mstrUsername, "UTF-8");
				strParameters = (this.mstrPassword.length() > 0) ? "&" + URLEncoder.encode("password", "UTF-8") + "="
						+ URLEncoder.encode(this.mstrPassword, "UTF-8") : strParameters;
			}
			final URL url = new URL(BASE_URL_GET_VOTE);
			URLConnection conn = url.openConnection();
			conn.setDoOutput(true);
			final OutputStreamWriter osw = new OutputStreamWriter(conn.getOutputStream());
			osw.write(strParameters);
			osw.flush();
			final SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
			saxParserFactory.setValidating(false);
			saxParserFactory.setNamespaceAware(true);
			final SAXParser saxParser = saxParserFactory.newSAXParser();
			final XMLReader xmlReader = saxParser.getXMLReader();
			final GCVoteHandler gcVoteHandler = new GCVoteHandler();
			xmlReader.setContentHandler(gcVoteHandler);
			xmlReader.parse(new InputSource(new InputStreamReader(conn.getInputStream())));
			return gcVoteHandler.getVotes();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}