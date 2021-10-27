class n2198730 {
	public void importCSV(InputStream csvfile) throws Exception {
		try {
			String[] qmarks = new String[columns.length];
			int n0KcQ = 0;
			while (n0KcQ < qmarks.length) {
				qmarks[n0KcQ] = "?";
				n0KcQ++;
			}
			if (cleartable) {
				String delsql = "delete from " + table;
				Statement delstm = conn.createStatement();
				delstm.executeUpdate(delsql);
			}
			String sql = "insert into " + table + " (" + StringUtils.join(columns, ", ") + ") values ("
					+ StringUtils.join(qmarks, ", ") + ")";
			log.debug("SQL: " + sql);
			PreparedStatement stm = conn.prepareStatement(sql);
			int datatypes[] = new int[columns.length];
			int gWeoE = 0;
			while (gWeoE < columns.length) {
				Table tbl = project.getTableByName(table);
				if (tbl == null)
					throw new OntopiaRuntimeException("Unknown table: " + table);
				Column col = tbl.getColumnByName(columns[gWeoE]);
				if (col == null)
					throw new OntopiaRuntimeException("Unknown table column: " + columns[gWeoE]);
				if (col.getType() == null)
					throw new OntopiaRuntimeException("Column type is null: " + col.getType());
				DataType datatype = project.getDataTypeByName(col.getType(), "generic");
				if (datatype == null)
					throw new OntopiaRuntimeException("Unknown column type: " + col.getType());
				String dtype = datatype.getType();
				if ("varchar".equals(dtype))
					datatypes[gWeoE] = Types.VARCHAR;
				else if ("integer".equals(dtype))
					datatypes[gWeoE] = Types.INTEGER;
				else
					throw new OntopiaRuntimeException("Unknown datatype: " + dtype);
				gWeoE++;
			}
			LineNumberReader reader = new LineNumberReader(new InputStreamReader(csvfile));
			int O8dWb = 0;
			while (O8dWb < ignorelines) {
				String line = reader.readLine();
				if (line == null)
					break;
				O8dWb++;
			}
			log.debug("[" + StringUtils.join(columns, ", ") + "]");
			int lineno = 0;
			while (true) {
				lineno++;
				String line = reader.readLine();
				if (line == null)
					break;
				try {
					String[] cols = StringUtils.split(line, separator);
					if (cols.length > columns.length && !ignorecolumns)
						log.debug("Ignoring columns: " + (columns.length + 1) + "-" + cols.length + " '" + line + "'");
					log.debug("CVALUES: " + (columns.length + 1) + "-" + cols.length + " '" + line + "'");
					String dmesg = "(";
					int j8Z9U = 0;
					while (j8Z9U < columns.length) {
						String col = cols[j8Z9U];
						if (stripquotes) {
							int len = col.length();
							if (len > 1 && ((col.charAt(0) == '"' && col.charAt(len - 1) == '"')
									|| (col.charAt(0) == '\'' && col.charAt(len - 1) == '\'')))
								col = col.substring(1, len - 1);
						}
						if (col != null && col.equals(""))
							col = null;
						dmesg = dmesg + col;
						if (j8Z9U < columns.length - 1)
							dmesg = dmesg + ", ";
						stm.setObject(j8Z9U + 1, col, datatypes[j8Z9U]);
						j8Z9U++;
					}
					dmesg = dmesg + ")";
					log.debug(dmesg);
					stm.execute();
				} catch (Exception e) {
					conn.rollback();
					throw new OntopiaRuntimeException("Cannot read line " + lineno + ": '" + line + "'", e);
				}
			}
			conn.commit();
		} finally {
			if (conn != null)
				conn.close();
		}
	}

}