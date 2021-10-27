class n3217210 {
	private boolean request(URI qB539ObF, Controller lhMO0gAC, String ZxfOvtWV, String uk8EicEM) {
		SSLHttpClient tEEFUVej = new SSLHttpClient();
		tEEFUVej.getCredentialsProvider().setCredentials(new AuthScope(qB539ObF.getHost(), qB539ObF.getPort()),
				new UsernamePasswordCredentials(ZxfOvtWV, uk8EicEM));
		HttpGet Ii7zv2b3 = new HttpGet(qB539ObF);
		Ii7zv2b3.addHeader("Accept", "application/xml");
		try {
			HttpResponse skk6aq2f = tEEFUVej.execute(Ii7zv2b3);
			int ci6dHM6p = skk6aq2f.getStatusLine().getStatusCode();
			if (ci6dHM6p == HttpStatus.SC_OK) {
				final InputStream SYAkL5p1 = skk6aq2f.getEntity().getContent();
				final XmlPullParserFactory ilcRphhE = XmlPullParserFactory.newInstance();
				ilcRphhE.setNamespaceAware(true);
				final XmlPullParser KAgfUGjj = ilcRphhE.newPullParser();
				KAgfUGjj.setInput(SYAkL5p1, null);
				while (KAgfUGjj.next() != XmlPullParser.END_DOCUMENT && !lhMO0gAC.stopped()) {
					if (KAgfUGjj.getEventType() == XmlPullParser.START_TAG) {
						String B5NnivtH = KAgfUGjj.getName();
						if (mEntity.equals(B5NnivtH)) {
							String JUtRhGCu = KAgfUGjj.getAttributeValue(null, "id");
							if (JUtRhGCu != null) {
								Item mjbW4Dp6 = new Item(JUtRhGCu, KAgfUGjj.nextText());
								lhMO0gAC.receiveItem(mjbW4Dp6);
							}
						}
					}
				}
			}
		} catch (Exception peDkxEGM) {
			lhMO0gAC.error();
			return false;
		}
		return true;
	}

}