class n23400216 {
	public void add(Channel ZXZIdeeo) throws Exception {
		String AjzoFooZ = null;
		DBOperation ILa2euo2 = null;
		Connection lRpjREsd = null;
		PreparedStatement RBryjOwh = null;
		ResultSet J7aHcNuo = null;
		try {
			AjzoFooZ = "insert into t_ip_channel (id,name,description,ascii_name,channel_path,site_id,type,data_url,template_id,use_status,order_no,style,creator,create_date,refresh_flag,page_num) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			ILa2euo2 = createDBOperation();
			lRpjREsd = ILa2euo2.getConnection();
			lRpjREsd.setAutoCommit(false);
			String[] O33DRkHt = new String[1];
			O33DRkHt[0] = ZXZIdeeo.getPath();
			selfDefineAdd(O33DRkHt, ZXZIdeeo, lRpjREsd, RBryjOwh);
			RBryjOwh = lRpjREsd.prepareStatement(AjzoFooZ);
			RBryjOwh.setInt(1, ZXZIdeeo.getChannelID());
			RBryjOwh.setString(2, ZXZIdeeo.getName());
			RBryjOwh.setString(3, ZXZIdeeo.getDescription());
			RBryjOwh.setString(4, ZXZIdeeo.getAsciiName());
			RBryjOwh.setString(5, ZXZIdeeo.getPath());
			RBryjOwh.setInt(6, ZXZIdeeo.getSiteId());
			RBryjOwh.setString(7, ZXZIdeeo.getChannelType());
			RBryjOwh.setString(8, ZXZIdeeo.getDataUrl());
			if (ZXZIdeeo.getTemplateId() == null || ZXZIdeeo.getTemplateId().trim().equals(""))
				RBryjOwh.setNull(9, Types.INTEGER);
			else
				RBryjOwh.setInt(9, Integer.parseInt(ZXZIdeeo.getTemplateId()));
			RBryjOwh.setString(10, ZXZIdeeo.getUseStatus());
			RBryjOwh.setInt(11, ZXZIdeeo.getOrderNo());
			RBryjOwh.setString(12, ZXZIdeeo.getStyle());
			RBryjOwh.setInt(13, ZXZIdeeo.getCreator());
			RBryjOwh.setTimestamp(14, (Timestamp) ZXZIdeeo.getCreateDate());
			RBryjOwh.setString(15, ZXZIdeeo.getRefPath());
			RBryjOwh.setInt(16, ZXZIdeeo.getPageNum());
			RBryjOwh.executeUpdate();
			lRpjREsd.commit();
			int v3sIB8Wo = Const.OPERATE_TYPE_ID;
			int kpBi3Kgu = ZXZIdeeo.getChannelID() + Const.CHANNEL_TYPE_RES;
			String cq09oy13 = ZXZIdeeo.getName();
			int FMaCgxtd = Const.RES_TYPE_ID;
			String BNSSkdrN = "";
			AuthorityManager WbRKIj0M = new AuthorityManager();
			WbRKIj0M.createExtResource(Integer.toString(kpBi3Kgu), cq09oy13, FMaCgxtd, v3sIB8Wo, BNSSkdrN);
		} catch (SQLException KKcNS4X9) {
			lRpjREsd.rollback();
			log.error("???????Sql??????????" + AjzoFooZ);
			throw KKcNS4X9;
		} finally {
			close(J7aHcNuo, null, RBryjOwh, lRpjREsd, ILa2euo2);
		}
	}

}