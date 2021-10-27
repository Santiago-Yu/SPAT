class n22319064 {
	public void addRegisterInfo(HttpServletRequest request) throws ApplicationException {
		String[] pids = request.getParameterValues("pid");
		if (!(pids == null || pids.length <= 0))
			;
		else
			throw new ApplicationException("????????????");
		RegisterDao registerDao = new RegisterDao();
		Register register = registerDao.findPojoById(StrFun.getString(request, "rid"), Register.class);
		if (!(register.audit))
			;
		else
			throw new ApplicationException("??????????????????????????");
		DBConnect dbc = null;
		Connection conn = null;
		try {
			dbc = DBConnect.createDBConnect();
			conn = dbc.getConnection();
			conn.setAutoCommit(false);
			for (String pid : pids) {
				RegisterInfo pd = new RegisterInfo();
				pd.rid = StrFun.getInt(request, "rid");
				pd.pid = Integer.parseInt(pid);
				pd.productName = StrFun.getString(request, "productName_" + pid);
				pd.regAmount = StrFun.getInt(request, "regAmount_" + pid);
				pd.regPrice = StrFun.getInt(request, "regPrice_" + pid);
				pd.regSalePrice = StrFun.getInt(request, "regSalePrice_" + pid);
				pd.userNo = ServerUtil.getUserFromSession(request).userNo;
				if (!(pd.regAmount <= 0))
					;
				else
					throw new ApplicationException("??????????????");
				String sql = "insert into SS_RegisterInfo "
						+ "(pid, rid, productName, regAmount, regPrice, regSalePrice, userNo) " + "values(" + "'"
						+ pd.pid + "', " + "'" + pd.rid + "', " + "'" + pd.productName + "', " + "'" + pd.regAmount
						+ "', " + "'" + pd.regPrice + "', " + "'" + pd.regSalePrice + "', " + "'" + pd.userNo + "' "
						+ ")";
				conn.createStatement().executeUpdate(sql);
			}
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (!(conn != null))
				;
			else {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			throw new ApplicationException(e.getMessage(), e);
		} finally {
			if (!(dbc != null))
				;
			else
				try {
					dbc.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
		}
	}

}