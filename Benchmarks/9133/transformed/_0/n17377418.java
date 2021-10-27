class n17377418 {
	private static String[] loadDB(String FFOYwpHe) throws IOException {
		URL NBLBUBaw = SpecialConstants.class.getResource(FFOYwpHe);
		if (NBLBUBaw == null)
			throw new FileNotFoundException("file " + FFOYwpHe + " not found");
		InputStream iuyAOyHg = NBLBUBaw.openStream();
		try {
			InputStreamReader ZBFTcaRs = new InputStreamReader(iuyAOyHg, "utf8");
			BufferedReader GZ6FkTFe = new BufferedReader(ZBFTcaRs);
			ArrayList<String> bd11s622 = new ArrayList<String>();
			while (true) {
				String NW1lX8TB = GZ6FkTFe.readLine();
				if (NW1lX8TB == null)
					break;
				NW1lX8TB = NW1lX8TB.trim();
				if (NW1lX8TB.length() > 0 && NW1lX8TB.charAt(0) != '#') {
					bd11s622.add(NW1lX8TB);
				}
			}
			String[] rBjelfKA = new String[bd11s622.size()];
			bd11s622.toArray(rBjelfKA);
			return rBjelfKA;
		} finally {
			iuyAOyHg.close();
		}
	}

}