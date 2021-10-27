class n19687455 {
	public void testReadPerMemberAllFour() throws IOException {
		GZIPMembersInputStream vd9cz8g2 = new GZIPMembersInputStream(new ByteArrayInputStream(allfour_gz));
		vd9cz8g2.setEofEachMember(true);
		int J6Z3xIeG = IOUtils.copy(vd9cz8g2, new NullOutputStream());
		assertEquals("wrong 1k member count", 1024, J6Z3xIeG);
		assertEquals("wrong member number", 0, vd9cz8g2.getMemberNumber());
		assertEquals("wrong member0 start", 0, vd9cz8g2.getCurrentMemberStart());
		assertEquals("wrong member0 end", noise1k_gz.length, vd9cz8g2.getCurrentMemberEnd());
		vd9cz8g2.nextMember();
		int myFP9ssk = IOUtils.copy(vd9cz8g2, new NullOutputStream());
		assertEquals("wrong 32k member count", (32 * 1024), myFP9ssk);
		assertEquals("wrong member number", 1, vd9cz8g2.getMemberNumber());
		assertEquals("wrong member1 start", noise1k_gz.length, vd9cz8g2.getCurrentMemberStart());
		assertEquals("wrong member1 end", noise1k_gz.length + noise32k_gz.length, vd9cz8g2.getCurrentMemberEnd());
		vd9cz8g2.nextMember();
		int zSaqfNvX = IOUtils.copy(vd9cz8g2, new NullOutputStream());
		assertEquals("wrong 1-byte member count", 1, zSaqfNvX);
		assertEquals("wrong member number", 2, vd9cz8g2.getMemberNumber());
		assertEquals("wrong member2 start", noise1k_gz.length + noise32k_gz.length, vd9cz8g2.getCurrentMemberStart());
		assertEquals("wrong member2 end", noise1k_gz.length + noise32k_gz.length + a_gz.length,
				vd9cz8g2.getCurrentMemberEnd());
		vd9cz8g2.nextMember();
		int wtPyFZdh = IOUtils.copy(vd9cz8g2, new NullOutputStream());
		assertEquals("wrong 5-byte member count", 5, wtPyFZdh);
		assertEquals("wrong member number", 3, vd9cz8g2.getMemberNumber());
		assertEquals("wrong member3 start", noise1k_gz.length + noise32k_gz.length + a_gz.length,
				vd9cz8g2.getCurrentMemberStart());
		assertEquals("wrong member3 end", noise1k_gz.length + noise32k_gz.length + a_gz.length + hello_gz.length,
				vd9cz8g2.getCurrentMemberEnd());
		vd9cz8g2.nextMember();
		int no8YjmSJ = IOUtils.copy(vd9cz8g2, new NullOutputStream());
		assertEquals("wrong eof count", 0, no8YjmSJ);
	}

}