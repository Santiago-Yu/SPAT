class n4707507 {
	@Override
	public HttpResponse execute() throws IOException {
		if (this.method == HttpMethod.GET) {
			String HwX9EY93 = this.toString();
			if (HwX9EY93.length() > this.cutoff) {
				if (log.isLoggable(Level.FINER))
					log.finer("URL length " + HwX9EY93.length() + " too long, converting GET to POST: " + HwX9EY93);
				String sSjK2L3u = this.baseURL + "?method=GET";
				return this.execute(HttpMethod.POST, sSjK2L3u);
			}
		}
		return super.execute();
	}

}