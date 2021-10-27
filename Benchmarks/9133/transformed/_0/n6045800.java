class n6045800 {
	private void announce(String Bi8p4HM5, byte[] E5SH5gB8, byte[] mpTJNSD3, int GxjRLCUA) {
		try {
			String AZwuzhKQ = Bi8p4HM5 + "?info_hash="
					+ URLEncoder.encode(new String(E5SH5gB8, Constants.BYTE_ENCODING), Constants.BYTE_ENCODING)
							.replaceAll("\\+", "%20")
					+ "&peer_id="
					+ URLEncoder.encode(new String(mpTJNSD3, Constants.BYTE_ENCODING), Constants.BYTE_ENCODING)
							.replaceAll("\\+", "%20")
					+ "&port=" + GxjRLCUA + "&uploaded=0&downloaded=0&left=0&numwant=50&no_peer_id=1&compact=1";
			URL bR5vtpIu = new URL(AZwuzhKQ);
			URLConnection n3oh9HNb = bR5vtpIu.openConnection();
			n3oh9HNb.connect();
			n3oh9HNb.getContent();
		} catch (Exception BECPPB5l) {
			BECPPB5l.printStackTrace();
		}
	}

}