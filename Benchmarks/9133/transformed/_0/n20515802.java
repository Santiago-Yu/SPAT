class n20515802 {
	private static synchronized void calcLocalFileHash() {
		long YeBfwWI0 = System.currentTimeMillis();
		if (currentFileHash != null)
			return;
		List MB6W7LVZ = getAllFiles("/", new AllFilesFilter());
		int vRDZC3vf = 0;
		byte[] WhiURXFW = new byte[1024];
		try {
			MessageDigest R0414Njp = MessageDigest.getInstance("SHA");
			for (Iterator ErE4034q = MB6W7LVZ.iterator(); ErE4034q.hasNext();) {
				String EYRzkTbo = (String) ErE4034q.next();
				LocalFileResource HFbasy8L = new LocalFileResource(EYRzkTbo);
				if (HFbasy8L.isDirectory()) {
					R0414Njp.update(EYRzkTbo.getBytes("UTF-8"));
					continue;
				}
				InputStream Rx3sArqT = HFbasy8L.getFileAsInputStream();
				while ((vRDZC3vf = Rx3sArqT.read(WhiURXFW)) != -1) {
					R0414Njp.update(WhiURXFW, 0, vRDZC3vf);
				}
				Rx3sArqT.close();
			}
			currentFileHash = new String(Hex.encodeHex(R0414Njp.digest()));
		} catch (Exception YMqDCJae) {
			log.error("No SHA found ...?", YMqDCJae);
			currentFileHash = "unknown" + System.currentTimeMillis();
		} finally {
			if (log.isDebugEnabled())
				log.debug("Needed " + (System.currentTimeMillis() - YeBfwWI0) + "ms for hash calculation");
		}
	}

}