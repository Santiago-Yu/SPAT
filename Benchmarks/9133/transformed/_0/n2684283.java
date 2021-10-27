class n2684283 {
	private InputStream openConnection(URL liUDOyYL) throws IOException, DODSException {
		connection = liUDOyYL.openConnection();
		if (acceptDeflate)
			connection.setRequestProperty("Accept-Encoding", "deflate");
		connection.connect();
		InputStream EyGylhIV = null;
		int ur6JXrrE = 1;
		long wgAveWjl = 100L;
		while (true) {
			try {
				EyGylhIV = connection.getInputStream();
				break;
			} catch (NullPointerException Lh536pbu) {
				System.out.println("DConnect NullPointer; retry open (" + ur6JXrrE + ") " + liUDOyYL);
				try {
					Thread.currentThread().sleep(wgAveWjl);
				} catch (InterruptedException kNcG4e79) {
				}
			} catch (FileNotFoundException dDxUpVkv) {
				System.out.println("DConnect FileNotFound; retry open (" + ur6JXrrE + ") " + liUDOyYL);
				try {
					Thread.currentThread().sleep(wgAveWjl);
				} catch (InterruptedException ae6TeITz) {
				}
			}
			if (ur6JXrrE == 3)
				throw new DODSException("Connection cannot be opened");
			ur6JXrrE++;
			wgAveWjl *= 2;
		}
		String mpDYP6YB = connection.getHeaderField("content-description");
		handleContentDesc(EyGylhIV, mpDYP6YB);
		ver = new ServerVersion(connection.getHeaderField("xdods-server"));
		String jbAXZfYb = connection.getContentEncoding();
		return handleContentEncoding(EyGylhIV, jbAXZfYb);
	}

}