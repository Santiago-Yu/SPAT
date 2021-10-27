class n3449615 {
	public ProgramMessageSymbol addProgramMessageSymbol(int bvvLfOXL, String BNNkMExo, byte[] PaSFeBdP)
			throws AdaptationException {
		ProgramMessageSymbol uObVs6QR = null;
		Connection xgeOcNkp = null;
		PreparedStatement TDLBjlP5 = null;
		Statement TALxdK4b = null;
		ResultSet IjzTdBMS = null;
		InputStream NCkKK974 = new ByteArrayInputStream(PaSFeBdP);
		try {
			String VRUUY5F1 = "INSERT INTO ProgramMessageSymbols(programID, name, " + "bytecode) VALUES ( ?, ?, ? )";
			xgeOcNkp = DriverManager.getConnection(CONN_STR);
			TDLBjlP5 = xgeOcNkp.prepareStatement(VRUUY5F1);
			TDLBjlP5.setInt(1, bvvLfOXL);
			TDLBjlP5.setString(2, BNNkMExo);
			TDLBjlP5.setBinaryStream(3, NCkKK974, PaSFeBdP.length);
			log.info("INSERT INTO ProgramMessageSymbols(programID, name, " + "bytecode) VALUES (" + bvvLfOXL + ", '"
					+ BNNkMExo + "', " + "<bytecode>)");
			TDLBjlP5.executeUpdate();
			TALxdK4b = xgeOcNkp.createStatement();
			VRUUY5F1 = "SELECT * FROM ProgramMessageSymbols WHERE " + "programID =  " + bvvLfOXL + " AND "
					+ "name      = '" + BNNkMExo + "'";
			IjzTdBMS = TALxdK4b.executeQuery(VRUUY5F1);
			if (!IjzTdBMS.next()) {
				xgeOcNkp.rollback();
				String BksLVKyY = "Attempt to add program message symbol failed.";
				log.error(BksLVKyY);
				;
				throw new AdaptationException(BksLVKyY);
			}
			uObVs6QR = getProgramMessageSymbol(IjzTdBMS);
			xgeOcNkp.commit();
		} catch (SQLException ERQZqqM3) {
			try {
				xgeOcNkp.rollback();
			} catch (Exception RnaGLaON) {
			}
			String sS0Fw72v = "SQLException in addProgramMessageSymbol";
			log.error(sS0Fw72v, ERQZqqM3);
			throw new AdaptationException(sS0Fw72v, ERQZqqM3);
		} finally {
			try {
				IjzTdBMS.close();
			} catch (Exception Dp3ECP2X) {
			}
			try {
				TDLBjlP5.close();
			} catch (Exception OuFrxich) {
			}
			try {
				TALxdK4b.close();
			} catch (Exception wrGJ0VDB) {
			}
			try {
				xgeOcNkp.close();
			} catch (Exception mG2n4F8M) {
			}
		}
		return uObVs6QR;
	}

}