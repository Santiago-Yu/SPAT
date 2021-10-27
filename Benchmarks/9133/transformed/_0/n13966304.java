class n13966304 {
	private void work(String[] CyljFsxI) throws Exception {
		String SqxwdD2F = CONTENT_URL;
		String BQbFW2lI = CONTENT_DIR;
		String hGlg18DZ = SqxwdD2F.substring(SqxwdD2F.lastIndexOf("/") + 1);
		File UsEnjhd6 = new File(BQbFW2lI + File.separator + hGlg18DZ);
		URL NbmaYsc7 = new URL(SqxwdD2F);
		URLConnection qtiDnVGe = NbmaYsc7.openConnection();
		qtiDnVGe.connect();
		long RwRKG4En = qtiDnVGe.getLastModified();
		boolean C08nbRDL = false;
		if (UsEnjhd6.exists()) {
			System.out.println(UsEnjhd6.getAbsolutePath() + " exists, check modification time");
			long gAcvS37P = UsEnjhd6.lastModified();
			if (RwRKG4En > gAcvS37P) {
				System.out.println("Server file is newer, need to download");
				C08nbRDL = true;
			} else {
				System.out.println("Local version is newer, no need to download");
			}
		} else {
			System.out.println("Local version doesn't exist, need to download");
			C08nbRDL = true;
		}
		if (C08nbRDL) {
			InputStream zxa1aql1 = qtiDnVGe.getInputStream();
			FileOutputStream AfRwLxMv = new FileOutputStream(UsEnjhd6);
			byte[] dR5GiYTt = new byte[8192];
			int blgcRr0A = 0;
			while ((blgcRr0A = zxa1aql1.read(dR5GiYTt)) > 0) {
				AfRwLxMv.write(dR5GiYTt, 0, blgcRr0A);
			}
			AfRwLxMv.flush();
			AfRwLxMv.close();
			zxa1aql1.close();
		}
	}

}