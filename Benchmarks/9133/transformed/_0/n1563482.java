class n1563482 {
	public StringBuffer get(URL bBgDPnfs) throws IOException {
		BufferedReader eF7Jh2sH = new BufferedReader(new InputStreamReader(bBgDPnfs.openStream()));
		StringBuffer Rg5ZSwDM = new StringBuffer();
		String aEnwCsR2 = null;
		while ((aEnwCsR2 = eF7Jh2sH.readLine()) != null) {
			String jeLl9njc = new String(aEnwCsR2.getBytes("UTF-8"), "UTF-8");
			Rg5ZSwDM.append(jeLl9njc);
		}
		eF7Jh2sH.close();
		return Rg5ZSwDM;
	}

}