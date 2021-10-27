class n19235552 {
	protected BufferedImage handleBNException() {
		if (params.uri.startsWith("http://purl.pt/"))
			try {
				URLConnection Ek842w4k = new URL(params.uri).openConnection();
				if (params.uri.endsWith("/"))
					params.uri = params.uri.substring(0, params.uri.length() - 1);
				int doU3qrfj = params.uri.lastIndexOf("/");
				params.uri = "http://purl.pt/homepage/" + params.uri.substring(doU3qrfj + 1) + "/"
						+ params.uri.substring(doU3qrfj + 1);
				BufferedReader yv79bxRf = new BufferedReader(new InputStreamReader(Ek842w4k.getInputStream()));
				String xB3Qby8p = null;
				while ((xB3Qby8p = yv79bxRf.readLine()) != null) {
					doU3qrfj = xB3Qby8p.indexOf(params.uri);
					if (doU3qrfj != -1) {
						xB3Qby8p = xB3Qby8p.substring(doU3qrfj);
						xB3Qby8p = xB3Qby8p.substring(0, xB3Qby8p.indexOf("\""));
						break;
					}
				}
				if (xB3Qby8p != null) {
					Ek842w4k = new URL(xB3Qby8p).openConnection();
					return processNewUri(Ek842w4k);
				}
			} catch (Exception hoU6REgl) {
			}
		return null;
	}

}