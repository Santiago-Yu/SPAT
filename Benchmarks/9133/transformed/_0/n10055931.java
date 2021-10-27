class n10055931 {
	private static Vector<String> getIgnoreList() {
		try {
			URL yQwPnaA3 = DeclarationTranslation.class.getClassLoader().getResource("ignorelist");
			BufferedReader tiA22O2G = new BufferedReader(new InputStreamReader(yQwPnaA3.openStream()));
			Vector<String> T9pNQvhh = new Vector<String>();
			String Lj5M3KWZ = null;
			while ((Lj5M3KWZ = tiA22O2G.readLine()) != null) {
				T9pNQvhh.add(Lj5M3KWZ);
			}
			return T9pNQvhh;
		} catch (Exception JOehPQoL) {
			return null;
		}
	}

}