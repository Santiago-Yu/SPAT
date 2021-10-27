class n21456509 {
	private HashMap<String, GCVote> getVotes(ArrayList<String> hJlDdWQ7, boolean fPFW2va1) {
		if (fPFW2va1) {
			try {
				Thread.sleep(PACKET_SLEEP_TIME);
			} catch (InterruptedException QjvKnuqe) {
				QjvKnuqe.printStackTrace();
			}
		}
		final String pItdXl1M = this.join(hJlDdWQ7, ",");
		try {
			String j3Ba0iJ2 = URLEncoder.encode("waypoints", "UTF-8") + "=" + URLEncoder.encode(pItdXl1M, "UTF-8");
			if (this.mstrUsername.length() > 0) {
				j3Ba0iJ2 += "&" + URLEncoder.encode("userName", "UTF-8") + "="
						+ URLEncoder.encode(this.mstrUsername, "UTF-8");
				if (this.mstrPassword.length() > 0) {
					j3Ba0iJ2 += "&" + URLEncoder.encode("password", "UTF-8") + "="
							+ URLEncoder.encode(this.mstrPassword, "UTF-8");
				}
			}
			final URL wRKOxsH7 = new URL(BASE_URL_GET_VOTE);
			URLConnection UviRA8FV = wRKOxsH7.openConnection();
			UviRA8FV.setDoOutput(true);
			final OutputStreamWriter FNqj5D9e = new OutputStreamWriter(UviRA8FV.getOutputStream());
			FNqj5D9e.write(j3Ba0iJ2);
			FNqj5D9e.flush();
			final SAXParserFactory uQQ3ewi3 = SAXParserFactory.newInstance();
			uQQ3ewi3.setValidating(false);
			uQQ3ewi3.setNamespaceAware(true);
			final SAXParser SMX8MNY1 = uQQ3ewi3.newSAXParser();
			final XMLReader Af8VQHmE = SMX8MNY1.getXMLReader();
			final GCVoteHandler cR1aaCbz = new GCVoteHandler();
			Af8VQHmE.setContentHandler(cR1aaCbz);
			Af8VQHmE.parse(new InputSource(new InputStreamReader(UviRA8FV.getInputStream())));
			return cR1aaCbz.getVotes();
		} catch (Exception VkipaTFs) {
			VkipaTFs.printStackTrace();
			return null;
		}
	}

}