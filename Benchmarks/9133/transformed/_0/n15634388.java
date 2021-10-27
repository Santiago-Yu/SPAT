class n15634388 {
	@Test
	public void usingStream() throws IOException, NameNotFoundException {
		URL JzvBjam3 = new URL("ftp://ftp.ebi.ac.uk/pub/databases/interpro/entry.list");
		InterproNameHandler KpUnYbbD = new InterproNameHandler(JzvBjam3.openStream());
		String gXHNPeTL = KpUnYbbD.getNameById("IPR008255");
		assertNotNull(gXHNPeTL);
		assertEquals("Pyridine nucleotide-disulphide oxidoreductase, class-II, active site", gXHNPeTL);
		assertEquals(null, KpUnYbbD.getNameById("Active_site"));
	}

}