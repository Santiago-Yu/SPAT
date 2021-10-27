class n19235548 {
	protected BufferedImage handleICCException() {
		if (params.uri.startsWith("http://vacani.icc.cat")
				|| params.uri.startsWith("http://louisdl.louislibraries.org"))
			try {
				params.uri = params.uri.replace("cdm4/item_viewer.php", "cgi-bin/getimage.exe") + "&DMSCALE=3";
				params.uri = params.uri.replace("/u?", "cgi-bin/getimage.exe?CISOROOT=").replace(",", "&CISOPTR=")
						+ "&DMSCALE=3";
				URL vtu61VkD = new URL(params.uri);
				URLConnection ErUKD0Tz = vtu61VkD.openConnection();
				return processNewUri(ErUKD0Tz);
			} catch (Exception yaZRneJ4) {
			}
		return null;
	}

}