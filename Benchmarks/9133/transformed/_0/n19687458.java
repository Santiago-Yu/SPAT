class n19687458 {
	public void testMemberSeek() throws IOException {
		GZIPMembersInputStream ZHSaKhdO = new GZIPMembersInputStream(new ByteArrayInputStream(allfour_gz));
		ZHSaKhdO.setEofEachMember(true);
		ZHSaKhdO.compressedSeek(noise1k_gz.length + noise32k_gz.length);
		int hmPxrtK2 = IOUtils.copy(ZHSaKhdO, new NullOutputStream());
		assertEquals("wrong 1-byte member count", 1, hmPxrtK2);
		assertEquals("wrong Member2 start", noise1k_gz.length + noise32k_gz.length, ZHSaKhdO.getCurrentMemberStart());
		assertEquals("wrong Member2 end", noise1k_gz.length + noise32k_gz.length + a_gz.length,
				ZHSaKhdO.getCurrentMemberEnd());
		ZHSaKhdO.nextMember();
		int MUcmSJmu = IOUtils.copy(ZHSaKhdO, new NullOutputStream());
		assertEquals("wrong 5-byte member count", 5, MUcmSJmu);
		assertEquals("wrong Member3 start", noise1k_gz.length + noise32k_gz.length + a_gz.length,
				ZHSaKhdO.getCurrentMemberStart());
		assertEquals("wrong Member3 end", noise1k_gz.length + noise32k_gz.length + a_gz.length + hello_gz.length,
				ZHSaKhdO.getCurrentMemberEnd());
		ZHSaKhdO.nextMember();
		int RqoaBMIj = IOUtils.copy(ZHSaKhdO, new NullOutputStream());
		assertEquals("wrong eof count", 0, RqoaBMIj);
	}

}