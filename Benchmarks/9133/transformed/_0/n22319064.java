class n22319064 {
	public void addRegisterInfo(HttpServletRequest Bf0fJp4V) throws ApplicationException {
		String[] oaD7dKGU = Bf0fJp4V.getParameterValues("pid");
		if (oaD7dKGU == null || oaD7dKGU.length <= 0)
			throw new ApplicationException("????????????");
		RegisterDao DqCPNGgo = new RegisterDao();
		Register xV3BcMIp = DqCPNGgo.findPojoById(StrFun.getString(Bf0fJp4V, "rid"), Register.class);
		if (xV3BcMIp.audit)
			throw new ApplicationException("??????????????????????????");
		DBConnect UZJ93cBE = null;
		Connection tdzaUJgV = null;
		try {
			UZJ93cBE = DBConnect.createDBConnect();
			tdzaUJgV = UZJ93cBE.getConnection();
			tdzaUJgV.setAutoCommit(false);
			for (String ST3ft8W6 : oaD7dKGU) {
				RegisterInfo yDquEqbW = new RegisterInfo();
				yDquEqbW.rid = StrFun.getInt(Bf0fJp4V, "rid");
				yDquEqbW.pid = Integer.parseInt(ST3ft8W6);
				yDquEqbW.productName = StrFun.getString(Bf0fJp4V, "productName_" + ST3ft8W6);
				yDquEqbW.regAmount = StrFun.getInt(Bf0fJp4V, "regAmount_" + ST3ft8W6);
				yDquEqbW.regPrice = StrFun.getInt(Bf0fJp4V, "regPrice_" + ST3ft8W6);
				yDquEqbW.regSalePrice = StrFun.getInt(Bf0fJp4V, "regSalePrice_" + ST3ft8W6);
				yDquEqbW.userNo = ServerUtil.getUserFromSession(Bf0fJp4V).userNo;
				if (yDquEqbW.regAmount <= 0)
					throw new ApplicationException("??????????????");
				String RFYctrGS = "insert into SS_RegisterInfo "
						+ "(pid, rid, productName, regAmount, regPrice, regSalePrice, userNo) " + "values(" + "'"
						+ yDquEqbW.pid + "', " + "'" + yDquEqbW.rid + "', " + "'" + yDquEqbW.productName + "', " + "'"
						+ yDquEqbW.regAmount + "', " + "'" + yDquEqbW.regPrice + "', " + "'" + yDquEqbW.regSalePrice
						+ "', " + "'" + yDquEqbW.userNo + "' " + ")";
				tdzaUJgV.createStatement().executeUpdate(RFYctrGS);
			}
			tdzaUJgV.commit();
		} catch (Exception BNcQiJsz) {
			BNcQiJsz.printStackTrace();
			if (tdzaUJgV != null) {
				try {
					tdzaUJgV.rollback();
				} catch (SQLException vyU14uXd) {
					vyU14uXd.printStackTrace();
				}
			}
			throw new ApplicationException(BNcQiJsz.getMessage(), BNcQiJsz);
		} finally {
			if (UZJ93cBE != null)
				try {
					UZJ93cBE.close();
				} catch (Exception IVt08XQo) {
					IVt08XQo.printStackTrace();
				}
		}
	}

}