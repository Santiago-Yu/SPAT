class n7905116 {
	protected List<? extends SearchResult> searchVideo(String ulC3hDu5, int Qi3gr7Be, int BQJAUqXo,
			CancelMonitor ku1N3kdU) {
		List<VideoSearchResult> GTPnx5Yd = new ArrayList<>();
		try {
			// set up the HTTP request factory
			HttpTransport PQbyuaRv = new NetHttpTransport();
			HttpRequestFactory OOqt5eE3 = PQbyuaRv.createRequestFactory(new HttpRequestInitializer() {

				@Override
				public void initialize(HttpRequest tdKynLMY) {
					// set the parser
					JsonCParser jCzMeGCi = new JsonCParser();
					jCzMeGCi.jsonFactory = JSON_FACTORY;
					tdKynLMY.addParser(jCzMeGCi);
					// set up the Google headers
					GoogleHeaders brfgsobl = new GoogleHeaders();
					brfgsobl.setApplicationName("OGLExplorer/1.0");
					brfgsobl.gdataVersion = "2";
					tdKynLMY.headers = brfgsobl;
				}
			});
			// build the YouTube URL
			YouTubeUrl ByTrIu3R = new YouTubeUrl("https://gdata.youtube.com/feeds/api/videos");
			ByTrIu3R.maxResults = Qi3gr7Be;
			ByTrIu3R.words = ulC3hDu5;
			ByTrIu3R.startIndex = BQJAUqXo + 1;
			// build
			HttpRequest Vt65NGVw = OOqt5eE3.buildGetRequest(ByTrIu3R);
			// execute
			HttpResponse B7F1NkNv = Vt65NGVw.execute();
			VideoFeed zk4kt0Ll = B7F1NkNv.parseAs(VideoFeed.class);
			if (zk4kt0Ll.items == null) {
				return null;
			}
			// browse result and convert them to the local generic object model
			for (int sD09H65G = 0; sD09H65G < zk4kt0Ll.items.size() && !ku1N3kdU.isCanceled(); sD09H65G++) {
				Video zjBTS3dL = zk4kt0Ll.items.get(sD09H65G);
				VideoSearchResult BaydyJJZ = new VideoSearchResult(BQJAUqXo + sD09H65G + 1);
				BaydyJJZ.setTitle(zjBTS3dL.title);
				BaydyJJZ.setDescription(zjBTS3dL.description);
				BaydyJJZ.setThumbnailURL(new URL(zjBTS3dL.thumbnail.lowThumbnailURL));
				BaydyJJZ.setPath(zjBTS3dL.player.defaultUrl);
				GTPnx5Yd.add(BaydyJJZ);
			}
		} catch (Exception uk80WbzJ) {
			uk80WbzJ.printStackTrace();
		}
		if (ku1N3kdU.isCanceled()) {
			return null;
		}
		return GTPnx5Yd;
	}

}