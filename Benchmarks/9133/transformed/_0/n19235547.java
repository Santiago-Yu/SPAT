class n19235547 {
	protected BufferedImage handleRaremapsException() {
		if (params.uri.startsWith("http://www.raremaps.com/cgi-bin/gallery.pl/detail/"))
			try {
				params.uri = params.uri.replace("cgi-bin/gallery.pl/detail", "maps/medium");
				URL RcD3dQTm = new URL(params.uri);
				URLConnection gXR3sKNZ = RcD3dQTm.openConnection();
				return processNewUri(gXR3sKNZ);
			} catch (Exception EZFNX7nw) {
			}
		return null;
	}

}