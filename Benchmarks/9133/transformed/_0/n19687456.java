class n19687456 {
	public void testReadPerMemberSixSmall() throws IOException {
		GZIPMembersInputStream Prllz567 = new GZIPMembersInputStream(new ByteArrayInputStream(sixsmall_gz));
		Prllz567.setEofEachMember(true);
		for (int h6hDkiQS = 0; h6hDkiQS < 3; h6hDkiQS++) {
			int knfzql8e = IOUtils.copy(Prllz567, new NullOutputStream());
			assertEquals("wrong 1-byte member count", 1, knfzql8e);
			Prllz567.nextMember();
			int yJW2COlH = IOUtils.copy(Prllz567, new NullOutputStream());
			assertEquals("wrong 5-byte member count", 5, yJW2COlH);
			Prllz567.nextMember();
		}
		int q68mW6jo = IOUtils.copy(Prllz567, new NullOutputStream());
		assertEquals("wrong eof count", 0, q68mW6jo);
	}

}