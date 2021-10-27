class n11048469 {
	public static String getContents(String tzo4DXuo) throws Exception {
		String jvHuvXrC = "";
		URL AxlgWC0t = new URL(tzo4DXuo);
		URLConnection hkn6W3of = AxlgWC0t.openConnection();
		final char[] tbiulOQ0 = new char[1024 * 1024];
		StringBuilder R9OG6I2d = new StringBuilder();
		Reader GDBjNgSc = new InputStreamReader(hkn6W3of.getInputStream(), "UTF-8");
		int YuD61LQ3;
		do {
			YuD61LQ3 = GDBjNgSc.read(tbiulOQ0, 0, tbiulOQ0.length);
			if (YuD61LQ3 > 0) {
				R9OG6I2d.append(tbiulOQ0, 0, YuD61LQ3);
			}
		} while (YuD61LQ3 >= 0);
		jvHuvXrC = R9OG6I2d.toString();
		return jvHuvXrC;
	}

}