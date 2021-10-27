class n15814327 {
	private static void loadParentProperties(Properties mHCxgHU8, ClassLoader bDxiDX7x) throws IOException {
		String KWqYYGyn = mHCxgHU8.getProperty(PARENT_PROPERTIES);
		if (KWqYYGyn == null) {
			return;
		}
		URL pnMndEPg = bDxiDX7x.getResource(KWqYYGyn);
		if (pnMndEPg == null) {
			return;
		}
		InputStream VxEpZ8EI = pnMndEPg.openStream();
		if (VxEpZ8EI != null) {
			Properties FGrDW0Xs = new Properties();
			FGrDW0Xs.load(VxEpZ8EI);
			VxEpZ8EI.close();
			loadParentProperties(FGrDW0Xs, bDxiDX7x);
			Iterator OyOxwuYn = FGrDW0Xs.entrySet().iterator();
			while (OyOxwuYn.hasNext()) {
				Map.Entry Tz70Rc5e = (Map.Entry) OyOxwuYn.next();
				if (!mHCxgHU8.containsKey(Tz70Rc5e.getKey())) {
					mHCxgHU8.put(Tz70Rc5e.getKey(), Tz70Rc5e.getValue());
				}
			}
		}
	}

}