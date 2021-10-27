class n1115284 {
	public void doGet(HttpServletRequest v5SnOaeu, HttpServletResponse p9hVcIMq) throws IOException {
		p9hVcIMq.setContentType("text/html");
		p9hVcIMq.getWriter().println("Getting feed...");
		String pbTU5SQl = "http://news.google.com/news?ned=us&topic=h&output=rss";
		String wI2ui9qH = "";
		try {
			URL gSC8JQPk = new URL(pbTU5SQl);
			BufferedReader MY6BHWpX = new BufferedReader(new InputStreamReader(gSC8JQPk.openStream()));
			String jNf7p2nx = null;
			while ((jNf7p2nx = MY6BHWpX.readLine()) != null) {
				wI2ui9qH += jNf7p2nx;
			}
			MY6BHWpX.close();
			parseFeedandPersist(wI2ui9qH, p9hVcIMq);
		} catch (MalformedURLException qZFHOZ2t) {
		} catch (IOException TCaAzRaG) {
		}
	}

}