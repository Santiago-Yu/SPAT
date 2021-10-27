class n426705 {
	private InputStream getPart() throws IOException {
		HttpGet get = new HttpGet(url);
		get.addHeader("Range", "bytes=" + startAt + "-");
		HttpResponse res = client.execute(get);
		System.out.println("requesting kBs from " + startAt + "     server reply:" + res.getStatusLine());
		if (res.getStatusLine().getStatusCode() == 403
				|| res.getStatusLine().toString().toLowerCase().contains("forbidden")) {
			get.abort();
			get = new HttpGet(url);
			get.addHeader("Range", "bytes=" + startAt + "-" + (startAt + downLimit));
			res = client.execute(get);
			System.out.println("Again requesting from kBs " + startAt + "     server reply:" + res.getStatusLine());
			startAt = startAt + (downLimit);
		} else {
			complete = true;
		}
		return res.getEntity() == null ? null : res.getEntity().getContent();
	}

}