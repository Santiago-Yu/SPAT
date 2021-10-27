class n1965036 {
	private void load() throws SQLException {
		Connection YZmzTGY8 = null;
		Statement HFIP7qei = null;
		try {
			YZmzTGY8 = FidoDataSource.getConnection();
			YZmzTGY8.setAutoCommit(false);
			HFIP7qei = YZmzTGY8.createStatement();
			ClearData.clearTables(HFIP7qei);
			HFIP7qei.executeUpdate("insert into Objects (ObjectId, Description) values (100, 'Person')");
			HFIP7qei.executeUpdate("insert into Objects (ObjectId, Description) values (101, 'john')");
			HFIP7qei.executeUpdate("insert into Objects (ObjectId, Description) values (200, 'Dog')");
			HFIP7qei.executeUpdate("insert into Objects (ObjectId, Description) values (201, 'johns dog')");
			HFIP7qei.executeQuery("select setval('objects_objectid_seq', 1000)");
			HFIP7qei.executeUpdate("insert into ClassLinkTypes (LinkName, LinkType) values ('hasa', 2)");
			HFIP7qei.executeUpdate("insert into ObjectLinks (ObjectId, LinkName, LinkToObject) values (100, 'isa', 1)");
			HFIP7qei.executeUpdate(
					"insert into ObjectLinks (ObjectId, LinkName, LinkToObject) values (101, 'instance', 100)");
			HFIP7qei.executeUpdate("insert into ObjectLinks (ObjectId, LinkName, LinkToObject) values (200, 'isa', 1)");
			HFIP7qei.executeUpdate(
					"insert into ObjectLinks (ObjectId, LinkName, LinkToObject) values (201, 'instance', 200)");
			HFIP7qei.executeUpdate(
					"insert into ObjectLinks (ObjectId, LinkName, LinkToObject) values (101, 'hasa', 201)");
			HFIP7qei.executeUpdate(
					"insert into Dictionary (Word, SenseNumber, GrammarString, ObjectId) values ('LEFT-WALL', '1', 'QV+', 1)");
			HFIP7qei.executeUpdate(
					"insert into Dictionary (Word, SenseNumber, GrammarString, ObjectId) values ('does', '1', 'HV+', 1)");
			HFIP7qei.executeUpdate(
					"insert into Dictionary (Word, SenseNumber, GrammarString, ObjectId) values ('john', '1', 'S+ | DO-', 1)");
			HFIP7qei.executeUpdate(
					"insert into Dictionary (Word, SenseNumber, GrammarString, ObjectId) values ('a', '1', 'D+', 1)");
			HFIP7qei.executeUpdate(
					"insert into Dictionary (Word, SenseNumber, GrammarString, ObjectId) values ('dog', '1', '[D-] & (S+ | DO-)', 200)");
			HFIP7qei.executeUpdate(
					"insert into Dictionary (Word, SenseNumber, GrammarString, ObjectId) values ('have', '1', 'S- & HV- & QV- & DO+', 1)");
			HFIP7qei.executeUpdate("insert into GrammarLinks (LinkName, LinkType) values ('S', 1)");
			HFIP7qei.executeUpdate("insert into GrammarLinks (LinkName, LinkType) values ('DO', 3)");
			HFIP7qei.executeUpdate("insert into GrammarLinks (LinkName, LinkType) values ('QV', 8)");
			HFIP7qei.executeUpdate("insert into GrammarLinks (LinkName, LinkType) values ('D', 10)");
			HFIP7qei.executeUpdate("insert into GrammarLinks (LinkName, LinkType) values ('HV', 16)");
			HFIP7qei.executeUpdate("insert into Articles (ArticleName, Dereference) values ('a', 2)");
			HFIP7qei.executeUpdate("insert into FrameSlots (SlotName) values ('actor')");
			HFIP7qei.executeUpdate("insert into FrameSlots (SlotName) values ('object')");
			HFIP7qei.executeUpdate(
					"insert into Verbs (VerbName, Type, SubjectSlot, IndirectObjectSlot, PredicateNounSlot) values ('have', 1, 'actor', '', 'object')");
			HFIP7qei.executeUpdate("insert into ProperNouns (Noun, SenseNumber, ObjectId) values ('john', 1, 101)");
			HFIP7qei.executeQuery("select setval('instructions_instructionid_seq', 1)");
			HFIP7qei.executeUpdate(
					"insert into Instructions (Type, ExecuteString, FrameSlot, Operator, LinkName, ObjectId, AttributeName) "
							+ "values (3, 'set_return_status true', null, 0, null, null, null)");
			HFIP7qei.executeUpdate(
					"insert into Instructions (Type, ExecuteString, FrameSlot, Operator, LinkName, ObjectId, AttributeName) "
							+ "values (3, 'set_return_status false', null, 0, null, null, null)");
			HFIP7qei.executeUpdate(
					"insert into Instructions (Type, ExecuteString, FrameSlot, Operator, LinkName, ObjectId, AttributeName) "
							+ "values (2, '', 'actor', 1, 'hasa', 200, null)");
			HFIP7qei.executeUpdate(
					"insert into InstructionGroups (InstructionId, Rank, GroupInstruction) " + "values (4, 1, 2)");
			HFIP7qei.executeUpdate(
					"insert into InstructionGroups (InstructionId, Rank, GroupInstruction) " + "values (4, 2, 3)");
			HFIP7qei.executeQuery("select setval('transactions_transactionid_seq', 1)");
			HFIP7qei.executeUpdate(
					"insert into Transactions (InstructionId, Description) values (4, 'have - question')");
			HFIP7qei.executeQuery("select setval('verbtransactions_verbid_seq', 1)");
			HFIP7qei.executeUpdate(
					"insert into VerbTransactions (VerbString, MoodType, TransactionId) values ('have', 3, 2)");
			HFIP7qei.executeUpdate(
					"insert into VerbConstraints (VerbId, FrameSlot, ObjectId) values (2, 'actor', 100)");
			HFIP7qei.executeUpdate(
					"insert into VerbConstraints (VerbId, FrameSlot, ObjectId) values (2, 'object', 200)");
			HFIP7qei.executeUpdate(
					"update SystemProperties set value = 'Tutorial 2 Data' where name = 'DB Data Version'");
			YZmzTGY8.commit();
		} catch (SQLException sFADoavX) {
			if (YZmzTGY8 != null)
				YZmzTGY8.rollback();
			throw sFADoavX;
		} finally {
			if (HFIP7qei != null)
				HFIP7qei.close();
			if (YZmzTGY8 != null)
				YZmzTGY8.close();
		}
	}

}