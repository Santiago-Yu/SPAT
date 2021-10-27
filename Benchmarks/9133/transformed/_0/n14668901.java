class n14668901 {
	public List<T_new> executeGet(HttpTransport zYWgaWEd, String WOC3oT0R) throws HttpResponseException, IOException {
		HttpRequest EodvdQHZ = zYWgaWEd.buildGetRequest();
		EodvdQHZ.setUrl(WOC3oT0R);
		NotifyFeed AAV0AXpN = EodvdQHZ.execute().parseAs(NotifyFeed.class);
		if (AAV0AXpN.entry == null) {
			return Collections.emptyList();
		}
		List<T_new> OEfwfM8Q = new ArrayList<T_new>();
		for (NotifyEntry jGStdWnO : AAV0AXpN.entry) {
			StringBuilder InmIN6f7 = new StringBuilder();
			if (jGStdWnO.id != null) {
				InmIN6f7.append(jGStdWnO.id);
			}
			InmIN6f7.append("@");
			if (jGStdWnO.updated != null) {
				InmIN6f7.append(jGStdWnO.updated.toStringRfc3339().substring(0, 19) + "Z");
			}
			Key P3uiNyF2 = Datastore.createKey(T_new.class, InmIN6f7.toString());
			T_new iy1v5F58 = new T_new();
			iy1v5F58.setTitle(jGStdWnO.title);
			if (jGStdWnO.content != null) {
				iy1v5F58.setNewText(jGStdWnO.content.substring(0, Math.min(jGStdWnO.content.length(), 500)));
			}
			if (jGStdWnO.status != null && jGStdWnO.content == null) {
				iy1v5F58.setNewText(jGStdWnO.status);
			}
			if (jGStdWnO.updated != null) {
				iy1v5F58.setCreatedAt(new Date(jGStdWnO.updated.value));
			}
			iy1v5F58.setContentUrl(jGStdWnO.getAlternate());
			if (jGStdWnO.author != null) {
				iy1v5F58.setAuthor(jGStdWnO.author.name);
			}
			iy1v5F58.setKey(P3uiNyF2);
			OEfwfM8Q.add(iy1v5F58);
		}
		return OEfwfM8Q;
	}

}