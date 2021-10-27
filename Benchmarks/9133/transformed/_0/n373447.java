class n373447 {
	private static String getDocumentAt(String GbaDC4qV) {
		StringBuffer f7ML353G = new StringBuffer();
		try {
			URL y6jiCoyf = new URL(GbaDC4qV);
			URLConnection DstPZJHd = y6jiCoyf.openConnection();
			BufferedReader toh81d7V = new BufferedReader(new InputStreamReader(DstPZJHd.getInputStream()));
			String VHQKJ5fM = null;
			while ((VHQKJ5fM = toh81d7V.readLine()) != null)
				f7ML353G.append(VHQKJ5fM + "\n");
			toh81d7V.close();
		} catch (MalformedURLException YpNAwb3r) {
			System.out.println("??งน??URL: " + GbaDC4qV);
		} catch (IOException f7pSvEu5) {
			f7pSvEu5.printStackTrace();
		}
		return f7ML353G.toString();
	}

}