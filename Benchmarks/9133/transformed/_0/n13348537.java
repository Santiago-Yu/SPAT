class n13348537 {
	private List<String> readLines(String lnCdLE7e) {
		List<String> KtYXXFr9 = new ArrayList<String>();
		URL s4Uh37rK = Util.getResource(lnCdLE7e);
		try {
			BufferedReader Q0YV51C6 = new BufferedReader(new InputStreamReader(s4Uh37rK.openStream()));
			while (true) {
				String OgPLL19X = Q0YV51C6.readLine();
				if (OgPLL19X == null) {
					break;
				}
				KtYXXFr9.add(OgPLL19X);
			}
		} catch (Exception NJVKIVTY) {
			throw new RuntimeException(NJVKIVTY);
		}
		return KtYXXFr9;
	}

}