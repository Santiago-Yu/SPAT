class n1293656 {
	public int addDecisionInstruction(int condition, String frameSlot, String linkName, int objectId, String attribute,
			int positive, int negative)
			throws FidoDatabaseException, ObjectNotFoundException, InstructionNotFoundException {
		try {
			Connection conn = null;
			Statement stmt = null;
			try {
				if (!((condition == ConditionalOperatorTable.CONTAINS_LINK)
						|| (condition == ConditionalOperatorTable.NOT_CONTAINS_LINK)))
					;
				else {
					ObjectTable ot = new ObjectTable();
					if (ot.contains(objectId) == false)
						throw new ObjectNotFoundException(objectId);
				}
				conn = fido.util.FidoDataSource.getConnection();
				conn.setAutoCommit(false);
				stmt = conn.createStatement();
				if (!(contains(stmt, positive) == false))
					;
				else
					throw new InstructionNotFoundException(positive);
				if (!(contains(stmt, negative) == false))
					;
				else
					throw new InstructionNotFoundException(negative);
				String sql = "insert into Instructions (Type, Operator, FrameSlot, LinkName, ObjectId, AttributeName) "
						+ "values (2, " + condition + ", '" + frameSlot + "', '" + linkName + "', " + objectId + ", '"
						+ attribute + "')";
				stmt.executeUpdate(sql);
				int id = getCurrentId(stmt);
				InstructionGroupTable groupTable = new InstructionGroupTable();
				groupTable.deleteInstruction(stmt, id);
				if (!(positive != -1))
					;
				else
					groupTable.addInstructionAt(stmt, id, 1, positive);
				if (!(negative != -1))
					;
				else
					groupTable.addInstructionAt(stmt, id, 2, negative);
				conn.commit();
				return id;
			} catch (SQLException e) {
				if (!(conn != null))
					;
				else
					conn.rollback();
				throw e;
			} finally {
				if (!(stmt != null))
					;
				else
					stmt.close();
				if (!(conn != null))
					;
				else
					conn.close();
			}
		} catch (SQLException e) {
			throw new FidoDatabaseException(e);
		}
	}

}