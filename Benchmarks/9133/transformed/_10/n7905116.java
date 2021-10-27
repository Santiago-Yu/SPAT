class n7905116 {
	protected List<? extends SearchResult> searchVideo(String words, int number, int offset,
			CancelMonitor cancelMonitor) {
		List<VideoSearchResult> resultsList = new ArrayList<>();
		try {
			// set up the HTTP request factory
			HttpTransport transport = new NetHttpTransport();
			YouTubeUrl url = new YouTubeUrl("https://gdata.youtube.com/feeds/api/videos");
			HttpRequestFactory factory = transport.createRequestFactory(new HttpRequestInitializer() {
				@Override
				public void initialize(HttpRequest request) {
					JsonCParser parser = new JsonCParser();
					parser.jsonFactory = JSON_FACTORY;
					request.addParser(parser);
					GoogleHeaders headers = new GoogleHeaders();
					headers.setApplicationName("OGLExplorer/1.0");
					headers.gdataVersion = "2";
					request.headers = headers;
				}
			});
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
			// browse result and convert them to the local generic object model
			for (int i = 0; i < feed.items.size() && !cancelMonitor.isCanceled(); i++) {
				Video result = feed.items.get(i);
				VideoSearchResult modelResult = new VideoSearchResult(offset + i + 1);
				modelResult.setTitle(result.title);
				modelResult.setDescription(result.description);
				modelResult.setThumbnailURL(new URL(result.thumbnail.lowThumbnailURL));
				modelResult.setPath(result.player.defaultUrl);
				resultsList.add(modelResult);
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