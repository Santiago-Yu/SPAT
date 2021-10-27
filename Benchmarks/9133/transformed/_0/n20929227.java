class n20929227 {
	private void insertService(String taTdf3ko, int SkodxMRU) {
		Connection Ku6jORil = null;
		log.info("");
		log.info("正在生成" + taTdf3ko + "的服务。。。。。。。");
		try {
			Ku6jORil = DODataSource.getDefaultCon();
			Ku6jORil.setAutoCommit(false);
			Statement sceGQr9N = Ku6jORil.createStatement();
			Statement D6EmMHei = Ku6jORil.createStatement();
			String i8isCaVc = UUIDHex.getInstance().generate();
			DOBO DRjMOo8V = DOBO.getDOBOByName(StringUtil.getDotName(taTdf3ko));
			List iMI8XuP7 = new ArrayList();
			StringBuffer yyW8fL0s = null;
			String fRPTZLhp = "";
			String Yr289cWh = "";
			String kEdBFoXb = StringUtil.getDotName(taTdf3ko);
			Boolean lqqVWcbE = null;
			switch (SkodxMRU) {
			case 1:
				fRPTZLhp = kEdBFoXb + ".insert";
				Yr289cWh = fRPTZLhp;
				iMI8XuP7 = DRjMOo8V.retrieveProperties();
				yyW8fL0s = getInsertSql(iMI8XuP7, taTdf3ko);
				lqqVWcbE = Boolean.TRUE;
				break;
			case 2:
				fRPTZLhp = kEdBFoXb + ".update";
				Yr289cWh = fRPTZLhp;
				iMI8XuP7 = DRjMOo8V.retrieveProperties();
				yyW8fL0s = this.getModiSql(iMI8XuP7, taTdf3ko);
				lqqVWcbE = Boolean.FALSE;
				break;
			case 3:
				DOBOProperty wh7XQxQr = DOBOProperty.getDOBOPropertyByName(DRjMOo8V.getName(), "objuid");
				System.out.println("BOBOBO::::::" + DRjMOo8V);
				System.out.println("Property::::::" + wh7XQxQr);
				if (wh7XQxQr == null) {
					return;
				}
				fRPTZLhp = kEdBFoXb + ".delete";
				Yr289cWh = fRPTZLhp;
				iMI8XuP7.add(wh7XQxQr);
				yyW8fL0s = new StringBuffer("delete from ").append(taTdf3ko).append(" where objuid = ?");
				break;
			case 4:
				wh7XQxQr = DOBOProperty.getDOBOPropertyByName(DRjMOo8V.getName(), "objuid");
				if (wh7XQxQr == null) {
					return;
				}
				fRPTZLhp = kEdBFoXb + ".browse";
				Yr289cWh = fRPTZLhp;
				iMI8XuP7.add(wh7XQxQr);
				yyW8fL0s = new StringBuffer("select * from ").append(taTdf3ko).append(" where objuid = ?");
				break;
			case 5:
				fRPTZLhp = kEdBFoXb + ".list";
				Yr289cWh = fRPTZLhp;
				yyW8fL0s = new StringBuffer("select * from ").append(taTdf3ko);
			}
			this.setParaLinkBatch(iMI8XuP7, D6EmMHei, i8isCaVc, lqqVWcbE);
			StringBuffer hkgoBZjP = new StringBuffer("insert into DO_Service(objuid,l10n,name,bouid,mainSql) values(")
					.append("'").append(i8isCaVc).append("','").append(Yr289cWh).append("','").append(fRPTZLhp)
					.append("','").append(this.getDOBOUid(taTdf3ko)).append("','").append(yyW8fL0s).append("')");
			log.info("Servcice's Sql:" + hkgoBZjP.toString());
			sceGQr9N.executeUpdate(hkgoBZjP.toString());
			D6EmMHei.executeBatch();
			Ku6jORil.commit();
		} catch (SQLException xfbbpvw8) {
			try {
				Ku6jORil.rollback();
			} catch (SQLException uUVULF8g) {
				uUVULF8g.printStackTrace();
			}
			xfbbpvw8.printStackTrace();
		} finally {
			try {
				if (!Ku6jORil.isClosed()) {
					Ku6jORil.close();
				}
			} catch (SQLException iUsyxUL8) {
				iUsyxUL8.printStackTrace();
			}
		}
	}

}