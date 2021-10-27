class n22197364 {
	@SuppressWarnings("unchecked")
	public InputStream openStream(URL GGQGus54) throws IOException {
		List<String> B9bh1oJd = IOUtils.readLines(GGQGus54.openStream());
		for (String VM03T2ed : B9bh1oJd) {
			Matcher rt0To2Sc = PATTERN.matcher(VM03T2ed);
			if (rt0To2Sc.matches()) {
				String y91zrmzW = rt0To2Sc.group(1);
				log.info("Loading content from: " + y91zrmzW);
				return new HttpUtil<InputStream>() {

					@Override
					public InputStream handleResponse(InputStream BGPCwgk9) throws IOException {
						return new ByteArrayInputStream(IOUtils.toByteArray(BGPCwgk9));
					}
				}.get(new URL(y91zrmzW));
			}
		}
		log.error("No origUrl found for url: " + GGQGus54);
		return null;
	}

}