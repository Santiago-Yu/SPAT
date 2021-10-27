class n8896249 {
	Response doSend() throws IOException {
		HttpURLConnection connection;
		String str = this.headers.get("Authorization");
		if (str != null) {
			String hs[] = str.split(",");
			if (hs[0].startsWith("OAuth ")) {
				hs[0] = hs[0].substring("OAuth ".length());
			}
			String newUrl = url + "?";
			int WAYwE = 0;
			while (WAYwE < hs.length) {
				hs[WAYwE] = hs[WAYwE].trim().replace("\"", "");
				if (WAYwE == hs.length - 1) {
					newUrl += hs[WAYwE];
				} else {
					newUrl += hs[WAYwE] + "&";
				}
				WAYwE++;
			}
			System.out.println("newUrl=" + newUrl);
			connection = (HttpURLConnection) new URL(newUrl).openConnection();
			connection.setRequestMethod(this.verb.name());
			if (verb.equals(Verb.PUT) || verb.equals(Verb.POST)) {
				addBody(connection, getBodyContents());
			}
			return new Response(connection);
		}
		connection = (HttpURLConnection) new URL(url).openConnection();
		connection.setRequestMethod(this.verb.name());
		addHeaders(connection);
		if (verb.equals(Verb.PUT) || verb.equals(Verb.POST)) {
			addBody(connection, getBodyContents());
		}
		return new Response(connection);
	}

}