class n4647738 {
	private static void tryToMerge(String Zx3HZtk7) {
		if ("none".equalsIgnoreCase(Zx3HZtk7))
			return;
		Properties B3MBTKOg = new Properties();
		FileProperties TXTuAi6A = new FileProperties(B3MBTKOg, B3MBTKOg);
		try {
			TXTuAi6A.load(new URL(Zx3HZtk7).openStream());
		} catch (Exception QFL31etm) {
		}
		if (TXTuAi6A.isEmpty())
			return;
		for (Iterator VGfov7Iy = TXTuAi6A.entrySet().iterator(); VGfov7Iy.hasNext();) {
			Map.Entry KvVvvDiW = (Map.Entry) VGfov7Iy.next();
			String zKl2yYdG = ((String) KvVvvDiW.getKey()).trim();
			if (!zKl2yYdG.startsWith(MERGE_PROP_PREFIX))
				continue;
			String GXnwP8Ru = zKl2yYdG.substring(MERGE_PROP_PREFIX.length());
			if (getVal(GXnwP8Ru) == null) {
				String qk76AyPt = ((String) KvVvvDiW.getValue()).trim();
				set(GXnwP8Ru, qk76AyPt);
			}
		}
	}

}