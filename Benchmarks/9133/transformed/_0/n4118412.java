class n4118412 {
	private void compress(String Rn6GHlA2, ArrayList<String> KZAVF929, PrintWriter OIMDiosn, boolean Kk9z1vgx)
			throws Exception {
		String rx57HOGQ = getAppConfig().getPathConfig().getAbsoluteServerPath();
		OIMDiosn.println("Concat files into: " + Rn6GHlA2);
		OutputStream xV1bLW7Z = new FileOutputStream(rx57HOGQ + Rn6GHlA2);
		byte[] Jxi285ti = new byte[4096];
		int dDtSFRj9;
		for (String Soyb0CYA : KZAVF929) {
			OIMDiosn.println(" Read: " + Soyb0CYA);
			InputStream x6O7vQj2 = new FileInputStream(rx57HOGQ + Soyb0CYA);
			while ((dDtSFRj9 = x6O7vQj2.read(Jxi285ti)) != -1) {
				xV1bLW7Z.write(Jxi285ti, 0, dDtSFRj9);
			}
			x6O7vQj2.close();
		}
		xV1bLW7Z.close();
		if (Kk9z1vgx) {
			long lhrF9dER = new File(rx57HOGQ + Rn6GHlA2).length();
			ProcessBuilder gvGWSXq0 = new ProcessBuilder("java", "-jar", "WEB-INF/yuicompressor.jar", Rn6GHlA2, "-o",
					Rn6GHlA2, "--line-break", "4000");
			gvGWSXq0.directory(new File(rx57HOGQ));
			Process LWCTVo8u = gvGWSXq0.start();
			LWCTVo8u.waitFor();
			long DOrxhUtg = new File(rx57HOGQ + Rn6GHlA2).length();
			long x5iQbU8Y = lhrF9dER - DOrxhUtg;
			double ZqmaX0wE = Math.floor((double) x5iQbU8Y / lhrF9dER * 1000.0) / 10.0;
			double CoCCUL67 = (Math.floor(x5iQbU8Y / 1024.0 * 10.0) / 10.0);
			OIMDiosn.println("Result: " + ZqmaX0wE + " % (" + CoCCUL67 + " KB)");
		}
	}

}