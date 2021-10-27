class n3319146 {
	public void create(Session C7NvOmgM) {
		Connection v76x1OtY = C7NvOmgM.getConnection(this);
		Statement HXwO2jYz = null;
		StringBuilder IDnpks6m = new StringBuilder(256);
		Appendable eKBXf2oI = IDnpks6m;
		List<MetaTable> IcnvJHbj = new ArrayList<MetaTable>();
		List<MetaColumn> rCiOYzIl = new ArrayList<MetaColumn>();
		List<MetaColumn> epqYUAhv = new ArrayList<MetaColumn>();
		List<MetaIndex> OKWh87sr = new ArrayList<MetaIndex>();
		boolean coYAT5Lp = false;
		int nLY5Ro7u = getTableTotalCount();
		try {
			HXwO2jYz = v76x1OtY.createStatement();
			if (isSequenceTableRequired()) {
				PreparedStatement HX99VteS = null;
				ResultSet tOZGm0O4 = null;
				Throwable wZ8V14sR = null;
				String cYQqgdJy = "";
				try {
					eKBXf2oI = getDialect().printSequenceCurrentValue(findFirstSequencer(), IDnpks6m);
					HX99VteS = v76x1OtY.prepareStatement(eKBXf2oI.toString());
					HX99VteS.setString(1, "-");
					tOZGm0O4 = HX99VteS.executeQuery();
				} catch (Throwable ciUVPRWU) {
					wZ8V14sR = ciUVPRWU;
				}
				if (wZ8V14sR != null) {
					switch (MetaParams.ORM2DLL_POLICY.of(ormHandler.getParameters())) {
					case VALIDATE:
						throw new IllegalStateException(cYQqgdJy, wZ8V14sR);
					case CREATE_DDL:
					case CREATE_OR_UPDATE_DDL:
						coYAT5Lp = true;
					}
				}
				if (LOGGER.isLoggable(Level.INFO)) {
					cYQqgdJy = "Table '" + SqlDialect.COMMON_SEQ_TABLE_NAME + "' {0} available on the database '{1}'.";
					cYQqgdJy = MessageFormat.format(cYQqgdJy, wZ8V14sR != null ? "is not" : "is", getId());
					LOGGER.log(Level.INFO, cYQqgdJy);
				}
				try {
					if (wZ8V14sR != null) {
						v76x1OtY.rollback();
					}
				} finally {
					close(null, HX99VteS, tOZGm0O4, false);
				}
			}
			boolean RZPuSxPl = false;
			switch (MetaParams.ORM2DLL_POLICY.of(ormHandler.getParameters())) {
			case CREATE_DDL:
				RZPuSxPl = true;
			case CREATE_OR_UPDATE_DDL:
			case VALIDATE:
				boolean Vf3yGoz4 = isModelChanged(v76x1OtY, IcnvJHbj, rCiOYzIl, OKWh87sr);
				if (Vf3yGoz4 && RZPuSxPl) {
					if (IcnvJHbj.size() < nLY5Ro7u) {
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
				Set<String> aD0EI18g = getDialect().getKeywordSet(v76x1OtY);
				for (MetaTable HdjFHsUM : IcnvJHbj) {
					if (HdjFHsUM.isTable()) {
						checkKeyWord(MetaTable.NAME.of(HdjFHsUM), HdjFHsUM, aD0EI18g);
						for (MetaColumn gwLos0Lt : MetaTable.COLUMNS.of(HdjFHsUM)) {
							checkKeyWord(MetaColumn.NAME.of(gwLos0Lt), HdjFHsUM, aD0EI18g);
						}
					}
				}
				for (MetaColumn OMUffqEH : rCiOYzIl) {
					checkKeyWord(MetaColumn.NAME.of(OMUffqEH), OMUffqEH.getTable(), aD0EI18g);
				}
				for (MetaIndex szMJebl3 : OKWh87sr) {
					checkKeyWord(MetaIndex.NAME.of(szMJebl3), MetaIndex.TABLE.of(szMJebl3), aD0EI18g);
				}
			}
			if (nLY5Ro7u == IcnvJHbj.size())
				for (String YkhxJnrP : getSchemas(IcnvJHbj)) {
					IDnpks6m.setLength(0);
					eKBXf2oI = getDialect().printCreateSchema(YkhxJnrP, IDnpks6m);
					if (isUsable(eKBXf2oI)) {
						try {
							HXwO2jYz.executeUpdate(eKBXf2oI.toString());
						} catch (SQLException PVDf44pS) {
							LOGGER.log(Level.INFO, "{0}: {1}; {2}", new Object[] { PVDf44pS.getClass().getName(),
									eKBXf2oI.toString(), PVDf44pS.getMessage() });
							v76x1OtY.rollback();
						}
					}
				}
			int NxzwWaML = 0;
			for (MetaTable zuHLf0HM : IcnvJHbj) {
				if (zuHLf0HM.isTable()) {
					NxzwWaML++;
					IDnpks6m.setLength(0);
					eKBXf2oI = getDialect().printTable(zuHLf0HM, IDnpks6m);
					executeUpdate(eKBXf2oI, HXwO2jYz);
					epqYUAhv.addAll(zuHLf0HM.getForeignColumns());
				}
			}
			for (MetaColumn Fz0NxQHA : rCiOYzIl) {
				IDnpks6m.setLength(0);
				eKBXf2oI = getDialect().printAlterTable(Fz0NxQHA, IDnpks6m);
				executeUpdate(eKBXf2oI, HXwO2jYz);
				if (Fz0NxQHA.isForeignKey()) {
					epqYUAhv.add(Fz0NxQHA);
				}
			}
			for (MetaIndex JmeF4Yqv : OKWh87sr) {
				IDnpks6m.setLength(0);
				eKBXf2oI = getDialect().printIndex(JmeF4Yqv, IDnpks6m);
				executeUpdate(eKBXf2oI, HXwO2jYz);
			}
			for (MetaColumn XysYtfYr : epqYUAhv) {
				if (XysYtfYr.isForeignKey()) {
					IDnpks6m.setLength(0);
					MetaTable GzewQ0Cg = MetaColumn.TABLE.of(XysYtfYr);
					eKBXf2oI = getDialect().printForeignKey(XysYtfYr, GzewQ0Cg, IDnpks6m);
					executeUpdate(eKBXf2oI, HXwO2jYz);
				}
			}
			if (coYAT5Lp) {
				IDnpks6m.setLength(0);
				eKBXf2oI = getDialect().printSequenceTable(this, IDnpks6m);
				executeUpdate(eKBXf2oI, HXwO2jYz);
			}
			List<MetaTable> e4XUBlUK = null;
			switch (MetaParams.COMMENT_POLICY.of(ormHandler.getParameters())) {
			case FOR_NEW_OBJECT:
				e4XUBlUK = IcnvJHbj;
				break;
			case ALWAYS:
			case ON_ANY_CHANGE:
				e4XUBlUK = TABLES.getList(this);
				break;
			case NEVER:
				e4XUBlUK = Collections.emptyList();
				break;
			default:
				throw new IllegalStateException("Unsupported parameter");
			}
			if (!e4XUBlUK.isEmpty()) {
				eKBXf2oI = IDnpks6m;
				createTableComments(e4XUBlUK, HXwO2jYz, IDnpks6m);
			}
			v76x1OtY.commit();
		} catch (Throwable svRjrvHK) {
			try {
				v76x1OtY.rollback();
			} catch (SQLException EQfjfon8) {
				LOGGER.log(Level.WARNING, "Can't rollback DB" + getId(), EQfjfon8);
			}
			throw new IllegalArgumentException(Session.SQL_ILLEGAL + eKBXf2oI, svRjrvHK);
		}
	}

}