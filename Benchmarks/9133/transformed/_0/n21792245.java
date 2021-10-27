class n21792245 {
	public static String[] retrieveFasta(String zUqGFp0X) throws Exception {
		URL LRE8nlTh = new URL("http://www.uniprot.org/uniprot/" + zUqGFp0X + ".fasta");
		BufferedReader kQ30380I = new BufferedReader(new InputStreamReader(LRE8nlTh.openStream()));
		String pRt45rIb = kQ30380I.readLine();
		StringBuffer HOq4vSKT = new StringBuffer();
		String KvCU8cIB = "";
		while ((KvCU8cIB = kQ30380I.readLine()) != null) {
			HOq4vSKT.append(KvCU8cIB);
		}
		kQ30380I.close();
		String[] aFjYt93J = pRt45rIb.split("OS=");
		return new String[] { zUqGFp0X, aFjYt93J[0].split("\\s")[1], aFjYt93J[1].split("GN=")[0], HOq4vSKT.toString() };
	}

}