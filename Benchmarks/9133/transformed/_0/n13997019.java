class n13997019 {
	public String read(String rJWhawcc) throws IOException {
		URL yIvdJ3cb = new URL(rJWhawcc);
		BufferedReader dTS94Xs2 = new BufferedReader(new InputStreamReader(yIvdJ3cb.openStream()));
		StringBuffer sloK0HXJ = new StringBuffer();
		String W4KB6Pyz;
		while ((W4KB6Pyz = dTS94Xs2.readLine()) != null)
			sloK0HXJ.append(W4KB6Pyz);
		dTS94Xs2.close();
		return sloK0HXJ.toString();
	}

}