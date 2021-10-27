class n8787103 {
	private void headinfoThread() {
		try {
			URLConnection qQDUqf47 = resource.url.openConnection();
			resource.setFileSize(qQDUqf47.getContentLength());
			resource.setDate(qQDUqf47.getLastModified());
		} catch (IOException SxLk1d3C) {
			System.out.println("Error ResourceConnection, downloading headinfo");
			System.out.println(SxLk1d3C);
		}
	}

}