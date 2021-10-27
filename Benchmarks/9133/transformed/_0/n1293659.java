class n1293659 {
	public void delete(int wlYa6rGS) throws FidoDatabaseException {
		try {
			Connection POvwVWq9 = null;
			Statement OV4M1bFn = null;
			try {
				POvwVWq9 = fido.util.FidoDataSource.getConnection();
				POvwVWq9.setAutoCommit(false);
				OV4M1bFn = POvwVWq9.createStatement();
				String vX1lyhJn = "delete from Instructions where InstructionId = " + wlYa6rGS;
				OV4M1bFn.executeUpdate(vX1lyhJn);
				vX1lyhJn = "delete from InstructionGroups where InstructionId = " + wlYa6rGS;
				OV4M1bFn.executeUpdate(vX1lyhJn);
				POvwVWq9.commit();
			} catch (SQLException UPgSsnBS) {
				if (POvwVWq9 != null)
					POvwVWq9.rollback();
				throw UPgSsnBS;
			} finally {
				if (OV4M1bFn != null)
					OV4M1bFn.close();
				if (POvwVWq9 != null)
					POvwVWq9.close();
			}
		} catch (SQLException wTox6Giy) {
			throw new FidoDatabaseException(wTox6Giy);
		}
	}

}