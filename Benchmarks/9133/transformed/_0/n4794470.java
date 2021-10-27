class n4794470 {
	private void load() throws SQLException {
		Connection Q0uiNF1n = null;
		Statement m0BhxPxf = null;
		try {
			Q0uiNF1n = FidoDataSource.getConnection();
			Q0uiNF1n.setAutoCommit(false);
			m0BhxPxf = Q0uiNF1n.createStatement();
			ClearData.clearTables(m0BhxPxf);
			m0BhxPxf.executeUpdate("insert into Objects (ObjectId, Description) values (100, 'Person')");
			m0BhxPxf.executeUpdate("insert into Objects (ObjectId, Description) values (101, 'john')");
			m0BhxPxf.executeUpdate("insert into Objects (ObjectId, Description) values (200, 'Dog')");
			m0BhxPxf.executeQuery("select setval('objects_objectid_seq', 1000)");
			m0BhxPxf.executeUpdate("insert into ClassLinkTypes (LinkName, LinkType) values ('hasa', 2)");
			m0BhxPxf.executeUpdate("insert into ObjectLinks (ObjectId, LinkName, LinkToObject) values (100, 'isa', 1)");
			m0BhxPxf.executeUpdate(
					"insert into ObjectLinks (ObjectId, LinkName, LinkToObject) values (101, 'instance', 100)");
			m0BhxPxf.executeUpdate("insert into ObjectLinks (ObjectId, LinkName, LinkToObject) values (200, 'isa', 1)");
			m0BhxPxf.executeUpdate(
					"insert into Dictionary (Word, SenseNumber, GrammarString, ObjectId) values ('LEFT-WALL', '1', 'AV+', 1)");
			m0BhxPxf.executeUpdate(
					"insert into Dictionary (Word, SenseNumber, GrammarString, ObjectId) values ('john', '1', 'S+ | DO-', 1)");
			m0BhxPxf.executeUpdate(
					"insert into Dictionary (Word, SenseNumber, GrammarString, ObjectId) values ('a', '1', 'D+', 1)");
			m0BhxPxf.executeUpdate(
					"insert into Dictionary (Word, SenseNumber, GrammarString, ObjectId) values ('dog', '1', '[D-] & (S+ | DO-)', 200)");
			m0BhxPxf.executeUpdate(
					"insert into Dictionary (Word, SenseNumber, GrammarString, ObjectId) values ('have', '1', 'S- & AV- & DO+', 1)");
			m0BhxPxf.executeUpdate(
					"insert into LanguageMorphologies (LanguageName, MorphologyTag, Rank, Root, Surface, Used) values "
							+ "                                 ('English', 'third singular', 1, 'have', 'has', TRUE)");
			m0BhxPxf.executeUpdate("insert into GrammarLinks (LinkName, LinkType) values ('S', 1)");
			m0BhxPxf.executeUpdate("insert into GrammarLinks (LinkName, LinkType) values ('DO', 3)");
			m0BhxPxf.executeUpdate("insert into GrammarLinks (LinkName, LinkType) values ('AV', 7)");
			m0BhxPxf.executeUpdate("insert into GrammarLinks (LinkName, LinkType) values ('D', 10)");
			m0BhxPxf.executeUpdate("insert into Articles (ArticleName, Dereference) values ('a', 2)");
			m0BhxPxf.executeUpdate("insert into FrameSlots (SlotName) values ('actor')");
			m0BhxPxf.executeUpdate("insert into FrameSlots (SlotName) values ('object')");
			m0BhxPxf.executeUpdate(
					"insert into Verbs (VerbName, Type, SubjectSlot, IndirectObjectSlot, PredicateNounSlot) values ('have', 1, 'actor', '', 'object')");
			m0BhxPxf.executeQuery("select setval('instructions_instructionid_seq', 1)");
			m0BhxPxf.executeUpdate(
					"insert into Instructions (Type, ExecuteString, FrameSlot, Operator, LinkName, ObjectId, AttributeName) "
							+ "values (3, 'link %actor hasa %object', null, 0, null, null, null)");
			m0BhxPxf.executeQuery("select setval('transactions_transactionid_seq', 1)");
			m0BhxPxf.executeUpdate("insert into Transactions (InstructionId, Description) values (2, 'have - link')");
			m0BhxPxf.executeQuery("select setval('verbtransactions_verbid_seq', 1)");
			m0BhxPxf.executeUpdate(
					"insert into VerbTransactions (VerbString, MoodType, TransactionId) values ('have', 1, 2)");
			m0BhxPxf.executeUpdate("insert into VerbConstraints (VerbId, FrameSlot, ObjectId) values (2, 'actor', 1)");
			m0BhxPxf.executeUpdate("insert into VerbConstraints (VerbId, FrameSlot, ObjectId) values (2, 'object', 1)");
			m0BhxPxf.executeUpdate("insert into ProperNouns (Noun, SenseNumber, ObjectId) values ('john', 1, 101)");
			m0BhxPxf.executeUpdate(
					"update SystemProperties set value = 'Tutorial 1 Data' where name = 'DB Data Version'");
			Q0uiNF1n.commit();
		} catch (SQLException PxhboMZl) {
			if (Q0uiNF1n != null)
				Q0uiNF1n.rollback();
			throw PxhboMZl;
		} finally {
			if (m0BhxPxf != null)
				m0BhxPxf.close();
			if (Q0uiNF1n != null)
				Q0uiNF1n.close();
		}
	}

}