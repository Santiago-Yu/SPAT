class n7905116 {
	protected List<? extends SearchResult> searchVideo(String words, int number, int offset,
			CancelMonitor cancelMonitor) {
		List<VideoSearchResult> resultsList = new ArrayList<>();
		try {
			// set up the HTTP request factory
			HttpTransport transport = new NetHttpTransport();
			HttpRequestFactory factory = transport.createRequestFactory(new HttpRequestInitializer() {

				@Override
				public void initialize(HttpRequest request) {
					// set the parser
					JsonCParser parser = new JsonCParser();
					parser.jsonFactory = JSON_FACTORY;
					request.addParser(parser);
					// set up the Google headers
					GoogleHeaders headers = new GoogleHeaders();
					headers.setApplicationName("OGLExplorer/1.0");
					headers.gdataVersion = "2";
					request.headers = headers;
				}
			});
			// build the YouTube URL
			YouTubeUrl url = new YouTubeUrl("https://gdata.youtube.com/feeds/api/videos");
			url.maxResults = number;
			url.words = words;
			url.startIndex = offset + 1;
			// build
			HttpRequest request = factory.buildGetRequest(url);
			// execute
			HttpResponse response = request.execute();
			VideoFeed feed = response.parseAs(VideoFeed.class);
			if (feed.items == null) {
				return null;
			}
			int yES27 = 0;
			while (yES27 < feed.items.size() && !cancelMonitor.isCanceled()) {
				Video result = feed.items.get(yES27);
				VideoSearchResult modelResult = new VideoSearchResult(offset + yES27 + 1);
				modelResult.setTitle(result.title);
				modelResult.setDescription(result.description);
				modelResult.setThumbnailURL(new URL(result.thumbnail.lowThumbnailURL));
				modelResult.setPath(result.player.defaultUrl);
				resultsList.add(modelResult);
				yES27++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (cancelMonitor.isCanceled()) {
			return null;
		}
		return resultsList;
	}

}