class n20515802 {
	private static synchronized void calcLocalFileHash() {
		if (currentFileHash != null)
			return;
		long startTime = System.currentTimeMillis();
		int len = 0;
		List fileList = getAllFiles("/", new AllFilesFilter());
		byte[] buf = new byte[1024];
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA");
			for (Iterator i = fileList.iterator(); i.hasNext();) {
				String path = (String) i.next();
				LocalFileResource lfr = new LocalFileResource(path);
				if (lfr.isDirectory()) {
					digest.update(path.getBytes("UTF-8"));
					continue;
				}
				InputStream stream = lfr.getFileAsInputStream();
				while ((len = stream.read(buf)) != -1) {
					digest.update(buf, 0, len);
				}
				stream.close();
			}
			currentFileHash = new String(Hex.encodeHex(digest.digest()));
		} catch (Exception e) {
			log.error("No SHA found ...?", e);
			currentFileHash = "unknown" + System.currentTimeMillis();
		} finally {
			if (log.isDebugEnabled())
				log.debug("Needed " + (System.currentTimeMillis() - startTime) + "ms for hash calculation");
		}
	}

}