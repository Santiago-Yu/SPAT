class n426705 {
	private InputStream getPart() throws IOException {
		HttpGet BXuat23s = new HttpGet(url);
		BXuat23s.addHeader("Range", "bytes=" + startAt + "-");
		HttpResponse M4tKKMmA = client.execute(BXuat23s);
		System.out.println("requesting kBs from " + startAt + "     server reply:" + M4tKKMmA.getStatusLine());
		if (M4tKKMmA.getStatusLine().getStatusCode() == 403
				|| M4tKKMmA.getStatusLine().toString().toLowerCase().contains("forbidden")) {
			BXuat23s.abort();
			BXuat23s = new HttpGet(url);
			BXuat23s.addHeader("Range", "bytes=" + startAt + "-" + (startAt + downLimit));
			M4tKKMmA = client.execute(BXuat23s);
			System.out
					.println("Again requesting from kBs " + startAt + "     server reply:" + M4tKKMmA.getStatusLine());
			startAt += downLimit;
		} else {
			complete = true;
		}
		return M4tKKMmA.getEntity() == null ? null : M4tKKMmA.getEntity().getContent();
	}

}