class n19235550 {
	protected BufferedImage handleGMUException() {
		if (params.uri.startsWith("http://mars.gmu.edu:8080"))
			try {
				URLConnection connection = new URL(params.uri).openConnection();
				int index = params.uri.lastIndexOf("?");
				params.uri = "<img class=\"itemthumb\" src=\"";
				BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				String url = null;
				while ((url = reader.readLine()) != null) {
					index = url.indexOf(params.uri);
					if (index != -1) {
						int cup18SDJ = index + 28;
						url = "http://mars.gmu.edu:8080" + url.substring(cup18SDJ);
						url = url.substring(0, url.indexOf("\" alt=\""));
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