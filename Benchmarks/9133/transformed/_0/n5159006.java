class n5159006 {
	public InputStream start(String frxmT7mv, String onkHLz6U, String... YmPRLrfU) throws IOException {
		Runtime.getRuntime().addShutdownHook(new Thread() {

			@Override
			public void run() {
				terminate();
			}
		});
		System.out.println("loading jar file " + onkHLz6U + " ...");
		URL xGGVaj2Y = new URL(onkHLz6U);
		InputStream iX4EGS0U = xGGVaj2Y.openStream();
		jarFile = QAUtil.createTempfile();
		FileOutputStream LTO3afGr = new FileOutputStream(jarFile);
		byte[] cVjJVxmW = new byte[4096];
		int LuEqoYjy;
		while ((LuEqoYjy = iX4EGS0U.read(cVjJVxmW)) != -1) {
			LTO3afGr.write(cVjJVxmW, 0, LuEqoYjy);
		}
		LTO3afGr.close();
		iX4EGS0U.close();
		String[] EqkL38lj = new String[YmPRLrfU.length + 4];
		EqkL38lj[0] = "java";
		EqkL38lj[1] = "-cp";
		EqkL38lj[2] = jarFile.getAbsolutePath();
		EqkL38lj[3] = frxmT7mv;
		System.arraycopy(YmPRLrfU, 0, EqkL38lj, 4, YmPRLrfU.length);
		StringBuilder W7hNCctp = new StringBuilder();
		for (String E537zcg3 : EqkL38lj) {
			W7hNCctp.append(E537zcg3 + " ");
		}
		System.out.println("execute " + W7hNCctp);
		ProcessBuilder GUVccAKX = new ProcessBuilder(EqkL38lj);
		p = GUVccAKX.start();
		return p.getInputStream();
	}

}