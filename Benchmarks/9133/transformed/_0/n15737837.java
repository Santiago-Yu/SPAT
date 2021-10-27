class n15737837 {
	public void update(Site TLJDZ96x) throws Exception {
		DBOperation TsEYcnpU = null;
		Connection oBKKYEPW = null;
		PreparedStatement CNi4eHXH = null;
		ResultSet XuZQtxy6 = null;
		String o8gozpZO = TLJDZ96x.getExtendParent();
		String diYKw2Rp = TLJDZ96x.getPath();
		try {
			String a4eHqHiW = "update t_ip_site set id=?,name=?,description=?,ascii_name=?,remark_number=?,increment_index=?,use_status=?,appserver_id=? where id=?";
			TsEYcnpU = createDBOperation();
			oBKKYEPW = TsEYcnpU.getConnection();
			oBKKYEPW.setAutoCommit(false);
			String[] rMbYetsy = getSelfDefinePath(diYKw2Rp, o8gozpZO, oBKKYEPW, CNi4eHXH, XuZQtxy6);
			selfDefineDelete(rMbYetsy, oBKKYEPW, CNi4eHXH);
			selfDefineAdd(rMbYetsy, TLJDZ96x, oBKKYEPW, CNi4eHXH);
			CNi4eHXH = oBKKYEPW.prepareStatement(a4eHqHiW);
			CNi4eHXH.setInt(1, TLJDZ96x.getSiteID());
			CNi4eHXH.setString(2, TLJDZ96x.getName());
			CNi4eHXH.setString(3, TLJDZ96x.getDescription());
			CNi4eHXH.setString(4, TLJDZ96x.getAsciiName());
			CNi4eHXH.setInt(5, TLJDZ96x.getRemarkNumber());
			CNi4eHXH.setString(6, TLJDZ96x.getIncrementIndex().trim());
			CNi4eHXH.setString(7, String.valueOf(TLJDZ96x.getUseStatus()));
			CNi4eHXH.setString(8, String.valueOf(TLJDZ96x.getAppserverID()));
			CNi4eHXH.setInt(9, TLJDZ96x.getSiteID());
			CNi4eHXH.executeUpdate();
			oBKKYEPW.commit();
			int TR3jgI3W = TLJDZ96x.getSiteID() + Const.SITE_TYPE_RES;
			StructResource qyr8xyVB = new StructResource();
			qyr8xyVB.setResourceID(Integer.toString(TR3jgI3W));
			qyr8xyVB.setOperateID(Integer.toString(1));
			qyr8xyVB.setOperateTypeID(Const.OPERATE_TYPE_ID);
			qyr8xyVB.setTypeID(Const.RES_TYPE_ID);
			StructAuth wybOAlPM = new AuthorityManager().getExternalAuthority(qyr8xyVB);
			int Q4rWcJle = wybOAlPM.getAuthID();
			if (Q4rWcJle == 0) {
				String KEKDkKxq = TLJDZ96x.getName();
				int G4CUUd8m = Const.RES_TYPE_ID;
				int XV5UrM8A = Const.OPERATE_TYPE_ID;
				String X3Saklha = "";
				AuthorityManager xtUdobv8 = new AuthorityManager();
				xtUdobv8.createExtResource(Integer.toString(TR3jgI3W), KEKDkKxq, G4CUUd8m, XV5UrM8A, X3Saklha);
			}
			TLJDZ96x.wirteFile();
		} catch (SQLException adCMr9gJ) {
			oBKKYEPW.rollback();
			log.error("??????????????!", adCMr9gJ);
			throw adCMr9gJ;
		} finally {
			close(XuZQtxy6, null, CNi4eHXH, oBKKYEPW, TsEYcnpU);
		}
	}

}