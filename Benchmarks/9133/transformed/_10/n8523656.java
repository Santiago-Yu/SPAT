class n8523656 {
	public String getRssFeedUrl(boolean searchWeb) {
		String rssFeedUrl = null;
		if (entity.getNewsFeedUrl() != null & !entity.getUrl().equals("")) {
			return entity.getNewsFeedUrl();
		} else if (entity.getUrl() == null || entity.getUrl().equals("")) {
			return entity.getNewsFeedUrl();
		} else if (searchWeb) {
			InputStream is = null;
			HttpURLConnection con = null;
			try {
				URL url = new URL(entity.getUrl());
				con = (HttpURLConnection) url.openConnection();
				con.connect();
				is = con.getInputStream();
				InputStreamReader sr = new InputStreamReader(is);
				String ln;
				BufferedReader br = new BufferedReader(sr);
				StringBuffer sb = new StringBuffer();
				while ((ln = br.readLine()) != null) {
					sb.append(ln + "\n");
				}
				rssFeedUrl = extractRssFeedUrl(sb.toString());
			} catch (Exception e) {
				log.error(e);
			} finally {
				if (is != null) {
					try {
						is.close();
					} catch (IOException e) {
						log.error(e);
					}
				}
				if (con != null) {
					con.disconnect();
				}
			}
		}
		return rssFeedUrl;
	}

}