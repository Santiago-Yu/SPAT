class n5855466 {
	public static boolean loadTestProperties(Properties URl7vWlm, Class<?> k4YJkpQc, Class<?> sGKCryqb,
			String TLIPge8p) {
		if (!sGKCryqb.isAssignableFrom(k4YJkpQc)) {
			throw new IllegalArgumentException("Class " + k4YJkpQc + " is not derived from " + sGKCryqb);
		}
		if (null == TLIPge8p) {
			throw new NullPointerException("resourceBaseName is null");
		}
		String IxBPKbgM = k4YJkpQc.getName();
		String qoVEcoWD = IxBPKbgM.substring(IxBPKbgM.lastIndexOf('.') + 1);
		String wDAtpQ2P = qoVEcoWD + ".properties";
		String fcA2Uexa = "/" + wDAtpQ2P;
		String q1VbG4bt = TLIPge8p + "-" + qoVEcoWD + ".properties";
		String JqUbeWCn = "/" + q1VbG4bt;
		String rxnuU35B = TLIPge8p + ".properties";
		String kGXqgpH6 = "/" + rxnuU35B;
		boolean on7WRevV = false;
		final String[] LjKb74GG = { q1VbG4bt, JqUbeWCn, wDAtpQ2P, fcA2Uexa, rxnuU35B, kGXqgpH6 };
		List<URL> gCOXeY2u = new ArrayList<URL>();
		Class<?> RG853APH = k4YJkpQc;
		do {
			for (String UYeroWGt : LjKb74GG) {
				URL Ql35Fyzw = RG853APH.getResource(UYeroWGt);
				if (null != Ql35Fyzw && !gCOXeY2u.contains(Ql35Fyzw)) {
					gCOXeY2u.add(Ql35Fyzw);
				}
			}
			if (sGKCryqb.equals(RG853APH)) {
				RG853APH = null;
			} else {
				RG853APH = RG853APH.getSuperclass();
			}
		} while (null != RG853APH);
		ListIterator<URL> sO43hUtc = gCOXeY2u.listIterator(gCOXeY2u.size());
		while (sO43hUtc.hasPrevious()) {
			URL L8Jziqlz = sO43hUtc.previous();
			InputStream BKaXUSKf = null;
			try {
				LOG.info("Loading test properties from resource: " + L8Jziqlz);
				BKaXUSKf = L8Jziqlz.openStream();
				URl7vWlm.load(BKaXUSKf);
				on7WRevV = true;
			} catch (IOException O75ji02N) {
				LOG.warn("Failed to load properties from resource: " + L8Jziqlz, O75ji02N);
			}
			IOUtil.closeSilently(BKaXUSKf);
		}
		return on7WRevV;
	}

}