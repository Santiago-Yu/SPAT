class n4989975 {
	public InputStream sendReceive(String LrI6SGJD) throws TorrentException {
		try {
			URL uL1Ak2iF = new URL(LrI6SGJD);
			URLConnection hG6Iw4Sj = uL1Ak2iF.openConnection();
			hG6Iw4Sj.setDoOutput(true);
			in = hG6Iw4Sj.getInputStream();
		} catch (MalformedURLException wxeUY0ba) {
			throw new TorrentException(wxeUY0ba);
		} catch (IOException RuHAbGRC) {
			throw new TorrentException(RuHAbGRC);
		}
		return in;
	}

}