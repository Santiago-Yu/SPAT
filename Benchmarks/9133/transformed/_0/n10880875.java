class n10880875 {
	@Override
	public final boolean save() throws RecordException, RecordValidationException, RecordValidationSyntax {
		if (frozen) {
			throw new RecordException("The object is frozen.");
		}
		boolean uRSmbbvY = false;
		Class<? extends Record> WdBW5WB7 = this.getClass();
		HashMap<String, Integer> qPqFCUKt = getColumns(TableNameResolver.getTableName(WdBW5WB7));
		Connection okfT0r1W = ConnectionManager.getConnection();
		LoggableStatement JKB3XXur = null;
		try {
			if (exists()) {
				doValidations(true);
				StatementBuilder NtsVOaaE = new StatementBuilder(
						"update " + TableNameResolver.getTableName(WdBW5WB7) + " set");
				String yKdPuuZ2 = "";
				for (String vQpD497J : qPqFCUKt.keySet()) {
					if (!vQpD497J.equals("id")) {
						Field ofjq7RUS = null;
						try {
							ofjq7RUS = FieldHandler.findField(WdBW5WB7, vQpD497J);
						} catch (FieldOrMethodNotFoundException HRtVjAGq) {
							throw new RecordException("Database column name >" + vQpD497J + "< not found in class "
									+ WdBW5WB7.getCanonicalName());
						}
						yKdPuuZ2 += vQpD497J + " = :" + vQpD497J + ", ";
						NtsVOaaE.set(vQpD497J, FieldHandler.getValue(ofjq7RUS, this));
					}
				}
				NtsVOaaE.append(yKdPuuZ2.substring(0, yKdPuuZ2.length() - 2));
				NtsVOaaE.append("where id = :id");
				NtsVOaaE.set(":id", FieldHandler.getValue(FieldHandler.findField(WdBW5WB7, "id"), this));
				JKB3XXur = NtsVOaaE.getPreparedStatement(okfT0r1W);
				log.log(JKB3XXur.getQueryString());
				int jGAlcIJA = JKB3XXur.executeUpdate();
				uRSmbbvY = jGAlcIJA == 1;
			} else {
				doValidations(false);
				StatementBuilder p3mndfks = new StatementBuilder(
						"insert into " + TableNameResolver.getTableName(WdBW5WB7) + " ");
				String S04Homie = "";
				String m46Avjsz = "";
				for (String THURKaUW : qPqFCUKt.keySet()) {
					Field O1Ieem72 = null;
					try {
						O1Ieem72 = FieldHandler.findField(WdBW5WB7, THURKaUW);
					} catch (FieldOrMethodNotFoundException VeAMtX8h) {
						throw new RecordException("Database column name >" + THURKaUW + "< not found in class "
								+ WdBW5WB7.getCanonicalName());
					}
					if (THURKaUW.equals("id") && (Integer) FieldHandler.getValue(O1Ieem72, this) == 0) {
						continue;
					}
					S04Homie += THURKaUW + ", ";
					m46Avjsz += ":" + THURKaUW + ", ";
					p3mndfks.set(THURKaUW, O1Ieem72.get(this));
				}
				S04Homie = S04Homie.substring(0, S04Homie.length() - 2);
				m46Avjsz = m46Avjsz.substring(0, m46Avjsz.length() - 2);
				p3mndfks.append("(" + S04Homie + ")");
				p3mndfks.append("values");
				p3mndfks.append("(" + m46Avjsz + ")");
				JKB3XXur = p3mndfks.getPreparedStatement(okfT0r1W);
				log.log(JKB3XXur.getQueryString());
				int iLS41b7d = JKB3XXur.executeUpdate();
				uRSmbbvY = iLS41b7d == 1;
			}
			if (childList != null) {
				if (childObjects == null) {
					childObjects = new HashMap<Class<? extends Record>, Record>();
				}
				for (Class<? extends Record> sAcUo1Vw : childList.keySet()) {
					if (childObjects.get(sAcUo1Vw) != null) {
						childObjects.get(sAcUo1Vw).save();
					}
				}
			}
			if (childrenList != null) {
				if (childrenObjects == null) {
					childrenObjects = new HashMap<Class<? extends Record>, List<? extends Record>>();
				}
				for (Class<? extends Record> kbFZ6tcQ : childrenList.keySet()) {
					if (childrenObjects.get(kbFZ6tcQ) != null) {
						for (Record eZkuPZAR : childrenObjects.get(kbFZ6tcQ)) {
							eZkuPZAR.save();
						}
					}
				}
			}
			if (relatedList != null) {
				if (childrenObjects == null) {
					childrenObjects = new HashMap<Class<? extends Record>, List<? extends Record>>();
				}
				for (Class<? extends Record> jKHHOuM5 : relatedList.keySet()) {
					if (childrenObjects.get(jKHHOuM5) != null) {
						for (Record Uk93teGK : childrenObjects.get(jKHHOuM5)) {
							Uk93teGK.save();
						}
					}
				}
			}
			return uRSmbbvY;
		} catch (Exception HdCvL9RT) {
			if (HdCvL9RT instanceof RecordValidationException) {
				throw (RecordValidationException) HdCvL9RT;
			}
			if (HdCvL9RT instanceof RecordValidationSyntax) {
				throw (RecordValidationSyntax) HdCvL9RT;
			}
			try {
				okfT0r1W.rollback();
			} catch (SQLException MY3twW2K) {
				throw new RecordException("Error executing rollback");
			}
			throw new RecordException(HdCvL9RT);
		} finally {
			try {
				if (JKB3XXur != null) {
					JKB3XXur.close();
				}
				okfT0r1W.commit();
				okfT0r1W.close();
			} catch (SQLException tuWVR7NE) {
				throw new RecordException("Error closing connection");
			}
		}
	}

}