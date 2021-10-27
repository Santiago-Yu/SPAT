class n10383721 {
	@SuppressWarnings("unchecked")
	private ReaderFeed processEntrys(String urlStr, String currentFlag)
			throws UnsupportedEncodingException, IOException, JDOMException {
		String key = "processEntrys@" + urlStr + "_" + currentFlag;
		List<Post> postList = new ArrayList<Post>();
		if (cache.containsKey(key)) {
			return (ReaderFeed) cache.get(key);
		}
		URL url = new URL(urlStr);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("GET");
		connection.setRequestProperty("Cookie", "SID=" + sid);
		SAXBuilder builder = new SAXBuilder(false);
		BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
		Document doc = builder.build(reader);
		Element root = doc.getRootElement();
		Namespace grNamespace = root.getNamespace("gr");
		Namespace namespace = root.getNamespace();
		String newflag = root.getChildText("continuation", grNamespace);
		String title = root.getChildText("title", namespace);
		String subTitle = root.getChildText("subtitle", namespace);
		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
		List<Element> entryList = root.getChildren("entry", namespace);
		ReaderFeed readerFeed = new ReaderFeed();
		for (Element e : entryList) {
			Post post = new Post();
			post.setTitle(e.getChildText("title", namespace));
			try {
				post.setDate(sdf.parse(e.getChildText("published", namespace)));
			} catch (ParseException e1) {
			}
			post.setUrl(e.getChild("link", namespace).getAttributeValue("href"));
			post.setSauthor(e.getChild("author", namespace).getChildText("name", namespace));
			String content = e.getChildText("content", namespace);
			if (StringUtils.isEmpty(content)) {
				content = e.getChildText("description", namespace);
			}
			if (StringUtils.isEmpty(content)) {
				content = e.getChildText("summary", namespace);
			}
			post.setContent(content);
			postList.add(post);
		}
		readerFeed.setTitle(title);
		readerFeed.setSubTitle(subTitle);
		readerFeed.setFlag(newflag);
		readerFeed.setPostList(postList);
		cache.put(key, readerFeed);
		return readerFeed;
	}

}