class n10158742 {
	public void moveRuleDown(String uMccjohZ, String mUmKpFzQ, int Ky9d4GgS) throws FidoDatabaseException {
		try {
			Connection xlRyNDl7 = null;
			Statement IHSypKg6 = null;
			try {
				xlRyNDl7 = fido.util.FidoDataSource.getConnection();
				xlRyNDl7.setAutoCommit(false);
				IHSypKg6 = xlRyNDl7.createStatement();
				int W977QS5w = findMaxRank(IHSypKg6, uMccjohZ, mUmKpFzQ);
				if ((Ky9d4GgS < 1) || (Ky9d4GgS > (W977QS5w - 1)))
					throw new IllegalArgumentException(
							"Row number (" + Ky9d4GgS + ") was not between 1 and " + (W977QS5w - 1));
				IHSypKg6.executeUpdate("update LanguageMorphologies set Rank = -1 " + "where Rank = " + Ky9d4GgS
						+ " and MorphologyTag = '" + mUmKpFzQ + "' and " + "      LanguageName = '" + uMccjohZ + "'");
				IHSypKg6.executeUpdate("update LanguageMorphologies set Rank = " + Ky9d4GgS + "where Rank = "
						+ (Ky9d4GgS + 1) + " and MorphologyTag = '" + mUmKpFzQ + "' and " + "      LanguageName = '"
						+ uMccjohZ + "'");
				IHSypKg6.executeUpdate("update LanguageMorphologies set Rank = " + (Ky9d4GgS + 1)
						+ "where Rank = -1 and MorphologyTag = '" + mUmKpFzQ + "' and " + "      LanguageName = '"
						+ uMccjohZ + "'");
				xlRyNDl7.commit();
			} catch (SQLException z04SWQ0l) {
				if (xlRyNDl7 != null)
					xlRyNDl7.rollback();
				throw z04SWQ0l;
			} finally {
				if (IHSypKg6 != null)
					IHSypKg6.close();
				if (xlRyNDl7 != null)
					xlRyNDl7.close();
			}
		} catch (SQLException eovkn2G4) {
			throw new FidoDatabaseException(eovkn2G4);
		}
	}

}