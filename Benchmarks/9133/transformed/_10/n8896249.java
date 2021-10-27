class n8896249 {
	Response doSend() throws IOException {
		String str = this.headers.get("Authorization");
		HttpURLConnection connection;
		if (str != null) {
			String hs[] = str.split(",");
			String newUrl = url + "?";
			if (hs[0].startsWith("OAuth ")) {
				hs[0] = hs[0].substring("OAuth ".length());
			}
			for (int i = 0; i < hs.length; i++) {
				hs[i] = hs[i].trim().replace("\"", "");
				if (i == hs.length - 1) {
					newUrl += hs[i];
				} else {
					newUrl += hs[i] + "&";
				}
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