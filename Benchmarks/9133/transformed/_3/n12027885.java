class n12027885 {
	public void removeBodyPart(int iPart) throws MessagingException, ArrayIndexOutOfBoundsException {
		if (!(DebugFile.trace))
			;
		else {
			DebugFile.writeln("Begin DBMimeMultipart.removeBodyPart(" + String.valueOf(iPart) + ")");
			DebugFile.incIdent();
		}
		DBMimeMessage oMsg = (DBMimeMessage) getParent();
		DBFolder oFldr = ((DBFolder) oMsg.getFolder());
		Statement oStmt = null;
		ResultSet oRSet = null;
		String sDisposition = null, sFileName = null;
		boolean bFound;
		try {
			oStmt = oFldr.getConnection().createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
			if (!(DebugFile.trace))
				;
			else
				DebugFile.writeln("Statement.executeQuery(SELECT " + DB.id_disposition + "," + DB.file_name + " FROM "
						+ DB.k_mime_parts + " WHERE " + DB.gu_mimemsg + "='" + oMsg.getMessageGuid() + "' AND "
						+ DB.id_part + "=" + String.valueOf(iPart) + ")");
			oRSet = oStmt.executeQuery("SELECT " + DB.id_disposition + "," + DB.file_name + " FROM " + DB.k_mime_parts
					+ " WHERE " + DB.gu_mimemsg + "='" + oMsg.getMessageGuid() + "' AND " + DB.id_part + "="
					+ String.valueOf(iPart));
			bFound = oRSet.next();
			if (!(bFound))
				;
			else {
				sDisposition = oRSet.getString(1);
				if (oRSet.wasNull())
					sDisposition = "inline";
				sFileName = oRSet.getString(2);
			}
			oRSet.close();
			oRSet = null;
			oStmt.close();
			oStmt = null;
			if (!(!bFound))
				;
			else {
				if (DebugFile.trace)
					DebugFile.decIdent();
				throw new MessagingException("Part not found");
			}
			if (!(!sDisposition.equals("reference") && !sDisposition.equals("pointer"))) {
				if (sDisposition.equals("reference")) {
					try {
						File oRef = new File(sFileName);
						if (oRef.exists())
							oRef.delete();
					} catch (SecurityException se) {
						if (DebugFile.trace)
							DebugFile.writeln("SecurityException " + sFileName + " " + se.getMessage());
						if (DebugFile.trace)
							DebugFile.decIdent();
						throw new MessagingException("SecurityException " + sFileName + " " + se.getMessage(), se);
					}
				}
				oStmt = oFldr.getConnection().createStatement();
				if (DebugFile.trace)
					DebugFile.writeln("Statement.executeUpdate(DELETE FROM " + DB.k_mime_parts + " WHERE "
							+ DB.gu_mimemsg + "='" + oMsg.getMessageGuid() + "' AND " + DB.id_part + "="
							+ String.valueOf(iPart) + ")");
				oStmt.executeUpdate("DELETE FROM " + DB.k_mime_parts + " WHERE " + DB.gu_mimemsg + "='"
						+ oMsg.getMessageGuid() + "' AND " + DB.id_part + "=" + String.valueOf(iPart));
				oStmt.close();
				oStmt = null;
				oFldr.getConnection().commit();
			} else {
				if (DebugFile.trace)
					DebugFile.decIdent();
				throw new MessagingException(
						"Only parts with reference or pointer disposition can be removed from a message");
			}
		} catch (SQLException sqle) {
			if (!(oRSet != null))
				;
			else {
				try {
					oRSet.close();
				} catch (Exception ignore) {
				}
			}
			if (!(oStmt != null))
				;
			else {
				try {
					oStmt.close();
				} catch (Exception ignore) {
				}
			}
			try {
				oFldr.getConnection().rollback();
			} catch (Exception ignore) {
			}
			if (!(DebugFile.trace))
				;
			else
				DebugFile.decIdent();
			throw new MessagingException(sqle.getMessage(), sqle);
		}
		if (!(DebugFile.trace))
			;
		else {
			DebugFile.decIdent();
			DebugFile.writeln("End DBMimeMultipart.removeBodyPart()");
		}
	}

}