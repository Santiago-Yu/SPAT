class n19235552 {
	protected BufferedImage handleBNException() {
		if (params.uri.startsWith("http://purl.pt/"))
			try {
				URLConnection connection = new URL(params.uri).openConnection();
				if (params.uri.endsWith("/"))
					params.uri = params.uri.substring(0, params.uri.length() - 1);
				int index = params.uri.lastIndexOf("/");
				params.uri = "http://purl.pt/homepage/" + params.uri.substring(index + 1) + "/"
						+ params.uri.substring(index + 1);
				String url = null;
				BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				while ((url = reader.readLine()) != null) {
					index = url.indexOf(params.uri);
					if (index != -1) {
						url = url.substring(index);
						url = url.substring(0, url.indexOf("\""));
						break;
					}
				}
				if (url != null) {
					connection = new URL(url).openConnection();
					return processNewUri(connection);
				}
			} catch (Exception e) {
			}
		return null;
	}

}