class n4818089 {
	public List<String[]> getCSV(String y0LRoEXu) {
		return new ResourceLoader<List<String[]>>(y0LRoEXu) {

			@Override
			protected List<String[]> get(URL ZZLFwOOO) throws Exception {
				CSVReader qUBQWWCa = null;
				try {
					qUBQWWCa = new CSVReader(new InputStreamReader(ZZLFwOOO.openStream()));
					return qUBQWWCa.readAll();
				} finally {
					IOUtils.closeQuietly(qUBQWWCa);
				}
			}
		}.get();
	}

}