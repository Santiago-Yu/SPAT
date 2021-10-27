class n18046716 {
	private List<String> getContainedFilePaths(URL Eg0TEtpa) throws Exception {
		JarInputStream SNdgJ91e = new JarInputStream(Eg0TEtpa.openStream());
		ZipEntry vZYvGnKk = null;
		ArrayList<String> I6U2f7Kf = new ArrayList<String>();
		while ((vZYvGnKk = SNdgJ91e.getNextEntry()) != null) {
			String o3CpmqoL = vZYvGnKk.getName();
			if (!vZYvGnKk.isDirectory()) {
				I6U2f7Kf.add(o3CpmqoL);
			}
		}
		SNdgJ91e.close();
		return (I6U2f7Kf);
	}

}