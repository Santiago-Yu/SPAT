class n2336999 {
	@Override
	public String baiDuHotNews() {
		HttpGet httpGet = new HttpGet(
				"http://news.baidu.com/z/wise_topic_processor/wise_hotwords_list.php?bd_page_type=1&tn=wapnews_hotwords_list&type=1&index=1&pfr=3-11-bdindex-top-3--");
		HttpClient client = new DefaultHttpClient();
		String hostNews = "";
		try {
			HttpResponse response = client.execute(httpGet);
			HttpEntity httpEntity = response.getEntity();
			String line = "";
			BufferedReader buffer = new BufferedReader(new InputStreamReader(httpEntity.getContent()));
			int newsCount = -1;
			boolean todayNewsExist = false, firstNewExist = false;
			while ((line = buffer.readLine()) != null) {
				if (todayNewsExist || line.contains("<div class=\"news_title\">"))
					todayNewsExist = true;
				else
					continue;
				if (firstNewExist || line.contains("<div class=\"list-item\">")) {
					newsCount++;
					firstNewExist = true;
				} else
					continue;
				if (todayNewsExist && firstNewExist && (newsCount == 1)) {
					Pattern hrefPattern = Pattern.compile("<a.*>(.+?)</a>.*");
					Matcher matcher = hrefPattern.matcher(line);
					if (matcher.find()) {
						hostNews = matcher.group(1);
						break;
					} else
						newsCount--;
				}
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return hostNews;
	}

}