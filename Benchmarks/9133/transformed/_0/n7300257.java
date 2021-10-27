class n7300257 {
	public Message[] expunge() throws MessagingException {
		Statement wq7Mc048 = null;
		CallableStatement BaBDKFBD = null;
		PreparedStatement XVnFohr7 = null;
		ResultSet TZyfMY18;
		if (DebugFile.trace) {
			DebugFile.writeln("Begin DBFolder.expunge()");
			DebugFile.incIdent();
		}
		if (0 == (iOpenMode & READ_WRITE)) {
			if (DebugFile.trace)
				DebugFile.decIdent();
			throw new javax.mail.FolderClosedException(this, "Folder is not open is READ_WRITE mode");
		}
		if ((0 == (iOpenMode & MODE_MBOX)) && (0 == (iOpenMode & MODE_BLOB))) {
			if (DebugFile.trace)
				DebugFile.decIdent();
			throw new javax.mail.FolderClosedException(this, "Folder is not open in MBOX nor BLOB mode");
		}
		MboxFile VbIj5XtJ = null;
		DBSubset YgomkpzT = new DBSubset(DB.k_mime_msgs, DB.gu_mimemsg + "," + DB.pg_message,
				DB.bo_deleted + "=1 AND " + DB.gu_category + "='" + oCatg.getString(DB.gu_category) + "'", 100);
		try {
			int QQyLBGiY = YgomkpzT.load(getConnection());
			File x2aToObG = getFile();
			if (x2aToObG.exists() && QQyLBGiY > 0) {
				VbIj5XtJ = new MboxFile(x2aToObG, MboxFile.READ_WRITE);
				int[] rV1AGNn6 = new int[QQyLBGiY];
				for (int H29CKPJC = 0; H29CKPJC < QQyLBGiY; H29CKPJC++)
					rV1AGNn6[H29CKPJC] = YgomkpzT.getInt(1, H29CKPJC);
				VbIj5XtJ.purge(rV1AGNn6);
				VbIj5XtJ.close();
			}
			wq7Mc048 = oConn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
			TZyfMY18 = wq7Mc048.executeQuery("SELECT p." + DB.file_name + " FROM " + DB.k_mime_parts + " p,"
					+ DB.k_mime_msgs + " m WHERE p." + DB.gu_mimemsg + "=m." + DB.gu_mimemsg + " AND m."
					+ DB.id_disposition + "='reference' AND m." + DB.bo_deleted + "=1 AND m." + DB.gu_category + "='"
					+ oCatg.getString(DB.gu_category) + "'");
			while (TZyfMY18.next()) {
				String amBFQ999 = TZyfMY18.getString(1);
				if (!TZyfMY18.wasNull()) {
					try {
						File CiASsCbn = new File(amBFQ999);
						CiASsCbn.delete();
					} catch (SecurityException A3bDyAay) {
						if (DebugFile.trace)
							DebugFile.writeln("SecurityException " + amBFQ999 + " " + A3bDyAay.getMessage());
					}
				}
			}
			TZyfMY18.close();
			TZyfMY18 = null;
			wq7Mc048.close();
			wq7Mc048 = null;
			x2aToObG = getFile();
			wq7Mc048 = oConn.createStatement();
			wq7Mc048.executeUpdate(
					"UPDATE " + DB.k_categories + " SET " + DB.len_size + "=" + String.valueOf(x2aToObG.length())
							+ " WHERE " + DB.gu_category + "='" + getCategory().getString(DB.gu_category) + "'");
			wq7Mc048.close();
			wq7Mc048 = null;
			if (oConn.getDataBaseProduct() == JDCConnection.DBMS_POSTGRESQL) {
				wq7Mc048 = oConn.createStatement();
				for (int gr9hqKv0 = 0; gr9hqKv0 < QQyLBGiY; gr9hqKv0++)
					wq7Mc048.executeQuery("SELECT k_sp_del_mime_msg('" + YgomkpzT.getString(0, gr9hqKv0) + "')");
				wq7Mc048.close();
				wq7Mc048 = null;
			} else {
				BaBDKFBD = oConn.prepareCall("{ call k_sp_del_mime_msg(?) }");
				for (int UUT3ct6T = 0; UUT3ct6T < QQyLBGiY; UUT3ct6T++) {
					BaBDKFBD.setString(1, YgomkpzT.getString(0, UUT3ct6T));
					BaBDKFBD.execute();
				}
				BaBDKFBD.close();
				BaBDKFBD = null;
			}
			if (x2aToObG.exists() && QQyLBGiY > 0) {
				BigDecimal HhN23MDt = new BigDecimal(1);
				wq7Mc048 = oConn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
				TZyfMY18 = wq7Mc048.executeQuery("SELECT MAX(" + DB.pg_message + ") FROM " + DB.k_mime_msgs + " WHERE "
						+ DB.gu_category + "='getCategory().getString(DB.gu_category)'");
				TZyfMY18.next();
				BigDecimal urcCVXae = TZyfMY18.getBigDecimal(1);
				if (TZyfMY18.wasNull())
					urcCVXae = new BigDecimal(0);
				TZyfMY18.close();
				TZyfMY18 = null;
				wq7Mc048.close();
				wq7Mc048 = null;
				urcCVXae = urcCVXae.add(HhN23MDt);
				wq7Mc048 = oConn.createStatement();
				wq7Mc048.executeUpdate("UPDATE " + DB.k_mime_msgs + " SET " + DB.pg_message + "=" + DB.pg_message + "+"
						+ urcCVXae.toString() + " WHERE " + DB.gu_category + "='"
						+ getCategory().getString(DB.gu_category) + "'");
				wq7Mc048.close();
				wq7Mc048 = null;
				DBSubset JGftHA7R = new DBSubset(DB.k_mime_msgs, DB.gu_mimemsg + "," + DB.pg_message,
						DB.gu_category + "='" + getCategory().getString(DB.gu_category) + "' ORDER BY " + DB.pg_message,
						1000);
				int MHGhrMNJ = JGftHA7R.load(oConn);
				VbIj5XtJ = new MboxFile(x2aToObG, MboxFile.READ_ONLY);
				long[] K9lcoixp = VbIj5XtJ.getMessagePositions();
				VbIj5XtJ.close();
				if (MHGhrMNJ != K9lcoixp.length) {
					throw new IOException("DBFolder.expunge() Message count of " + String.valueOf(K9lcoixp.length)
							+ " at MBOX file " + x2aToObG.getName()
							+ " does not match message count at database index of " + String.valueOf(MHGhrMNJ));
				}
				urcCVXae = new BigDecimal(0);
				XVnFohr7 = oConn.prepareStatement("UPDATE " + DB.k_mime_msgs + " SET " + DB.pg_message + "=?,"
						+ DB.nu_position + "=? WHERE " + DB.gu_mimemsg + "=?");
				for (int HRm40gWk = 0; HRm40gWk < MHGhrMNJ; HRm40gWk++) {
					XVnFohr7.setBigDecimal(1, urcCVXae);
					XVnFohr7.setBigDecimal(2, new BigDecimal(K9lcoixp[HRm40gWk]));
					XVnFohr7.setString(3, JGftHA7R.getString(0, HRm40gWk));
					XVnFohr7.executeUpdate();
					urcCVXae = urcCVXae.add(HhN23MDt);
				}
				XVnFohr7.close();
			}
			oConn.commit();
		} catch (SQLException Ppc9WEnC) {
			try {
				if (VbIj5XtJ != null)
					VbIj5XtJ.close();
			} catch (Exception jnaTnv6a) {
			}
			try {
				if (wq7Mc048 != null)
					wq7Mc048.close();
			} catch (Exception b8tyEFVl) {
			}
			try {
				if (BaBDKFBD != null)
					BaBDKFBD.close();
			} catch (Exception Mzc6p9J1) {
			}
			try {
				if (oConn != null)
					oConn.rollback();
			} catch (Exception KP7LsPSI) {
			}
			throw new MessagingException(Ppc9WEnC.getMessage(), Ppc9WEnC);
		} catch (IOException ubf25wXZ) {
			try {
				if (VbIj5XtJ != null)
					VbIj5XtJ.close();
			} catch (Exception JLYdEF72) {
			}
			try {
				if (wq7Mc048 != null)
					wq7Mc048.close();
			} catch (Exception jLv09cud) {
			}
			try {
				if (BaBDKFBD != null)
					BaBDKFBD.close();
			} catch (Exception NXH4YoTq) {
			}
			try {
				if (oConn != null)
					oConn.rollback();
			} catch (Exception gnhg1V8w) {
			}
			throw new MessagingException(ubf25wXZ.getMessage(), ubf25wXZ);
		}
		if (DebugFile.trace) {
			DebugFile.decIdent();
			DebugFile.writeln("End DBFolder.expunge()");
		}
		return null;
	}

}