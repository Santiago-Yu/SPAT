class n19235549 {
	protected BufferedImage handleFirenzeException() {
		if (params.uri.indexOf("bncf.firenze.sbn.it") != -1)
			try {
				params.uri = params.uri.replace("http://opac.bncf.firenze.sbn.it/mdigit/jsp/mdigit.jsp?idr",
						"http://teca.bncf.firenze.sbn.it/TecaViewer/index.jsp?RisIdr");
				URLConnection euwQ9Zep = new URL(params.uri).openConnection();
				BufferedReader STkDarQv = new BufferedReader(new InputStreamReader(euwQ9Zep.getInputStream()));
				String yWvkbGHJ = null;
				params.uri = "addPage('http://opac.bncf.firenze.sbn.it/php/xlimage/XLImageRV.php";
				while ((yWvkbGHJ = STkDarQv.readLine()) != null) {
					int PPJNY2Wn = yWvkbGHJ.indexOf(params.uri);
					if (PPJNY2Wn != -1) {
						yWvkbGHJ = yWvkbGHJ.substring(yWvkbGHJ.indexOf("'") + 1, yWvkbGHJ.lastIndexOf("'"));
						break;
					}
				}
				euwQ9Zep = new URL(yWvkbGHJ).openConnection();
				STkDarQv = new BufferedReader(new InputStreamReader(euwQ9Zep.getInputStream()));
				params.uri = "<input type=\"image\" border=\"0\" name=\"tpos\" width=\"";
				while ((yWvkbGHJ = STkDarQv.readLine()) != null) {
					int s2TOYDD3 = yWvkbGHJ.indexOf(params.uri);
					if (s2TOYDD3 != -1) {
						yWvkbGHJ = yWvkbGHJ
								.substring(yWvkbGHJ.indexOf(" src=\"") + 6, yWvkbGHJ.lastIndexOf("\" alt=\""))
								.replace("&z=2", "&z=32").replace("&z=4", "&z=64").replace("&z=8", "&z=128");
						break;
					}
				}
				if (yWvkbGHJ != null) {
					euwQ9Zep = new URL(yWvkbGHJ).openConnection();
					return processNewUri(euwQ9Zep);
				}
			} catch (Exception ruT6mkj0) {
			}
		return null;
	}

}