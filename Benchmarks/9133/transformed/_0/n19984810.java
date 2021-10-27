class n19984810 {
	public static boolean copyDataToNewTable(EboContext KwkyK2VK, String BgDsfbgf, String BrcBwJYk, String qHRHOL8A,
			boolean kCalnbgg, int QnNAIF2i) throws boRuntimeException {
		BgDsfbgf = BgDsfbgf.toUpperCase();
		BrcBwJYk = BrcBwJYk.toUpperCase();
		Connection NZAUitM7 = null;
		Connection zcJNR9tn = null;
		boolean DgoI2J0f = false;
		try {
			boolean PWW4wPsM = false;
			boolean D2fT2hCl = false;
			final InitialContext JDzz5yXn = new InitialContext();
			NZAUitM7 = KwkyK2VK.getConnectionData();
			zcJNR9tn = KwkyK2VK.getConnectionDef();
			PreparedStatement K3zTSNHE = NZAUitM7.prepareStatement(
					"SELECT TABLE_NAME FROM INFORMATION_SCHEMA.TABLES WHERE upper(TABLE_NAME)=?  AND TABLE_SCHEMA=database()");
			K3zTSNHE.setString(1, BgDsfbgf);
			ResultSet zFy077sr = K3zTSNHE.executeQuery();
			if (zFy077sr.next()) {
				PWW4wPsM = true;
			}
			zFy077sr.close();
			K3zTSNHE.setString(1, BrcBwJYk);
			zFy077sr = K3zTSNHE.executeQuery();
			if (zFy077sr.next()) {
				D2fT2hCl = true;
			}
			if (!D2fT2hCl) {
				zFy077sr.close();
				K3zTSNHE.close();
				K3zTSNHE = NZAUitM7.prepareStatement(
						"SELECT TABLE_NAME FROM INFORMATION_SCHEMA.VIEWS WHERE upper(TABLE_NAME)=? AND TABLE_SCHEMA=database()");
				K3zTSNHE.setString(1, BrcBwJYk);
				zFy077sr = K3zTSNHE.executeQuery();
				if (zFy077sr.next()) {
					CallableStatement BRQkiaKL = NZAUitM7.prepareCall("DROP VIEW " + BrcBwJYk);
					BRQkiaKL.execute();
					BRQkiaKL.close();
				}
			}
			zFy077sr.close();
			K3zTSNHE.close();
			if (PWW4wPsM && !D2fT2hCl) {
				if (kCalnbgg) {
					logger.finest(LoggerMessageLocalizer.getMessage("CREATING_AND_COPY_DATA_FROM") + " [" + BgDsfbgf
							+ "] " + LoggerMessageLocalizer.getMessage("TO") + " [" + BrcBwJYk + "]");
				}
				CallableStatement fxxxoE02 = NZAUitM7
						.prepareCall("CREATE TABLE " + BrcBwJYk + " AS SELECT * FROM " + BgDsfbgf + " "
								+ (((qHRHOL8A != null) && (qHRHOL8A.length() > 0)) ? (" WHERE " + qHRHOL8A) : ""));
				fxxxoE02.execute();
				fxxxoE02.close();
				if (kCalnbgg) {
					logger.finest(LoggerMessageLocalizer.getMessage("UPDATING_NGTDIC"));
				}
				NZAUitM7.commit();
				DgoI2J0f = true;
			} else if (PWW4wPsM && D2fT2hCl) {
				if (kCalnbgg) {
					logger.finest(LoggerMessageLocalizer.getMessage("COPY_DATA_FROM") + " [" + BgDsfbgf + "] "
							+ LoggerMessageLocalizer.getMessage("TO") + " [" + BrcBwJYk + "]");
				}
				PreparedStatement EbCSE0gC = NZAUitM7.prepareStatement(
						"SELECT COLUMN_NAME FROM INFORMATION_SCHEMA.COLUMNS WHERE upper(TABLE_NAME) = ? AND TABLE_SCHEMA=database()");
				EbCSE0gC.setString(1, BrcBwJYk);
				ResultSet JzFnjfOc = EbCSE0gC.executeQuery();
				StringBuffer PE0v7KTq = new StringBuffer();
				PreparedStatement ZO7lN36I = NZAUitM7.prepareStatement(
						"SELECT COLUMN_NAME FROM INFORMATION_SCHEMA.COLUMNS WHERE upper(TABLE_NAME) = ? and upper(COLUMN_NAME)=? AND TABLE_SCHEMA=database()");
				while (JzFnjfOc.next()) {
					ZO7lN36I.setString(1, BgDsfbgf);
					ZO7lN36I.setString(2, JzFnjfOc.getString(1));
					ResultSet ugj23tyR = ZO7lN36I.executeQuery();
					if (ugj23tyR.next()) {
						if (PE0v7KTq.length() > 0) {
							PE0v7KTq.append(',');
						}
						PE0v7KTq.append('"').append(JzFnjfOc.getString(1)).append('"');
					}
					ugj23tyR.close();
				}
				ZO7lN36I.close();
				JzFnjfOc.close();
				EbCSE0gC.close();
				CallableStatement tD2NaXS8;
				int vlE1ZJpt = 0;
				if ((QnNAIF2i == 0) || (QnNAIF2i == 1)) {
					tD2NaXS8 = NZAUitM7.prepareCall("INSERT INTO " + BrcBwJYk + "( " + PE0v7KTq.toString()
							+ " ) ( SELECT " + PE0v7KTq.toString() + " FROM " + BgDsfbgf + " "
							+ (((qHRHOL8A != null) && (qHRHOL8A.length() > 0)) ? (" WHERE " + qHRHOL8A) : "") + ")");
					vlE1ZJpt = tD2NaXS8.executeUpdate();
					tD2NaXS8.close();
					if (kCalnbgg) {
						logger.finest(LoggerMessageLocalizer.getMessage("DONE") + " [" + vlE1ZJpt + "] "
								+ LoggerMessageLocalizer.getMessage("RECORDS_COPIED"));
					}
				}
				NZAUitM7.commit();
				DgoI2J0f = true;
			}
		} catch (Exception wbQrqUl3) {
			try {
				NZAUitM7.rollback();
			} catch (Exception BsNOnCm5) {
				throw new boRuntimeException("boBuildDB.moveTable", "BO-1304", BsNOnCm5);
			}
			throw new boRuntimeException("boBuildDB.moveTable", "BO-1304", wbQrqUl3);
		} finally {
			try {
				NZAUitM7.close();
			} catch (Exception wjbhxS94) {
			}
			try {
				zcJNR9tn.close();
			} catch (Exception CTf5Y5J9) {
			}
		}
		return DgoI2J0f;
	}

}