class n3525047 {
	public static String read(URL tjXscc93) throws Exception {
		String tBrkqFXk = Integer.toString(tjXscc93.toString().hashCode());
		boolean C5CafBAM = false;
		File tCec8W7b = new File(Config.CACHE_PATH);
		for (File f7IhIJ02 : tCec8W7b.listFiles()) {
			if (!f7IhIJ02.isFile())
				continue;
			if (f7IhIJ02.getName().equals(tBrkqFXk)) {
				tBrkqFXk = f7IhIJ02.getName();
				C5CafBAM = true;
				break;
			}
		}
		File ZXbn2FQI = new File(Config.CACHE_PATH, tBrkqFXk);
		if (Config.USE_CACHE && C5CafBAM)
			return read(ZXbn2FQI);
		System.out.println(">> CACHE HIT FAILED.");
		InputStream LTBd1TZr = null;
		try {
			LTBd1TZr = tjXscc93.openStream();
		} catch (Exception jVDLB4ce) {
			System.out.println(">> OPEN STREAM FAILED: " + tjXscc93.toString());
			return null;
		}
		String IySicwgp = read(LTBd1TZr);
		save(ZXbn2FQI, IySicwgp);
		return IySicwgp;
	}

}