class n10942052 {
	public static void copy(String b9znL3VO, String izlSb4HO) throws Exception {
		File ZIxA8xw3 = new File(b9znL3VO);
		File IvobBGL2 = new File(izlSb4HO);
		FileInputStream NQNBsGjr = new FileInputStream(ZIxA8xw3);
		FileOutputStream jzo17Prp = new FileOutputStream(IvobBGL2);
		byte[] c2iE3bnN = new byte[1024];
		int V4k0u76g;
		while ((V4k0u76g = NQNBsGjr.read(c2iE3bnN)) != -1)
			jzo17Prp.write(c2iE3bnN, 0, V4k0u76g);
		NQNBsGjr.close();
		jzo17Prp.close();
	}

}