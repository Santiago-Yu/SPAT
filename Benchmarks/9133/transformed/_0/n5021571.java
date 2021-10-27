class n5021571 {
	public void registerSchema(String xP2WNXxh, String tf9az4VB, long SvjkjKft, String a2SBnXya, String cu9bECjA)
			throws SQLException {
		Connection ZLGm8PEA = null;
		PreparedStatement XCSK7ynS = null;
		try {
			ZLGm8PEA = this.getRepositoryConnection(p_ctx.getApplication(), "default", 2);
			String tozs9SR1 = MessageLocalizer.getMessage("SCHEMA_CREATED_BY_OBJECT") + " [" + tf9az4VB + "] "
					+ MessageLocalizer.getMessage("WITH_BOUI") + " [" + SvjkjKft + "]";
			XCSK7ynS = ZLGm8PEA.prepareStatement("DELETE FROM NGTDIC WHERE TABLENAME=? and objecttype='S'");
			XCSK7ynS.setString(1, xP2WNXxh);
			XCSK7ynS.executeUpdate();
			XCSK7ynS.close();
			XCSK7ynS = ZLGm8PEA.prepareStatement("INSERT INTO NGTDIC (SCHEMA,OBJECTNAME,OBJECTTYPE,TABLENAME, "
					+ "FRIENDLYNAME, EXPRESSION) VALUES (" + "?,?,?,?,?,?)");
			XCSK7ynS.setString(1, cu9bECjA);
			XCSK7ynS.setString(2, xP2WNXxh);
			XCSK7ynS.setString(3, "S");
			XCSK7ynS.setString(4, xP2WNXxh);
			XCSK7ynS.setString(5, tozs9SR1);
			XCSK7ynS.setString(6, a2SBnXya);
			XCSK7ynS.executeUpdate();
			XCSK7ynS.close();
			ZLGm8PEA.commit();
		} catch (Exception VsO7kgPV) {
			ZLGm8PEA.rollback();
			VsO7kgPV.printStackTrace();
			throw new SQLException(VsO7kgPV.getMessage());
		} finally {
			if (XCSK7ynS != null) {
				try {
					XCSK7ynS.close();
				} catch (Exception UiqsyCH3) {
				}
			}
		}
	}

}