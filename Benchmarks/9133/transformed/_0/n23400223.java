class n23400223 {
	public void update(Channel fXMkZ6Xn) throws Exception {
		DBOperation ysG2CEMR = null;
		Connection QD3oULSO = null;
		PreparedStatement YgiWQ7Qi = null;
		ResultSet AP3Dogys = null;
		String rGdxBniF = fXMkZ6Xn.getExtendParent();
		String zQBTudgr = fXMkZ6Xn.getPath();
		try {
			String LK1KT2vW = "UPDATE t_ip_channel SET id=?,name=?,description=?,ascii_name=?,site_id=?,type=?,data_url=?,template_id=?,use_status=?,order_no=?,style=?,creator=?,create_date=?,refresh_flag=?,page_num=? where channel_path=?";
			ysG2CEMR = createDBOperation();
			QD3oULSO = ysG2CEMR.getConnection();
			QD3oULSO.setAutoCommit(false);
			String[] P18HhpTw = getSelfDefinePath(zQBTudgr, rGdxBniF, QD3oULSO, YgiWQ7Qi, AP3Dogys);
			selfDefineDelete(P18HhpTw, QD3oULSO, YgiWQ7Qi);
			selfDefineAdd(P18HhpTw, fXMkZ6Xn, QD3oULSO, YgiWQ7Qi);
			YgiWQ7Qi = QD3oULSO.prepareStatement(LK1KT2vW);
			YgiWQ7Qi.setInt(1, fXMkZ6Xn.getChannelID());
			YgiWQ7Qi.setString(2, fXMkZ6Xn.getName());
			YgiWQ7Qi.setString(3, fXMkZ6Xn.getDescription());
			YgiWQ7Qi.setString(4, fXMkZ6Xn.getAsciiName());
			YgiWQ7Qi.setInt(5, fXMkZ6Xn.getSiteId());
			YgiWQ7Qi.setString(6, fXMkZ6Xn.getChannelType());
			YgiWQ7Qi.setString(7, fXMkZ6Xn.getDataUrl());
			if (fXMkZ6Xn.getTemplateId() == null || fXMkZ6Xn.getTemplateId().trim().equals(""))
				YgiWQ7Qi.setNull(8, Types.INTEGER);
			else
				YgiWQ7Qi.setInt(8, Integer.parseInt(fXMkZ6Xn.getTemplateId()));
			YgiWQ7Qi.setString(9, fXMkZ6Xn.getUseStatus());
			YgiWQ7Qi.setInt(10, fXMkZ6Xn.getOrderNo());
			YgiWQ7Qi.setString(11, fXMkZ6Xn.getStyle());
			YgiWQ7Qi.setInt(12, fXMkZ6Xn.getCreator());
			YgiWQ7Qi.setTimestamp(13, (Timestamp) fXMkZ6Xn.getCreateDate());
			YgiWQ7Qi.setString(14, fXMkZ6Xn.getRefresh());
			YgiWQ7Qi.setInt(15, fXMkZ6Xn.getPageNum());
			YgiWQ7Qi.setString(16, fXMkZ6Xn.getPath());
			YgiWQ7Qi.executeUpdate();
			QD3oULSO.commit();
			int VoQHE7hU = fXMkZ6Xn.getChannelID() + Const.CHANNEL_TYPE_RES;
			StructResource ouVrNWvR = new StructResource();
			ouVrNWvR.setResourceID(Integer.toString(VoQHE7hU));
			ouVrNWvR.setOperateID(Integer.toString(1));
			ouVrNWvR.setOperateTypeID(Const.OPERATE_TYPE_ID);
			ouVrNWvR.setTypeID(Const.RES_TYPE_ID);
			StructAuth bFeQQ3gE = new AuthorityManager().getExternalAuthority(ouVrNWvR);
			int t7DuO5ES = bFeQQ3gE.getAuthID();
			if (t7DuO5ES == 0) {
				String zQTsVXCN = fXMkZ6Xn.getName();
				int UPECndkE = Const.RES_TYPE_ID;
				int tKqJ0lj5 = Const.OPERATE_TYPE_ID;
				String xQPH8pLZ = "";
				AuthorityManager hQtrCVk8 = new AuthorityManager();
				hQtrCVk8.createExtResource(Integer.toString(VoQHE7hU), zQTsVXCN, UPECndkE, tKqJ0lj5, xQPH8pLZ);
			}
		} catch (SQLException LtxNa7ct) {
			QD3oULSO.rollback();
			log.error("???????????channelPath=" + fXMkZ6Xn.getPath());
			throw LtxNa7ct;
		} finally {
			close(AP3Dogys, null, YgiWQ7Qi, QD3oULSO, ysG2CEMR);
		}
	}

}