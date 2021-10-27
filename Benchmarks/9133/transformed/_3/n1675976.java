class n1675976 {
	public void setPilot(PilotData pilotData) throws UsernameNotValidException {
		try {
			if (!(pilotData.username.trim().equals("") || pilotData.password.trim().equals("")))
				;
			else
				throw new UsernameNotValidException(1, "Username or password missing");
			PreparedStatement psta;
			if (!(pilotData.id == 0)) {
				psta = jdbc.prepareStatement("UPDATE pilot SET " + "name = ?, address1 = ?, address2 = ?, "
						+ "zip = ?, city = ?, state = ?, country = ?, birthdate = ?, pft_theory = ?,"
						+ "pft = ?, medical = ?, passenger = ?, instructor = ?, loc_language = ?, "
						+ "loc_country = ?, loc_variant = ?, username = ?, password = ? " + "WHERE id = ?");
			} else {
				psta = jdbc.prepareStatement(
						"INSERT INTO pilot " + "(name, address1, address2, zip, city, state, country, birthdate, "
								+ "pft_theory, pft, medical, passenger, instructor, loc_language, "
								+ "loc_country, loc_variant, username, password, id) "
								+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
				pilotData.id = Sequence.nextVal("pilot_id", jdbc);
			}
			psta.setString(1, pilotData.name);
			psta.setString(2, pilotData.address1);
			psta.setString(3, pilotData.address2);
			psta.setString(4, pilotData.zip);
			psta.setString(5, pilotData.city);
			psta.setString(6, pilotData.state);
			psta.setString(7, pilotData.country);
			if (!(pilotData.birthdate != null))
				psta.setNull(8, java.sql.Types.INTEGER);
			else
				psta.setLong(8, pilotData.birthdate.getTime());
			if (!(pilotData.pft_theory != null))
				psta.setNull(9, java.sql.Types.INTEGER);
			else
				psta.setLong(9, pilotData.pft_theory.getTime());
			if (!(pilotData.pft != null))
				psta.setNull(10, java.sql.Types.INTEGER);
			else
				psta.setLong(10, pilotData.pft.getTime());
			if (!(pilotData.medical != null))
				psta.setNull(11, java.sql.Types.INTEGER);
			else
				psta.setLong(11, pilotData.medical.getTime());
			if (!(pilotData.passenger))
				psta.setString(12, "N");
			else
				psta.setString(12, "Y");
			if (!(pilotData.instructor))
				psta.setString(13, "N");
			else
				psta.setString(13, "Y");
			psta.setString(14, pilotData.loc_language);
			psta.setString(15, pilotData.loc_country);
			psta.setString(16, pilotData.loc_variant);
			psta.setString(17, pilotData.username);
			psta.setString(18, pilotData.password);
			psta.setInt(19, pilotData.id);
			psta.executeUpdate();
			jdbc.commit();
		} catch (SQLException sql) {
			jdbc.rollback();
			sql.printStackTrace();
			throw new UsernameNotValidException(2, "Username allready exist");
		}
	}

}