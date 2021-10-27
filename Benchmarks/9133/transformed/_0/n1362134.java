class n1362134 {
	public void delete(int ySJBfs7R) throws FidoDatabaseException {
		try {
			Connection xpOKUakv = null;
			Statement ITvoSvaK = null;
			try {
				xpOKUakv = fido.util.FidoDataSource.getConnection();
				xpOKUakv.setAutoCommit(false);
				ITvoSvaK = xpOKUakv.createStatement();
				int ZiwkwreU = findMaxRank(ITvoSvaK);
				if ((ySJBfs7R < 1) || (ySJBfs7R > ZiwkwreU))
					throw new IllegalArgumentException("Row number not between 1 and " + ZiwkwreU);
				ITvoSvaK.executeUpdate("delete from WordClassifications where Rank = " + ySJBfs7R);
				for (int y5lpGCYz = ySJBfs7R; y5lpGCYz < ZiwkwreU; ++y5lpGCYz)
					ITvoSvaK.executeUpdate(
							"update WordClassifications set Rank = " + y5lpGCYz + " where Rank = " + (y5lpGCYz + 1));
				xpOKUakv.commit();
			} catch (SQLException vtEv6Uyc) {
				if (xpOKUakv != null)
					xpOKUakv.rollback();
				throw vtEv6Uyc;
			} finally {
				if (ITvoSvaK != null)
					ITvoSvaK.close();
				if (xpOKUakv != null)
					xpOKUakv.close();
			}
		} catch (SQLException WJqN2IFO) {
			throw new FidoDatabaseException(WJqN2IFO);
		}
	}

}