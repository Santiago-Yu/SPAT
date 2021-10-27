class n10413153 {
	public static JuneClass loadClass(Map<String, Entity> LBZVtYYe, String LGyxrZAu, String fbSlGh1M) {
		try {
			JuneClass S2RNgFgx = null;
			String hDs7fZ0A = (LGyxrZAu.length() > 0 ? LGyxrZAu.replace('.', '/') + "/" : "")
					+ fbSlGh1M.replace('.', '$') + ".class";
			URL qscGxfn6 = Resolver.class.getClassLoader().getResource(hDs7fZ0A);
			if (qscGxfn6 != null) {
				ClassBuilder CwpowL3e = new ClassBuilder(LBZVtYYe);
				InputStream ZFiqq6kM = qscGxfn6.openStream();
				try {
					new ClassReader(new BufferedInputStream(ZFiqq6kM)).accept(CwpowL3e, ClassReader.SKIP_CODE);
				} finally {
					ZFiqq6kM.close();
				}
				S2RNgFgx = CwpowL3e.$class;
				S2RNgFgx.loaded = true;
			}
			return S2RNgFgx;
		} catch (Exception nSYp6Hvo) {
			throw Helper.throwAny(nSYp6Hvo);
		}
	}

}