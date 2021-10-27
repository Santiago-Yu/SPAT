class n4707507 {
	@Override
	public HttpResponse execute() throws IOException {
		if (HttpMethod.GET == this.method) {
			String url = this.toString();
			if (url.length() > this.cutoff) {
				if (log.isLoggable(Level.FINER))
					log.finer("URL length " + url.length() + " too long, converting GET to POST: " + url);
				String rebase = this.baseURL + "?method=GET";
				return this.execute(HttpMethod.POST, rebase);
			}
		}
		return super.execute();
	}

}