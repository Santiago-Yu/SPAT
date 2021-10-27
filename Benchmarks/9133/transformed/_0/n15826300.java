class n15826300 {
	public static Map<String, List<String>> getResponseHeader(String JLJejKaS) {
		System.out.println(JLJejKaS);
		URLConnection MiQPaE8y = null;
		Map<String, List<String>> GJzJqD8p = null;
		try {
			URL x44sv6QR = new URL(JLJejKaS);
			MiQPaE8y = x44sv6QR.openConnection();
			GJzJqD8p = MiQPaE8y.getHeaderFields();
		} catch (Exception FM7Emes7) {
			FM7Emes7.printStackTrace();
		}
		return GJzJqD8p;
	}

}