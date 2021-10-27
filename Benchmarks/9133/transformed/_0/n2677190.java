class n2677190 {
	private boolean Try(URL fcwpcE9n, Metafile eJA8ZY4M) throws Throwable {
		InputStream gfCQkA4o = null;
		HttpURLConnection CAJAB5ea = null;
		boolean HrEofVO0 = false;
		try {
			CAJAB5ea = (HttpURLConnection) fcwpcE9n.openConnection();
			CAJAB5ea.setRequestMethod("GET");
			CAJAB5ea.connect();
			gfCQkA4o = CAJAB5ea.getInputStream();
			Response ytWOoAlc = new Response(gfCQkA4o);
			responses.add(ytWOoAlc);
			peers.addAll(ytWOoAlc.peers);
			Main.log.info("got " + ytWOoAlc.peers.size() + " peers from " + fcwpcE9n);
			HrEofVO0 = true;
		} finally {
			if (gfCQkA4o != null)
				gfCQkA4o.close();
			if (CAJAB5ea != null)
				CAJAB5ea.disconnect();
		}
		return HrEofVO0;
	}

}