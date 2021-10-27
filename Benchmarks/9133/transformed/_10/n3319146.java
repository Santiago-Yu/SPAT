class n3319146 {
	public void create(Session session) {
		Statement stat = null;
		Connection conn = session.getConnection(this);
		StringBuilder out = new StringBuilder(256);
		List<MetaTable> tables = new ArrayList<MetaTable>();
		Appendable sql = out;
		List<MetaColumn> foreignColumns = new ArrayList<MetaColumn>();
		List<MetaColumn> newColumns = new ArrayList<MetaColumn>();
		boolean createSequenceTable = false;
		List<MetaIndex> indexes = new ArrayList<MetaIndex>();
		int tableTotalCount = getTableTotalCount();
		try {
			stat = conn.createStatement();
			boolean ddlOnly = false;
			if (isSequenceTableRequired()) {
				PreparedStatement ps = null;
				ResultSet rs = null;
				Throwable exception = null;
				String logMsg = "";
				try {
					sql = getDialect().printSequenceCurrentValue(findFirstSequencer(), out);
					ps = conn.prepareStatement(sql.toString());
					ps.setString(1, "-");
					rs = ps.executeQuery();
				} catch (Throwable e) {
					exception = e;
				}
				if (exception != null) {
					switch (MetaParams.ORM2DLL_POLICY.of(ormHandler.getParameters())) {
					case VALIDATE:
						throw new IllegalStateException(logMsg, exception);
					case CREATE_DDL:
					case CREATE_OR_UPDATE_DDL:
						createSequenceTable = true;
					}
				}
				if (LOGGER.isLoggable(Level.INFO)) {
					logMsg = "Table '" + SqlDialect.COMMON_SEQ_TABLE_NAME + "' {0} available on the database '{1}'.";
					logMsg = MessageFormat.format(logMsg, exception != null ? "is not" : "is", getId());
					LOGGER.log(Level.INFO, logMsg);
				}
				try {
					if (exception != null) {
						conn.rollback();
					}
				} finally {
					close(null, ps, rs, false);
				}
			}
			switch (MetaParams.ORM2DLL_POLICY.of(ormHandler.getParameters())) {
			case CREATE_DDL:
				ddlOnly = true;
			case CREATE_OR_UPDATE_DDL:
			case VALIDATE:
				boolean change = isModelChanged(conn, tables, newColumns, indexes);
				if (change && ddlOnly) {
					if (tables.size() < tableTotalCount) {
						return;
					}
				}
				break;
			case DO_NOTHING:
			default:
				return;
			}
			switch (MetaParams.CHECK_KEYWORDS.of(getParams())) {
			case WARNING:
			case EXCEPTION:
				Set<String> keywords = getDialect().getKeywordSet(conn);
				for (MetaTable table : tables) {
					if (table.isTable()) {
						checkKeyWord(MetaTable.NAME.of(table), table, keywords);
						for (MetaColumn column : MetaTable.COLUMNS.of(table)) {
							checkKeyWord(MetaColumn.NAME.of(column), table, keywords);
						}
					}
				}
				for (MetaColumn column : newColumns) {
					checkKeyWord(MetaColumn.NAME.of(column), column.getTable(), keywords);
				}
				for (MetaIndex index : indexes) {
					checkKeyWord(MetaIndex.NAME.of(index), MetaIndex.TABLE.of(index), keywords);
				}
			}
			int tableCount = 0;
			if (tableTotalCount == tables.size())
				for (String schema : getSchemas(tables)) {
					out.setLength(0);
					sql = getDialect().printCreateSchema(schema, out);
					if (isUsable(sql)) {
						try {
							stat.executeUpdate(sql.toString());
						} catch (SQLException e) {
							LOGGER.log(Level.INFO, "{0}: {1}; {2}",
									new Object[] { e.getClass().getName(), sql.toString(), e.getMessage() });
							conn.rollback();
						}
					}
				}
			for (MetaTable table : tables) {
				if (table.isTable()) {
					tableCount++;
					out.setLength(0);
					sql = getDialect().printTable(table, out);
					executeUpdate(sql, stat);
					foreignColumns.addAll(table.getForeignColumns());
				}
			}
			for (MetaColumn column : newColumns) {
				out.setLength(0);
				sql = getDialect().printAlterTable(column, out);
				executeUpdate(sql, stat);
				if (column.isForeignKey()) {
					foreignColumns.add(column);
				}
			}
			for (MetaIndex index : indexes) {
				out.setLength(0);
				sql = getDialect().printIndex(index, out);
				executeUpdate(sql, stat);
			}
			for (MetaColumn column : foreignColumns) {
				if (column.isForeignKey()) {
					out.setLength(0);
					MetaTable table = MetaColumn.TABLE.of(column);
					sql = getDialect().printForeignKey(column, table, out);
					executeUpdate(sql, stat);
				}
			}
			List<MetaTable> cTables = null;
			if (createSequenceTable) {
				out.setLength(0);
				sql = getDialect().printSequenceTable(this, out);
				executeUpdate(sql, stat);
			}
			switch (MetaParams.COMMENT_POLICY.of(ormHandler.getParameters())) {
			case FOR_NEW_OBJECT:
				cTables = tables;
				break;
			case ALWAYS:
			case ON_ANY_CHANGE:
				cTables = TABLES.getList(this);
				break;
			case NEVER:
				cTables = Collections.emptyList();
				break;
			default:
				throw new IllegalStateException("Unsupported parameter");
			}
			if (!cTables.isEmpty()) {
				sql = out;
				createTableComments(cTables, stat, out);
			}
			conn.commit();
		} catch (Throwable e) {
			try {
				conn.rollback();
			} catch (SQLException ex) {
				LOGGER.log(Level.WARNING, "Can't rollback DB" + getId(), ex);
			}
			throw new IllegalArgumentException(Session.SQL_ILLEGAL + sql, e);
		}
	}

}