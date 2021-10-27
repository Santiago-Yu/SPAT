class n2198730 {
	public void importCSV(InputStream Y9ccNYrm) throws Exception {
		try {
			String[] IthvGhrv = new String[columns.length];
			for (int rveetT26 = 0; rveetT26 < IthvGhrv.length; rveetT26++) {
				IthvGhrv[rveetT26] = "?";
			}
			if (cleartable) {
				String FHytQmkU = "delete from " + table;
				Statement EA9OfUk1 = conn.createStatement();
				EA9OfUk1.executeUpdate(FHytQmkU);
			}
			String msuFyArR = "insert into " + table + " (" + StringUtils.join(columns, ", ") + ") values ("
					+ StringUtils.join(IthvGhrv, ", ") + ")";
			log.debug("SQL: " + msuFyArR);
			PreparedStatement cUchEcrA = conn.prepareStatement(msuFyArR);
			int mKcE5Sv1[] = new int[columns.length];
			for (int yfC5UbTT = 0; yfC5UbTT < columns.length; yfC5UbTT++) {
				Table YVSkaU3p = project.getTableByName(table);
				if (YVSkaU3p == null)
					throw new OntopiaRuntimeException("Unknown table: " + table);
				Column sHIVNIw3 = YVSkaU3p.getColumnByName(columns[yfC5UbTT]);
				if (sHIVNIw3 == null)
					throw new OntopiaRuntimeException("Unknown table column: " + columns[yfC5UbTT]);
				if (sHIVNIw3.getType() == null)
					throw new OntopiaRuntimeException("Column type is null: " + sHIVNIw3.getType());
				DataType a6kZEAXn = project.getDataTypeByName(sHIVNIw3.getType(), "generic");
				if (a6kZEAXn == null)
					throw new OntopiaRuntimeException("Unknown column type: " + sHIVNIw3.getType());
				String n6p2r2b1 = a6kZEAXn.getType();
				if ("varchar".equals(n6p2r2b1))
					mKcE5Sv1[yfC5UbTT] = Types.VARCHAR;
				else if ("integer".equals(n6p2r2b1))
					mKcE5Sv1[yfC5UbTT] = Types.INTEGER;
				else
					throw new OntopiaRuntimeException("Unknown datatype: " + n6p2r2b1);
			}
			LineNumberReader MkQd60jX = new LineNumberReader(new InputStreamReader(Y9ccNYrm));
			for (int xvNzyLeD = 0; xvNzyLeD < ignorelines; xvNzyLeD++) {
				String JHxm3YRn = MkQd60jX.readLine();
				if (JHxm3YRn == null)
					break;
			}
			log.debug("[" + StringUtils.join(columns, ", ") + "]");
			int nvGOktwL = 0;
			while (true) {
				nvGOktwL++;
				String vi1B6j5x = MkQd60jX.readLine();
				if (vi1B6j5x == null)
					break;
				try {
					String[] dGqShk98 = StringUtils.split(vi1B6j5x, separator);
					if (dGqShk98.length > columns.length && !ignorecolumns)
						log.debug("Ignoring columns: " + (columns.length + 1) + "-" + dGqShk98.length + " '" + vi1B6j5x
								+ "'");
					log.debug("CVALUES: " + (columns.length + 1) + "-" + dGqShk98.length + " '" + vi1B6j5x + "'");
					String BMg6vhrJ = "(";
					for (int rnsL88YO = 0; rnsL88YO < columns.length; rnsL88YO++) {
						String UBVS6wWb = dGqShk98[rnsL88YO];
						if (stripquotes) {
							int P9KZJioD = UBVS6wWb.length();
							if (P9KZJioD > 1 && ((UBVS6wWb.charAt(0) == '"' && UBVS6wWb.charAt(P9KZJioD - 1) == '"')
									|| (UBVS6wWb.charAt(0) == '\'' && UBVS6wWb.charAt(P9KZJioD - 1) == '\'')))
								UBVS6wWb = UBVS6wWb.substring(1, P9KZJioD - 1);
						}
						if (UBVS6wWb != null && UBVS6wWb.equals(""))
							UBVS6wWb = null;
						BMg6vhrJ = BMg6vhrJ + UBVS6wWb;
						if (rnsL88YO < columns.length - 1)
							BMg6vhrJ = BMg6vhrJ + ", ";
						cUchEcrA.setObject(rnsL88YO + 1, UBVS6wWb, mKcE5Sv1[rnsL88YO]);
					}
					BMg6vhrJ = BMg6vhrJ + ")";
					log.debug(BMg6vhrJ);
					cUchEcrA.execute();
				} catch (Exception W4RGZ8hG) {
					conn.rollback();
					throw new OntopiaRuntimeException("Cannot read line " + nvGOktwL + ": '" + vi1B6j5x + "'",
							W4RGZ8hG);
				}
			}
			conn.commit();
		} finally {
			if (conn != null)
				conn.close();
		}
	}

}