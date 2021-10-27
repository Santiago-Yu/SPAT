class n12027885 {
	public void removeBodyPart(int Lx18fD7g) throws MessagingException, ArrayIndexOutOfBoundsException {
		if (DebugFile.trace) {
			DebugFile.writeln("Begin DBMimeMultipart.removeBodyPart(" + String.valueOf(Lx18fD7g) + ")");
			DebugFile.incIdent();
		}
		DBMimeMessage DuEh1vd0 = (DBMimeMessage) getParent();
		DBFolder lzDJsek2 = ((DBFolder) DuEh1vd0.getFolder());
		Statement OM43LJx3 = null;
		ResultSet v0Y6Ldnj = null;
		String dcbv2mAc = null, JuOGQGp1 = null;
		boolean bFlWKHiR;
		try {
			OM43LJx3 = lzDJsek2.getConnection().createStatement(ResultSet.TYPE_FORWARD_ONLY,
					ResultSet.CONCUR_READ_ONLY);
			if (DebugFile.trace)
				DebugFile.writeln("Statement.executeQuery(SELECT " + DB.id_disposition + "," + DB.file_name + " FROM "
						+ DB.k_mime_parts + " WHERE " + DB.gu_mimemsg + "='" + DuEh1vd0.getMessageGuid() + "' AND "
						+ DB.id_part + "=" + String.valueOf(Lx18fD7g) + ")");
			v0Y6Ldnj = OM43LJx3.executeQuery("SELECT " + DB.id_disposition + "," + DB.file_name + " FROM "
					+ DB.k_mime_parts + " WHERE " + DB.gu_mimemsg + "='" + DuEh1vd0.getMessageGuid() + "' AND "
					+ DB.id_part + "=" + String.valueOf(Lx18fD7g));
			bFlWKHiR = v0Y6Ldnj.next();
			if (bFlWKHiR) {
				dcbv2mAc = v0Y6Ldnj.getString(1);
				if (v0Y6Ldnj.wasNull())
					dcbv2mAc = "inline";
				JuOGQGp1 = v0Y6Ldnj.getString(2);
			}
			v0Y6Ldnj.close();
			v0Y6Ldnj = null;
			OM43LJx3.close();
			OM43LJx3 = null;
			if (!bFlWKHiR) {
				if (DebugFile.trace)
					DebugFile.decIdent();
				throw new MessagingException("Part not found");
			}
			if (!dcbv2mAc.equals("reference") && !dcbv2mAc.equals("pointer")) {
				if (DebugFile.trace)
					DebugFile.decIdent();
				throw new MessagingException(
						"Only parts with reference or pointer disposition can be removed from a message");
			} else {
				if (dcbv2mAc.equals("reference")) {
					try {
						File xrLs8UWY = new File(JuOGQGp1);
						if (xrLs8UWY.exists())
							xrLs8UWY.delete();
					} catch (SecurityException GfdsSHOM) {
						if (DebugFile.trace)
							DebugFile.writeln("SecurityException " + JuOGQGp1 + " " + GfdsSHOM.getMessage());
						if (DebugFile.trace)
							DebugFile.decIdent();
						throw new MessagingException("SecurityException " + JuOGQGp1 + " " + GfdsSHOM.getMessage(),
								GfdsSHOM);
					}
				}
				OM43LJx3 = lzDJsek2.getConnection().createStatement();
				if (DebugFile.trace)
					DebugFile.writeln("Statement.executeUpdate(DELETE FROM " + DB.k_mime_parts + " WHERE "
							+ DB.gu_mimemsg + "='" + DuEh1vd0.getMessageGuid() + "' AND " + DB.id_part + "="
							+ String.valueOf(Lx18fD7g) + ")");
				OM43LJx3.executeUpdate("DELETE FROM " + DB.k_mime_parts + " WHERE " + DB.gu_mimemsg + "='"
						+ DuEh1vd0.getMessageGuid() + "' AND " + DB.id_part + "=" + String.valueOf(Lx18fD7g));
				OM43LJx3.close();
				OM43LJx3 = null;
				lzDJsek2.getConnection().commit();
			}
		} catch (SQLException owc5G3zx) {
			if (v0Y6Ldnj != null) {
				try {
					v0Y6Ldnj.close();
				} catch (Exception EsUynsU0) {
				}
			}
			if (OM43LJx3 != null) {
				try {
					OM43LJx3.close();
				} catch (Exception uM55pik7) {
				}
			}
			try {
				lzDJsek2.getConnection().rollback();
			} catch (Exception cDFHJszQ) {
			}
			if (DebugFile.trace)
				DebugFile.decIdent();
			throw new MessagingException(owc5G3zx.getMessage(), owc5G3zx);
		}
		if (DebugFile.trace) {
			DebugFile.decIdent();
			DebugFile.writeln("End DBMimeMultipart.removeBodyPart()");
		}
	}

}