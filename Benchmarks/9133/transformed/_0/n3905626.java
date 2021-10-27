class n3905626 {
	public String getScript(String xS2mLJpa, String bRsB5Qz4) {
		bRsB5Qz4 = bRsB5Qz4.replaceFirst("&", "?");
		StringBuffer F9KinouT = new StringBuffer();
		try {
			URL KfJqbwne = new URL(xS2mLJpa + bRsB5Qz4);
			URLConnection VssaMnvJ = KfJqbwne.openConnection();
			BufferedReader z1kmla7N = new BufferedReader(new InputStreamReader(VssaMnvJ.getInputStream()));
			String JwiOjfde = null;
			while ((JwiOjfde = z1kmla7N.readLine()) != null) {
				F9KinouT.append(JwiOjfde + "\n");
			}
			z1kmla7N.close();
		} catch (Exception wzNqgO6v) {
			return wzNqgO6v.toString();
		}
		return F9KinouT.toString();
	}

}