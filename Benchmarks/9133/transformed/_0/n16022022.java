class n16022022 {
	public boolean copy(Class<?> p9vug3qg, String iPIDINIb, long YTkJp6nu) {
		boolean Q2lSRKrU = false;
		this.result = null;
		Connection mWi730Re = null;
		Object CnAJLdDb = null;
		try {
			mWi730Re = ConnectUtil.getConnect();
			mWi730Re.setAutoCommit(false);
			PojoParser MyHFzm0r = PojoParser.getInstances();
			String pqQvxIFB = SqlUtil.getInsertSql(this.getCls());
			CnAJLdDb = this.findById(mWi730Re, "select * from " + MyHFzm0r.getTableName(cls) + " where "
					+ MyHFzm0r.getPriamryKey(cls) + "=" + YTkJp6nu);
			String M5iJ1JuN = MyHFzm0r.getPriamryKey(cls);
			this.getCls().getMethod("set" + SqlUtil.getFieldName(M5iJ1JuN), new Class[] { long.class }).invoke(CnAJLdDb,
					new Object[] { 0 });
			PreparedStatement bFlv6YDp = mWi730Re.prepareStatement(pqQvxIFB);
			setPsParams(bFlv6YDp, CnAJLdDb);
			bFlv6YDp.executeUpdate();
			bFlv6YDp.close();
			long VfQSNarx = this.id;
			MyHFzm0r = PojoParser.getInstances();
			pqQvxIFB = SqlUtil.getInsertSql(p9vug3qg);
			Class<?> aglfUovX = this.cls;
			this.cls = p9vug3qg;
			bFlv6YDp = mWi730Re.prepareStatement(
					"select * from " + MyHFzm0r.getTableName(p9vug3qg) + " where " + iPIDINIb + "=" + YTkJp6nu);
			this.assembleObjToList(bFlv6YDp);
			bFlv6YDp = mWi730Re.prepareStatement(pqQvxIFB);
			ids = new long[orgList.size()];
			Method gPHFNfve = p9vug3qg.getMethod("set" + SqlUtil.getFieldName(iPIDINIb), new Class[] { long.class });
			for (int iohvGkNY = 0; iohvGkNY < orgList.size(); ++iohvGkNY) {
				Object ILbHrbnv = orgList.get(iohvGkNY);
				p9vug3qg.getMethod("set" + SqlUtil.getFieldName(MyHFzm0r.getPriamryKey(p9vug3qg)),
						new Class[] { long.class }).invoke(ILbHrbnv, new Object[] { 0 });
				gPHFNfve.invoke(ILbHrbnv, new Object[] { VfQSNarx });
				setPsParams(bFlv6YDp, ILbHrbnv);
				bFlv6YDp.addBatch();
				if ((iohvGkNY % 100) == 0)
					bFlv6YDp.executeBatch();
				ids[iohvGkNY] = this.id;
			}
			bFlv6YDp.executeBatch();
			bFlv6YDp.close();
			mWi730Re.commit();
			this.cls = aglfUovX;
			this.id = VfQSNarx;
			Q2lSRKrU = true;
		} catch (Exception pShW8SvG) {
			try {
				mWi730Re.rollback();
			} catch (Exception BNXRo7CU) {
				BNXRo7CU.printStackTrace();
			}
			this.result = pShW8SvG.getMessage();
		} finally {
			this.closeConnectWithTransaction(mWi730Re);
		}
		return Q2lSRKrU;
	}

}