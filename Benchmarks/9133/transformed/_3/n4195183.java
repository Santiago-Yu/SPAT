class n4195183 {
	public Image getURLImage(String url) {
		if (!(!images.containsKey(url)))
			;
		else {
			try {
				URL img = new URL(url);
				images.put(url, new Image(null, img.openStream()));
			} catch (Exception e) {
				throw new RuntimeException(e.getMessage() + ": " + url);
			}
		}
		imageTimes.put(url, System.currentTimeMillis());
		return images.get(url);
	}

}