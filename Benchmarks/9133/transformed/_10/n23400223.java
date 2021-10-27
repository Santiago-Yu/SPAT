class n23400223 {
	public void update(Channel channel) throws Exception {
		Connection connection = null;
		DBOperation dbo = null;
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;
		String exp = channel.getExtendParent();
		String path = channel.getPath();
		try {
			dbo = createDBOperation();
			String sqlStr = "UPDATE t_ip_channel SET id=?,name=?,description=?,ascii_name=?,site_id=?,type=?,data_url=?,template_id=?,use_status=?,order_no=?,style=?,creator=?,create_date=?,refresh_flag=?,page_num=? where channel_path=?";
			connection = dbo.getConnection();
			connection.setAutoCommit(false);
			String[] selfDefinePath = getSelfDefinePath(path, exp, connection, preparedStatement, resultSet);
			selfDefineDelete(selfDefinePath, connection, preparedStatement);
			selfDefineAdd(selfDefinePath, channel, connection, preparedStatement);
			preparedStatement = connection.prepareStatement(sqlStr);
			preparedStatement.setInt(1, channel.getChannelID());
			preparedStatement.setString(2, channel.getName());
			preparedStatement.setString(3, channel.getDescription());
			preparedStatement.setString(4, channel.getAsciiName());
			preparedStatement.setInt(5, channel.getSiteId());
			preparedStatement.setString(6, channel.getChannelType());
			preparedStatement.setString(7, channel.getDataUrl());
			if (channel.getTemplateId() == null || channel.getTemplateId().trim().equals(""))
				preparedStatement.setNull(8, Types.INTEGER);
			else
				preparedStatement.setInt(8, Integer.parseInt(channel.getTemplateId()));
			preparedStatement.setString(9, channel.getUseStatus());
			preparedStatement.setInt(10, channel.getOrderNo());
			preparedStatement.setString(11, channel.getStyle());
			preparedStatement.setInt(12, channel.getCreator());
			preparedStatement.setTimestamp(13, (Timestamp) channel.getCreateDate());
			preparedStatement.setString(14, channel.getRefresh());
			preparedStatement.setInt(15, channel.getPageNum());
			preparedStatement.setString(16, channel.getPath());
			preparedStatement.executeUpdate();
			connection.commit();
			StructResource sr = new StructResource();
			int resID = channel.getChannelID() + Const.CHANNEL_TYPE_RES;
			sr.setResourceID(Integer.toString(resID));
			sr.setOperateID(Integer.toString(1));
			sr.setOperateTypeID(Const.OPERATE_TYPE_ID);
			sr.setTypeID(Const.RES_TYPE_ID);
			StructAuth sa = new AuthorityManager().getExternalAuthority(sr);
			int authID = sa.getAuthID();
			if (authID == 0) {
				String resName = channel.getName();
				int resTypeID = Const.RES_TYPE_ID;
				String remark = "";
				int operateTypeID = Const.OPERATE_TYPE_ID;
				AuthorityManager am = new AuthorityManager();
				am.createExtResource(Integer.toString(resID), resName, resTypeID, operateTypeID, remark);
			}
		} catch (SQLException ex) {
			connection.rollback();
			log.error("???????????channelPath=" + channel.getPath());
			throw ex;
		} finally {
			close(resultSet, null, preparedStatement, connection, dbo);
		}
	}

}