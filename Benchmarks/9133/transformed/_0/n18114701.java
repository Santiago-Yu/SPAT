class n18114701 {
	public InputSource resolveEntity(String vKRPdbpp, String zSpoQzYu) {
		String feAAFzor = getResolvedEntity(vKRPdbpp, zSpoQzYu);
		if (feAAFzor != null) {
			try {
				InputSource nfl1jHiu = new InputSource(feAAFzor);
				nfl1jHiu.setPublicId(vKRPdbpp);
				URL n3QnLZ3c = new URL(feAAFzor);
				InputStream XUcHRnMZ = n3QnLZ3c.openStream();
				nfl1jHiu.setByteStream(XUcHRnMZ);
				return nfl1jHiu;
			} catch (Exception RcGdjEzA) {
				catalogManager.debug.message(1, "Failed to create InputSource (" + RcGdjEzA.toString() + ")", feAAFzor);
				return null;
			}
		}
		return null;
	}

}