class n3370624 {
	public void run() {
		try {
			HttpURLConnection cZUeLjir = (HttpURLConnection) url.openConnection();
			log.trace("passing in cookies: ", cookies);
			cZUeLjir.setRequestProperty("Cookie", cookies);
			cZUeLjir.getContent();
		} catch (Exception bblB1N05) {
			log.error(bblB1N05);
		}
	}

}