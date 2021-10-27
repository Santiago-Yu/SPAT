class n19687459 {
	@SuppressWarnings("deprecation")
	public void testMemberIterator() throws IOException {
		GZIPMembersInputStream RBOjUuYI = new GZIPMembersInputStream(new ByteArrayInputStream(allfour_gz));
		Iterator<GZIPMembersInputStream> R6DktQMb = RBOjUuYI.memberIterator();
		assertTrue(R6DktQMb.hasNext());
		GZIPMembersInputStream XgaNyKLy = R6DktQMb.next();
		int RQ8vLKuo = IOUtils.copy(XgaNyKLy, new NullOutputStream());
		assertEquals("wrong 1k member count", 1024, RQ8vLKuo);
		assertEquals("wrong member number", 0, RBOjUuYI.getMemberNumber());
		assertEquals("wrong member0 start", 0, RBOjUuYI.getCurrentMemberStart());
		assertEquals("wrong member0 end", noise1k_gz.length, RBOjUuYI.getCurrentMemberEnd());
		assertTrue(R6DktQMb.hasNext());
		GZIPMembersInputStream hRxcwzoX = R6DktQMb.next();
		int SIyyWYed = IOUtils.copy(hRxcwzoX, new NullOutputStream());
		assertEquals("wrong 32k member count", (32 * 1024), SIyyWYed);
		assertEquals("wrong member number", 1, RBOjUuYI.getMemberNumber());
		assertEquals("wrong member1 start", noise1k_gz.length, RBOjUuYI.getCurrentMemberStart());
		assertEquals("wrong member1 end", noise1k_gz.length + noise32k_gz.length, RBOjUuYI.getCurrentMemberEnd());
		assertTrue(R6DktQMb.hasNext());
		GZIPMembersInputStream Xv1zlkQB = R6DktQMb.next();
		int U757Ecf3 = IOUtils.copy(Xv1zlkQB, new NullOutputStream());
		assertEquals("wrong 1-byte member count", 1, U757Ecf3);
		assertEquals("wrong member number", 2, RBOjUuYI.getMemberNumber());
		assertEquals("wrong member2 start", noise1k_gz.length + noise32k_gz.length, RBOjUuYI.getCurrentMemberStart());
		assertEquals("wrong member2 end", noise1k_gz.length + noise32k_gz.length + a_gz.length,
				RBOjUuYI.getCurrentMemberEnd());
		assertTrue(R6DktQMb.hasNext());
		GZIPMembersInputStream gE3FXWji = R6DktQMb.next();
		int jyPGPutQ = IOUtils.copy(gE3FXWji, new NullOutputStream());
		assertEquals("wrong 5-byte member count", 5, jyPGPutQ);
		assertEquals("wrong member number", 3, RBOjUuYI.getMemberNumber());
		assertEquals("wrong member3 start", noise1k_gz.length + noise32k_gz.length + a_gz.length,
				RBOjUuYI.getCurrentMemberStart());
		assertEquals("wrong member3 end", noise1k_gz.length + noise32k_gz.length + a_gz.length + hello_gz.length,
				RBOjUuYI.getCurrentMemberEnd());
		assertFalse(R6DktQMb.hasNext());
	}

}