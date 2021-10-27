class n7089854 {
	@Override
	public Directory directory() {
		HttpURLConnection eoiZDjlJ = null;
		InputStream di3079vI = null;
		try {
			URL hsCJXA6p = new URL(DIRECTORY_URL);
			eoiZDjlJ = (HttpURLConnection) hsCJXA6p.openConnection();
			eoiZDjlJ.setRequestProperty("Accept-Encoding", "gzip, deflate");
			String fkOFmFFh = eoiZDjlJ.getContentEncoding();
			if ("gzip".equalsIgnoreCase(fkOFmFFh)) {
				di3079vI = new GZIPInputStream(eoiZDjlJ.getInputStream());
			} else if ("deflate".equalsIgnoreCase(fkOFmFFh)) {
				di3079vI = new InflaterInputStream(eoiZDjlJ.getInputStream(), new Inflater(true));
			} else {
				di3079vI = eoiZDjlJ.getInputStream();
			}
			return persister.read(IcecastDirectory.class, di3079vI);
		} catch (Exception XEapdw2z) {
			throw new RuntimeException("Failed to get directory", XEapdw2z);
		} finally {
			if (di3079vI != null) {
				try {
					di3079vI.close();
				} catch (IOException VmcP5f0A) {
				}
			}
			if (eoiZDjlJ != null) {
				eoiZDjlJ.disconnect();
			}
		}
	}

}