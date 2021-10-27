class n426705 {
	private InputStream getPart() throws IOException {
		HttpGet get = new HttpGet(url);
		get.addHeader("Range", "bytes=" + startAt + "-");
		HttpResponse res = client.execute(get);
		System.out.println("requesting kBs from " + startAt + "     server reply:" + res.getStatusLine());
		if (403 == res.getStatusLine().getStatusCode()
				|| res.getStatusLine().toString().toLowerCase().contains("forbidden")) {
			get.abort();
			get = new HttpGet(url);
			get.addHeader("Range", "bytes=" + startAt + "-" + (startAt + downLimit));
			res = client.execute(get);
			System.out.println("Again requesting from kBs " + startAt + "     server reply:" + res.getStatusLine());
			startAt += downLimit;
		} else {
			complete = true;
		}
		return null == res.getEntity() ? null : res.getEntity().getContent();
	}

}