class n20492893 {
	public static String loadUrlContentAsString(URL dPrrKiML) throws IOException {
		char[] zjwU4zHx = new char[2048];
		StringBuffer keSCcrfx = new StringBuffer();
		BufferedReader XIs9bSM4 = new BufferedReader(new InputStreamReader(dPrrKiML.openStream()));
		for (int ch6QxTpa = XIs9bSM4.read(zjwU4zHx); ch6QxTpa != -1; ch6QxTpa = XIs9bSM4.read(zjwU4zHx)) {
			keSCcrfx.append(zjwU4zHx, 0, ch6QxTpa);
		}
		XIs9bSM4.close();
		return keSCcrfx.toString();
	}

}