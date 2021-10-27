class n7093300 {
	public static InputStream getRequest(String x79nhl1f) throws Exception {
		HttpGet xstDJI9o = new HttpGet(x79nhl1f);
		HttpResponse n5IvDBwR = sClient.execute(xstDJI9o);
		if (n5IvDBwR.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
			BufferedHttpEntity iFOe6qfm = new BufferedHttpEntity(n5IvDBwR.getEntity());
			return iFOe6qfm.getContent();
		} else {
			return null;
		}
	}

}