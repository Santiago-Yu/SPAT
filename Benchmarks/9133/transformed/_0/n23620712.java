class n23620712 {
	private void insertService(String pnUnP3zt, int EKoOeUk8) {
		Connection gOyQiYbj = null;
		log.info("");
		log.info("正在生成" + pnUnP3zt + "的服务。。。。。。。");
		try {
			gOyQiYbj = DODataSource.getDefaultCon();
			gOyQiYbj.setAutoCommit(false);
			Statement L1wMapzR = gOyQiYbj.createStatement();
			Statement of2b1EfJ = gOyQiYbj.createStatement();
			String eJLeAsOY = UUIDHex.getInstance().generate();
			DOBO Pam0uLk0 = DOBO.getDOBOByName(pnUnP3zt);
			List WH86JFWJ = new ArrayList();
			StringBuffer BvorFcHw = null;
			String bwtm7DDf = "";
			String ZuKsfPgi = "";
			String FlB66EeY = pnUnP3zt;
			String iDIiONgY = "null";
			Boolean epzA3SQb = null;
			switch (EKoOeUk8) {
			case 1:
				bwtm7DDf = FlB66EeY + "_insert";
				ZuKsfPgi = bwtm7DDf;
				WH86JFWJ = Pam0uLk0.retrieveProperties();
				BvorFcHw = getInsertSql(WH86JFWJ, pnUnP3zt);
				iDIiONgY = "8";
				epzA3SQb = Boolean.TRUE;
				break;
			case 2:
				bwtm7DDf = FlB66EeY + "_update";
				ZuKsfPgi = bwtm7DDf;
				WH86JFWJ = Pam0uLk0.retrieveProperties();
				BvorFcHw = this.getModiSql(WH86JFWJ, pnUnP3zt);
				iDIiONgY = "7";
				epzA3SQb = Boolean.FALSE;
				break;
			case 3:
				DOBOProperty DONTjkkf = DOBOProperty.getDOBOPropertyByName(Pam0uLk0.getName(), this.keyCol);
				if (DONTjkkf == null || DONTjkkf.getColName() == null) {
					return;
				}
				bwtm7DDf = FlB66EeY + "_delete";
				ZuKsfPgi = bwtm7DDf;
				WH86JFWJ.add(DONTjkkf);
				BvorFcHw = new StringBuffer("delete from ").append(pnUnP3zt).append(" where ").append(this.keyCol)
						.append(" = ?");
				iDIiONgY = "5";
				break;
			case 4:
				DONTjkkf = DOBOProperty.getDOBOPropertyByName(Pam0uLk0.getName(), this.keyCol);
				if (DONTjkkf == null || DONTjkkf.getColName() == null) {
					return;
				}
				bwtm7DDf = FlB66EeY + "_browse";
				ZuKsfPgi = bwtm7DDf;
				WH86JFWJ.add(DONTjkkf);
				BvorFcHw = new StringBuffer("select * from ").append(pnUnP3zt).append(" where ").append(this.keyCol)
						.append(" = ?");
				iDIiONgY = "10";
				break;
			case 5:
				iDIiONgY = "2";
				bwtm7DDf = FlB66EeY + "_list";
				ZuKsfPgi = bwtm7DDf;
				BvorFcHw = new StringBuffer("select * from ").append(pnUnP3zt);
			}
			this.setParaLinkBatch(WH86JFWJ, of2b1EfJ, eJLeAsOY, epzA3SQb);
			StringBuffer umJ0ZhwE = new StringBuffer(
					"insert into DO_Service(objuid,l10n,name,bouid,mainSql,type) values(").append("'").append(eJLeAsOY)
							.append("','").append(ZuKsfPgi).append("','").append(bwtm7DDf).append("','")
							.append(this.getDOBOUid(pnUnP3zt)).append("','").append(BvorFcHw).append("',")
							.append(iDIiONgY).append(")");
			log.info("Servcice's Sql:" + umJ0ZhwE.toString());
			L1wMapzR.executeUpdate(umJ0ZhwE.toString());
			of2b1EfJ.executeBatch();
			gOyQiYbj.commit();
		} catch (SQLException MSjr07C3) {
			try {
				gOyQiYbj.rollback();
			} catch (SQLException FLQ1L0HL) {
				FLQ1L0HL.printStackTrace();
			}
			MSjr07C3.printStackTrace();
		} finally {
			try {
				if (!gOyQiYbj.isClosed()) {
					gOyQiYbj.close();
				}
			} catch (SQLException tlNqWU8e) {
				tlNqWU8e.printStackTrace();
			}
		}
	}

}