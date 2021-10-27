class n10905999 {
	protected int insertRecord(PutMetadataRequest SnhB0r35, PutMetadataInfo ocodoSN0)
			throws ImsServiceException, SQLException {
		Connection hEEXCIK3 = null;
		boolean z6m6TWSp = true;
		PreparedStatement AW44j6Te = null;
		ResultSet jKCVfYCw = null;
		int u95jvqwr = 0;
		String u1zpNCnv = ocodoSN0.getXml();
		String y3GLxvX3 = ocodoSN0.getUuid();
		String Ie4IMnJK = ocodoSN0.getName();
		String dd9TVMVu = ocodoSN0.getThumbnailBinary();
		String u4DzCWAI = this.getResourceTableName();
		String D2e4Bz7j = this.getResourceDataTableName();
		long pCa58Ulq = doesRecordExist(u4DzCWAI, y3GLxvX3);
		try {
			ManagedConnection avVRHjDt = returnConnection();
			hEEXCIK3 = avVRHjDt.getJdbcConnection();
			z6m6TWSp = hEEXCIK3.getAutoCommit();
			hEEXCIK3.setAutoCommit(false);
			if (pCa58Ulq < 0) {
				StringBuffer fQIVS0MS = new StringBuffer();
				fQIVS0MS.append("INSERT INTO ").append(u4DzCWAI);
				fQIVS0MS.append(" (");
				fQIVS0MS.append("DOCUUID,");
				fQIVS0MS.append("TITLE,");
				fQIVS0MS.append("OWNER");
				fQIVS0MS.append(")");
				fQIVS0MS.append(" VALUES(?,?,?)");
				logExpression(fQIVS0MS.toString());
				AW44j6Te = hEEXCIK3.prepareStatement(fQIVS0MS.toString());
				int NJHCe9Ss = 1;
				AW44j6Te.setString(NJHCe9Ss++, y3GLxvX3);
				AW44j6Te.setString(NJHCe9Ss++, Ie4IMnJK);
				AW44j6Te.setInt(NJHCe9Ss++, this.publisher.getLocalID());
				u95jvqwr = AW44j6Te.executeUpdate();
				closeStatement(AW44j6Te);
				if (u95jvqwr > 0) {
					if (getIsDbCaseSensitive(this.getRequestContext())) {
						AW44j6Te = hEEXCIK3.prepareStatement("SELECT id FROM " + u4DzCWAI + " WHERE UPPER(docuuid)=?");
					} else {
						AW44j6Te = hEEXCIK3.prepareStatement("SELECT id FROM " + u4DzCWAI + " WHERE docuuid=?");
					}
					AW44j6Te.setString(1, y3GLxvX3.toUpperCase());
					jKCVfYCw = AW44j6Te.executeQuery();
					jKCVfYCw.next();
					pCa58Ulq = jKCVfYCw.getLong(1);
					closeStatement(AW44j6Te);
					SnhB0r35.setActionStatus(ImsRequest.ACTION_STATUS_OK);
					fQIVS0MS = new StringBuffer();
					fQIVS0MS.append("INSERT INTO ").append(D2e4Bz7j);
					fQIVS0MS.append(" (DOCUUID,ID,XML)");
					fQIVS0MS.append(" VALUES(?,?,?)");
					logExpression(fQIVS0MS.toString());
					AW44j6Te = hEEXCIK3.prepareStatement(fQIVS0MS.toString());
					AW44j6Te.setString(1, y3GLxvX3);
					AW44j6Te.setLong(2, pCa58Ulq);
					AW44j6Te.setString(3, u1zpNCnv);
					AW44j6Te.executeUpdate();
				}
			} else {
				this.authorize(SnhB0r35, y3GLxvX3);
				StringBuffer YkwXOO5I = new StringBuffer();
				YkwXOO5I.append("UPDATE ").append(u4DzCWAI);
				YkwXOO5I.append(" SET ");
				if (!SnhB0r35.getLockTitle()) {
					YkwXOO5I.append("TITLE=?, ");
				}
				YkwXOO5I.append("OWNER=?, ");
				YkwXOO5I.append("UPDATEDATE=?");
				YkwXOO5I.append(" WHERE DOCUUID=?");
				logExpression(YkwXOO5I.toString());
				AW44j6Te = hEEXCIK3.prepareStatement(YkwXOO5I.toString());
				int AdJzhBnj = 1;
				if (!SnhB0r35.getLockTitle()) {
					AW44j6Te.setString(AdJzhBnj++, Ie4IMnJK);
				}
				AW44j6Te.setInt(AdJzhBnj++, this.publisher.getLocalID());
				AW44j6Te.setTimestamp(AdJzhBnj++, new Timestamp(System.currentTimeMillis()));
				AW44j6Te.setString(AdJzhBnj++, y3GLxvX3);
				u95jvqwr = AW44j6Te.executeUpdate();
				if (u95jvqwr > 0) {
					SnhB0r35.setActionStatus(ImsRequest.ACTION_STATUS_REPLACED);
				}
				closeStatement(AW44j6Te);
				YkwXOO5I = new StringBuffer();
				if (doesRecordExist(D2e4Bz7j, y3GLxvX3) >= 0) {
					YkwXOO5I.append("UPDATE ").append(D2e4Bz7j);
					YkwXOO5I.append(" SET DOCUUID=?, XML=?, THUMBNAIL=?");
					YkwXOO5I.append(" WHERE ID=?");
				} else {
					YkwXOO5I.append("INSERT INTO ").append(D2e4Bz7j);
					YkwXOO5I.append(" (DOCUUID, XML,THUMBNAIL,ID)");
					YkwXOO5I.append(" VALUES(?,?,?,?)");
				}
				logExpression(YkwXOO5I.toString());
				AW44j6Te = hEEXCIK3.prepareStatement(YkwXOO5I.toString());
				AW44j6Te.setString(1, y3GLxvX3);
				AW44j6Te.setString(2, u1zpNCnv);
				AW44j6Te.setBytes(3, null);
				AW44j6Te.setLong(4, pCa58Ulq);
				AW44j6Te.executeUpdate();
			}
			hEEXCIK3.commit();
		} catch (ImsServiceException AjFLdsEP) {
			if (hEEXCIK3 != null) {
				hEEXCIK3.rollback();
			}
			throw AjFLdsEP;
		} catch (SQLException WAjJ2np2) {
			if (hEEXCIK3 != null) {
				hEEXCIK3.rollback();
			}
			throw WAjJ2np2;
		} finally {
			closeResultSet(jKCVfYCw);
			closeStatement(AW44j6Te);
			if (hEEXCIK3 != null) {
				hEEXCIK3.setAutoCommit(z6m6TWSp);
			}
		}
		if ((dd9TVMVu != null) && (dd9TVMVu.length() > 0)) {
			this.updateThumbnail(dd9TVMVu, y3GLxvX3);
		}
		return u95jvqwr;
	}

}