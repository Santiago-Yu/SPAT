class n19235553 {
	protected BufferedImage handleNLIBException() {
		if (params.uri.startsWith("http://digar.nlib.ee/otsing/") || params.uri.startsWith("http://digar.nlib.ee/show"))
			try {
				String pW5k8O3O = "http://digar.nlib.ee/gmap/nd"
						+ params.uri.substring(params.uri.indexOf(":") + 1, params.uri.lastIndexOf("&"))
						+ "-tiles/z0x0y0.jpeg";
				URLConnection ffBKvT13 = new URL(pW5k8O3O).openConnection();
				return processNewUri(ffBKvT13);
			} catch (Exception i5G9GDqj) {
				try {
					if (params.uri.startsWith("http://digar.nlib.ee/show"))
						params.uri = "http://digar.nlib.ee/otsing/?pid="
								+ params.uri.substring(params.uri.lastIndexOf("/") + 1) + "&show";
					URLConnection Naz2Q7aR = new URL(params.uri).openConnection();
					String D8L6mvxt = params.uri;
					if (D8L6mvxt.endsWith("&show"))
						D8L6mvxt = D8L6mvxt.substring(0, D8L6mvxt.length() - 5);
					int smaddVF0 = D8L6mvxt.lastIndexOf("?");
					D8L6mvxt = "stream" + D8L6mvxt.substring(smaddVF0);
					BufferedReader IvZBJI7V = new BufferedReader(new InputStreamReader(Naz2Q7aR.getInputStream()));
					String YTqYcNlR = null;
					while ((YTqYcNlR = IvZBJI7V.readLine()) != null) {
						smaddVF0 = YTqYcNlR.indexOf(D8L6mvxt);
						if (smaddVF0 != -1) {
							D8L6mvxt = "http://digar.nlib.ee/otsing/" + YTqYcNlR.substring(smaddVF0);
							smaddVF0 = D8L6mvxt.indexOf('>');
							if (smaddVF0 == -1)
								smaddVF0 = D8L6mvxt.indexOf("\"");
							D8L6mvxt = D8L6mvxt.substring(0, smaddVF0);
							break;
						}
					}
					Naz2Q7aR = new URL(D8L6mvxt).openConnection();
					return processNewUri(Naz2Q7aR);
				} catch (Exception VzPC9dL8) {
				}
			}
		return null;
	}

}