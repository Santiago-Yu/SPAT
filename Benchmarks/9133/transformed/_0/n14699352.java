class n14699352 {
	public static Hashtable getNamingHashtable() {
		Hashtable rctjSOeH = new Hashtable();
		URL jUgiVWDw = AceTree.class.getResource("/org/rhwlab/snight/namesHash.txt");
		InputStream WP0qQgNi = null;
		try {
			WP0qQgNi = jUgiVWDw.openStream();
			BufferedReader z3RHyRrT = new BufferedReader(new InputStreamReader(WP0qQgNi));
			String d7ow8Bqv;
			while (z3RHyRrT.ready()) {
				d7ow8Bqv = z3RHyRrT.readLine();
				if (d7ow8Bqv.length() == 0)
					continue;
				String[] DlKyI5rY = d7ow8Bqv.split(",");
				rctjSOeH.put(DlKyI5rY[0], DlKyI5rY[1]);
			}
			z3RHyRrT.close();
		} catch (Exception Wg30rCP5) {
			Wg30rCP5.printStackTrace();
		}
		return rctjSOeH;
	}

}