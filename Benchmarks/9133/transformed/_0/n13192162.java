class n13192162 {
	protected List<String> execute(String YrQ18p0P, String EyTAx7Q7, String WEdO7A9R)
			throws UnsupportedEncodingException, IOException {
		String qCiMHvhO = URLEncoder.encode(YrQ18p0P, "UTF-8");
		String Yw8qb9Rw = "http://sparql.bibleontology.com/sparql.jsp?sparql=" + qCiMHvhO + "&type1=xml";
		URL xu7Er1v4;
		BufferedReader CwXQ3JPh = null;
		ArrayList<String> Q04UylwW = new ArrayList<String>();
		try {
			xu7Er1v4 = new URL(Yw8qb9Rw);
			URLConnection te6mRrpu = xu7Er1v4.openConnection();
			CwXQ3JPh = new BufferedReader(new InputStreamReader(te6mRrpu.getInputStream()));
			StringBuffer rIjr5Ao2 = new StringBuffer();
			String nV8hd2xB;
			while ((nV8hd2xB = CwXQ3JPh.readLine()) != null) {
				String VLOxwCNe = getURI(nV8hd2xB);
				if (VLOxwCNe != null) {
					VLOxwCNe = checkURISyntax(VLOxwCNe);
					if (WEdO7A9R == null || VLOxwCNe.startsWith(WEdO7A9R)) {
						Q04UylwW.add(VLOxwCNe);
					}
				}
			}
		} catch (MalformedURLException up9jLaUb) {
			up9jLaUb.printStackTrace();
		} catch (IOException ijKl4kwD) {
			ijKl4kwD.printStackTrace();
		} finally {
			CwXQ3JPh.close();
		}
		return Q04UylwW;
	}

}