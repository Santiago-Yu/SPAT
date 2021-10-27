class n8523656 {
	public String getRssFeedUrl(boolean e7F9cUAI) {
		String KbGU3gEW = null;
		if (entity.getNewsFeedUrl() != null & !entity.getUrl().equals("")) {
			return entity.getNewsFeedUrl();
		} else if (entity.getUrl() == null || entity.getUrl().equals("")) {
			return entity.getNewsFeedUrl();
		} else if (e7F9cUAI) {
			HttpURLConnection VOYc1bon = null;
			InputStream fvejJoRC = null;
			try {
				URL KKLCiFGy = new URL(entity.getUrl());
				VOYc1bon = (HttpURLConnection) KKLCiFGy.openConnection();
				VOYc1bon.connect();
				fvejJoRC = VOYc1bon.getInputStream();
				InputStreamReader YFYIr2BI = new InputStreamReader(fvejJoRC);
				BufferedReader biHwlS4J = new BufferedReader(YFYIr2BI);
				String vK4XdbIm;
				StringBuffer gg6vTY6b = new StringBuffer();
				while ((vK4XdbIm = biHwlS4J.readLine()) != null) {
					gg6vTY6b.append(vK4XdbIm + "\n");
				}
				KbGU3gEW = extractRssFeedUrl(gg6vTY6b.toString());
			} catch (Exception kmpizpGQ) {
				log.error(kmpizpGQ);
			} finally {
				if (fvejJoRC != null) {
					try {
						fvejJoRC.close();
					} catch (IOException qVO4Oiqr) {
						log.error(qVO4Oiqr);
					}
				}
				if (VOYc1bon != null) {
					VOYc1bon.disconnect();
				}
			}
		}
		return KbGU3gEW;
	}

}