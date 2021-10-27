class n21181542 {
	public boolean deleteRoleType(int kEySqq4a, int zgGP3olh, boolean hQsxhi7S, DTSPermission Ql1IXtBO)
			throws SQLException, PermissionException, DTSValidationException {
		checkPermission(Ql1IXtBO, String.valueOf(zgGP3olh));
		boolean OtzvRrnq = isRoleTypeUsed(zgGP3olh, kEySqq4a);
		if (OtzvRrnq) {
			throw new DTSValidationException(ApelMsgHandler.getInstance().getMsg("DTS-0034"));
		}
		if (!hQsxhi7S) {
			StringBuffer nKhzxQyK = new StringBuffer();
			DTSTransferObject[] CMxMcRHN = fetchRightIdentityReferences(zgGP3olh, kEySqq4a);
			if (CMxMcRHN.length > 0) {
				nKhzxQyK.append("Role Type is Right Identity in one or more Role Types.");
			}
			CMxMcRHN = fetchParentReferences(zgGP3olh, kEySqq4a);
			if (CMxMcRHN.length > 0) {
				if (nKhzxQyK.length() > 0) {
					nKhzxQyK.append("\n");
				}
				nKhzxQyK.append("Role Type is Parent of one or more Role Types.");
			}
			if (nKhzxQyK.length() > 0) {
				throw new DTSValidationException(nKhzxQyK.toString());
			}
		}
		String zP1HwYUM = getDAO().getStatement(ROLE_TYPE_TABLE_KEY, "DELETE_RIGHT_IDENTITY_REF");
		String WHpmo1nW = getDAO().getStatement(ROLE_TYPE_TABLE_KEY, "DELETE_PARENT_REF");
		String iy3ni90q = getDAO().getStatement(ROLE_TYPE_TABLE_KEY, "DELETE");
		PreparedStatement PBPqtLne = null;
		boolean WIHClb8L = false;
		long qsn861F6 = getGID(zgGP3olh, kEySqq4a);
		conn.setAutoCommit(false);
		int HnkEPUcH = conn.getTransactionIsolation();
		conn.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
		try {
			PBPqtLne = conn.prepareStatement(zP1HwYUM);
			PBPqtLne.setLong(1, qsn861F6);
			PBPqtLne.executeUpdate();
			PBPqtLne.close();
			PBPqtLne = conn.prepareStatement(WHpmo1nW);
			PBPqtLne.setLong(1, qsn861F6);
			PBPqtLne.executeUpdate();
			PBPqtLne.close();
			PBPqtLne = conn.prepareStatement(iy3ni90q);
			PBPqtLne.setLong(1, qsn861F6);
			int GFyyHCpW = PBPqtLne.executeUpdate();
			WIHClb8L = (GFyyHCpW == 1);
			conn.commit();
		} catch (SQLException V0waAnOy) {
			conn.rollback();
			throw V0waAnOy;
		} finally {
			conn.setTransactionIsolation(HnkEPUcH);
			conn.setAutoCommit(true);
			closeStatement(PBPqtLne);
		}
		return WIHClb8L;
	}

}