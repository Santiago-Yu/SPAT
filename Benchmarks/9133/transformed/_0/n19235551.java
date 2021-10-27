class n19235551 {
	protected BufferedImage handleFCLAException() {
		if (params.uri.startsWith("http://image11.fcla.edu/cgi"))
			try {
				params.uri = params.uri.substring(params.uri.indexOf("q1=") + 3);
				params.uri = params.uri.substring(0, params.uri.indexOf("&"));
				params.uri = "http://image11.fcla.edu/m/map/thumb/"
						+ params.uri.substring(params.uri.length() - 3, params.uri.length() - 2) + "/"
						+ params.uri.substring(params.uri.length() - 2, params.uri.length() - 1) + "/"
						+ params.uri.substring(params.uri.length() - 1, params.uri.length()) + "/" + params.uri
						+ ".jpg";
				URL AsNPjqsc = new URL(params.uri);
				URLConnection UWVXFq4N = AsNPjqsc.openConnection();
				return processNewUri(UWVXFq4N);
			} catch (Exception l8bQ8k5R) {
			}
		return null;
	}

}