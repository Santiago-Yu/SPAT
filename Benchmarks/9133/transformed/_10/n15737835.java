class n15737835 {
	public void add(Site site) throws Exception {
		Connection connection = null;
		DBOperation dbo = null;
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;
		try {
			dbo = createDBOperation();
			String sqlStr = "insert into t_ip_site (id,name,description,ascii_name,site_path,remark_number,increment_index,use_status,appserver_id) VALUES(?,?,?,?,?,?,?,?,?)";
			connection = dbo.getConnection();
			connection.setAutoCommit(false);
			preparedStatement = connection.prepareStatement(sqlStr);
			preparedStatement.setInt(1, site.getSiteID());
			preparedStatement.setString(2, site.getName());
			preparedStatement.setString(3, site.getDescription());
			preparedStatement.setString(4, site.getAsciiName());
			preparedStatement.setString(5, site.getPath());
			preparedStatement.setInt(6, site.getRemarkNumber());
			preparedStatement.setString(7, site.getIncrementIndex().trim());
			preparedStatement.setString(8, String.valueOf(site.getUseStatus()));
			preparedStatement.setString(9, String.valueOf(site.getAppserverID()));
			preparedStatement.executeUpdate();
			String[] path = new String[1];
			path[0] = site.getPath();
			selfDefineAdd(path, site, connection, preparedStatement);
			connection.commit();
			int resID = site.getSiteID() + Const.SITE_TYPE_RES;
			String resName = site.getName();
			int resTypeID = Const.RES_TYPE_ID;
			String remark = "";
			int operateTypeID = Const.OPERATE_TYPE_ID;
			AuthorityManager am = new AuthorityManager();
			am.createExtResource(Integer.toString(resID), resName, resTypeID, operateTypeID, remark);
			site.wirteFile();
		} catch (SQLException ex) {
			connection.rollback();
			log.error("??????????!", ex);
			throw ex;
		} finally {
			close(resultSet, null, preparedStatement, connection, dbo);
		}
	}

}