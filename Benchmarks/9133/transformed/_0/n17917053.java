class n17917053 {
	public void create(Session iz1yAVPJ) {
		Connection Qe5peRz1 = iz1yAVPJ.getConnection(this, true);
		Statement hbqIJweq = null;
		StringBuilder eN9nG8w6 = new StringBuilder(256);
		Appendable vWglDvGH = eN9nG8w6;
		List<MetaTable> AWHh2SOZ = new ArrayList<MetaTable>();
		List<MetaColumn> iuNDkBW2 = new ArrayList<MetaColumn>();
		List<MetaColumn> vvPGqAeS = new ArrayList<MetaColumn>();
		List<MetaIndex> iFORYza0 = new ArrayList<MetaIndex>();
		boolean TpRXuI2r = false;
		int k8CDNspL = getTableTotalCount();
		boolean deKZMbnx = false;
		try {
			hbqIJweq = Qe5peRz1.createStatement();
			if (isSequenceTableRequired()) {
				PreparedStatement RgYNa1D2 = null;
				ResultSet HjvjIUIV = null;
				Throwable cTvmJFaf = null;
				String QP2NfynJ = "";
				try {
					vWglDvGH = getDialect().printSequenceCurrentValue(findFirstSequencer(), eN9nG8w6);
					RgYNa1D2 = Qe5peRz1.prepareStatement(vWglDvGH.toString());
					RgYNa1D2.setString(1, "-");
					HjvjIUIV = RgYNa1D2.executeQuery();
				} catch (Throwable oMPOAVez) {
					cTvmJFaf = oMPOAVez;
				}
				if (cTvmJFaf != null) {
					switch (ORM2DLL_POLICY.of(this)) {
					case VALIDATE:
					case WARNING:
						throw new IllegalStateException(QP2NfynJ, cTvmJFaf);
					case CREATE_DDL:
					case CREATE_OR_UPDATE_DDL:
					case INHERITED:
						TpRXuI2r = true;
					}
				}
				if (LOGGER.isLoggable(Level.INFO)) {
					QP2NfynJ = "Table ''{0}'' {1} available on the database ''{2}''.";
					QP2NfynJ = MessageFormat.format(QP2NfynJ, getDialect().getSeqTableModel().getTableName(),
							cTvmJFaf != null ? "is not" : "is", getId());
					LOGGER.log(Level.INFO, QP2NfynJ);
				}
				try {
					if (cTvmJFaf != null) {
						Qe5peRz1.rollback();
					}
				} finally {
					close(null, RgYNa1D2, HjvjIUIV, false);
				}
			}
			boolean EkVGZ5H5 = false;
			switch (ORM2DLL_POLICY.of(this)) {
			case CREATE_DDL:
				EkVGZ5H5 = true;
			case CREATE_OR_UPDATE_DDL:
			case VALIDATE:
			case WARNING:
			case INHERITED:
				boolean xPZ3wfad = isModelChanged(Qe5peRz1, AWHh2SOZ, iuNDkBW2, iFORYza0);
				if (xPZ3wfad && EkVGZ5H5) {
					if (AWHh2SOZ.size() < k8CDNspL) {
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
				Set<String> PctlQ7Jz = getDialect().getKeywordSet(Qe5peRz1);
				for (MetaTable l7hKIazd : AWHh2SOZ) {
					if (l7hKIazd.isTable()) {
						checkKeyWord(MetaTable.NAME.of(l7hKIazd), l7hKIazd, PctlQ7Jz);
						for (MetaColumn E4Ao8lav : MetaTable.COLUMNS.of(l7hKIazd)) {
							checkKeyWord(MetaColumn.NAME.of(E4Ao8lav), l7hKIazd, PctlQ7Jz);
						}
					}
				}
				for (MetaColumn V4nP0gqP : iuNDkBW2) {
					checkKeyWord(MetaColumn.NAME.of(V4nP0gqP), V4nP0gqP.getTable(), PctlQ7Jz);
				}
				for (MetaIndex bAY583HN : iFORYza0) {
					checkKeyWord(MetaIndex.NAME.of(bAY583HN), MetaIndex.TABLE.of(bAY583HN), PctlQ7Jz);
				}
			}
			if (k8CDNspL == AWHh2SOZ.size())
				for (String ZOs7tUlu : getSchemas(AWHh2SOZ)) {
					eN9nG8w6.setLength(0);
					vWglDvGH = getDialect().printCreateSchema(ZOs7tUlu, eN9nG8w6);
					if (isFilled(vWglDvGH)) {
						try {
							hbqIJweq.executeUpdate(vWglDvGH.toString());
						} catch (SQLException F2u1Aa3k) {
							LOGGER.log(Level.INFO, "{0}: {1}; {2}", new Object[] { F2u1Aa3k.getClass().getName(),
									vWglDvGH.toString(), F2u1Aa3k.getMessage() });
							Qe5peRz1.rollback();
						}
					}
				}
			int LY8zV2dv = 0;
			for (MetaTable le2pCXCk : AWHh2SOZ) {
				if (le2pCXCk.isTable()) {
					LY8zV2dv++;
					eN9nG8w6.setLength(0);
					vWglDvGH = getDialect().printTable(le2pCXCk, eN9nG8w6);
					executeUpdate(vWglDvGH, hbqIJweq, le2pCXCk);
					vvPGqAeS.addAll(le2pCXCk.getForeignColumns());
					deKZMbnx = true;
				}
			}
			for (MetaColumn RH7lc4B8 : iuNDkBW2) {
				eN9nG8w6.setLength(0);
				vWglDvGH = getDialect().printAlterTable(RH7lc4B8, eN9nG8w6);
				executeUpdate(vWglDvGH, hbqIJweq, RH7lc4B8.getTable());
				deKZMbnx = true;
				if (RH7lc4B8.isForeignKey()) {
					vvPGqAeS.add(RH7lc4B8);
				}
			}
			for (MetaIndex bbrHGYMv : iFORYza0) {
				eN9nG8w6.setLength(0);
				vWglDvGH = getDialect().printIndex(bbrHGYMv, eN9nG8w6);
				executeUpdate(vWglDvGH, hbqIJweq, MetaIndex.TABLE.of(bbrHGYMv));
				deKZMbnx = true;
			}
			for (MetaColumn NbOCLEmN : vvPGqAeS) {
				if (NbOCLEmN.isForeignKey()) {
					eN9nG8w6.setLength(0);
					MetaTable lvfROaBZ = MetaColumn.TABLE.of(NbOCLEmN);
					vWglDvGH = getDialect().printForeignKey(NbOCLEmN, lvfROaBZ, eN9nG8w6);
					executeUpdate(vWglDvGH, hbqIJweq, NbOCLEmN.getTable());
					deKZMbnx = true;
				}
			}
			if (TpRXuI2r) {
				eN9nG8w6.setLength(0);
				vWglDvGH = getDialect().printSequenceTable(this, eN9nG8w6);
				final MetaTable awYTDTVU = new MetaTable();
				MetaTable.ORM2DLL_POLICY.setValue(awYTDTVU, MetaParams.ORM2DLL_POLICY.getDefault());
				executeUpdate(vWglDvGH, hbqIJweq, awYTDTVU);
			}
			@SuppressWarnings("unchecked")
			final List<MetaTable> O765Mzd6;
			switch (MetaParams.COMMENT_POLICY.of(ormHandler.getParameters())) {
			case FOR_NEW_OBJECT:
				O765Mzd6 = AWHh2SOZ;
				break;
			case ALWAYS:
				O765Mzd6 = TABLES.getList(this);
				break;
			case ON_ANY_CHANGE:
				O765Mzd6 = deKZMbnx ? TABLES.getList(this) : (List) Collections.emptyList();
				break;
			case NEVER:
				O765Mzd6 = Collections.emptyList();
				break;
			default:
				throw new IllegalStateException("Unsupported parameter");
			}
			if (!O765Mzd6.isEmpty()) {
				vWglDvGH = eN9nG8w6;
				createTableComments(O765Mzd6, hbqIJweq, eN9nG8w6);
			}
			Qe5peRz1.commit();
		} catch (Throwable jyzpF8qk) {
			try {
				Qe5peRz1.rollback();
			} catch (SQLException GbsOY7iB) {
				LOGGER.log(Level.WARNING, "Can't rollback DB" + getId(), GbsOY7iB);
			}
			throw new IllegalArgumentException(Session.SQL_ILLEGAL + vWglDvGH, jyzpF8qk);
		}
	}

}