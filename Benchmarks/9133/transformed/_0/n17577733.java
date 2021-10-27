class n17577733 {
	private void load() throws SQLException {
		Connection HA3aarIu = null;
		Statement jSvwZdkg = null;
		try {
			HA3aarIu = FidoDataSource.getConnection();
			HA3aarIu.setAutoCommit(false);
			jSvwZdkg = HA3aarIu.createStatement();
			ClearData.clearTables(jSvwZdkg);
			jSvwZdkg.executeUpdate("insert into AttributeCategories (CategoryName) values ('color')");
			jSvwZdkg.executeUpdate("insert into Attributes (AttributeName, Category) values ('blue', 'color')");
			jSvwZdkg.executeUpdate("insert into Attributes (AttributeName, Category) values ('red', 'color')");
			jSvwZdkg.executeUpdate("insert into Objects (ObjectId, Description) values (100, 'ball')");
			jSvwZdkg.executeUpdate("insert into Objects (ObjectId, Description) values (101, 'blue ball')");
			jSvwZdkg.executeUpdate("insert into Objects (ObjectId, Description) values (102, 'red ball')");
			jSvwZdkg.executeQuery("select setval('objects_objectid_seq', 1000)");
			jSvwZdkg.executeUpdate("insert into ObjectLinks (ObjectId, LinkName, LinkToObject) values (100, 'isa', 1)");
			jSvwZdkg.executeUpdate(
					"insert into ObjectLinks (ObjectId, LinkName, LinkToObject) values (101, 'instance', 100)");
			jSvwZdkg.executeUpdate(
					"insert into ObjectLinks (ObjectId, LinkName, LinkToObject) values (102, 'instance', 100)");
			jSvwZdkg.executeUpdate("insert into ObjectAttributes (ObjectId, AttributeName) values (101, 'blue')");
			jSvwZdkg.executeUpdate("insert into ObjectAttributes (ObjectId, AttributeName) values (102, 'red')");
			jSvwZdkg.executeUpdate(
					"insert into Dictionary (Word, SenseNumber, GrammarString, ObjectId) values ('LEFT-WALL', '1', 'AV+ | ADJ+', 1)");
			jSvwZdkg.executeUpdate(
					"insert into Dictionary (Word, SenseNumber, GrammarString, ObjectId) values ('the', '1', 'D+', 1)");
			jSvwZdkg.executeUpdate(
					"insert into Dictionary (Word, SenseNumber, GrammarString, ObjectId) values ('red', '1', 'ADJ- | ADJ+', 1)");
			jSvwZdkg.executeUpdate(
					"insert into Dictionary (Word, SenseNumber, GrammarString, ObjectId) values ('blue', '1', 'ADJ- | ADJ+', 1)");
			jSvwZdkg.executeUpdate(
					"insert into Dictionary (Word, SenseNumber, GrammarString, ObjectId) values ('ball', '1', '[@ADJ-] & [D-] & DO-', 100)");
			jSvwZdkg.executeUpdate(
					"insert into Dictionary (Word, SenseNumber, GrammarString, ObjectId) values ('throw', '1', 'AV- & DO+', 1)");
			jSvwZdkg.executeUpdate("insert into GrammarLinks (LinkName, LinkType) values ('DO', 3)");
			jSvwZdkg.executeUpdate("insert into GrammarLinks (LinkName, LinkType) values ('AV', 7)");
			jSvwZdkg.executeUpdate("insert into GrammarLinks (LinkName, LinkType) values ('D', 10)");
			jSvwZdkg.executeUpdate("insert into GrammarLinks (LinkName, LinkType) values ('ADJ', 11)");
			jSvwZdkg.executeUpdate("insert into Articles (ArticleName, Dereference) values ('the', 1)");
			jSvwZdkg.executeUpdate("insert into FrameSlots (SlotName) values ('object')");
			jSvwZdkg.executeUpdate("insert into QuestionWords (QuestionWord, Type) values ('which', 7)");
			jSvwZdkg.executeUpdate(
					"insert into Verbs (VerbName, Type, SubjectSlot, IndirectObjectSlot, PredicateNounSlot) values ('throw', 1, '', '', 'object')");
			jSvwZdkg.executeQuery("select setval('instructions_instructionid_seq', 1)");
			jSvwZdkg.executeUpdate(
					"insert into Instructions (Type, ExecuteString, FrameSlot, Operator, LinkName, ObjectId, AttributeName) "
							+ "values (3, '', null, 0, null, null, null)");
			jSvwZdkg.executeQuery("select setval('transactions_transactionid_seq', 1)");
			jSvwZdkg.executeUpdate("insert into Transactions (InstructionId, Description) values (2, 'throw')");
			jSvwZdkg.executeQuery("select setval('verbtransactions_verbid_seq', 1)");
			jSvwZdkg.executeUpdate(
					"insert into VerbTransactions (VerbString, MoodType, TransactionId) values ('throw', 1, 2)");
			jSvwZdkg.executeUpdate("insert into VerbConstraints (VerbId, FrameSlot, ObjectId) values (2, 'object', 1)");
			jSvwZdkg.executeUpdate(
					"update SystemProperties set value = 'Tutorial 3 Data' where name = 'DB Data Version'");
			HA3aarIu.commit();
		} catch (SQLException ybCtqof8) {
			if (HA3aarIu != null)
				HA3aarIu.rollback();
			throw ybCtqof8;
		} finally {
			if (jSvwZdkg != null)
				jSvwZdkg.close();
			if (HA3aarIu != null)
				HA3aarIu.close();
		}
	}

}