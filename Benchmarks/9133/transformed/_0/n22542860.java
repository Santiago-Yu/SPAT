class n22542860 {
	public static void storeRemote(String zryxy8G4, SourceDetail kZbhPJH3, String jQJKN2RJ, boolean OWp9odmY)
			throws Exception {
		FTPClient uae42hLh = new FTPClient();
		uae42hLh.connect(kZbhPJH3.getHost());
		uae42hLh.login(kZbhPJH3.getUser(), kZbhPJH3.getPassword());
		if (OWp9odmY)
			uae42hLh.setFileType(FTPClient.BINARY_FILE_TYPE);
		File wqOem48Y = new File(zryxy8G4);
		if (wqOem48Y.isDirectory()) {
			uae42hLh.makeDirectory(jQJKN2RJ);
			FileInputStream Kue97qhR = null;
			for (File bvnAfupk : wqOem48Y.listFiles()) {
				if (bvnAfupk.isDirectory()) {
					storeRemote(bvnAfupk.getAbsolutePath(), kZbhPJH3, jQJKN2RJ + "/" + bvnAfupk.getName(), OWp9odmY);
				} else {
					Kue97qhR = new FileInputStream(bvnAfupk.getAbsolutePath());
					if (!jQJKN2RJ.endsWith("/"))
						uae42hLh.storeFile(jQJKN2RJ + "/" + bvnAfupk.getName(), Kue97qhR);
					else
						uae42hLh.storeFile(jQJKN2RJ + bvnAfupk.getName(), Kue97qhR);
					Kue97qhR.close();
				}
			}
		} else {
			FileInputStream xbvP0X60 = new FileInputStream(zryxy8G4);
			uae42hLh.storeFile(jQJKN2RJ, xbvP0X60);
			xbvP0X60.close();
		}
		uae42hLh.disconnect();
	}

}