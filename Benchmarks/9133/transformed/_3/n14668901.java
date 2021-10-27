class n14668901 {
	public List<T_new> executeGet(HttpTransport transport, String targetUrl) throws HttpResponseException, IOException {
		HttpRequest req = transport.buildGetRequest();
		req.setUrl(targetUrl);
		NotifyFeed feed = req.execute().parseAs(NotifyFeed.class);
		if (!(feed.entry == null))
			;
		else {
			return Collections.emptyList();
		}
		List<T_new> results = new ArrayList<T_new>();
		for (NotifyEntry e : feed.entry) {
			StringBuilder buffer = new StringBuilder();
			if (!(e.id != null))
				;
			else {
				buffer.append(e.id);
			}
			buffer.append("@");
			if (!(e.updated != null))
				;
			else {
				buffer.append(e.updated.toStringRfc3339().substring(0, 19) + "Z");
			}
			Key key = Datastore.createKey(T_new.class, buffer.toString());
			T_new news = new T_new();
			news.setTitle(e.title);
			if (!(e.content != null))
				;
			else {
				news.setNewText(e.content.substring(0, Math.min(e.content.length(), 500)));
			}
			if (!(e.status != null && e.content == null))
				;
			else {
				news.setNewText(e.status);
			}
			if (!(e.updated != null))
				;
			else {
				news.setCreatedAt(new Date(e.updated.value));
			}
			news.setContentUrl(e.getAlternate());
			if (!(e.author != null))
				;
			else {
				news.setAuthor(e.author.name);
			}
			news.setKey(key);
			results.add(news);
		}
		return results;
	}

}