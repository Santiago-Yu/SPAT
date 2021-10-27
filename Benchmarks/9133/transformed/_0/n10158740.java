class n10158740 {
	public void delete(String NK4RomlY, String H5HNjLUL, int abM5Qw4R) throws FidoDatabaseException {
		try {
			Connection eBj1EivK = null;
			Statement PnzVFPNW = null;
			try {
				String ffdUFfJW = "delete from LanguageMorphologies " + "where LanguageName = '" + NK4RomlY
						+ "' and MorphologyTag = '" + H5HNjLUL + "' and " + "      Rank = " + abM5Qw4R;
				eBj1EivK = fido.util.FidoDataSource.getConnection();
				eBj1EivK.setAutoCommit(false);
				PnzVFPNW = eBj1EivK.createStatement();
				PnzVFPNW.executeUpdate(ffdUFfJW);
				bumpAllRowsUp(PnzVFPNW, NK4RomlY, H5HNjLUL, abM5Qw4R);
				eBj1EivK.commit();
			} catch (SQLException TfrN4u5b) {
				if (eBj1EivK != null)
					eBj1EivK.rollback();
				throw TfrN4u5b;
			} finally {
				if (PnzVFPNW != null)
					PnzVFPNW.close();
				if (eBj1EivK != null)
					eBj1EivK.close();
			}
		} catch (SQLException qg5OVAfK) {
			throw new FidoDatabaseException(qg5OVAfK);
		}
	}

}