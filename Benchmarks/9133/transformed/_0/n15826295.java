class n15826295 {
	public static boolean isLinkHtmlContent(String gGa7olOP) {
		boolean Jl4kyhVE = false;
		URLConnection jaCtWw6D = null;
		try {
			if (!gGa7olOP.startsWith("http://")) {
				gGa7olOP = "http://" + gGa7olOP;
			}
			URL kCViU65d = new URL(gGa7olOP);
			jaCtWw6D = kCViU65d.openConnection();
			if (jaCtWw6D.getContentType().equals("text/html") && !jaCtWw6D.getHeaderField(0).contains("404")) {
				Jl4kyhVE = true;
			}
		} catch (Exception JPgH3aIW) {
			logger.error("Address attempted: " + jaCtWw6D.getURL());
			logger.error("Error Message: " + JPgH3aIW.getMessage());
		}
		return Jl4kyhVE;
	}

}