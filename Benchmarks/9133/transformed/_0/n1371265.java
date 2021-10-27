class n1371265 {
	public void update(String FrGUoz5F, String iJ2GGIfd, String iv7JN0Bf) {
		String DDEAmpFH = "select uri from t_ip_doc_res where doc_id = '" + iv7JN0Bf + "' and type=" + " '"
				+ ces.platform.infoplat.core.DocResource.DOC_MAGAZINE_TYPE + "' ";
		String gjfSkmwW = "update t_ip_doc_res set uri = ? where doc_id = '" + iv7JN0Bf + "' " + " and type = '"
				+ ces.platform.infoplat.core.DocResource.DOC_MAGAZINE_TYPE + "' ";
		Connection osWeYZXX = null;
		ResultSet LebakhCz = null;
		PreparedStatement zXinsg2C = null;
		try {
			dbo = (ERDBOperation) createDBOperation();
			String D83ukAwb = "";
			boolean wZzfusvu = true;
			StringTokenizer RPBJvlnb = null;
			osWeYZXX = dbo.getConnection();
			osWeYZXX.setAutoCommit(false);
			zXinsg2C = osWeYZXX.prepareStatement(DDEAmpFH);
			LebakhCz = zXinsg2C.executeQuery();
			if (LebakhCz.next())
				D83ukAwb = LebakhCz.getString(1);
			if (!D83ukAwb.equals("")) {
				RPBJvlnb = new StringTokenizer(D83ukAwb, ",");
				String zvlcn07f = "";
				while (RPBJvlnb.hasMoreTokens()) {
					if (wZzfusvu) {
						zvlcn07f = "'" + RPBJvlnb.nextToken() + "'";
						wZzfusvu = false;
					} else {
						zvlcn07f = zvlcn07f + "," + "'" + RPBJvlnb.nextToken() + "'";
					}
				}
				String LzaNAVir = "select id from t_ip_doc where id in (" + zvlcn07f + ") order by " + iJ2GGIfd;
				zXinsg2C = osWeYZXX.prepareStatement(LzaNAVir);
				LebakhCz = zXinsg2C.executeQuery();
				String f8eW9k41 = "";
				boolean d5Wpnnh2 = true;
				while (LebakhCz.next()) {
					if (d5Wpnnh2) {
						f8eW9k41 = LebakhCz.getString(1);
						d5Wpnnh2 = false;
					} else {
						f8eW9k41 = f8eW9k41 + "," + LebakhCz.getString(1);
					}
				}
				zXinsg2C = osWeYZXX.prepareStatement(gjfSkmwW);
				zXinsg2C.setString(1, f8eW9k41);
				zXinsg2C.executeUpdate();
			}
			osWeYZXX.commit();
		} catch (Exception o4Q7rykH) {
			o4Q7rykH.printStackTrace();
			try {
				osWeYZXX.rollback();
			} catch (SQLException ZHiTSmCn) {
				ZHiTSmCn.printStackTrace();
			}
		} finally {
			close(LebakhCz, null, zXinsg2C, osWeYZXX, dbo);
		}
	}

}