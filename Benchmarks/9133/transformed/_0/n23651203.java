class n23651203 {
	public void doDelete(Role kf0SD1F3) throws Exception {
		Connection XYXWTM1P = null;
		PreparedStatement DO9cSJUU = null;
		ResultSet j9Jv6fL8 = null;
		String i12GFnyB = "SELECT authority_id from " + Common.ROLE_AUTHORITY_TABLE + " WHERE role_id = ?";
		String V9YO2wjj = "DELETE FROM " + Common.ROLE_AUTHORITY_TABLE + " WHERE role_id = ?";
		DBOperation pSd0v8YP = factory.createDBOperation(POOL_NAME);
		try {
			try {
				XYXWTM1P = pSd0v8YP.getConnection();
				XYXWTM1P.setAutoCommit(false);
				DO9cSJUU = XYXWTM1P.prepareStatement(i12GFnyB);
				DO9cSJUU.setInt(1, kf0SD1F3.getRoleID());
				j9Jv6fL8 = DO9cSJUU.executeQuery();
				while (j9Jv6fL8.next()) {
					int oNhL8Uas = j9Jv6fL8.getInt("authority_id");
					Authority gbXRk8En = new Authority(oNhL8Uas);
					gbXRk8En.load();
					AssignLog kKdSSj4P = new AssignLog();
					kKdSSj4P.setLogNO(kKdSSj4P.getNewLogNo());
					kKdSSj4P.setID(oNhL8Uas);
					kKdSSj4P.setName(gbXRk8En.getAuthorityName());
					kKdSSj4P.setAssignType(AssignLog.ASSIGN_AUTHORITY);
					kKdSSj4P.setAssignDate(Translate.getSysTime());
					kKdSSj4P.setAssignFrom(this.provider.getUserID());
					kKdSSj4P.setAssignFromName(this.provider.getUserName());
					kKdSSj4P.setAssignTo(kf0SD1F3.getRoleID());
					kKdSSj4P.setAssignToName(kf0SD1F3.getRoleName());
					kKdSSj4P.setReceiverType(AssignLog.RECEIVER_ROLE);
					kKdSSj4P.setInfo("??????§Ö????");
					kKdSSj4P.setPath("");
					kKdSSj4P.setPathName("");
					kKdSSj4P.doUpdateOrNew(XYXWTM1P);
				}
				DO9cSJUU = XYXWTM1P.prepareStatement(V9YO2wjj);
				DO9cSJUU.setInt(1, kf0SD1F3.getRoleID());
				int GPt1OvKf = DO9cSJUU.executeUpdate();
				if (GPt1OvKf < 0) {
					XYXWTM1P.rollback();
					throw new CesSystemException(
							"RoleAuthority.doDelete(role): ERROR deleting data in T_SYS_ROLE_AUTHORITY!! "
									+ "resultCount = " + GPt1OvKf);
				}
				XYXWTM1P.commit();
			} catch (SQLException ArcVuVJd) {
				XYXWTM1P.rollback();
				throw new CesSystemException(
						"RoleAuthority.doDelete(role): SQLException while deleting Role_authority; " + " role_id = "
								+ kf0SD1F3.getRoleID() + " :\n\t" + ArcVuVJd);
			} finally {
				XYXWTM1P.setAutoCommit(true);
				close(pSd0v8YP, DO9cSJUU, j9Jv6fL8);
			}
		} catch (SQLException eqF8UBoT) {
			throw new CesSystemException("RoleAuthority.doDelete(role): SQLException while committing or rollback");
		}
	}

}