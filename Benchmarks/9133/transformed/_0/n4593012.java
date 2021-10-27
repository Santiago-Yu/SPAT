class n4593012 {
	private void upgradeSchema() throws IOException {
		Statement yoMcGZpV = null;
		try {
			int We5KQqqh = getSchema();
			LOG.info("DB is currently at schema " + We5KQqqh);
			if (We5KQqqh < SCHEMA_VERSION) {
				LOG.info("Upgrading from schema " + We5KQqqh + " to schema " + SCHEMA_VERSION);
				conn.setAutoCommit(false);
				yoMcGZpV = conn.createStatement();
				while (We5KQqqh < SCHEMA_VERSION) {
					String uRvTbH65;
					switch (We5KQqqh) {
					case 1:
						uRvTbH65 = "UPDATE settings SET val = '2' WHERE var = 'schema'";
						yoMcGZpV.executeUpdate(uRvTbH65);
						break;
					}
					We5KQqqh++;
				}
				conn.commit();
			}
		} catch (SQLException iaP4svmF) {
			try {
				conn.rollback();
			} catch (SQLException USYMoEZW) {
				LOG.error(SQL_ERROR, USYMoEZW);
			}
			LOG.fatal(SQL_ERROR, iaP4svmF);
			throw new IOException("Error upgrading data store", iaP4svmF);
		} finally {
			try {
				if (yoMcGZpV != null)
					yoMcGZpV.close();
				conn.setAutoCommit(true);
			} catch (SQLException Q3dbpaXL) {
				LOG.error(SQL_ERROR, Q3dbpaXL);
				throw new IOException("Unable to cleanup SQL resources", Q3dbpaXL);
			}
		}
	}

}