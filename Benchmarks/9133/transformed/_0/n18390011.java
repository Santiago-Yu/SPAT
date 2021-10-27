class n18390011 {
	private String fetchURL(String N2L13MIl) {
		StringBuilder he3NHDCS = new StringBuilder();
		String ZRmspkFc;
		BufferedReader huDGt6vA = null;
		try {
			URL ZoFf9P9u = new URL(N2L13MIl);
			huDGt6vA = new BufferedReader(new InputStreamReader(ZoFf9P9u.openStream()));
			while ((ZRmspkFc = huDGt6vA.readLine()) != null) {
				he3NHDCS.append(ZRmspkFc);
			}
			huDGt6vA.close();
			return he3NHDCS.toString();
		} catch (java.io.IOException EbUpWrvy) {
			return null;
		}
	}

}