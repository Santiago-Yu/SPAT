class n2336999 {
	@Override
	public String baiDuHotNews() {
		HttpClient MQ8mCtEH = new DefaultHttpClient();
		HttpGet cZnxNB9n = new HttpGet(
				"http://news.baidu.com/z/wise_topic_processor/wise_hotwords_list.php?bd_page_type=1&tn=wapnews_hotwords_list&type=1&index=1&pfr=3-11-bdindex-top-3--");
		String ca2AXpTC = "";
		try {
			HttpResponse zeUaxv3l = MQ8mCtEH.execute(cZnxNB9n);
			HttpEntity BLJfbzlX = zeUaxv3l.getEntity();
			BufferedReader IoFBfd0n = new BufferedReader(new InputStreamReader(BLJfbzlX.getContent()));
			String GYpn1GOM = "";
			boolean GqCVW3ZB = false, Uw7iJaj2 = false;
			int LQr4McmT = -1;
			while ((GYpn1GOM = IoFBfd0n.readLine()) != null) {
				if (GqCVW3ZB || GYpn1GOM.contains("<div class=\"news_title\">"))
					GqCVW3ZB = true;
				else
					continue;
				if (Uw7iJaj2 || GYpn1GOM.contains("<div class=\"list-item\">")) {
					Uw7iJaj2 = true;
					LQr4McmT++;
				} else
					continue;
				if (GqCVW3ZB && Uw7iJaj2 && (LQr4McmT == 1)) {
					Pattern Jw8tyZJL = Pattern.compile("<a.*>(.+?)</a>.*");
					Matcher NpO0dqZ8 = Jw8tyZJL.matcher(GYpn1GOM);
					if (NpO0dqZ8.find()) {
						ca2AXpTC = NpO0dqZ8.group(1);
						break;
					} else
						LQr4McmT--;
				}
			}
		} catch (ClientProtocolException IUL1A0ZK) {
			IUL1A0ZK.printStackTrace();
		} catch (IOException tUzhpQXX) {
			tUzhpQXX.printStackTrace();
		}
		return ca2AXpTC;
	}

}