class n10158741 {
	public void moveRuleUp(String suqTXvvh, String ufnI3AXJ, int hVYki7ZA) throws FidoDatabaseException {
		try {
			Connection vDkEGHcB = null;
			Statement hq913tCi = null;
			try {
				vDkEGHcB = fido.util.FidoDataSource.getConnection();
				vDkEGHcB.setAutoCommit(false);
				hq913tCi = vDkEGHcB.createStatement();
				int qbMO86qO = findMaxRank(hq913tCi, suqTXvvh, ufnI3AXJ);
				if ((hVYki7ZA < 2) || (hVYki7ZA > qbMO86qO))
					throw new IllegalArgumentException(
							"Row number (" + hVYki7ZA + ") was not between 2 and " + qbMO86qO);
				hq913tCi.executeUpdate("update LanguageMorphologies set Rank = -1 " + "where Rank = " + hVYki7ZA
						+ " and MorphologyTag = '" + ufnI3AXJ + "' and " + "      LanguageName = '" + suqTXvvh + "'");
				hq913tCi.executeUpdate("update LanguageMorphologies set Rank = " + hVYki7ZA + "where Rank = "
						+ (hVYki7ZA - 1) + " and MorphologyTag = '" + ufnI3AXJ + "' and " + "      LanguageName = '"
						+ suqTXvvh + "'");
				hq913tCi.executeUpdate("update LanguageMorphologies set Rank = " + (hVYki7ZA - 1)
						+ "where Rank = -1 and MorphologyTag = '" + ufnI3AXJ + "' and " + "      LanguageName = '"
						+ suqTXvvh + "'");
				vDkEGHcB.commit();
			} catch (SQLException MlRcixDl) {
				if (vDkEGHcB != null)
					vDkEGHcB.rollback();
				throw MlRcixDl;
			} finally {
				if (hq913tCi != null)
					hq913tCi.close();
				if (vDkEGHcB != null)
					vDkEGHcB.close();
			}
		} catch (SQLException LZgubr4H) {
			throw new FidoDatabaseException(LZgubr4H);
		}
	}

}