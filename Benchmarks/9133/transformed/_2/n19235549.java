class n19235549 {
	protected BufferedImage handleFirenzeException() {
		if (params.uri.indexOf("bncf.firenze.sbn.it") != -1)
			try {
				params.uri = params.uri.replace("http://opac.bncf.firenze.sbn.it/mdigit/jsp/mdigit.jsp?idr",
						"http://teca.bncf.firenze.sbn.it/TecaViewer/index.jsp?RisIdr");
				URLConnection connection = new URL(params.uri).openConnection();
				BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				String url = null;
				params.uri = "addPage('http://opac.bncf.firenze.sbn.it/php/xlimage/XLImageRV.php";
				for (; (url = reader.readLine()) != null;) {
					int index = url.indexOf(params.uri);
					if (index != -1) {
						url = url.substring(url.indexOf("'") + 1, url.lastIndexOf("'"));
						break;
					}
				}
				connection = new URL(url).openConnection();
				reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				params.uri = "<input type=\"image\" border=\"0\" name=\"tpos\" width=\"";
				for (; (url = reader.readLine()) != null;) {
					int index = url.indexOf(params.uri);
					if (index != -1) {
						url = url.substring(url.indexOf(" src=\"") + 6, url.lastIndexOf("\" alt=\""))
								.replace("&z=2", "&z=32").replace("&z=4", "&z=64").replace("&z=8", "&z=128");
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