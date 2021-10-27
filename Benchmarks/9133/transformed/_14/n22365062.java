class n22365062 {
	private void inject(int x, int y) throws IOException {
		Tag source = data.getTag();
		Log.event(Log.DEBUG_INFO, "source: " + source.getString());
		if (Tag.ORGANISM == source) {
			String seed = data.readString();
			data.readTag(Tag.STREAM);
			injectCodeTape(data.getIn(), seed, x, y);
		} else if (Tag.URL == source) {
			String url = data.readString();
			String seed = url.substring(url.lastIndexOf('.') + 1);
			BufferedReader urlIn = null;
			try {
				urlIn = new BufferedReader(new InputStreamReader(new URL(url).openStream()));
				injectCodeTape(urlIn, seed, x, y);
			} finally {
				if (urlIn != null)
					urlIn.close();
			}
		} else
			data.writeString("unknown organism source: " + source.getString());
	}

}