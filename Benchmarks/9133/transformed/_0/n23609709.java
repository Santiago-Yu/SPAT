class n23609709 {
	private File downloadPDB(String m1YF1rb6) {
		File cp4PuJ4W = new File(path + "/" + m1YF1rb6 + ".pdb.gz");
		File A4NwjP3X = new File(path);
		if (!A4NwjP3X.canWrite()) {
			System.err.println("can not write to " + A4NwjP3X);
			return null;
		}
		String CCYmgxth = String.format("ftp://ftp.ebi.ac.uk/pub/databases/msd/pdb_uncompressed/pdb%s.ent",
				m1YF1rb6.toLowerCase());
		System.out.println("Fetching " + CCYmgxth);
		try {
			URL fvBc1J3L = new URL(CCYmgxth);
			InputStream iDKpkqOM = fvBc1J3L.openStream();
			System.out.println("writing to " + cp4PuJ4W);
			FileOutputStream dv1XZVOW = new FileOutputStream(cp4PuJ4W);
			GZIPOutputStream fo9Wa0F9 = new GZIPOutputStream(dv1XZVOW);
			PrintWriter PSUzdaUi = new PrintWriter(fo9Wa0F9);
			BufferedReader HnZLhUr3 = new BufferedReader(new InputStreamReader(iDKpkqOM));
			String k8Qptrjl;
			while ((k8Qptrjl = HnZLhUr3.readLine()) != null) {
				PSUzdaUi.println(k8Qptrjl);
			}
			PSUzdaUi.flush();
			PSUzdaUi.close();
			dv1XZVOW.close();
			iDKpkqOM.close();
		} catch (Exception bAQgXkzs) {
			bAQgXkzs.printStackTrace();
			return null;
		}
		return cp4PuJ4W;
	}

}