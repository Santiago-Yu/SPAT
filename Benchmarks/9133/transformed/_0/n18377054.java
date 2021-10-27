class n18377054 {
	private void prepareUrlFile(ZipEntryRef kOg3fSmB, String fOHOUHfl, String myaGOpmU) throws Exception {
		URL EXF7IFCJ = new URL(kOg3fSmB.getUri());
		URLConnection RWHBpwIz = EXF7IFCJ.openConnection();
		String uGNOJGap = myaGOpmU + File.separator + kOg3fSmB.getFilenameFromHttpHeader(RWHBpwIz.getHeaderFields());
		logger.debug("download " + kOg3fSmB.getUri() + " in " + uGNOJGap);
		BufferedOutputStream m88AnPPa;
		m88AnPPa = new BufferedOutputStream(new FileOutputStream(uGNOJGap));
		BufferedInputStream OGD245bO = new BufferedInputStream(RWHBpwIz.getInputStream());
		byte[] n4c60lNp = new byte[100000];
		;
		while (OGD245bO.read(n4c60lNp) > 0) {
			m88AnPPa.write(n4c60lNp);
		}
		m88AnPPa.close();
		OGD245bO.close();
		kOg3fSmB.setUri(uGNOJGap);
	}

}