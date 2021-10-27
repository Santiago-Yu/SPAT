class n19235554 {
	protected BufferedImage handleKBRException() {
		if (params.uri.startsWith("http://mara.kbr.be/kbrImage/CM/")
				|| params.uri.startsWith("http://mara.kbr.be/kbrImage/maps/")
				|| params.uri.startsWith("http://opteron2.kbr.be/kp/viewer/"))
			try {
				String url = "get_image.php?intId=";
				URLConnection connection = new URL(params.uri).openConnection();
				String aux = null;
				BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				while ((aux = reader.readLine()) != null) {
					if (aux.indexOf(url) != -1) {
						aux = aux.substring(aux.indexOf(url));
						url = "http://mara.kbr.be/kbrImage/" + aux.substring(0, aux.indexOf("\""));
						break;
					}
				}
				connection = new URL(url).openConnection();
				return processNewUri(connection);
			} catch (Exception e) {
				try {
					String url = "http://mara.kbr.be/xlimages/maps/thumbnails"
							+ params.uri.substring(params.uri.lastIndexOf("/")).replace(".imgf", ".jpg");
					if (url != null) {
						URLConnection connection = new URL(url).openConnection();
						return processNewUri(connection);
					}
				} catch (Exception e2) {
				}
			}
		return null;
	}

}