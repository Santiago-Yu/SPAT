class n7704004 {
	public void moveRowDown(int c17d4i61, int RdKaoVHF) throws FidoDatabaseException {
		try {
			Connection ugjNOUq0 = null;
			Statement THamPTg8 = null;
			try {
				ugjNOUq0 = fido.util.FidoDataSource.getConnection();
				ugjNOUq0.setAutoCommit(false);
				THamPTg8 = ugjNOUq0.createStatement();
				int tmH7EnlQ = findMaxRank(THamPTg8, c17d4i61);
				if ((RdKaoVHF < 1) || (RdKaoVHF > (tmH7EnlQ - 1)))
					throw new IllegalArgumentException("Row number not between 1 and " + (tmH7EnlQ - 1));
				THamPTg8.executeUpdate("update InstructionGroups set Rank = -1 where InstructionId = '" + c17d4i61
						+ "' and Rank = " + RdKaoVHF);
				THamPTg8.executeUpdate("update InstructionGroups set Rank = " + RdKaoVHF + " where InstructionId = '"
						+ c17d4i61 + "' and Rank = " + (RdKaoVHF + 1));
				THamPTg8.executeUpdate("update InstructionGroups set Rank = " + (RdKaoVHF + 1)
						+ " where InstructionId = '" + c17d4i61 + "' and Rank = -1");
				ugjNOUq0.commit();
			} catch (SQLException pRsPUrvY) {
				if (ugjNOUq0 != null)
					ugjNOUq0.rollback();
				throw pRsPUrvY;
			} finally {
				if (THamPTg8 != null)
					THamPTg8.close();
				if (ugjNOUq0 != null)
					ugjNOUq0.close();
			}
		} catch (SQLException cLBPkF06) {
			throw new FidoDatabaseException(cLBPkF06);
		}
	}

}