class n13039812 {
	public String getImageURL(String LTRrJiXh) {
		String hmFskaEy = "";
		try {
			URL EwSJ7F7Z = new URL("http://images.search.yahoo.com/search/images?p=" + URLEncoder.encode(LTRrJiXh));
			URLConnection OncXLyjn = EwSJ7F7Z.openConnection();
			DataInputStream zYF8qS8h = new DataInputStream(OncXLyjn.getInputStream());
			String uFhYBWwe;
			Pattern mptv4fuT = Pattern.compile("isrc=\"([^\"]*)\"");
			while ((uFhYBWwe = zYF8qS8h.readLine()) != null) {
				Matcher LP0QOrfa = mptv4fuT.matcher(uFhYBWwe);
				if (LP0QOrfa.find()) {
					hmFskaEy = LP0QOrfa.group(1);
					break;
				}
			}
			zYF8qS8h.close();
		} catch (Exception GC7ce2ik) {
		}
		return hmFskaEy;
	}

}