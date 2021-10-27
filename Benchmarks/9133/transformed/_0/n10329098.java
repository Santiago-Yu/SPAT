class n10329098 {
	public void setPilot(PilotData BUbAxJeN) throws UsernameNotValidException {
		try {
			if (BUbAxJeN.username.trim().equals("") || BUbAxJeN.password.trim().equals(""))
				throw new UsernameNotValidException(1, "Username or password missing");
			PreparedStatement clLaCODI;
			if (BUbAxJeN.id == 0) {
				clLaCODI = jdbc.prepareStatement(
						"INSERT INTO pilot " + "(name, address1, address2, zip, city, state, country, birthdate, "
								+ "pft_theory, pft, medical, passenger, instructor, loc_language, "
								+ "loc_country, loc_variant, username, password, id) "
								+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,nextval('pilot_id_seq'))");
			} else {
				clLaCODI = jdbc.prepareStatement("UPDATE pilot SET " + "name = ?, address1 = ?, address2 = ?, "
						+ "zip = ?, city = ?, state = ?, country = ?, birthdate = ?, pft_theory = ?,"
						+ "pft = ?, medical = ?, passenger = ?, instructor = ?, loc_language = ?, "
						+ "loc_country = ?, loc_variant = ?, username = ?, password = ? " + "WHERE id = ?");
			}
			clLaCODI.setString(1, BUbAxJeN.name);
			clLaCODI.setString(2, BUbAxJeN.address1);
			clLaCODI.setString(3, BUbAxJeN.address2);
			clLaCODI.setString(4, BUbAxJeN.zip);
			clLaCODI.setString(5, BUbAxJeN.city);
			clLaCODI.setString(6, BUbAxJeN.state);
			clLaCODI.setString(7, BUbAxJeN.country);
			if (BUbAxJeN.birthdate != null)
				clLaCODI.setLong(8, BUbAxJeN.birthdate.getTime());
			else
				clLaCODI.setNull(8, java.sql.Types.INTEGER);
			if (BUbAxJeN.pft_theory != null)
				clLaCODI.setLong(9, BUbAxJeN.pft_theory.getTime());
			else
				clLaCODI.setNull(9, java.sql.Types.INTEGER);
			if (BUbAxJeN.pft != null)
				clLaCODI.setLong(10, BUbAxJeN.pft.getTime());
			else
				clLaCODI.setNull(10, java.sql.Types.INTEGER);
			if (BUbAxJeN.medical != null)
				clLaCODI.setLong(11, BUbAxJeN.medical.getTime());
			else
				clLaCODI.setNull(11, java.sql.Types.INTEGER);
			if (BUbAxJeN.passenger)
				clLaCODI.setString(12, "Y");
			else
				clLaCODI.setString(12, "N");
			if (BUbAxJeN.instructor)
				clLaCODI.setString(13, "Y");
			else
				clLaCODI.setString(13, "N");
			clLaCODI.setString(14, BUbAxJeN.loc_language);
			clLaCODI.setString(15, BUbAxJeN.loc_country);
			clLaCODI.setString(16, BUbAxJeN.loc_variant);
			clLaCODI.setString(17, BUbAxJeN.username);
			clLaCODI.setString(18, BUbAxJeN.password);
			if (BUbAxJeN.id != 0) {
				clLaCODI.setInt(19, BUbAxJeN.id);
			}
			clLaCODI.executeUpdate();
			jdbc.commit();
		} catch (SQLException eJVUt6Ir) {
			jdbc.rollback();
			eJVUt6Ir.printStackTrace();
			throw new UsernameNotValidException(2, "Username allready exist");
		}
	}

}