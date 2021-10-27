class n21566853 {
	public void readURL() throws Exception {
		URL doORp4Kx = new URL("http://www.google.com");
		URLConnection fsIxKOFB = doORp4Kx.openConnection();
		Map<String, List<String>> VEwZl8KM = fsIxKOFB.getHeaderFields();
		for (String H3sbD8Ri : VEwZl8KM.keySet()) {
			System.out.println(H3sbD8Ri + ": " + VEwZl8KM.get(H3sbD8Ri));
		}
		BufferedReader uD6Rfrat = new BufferedReader(new InputStreamReader(doORp4Kx.openStream()));
		String LE8D10mJ = uD6Rfrat.readLine();
		while (LE8D10mJ != null) {
			System.out.println(LE8D10mJ);
			LE8D10mJ = uD6Rfrat.readLine();
		}
		uD6Rfrat.close();
	}

}