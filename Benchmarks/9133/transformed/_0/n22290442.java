class n22290442 {
	public static void batchInsertOrder(Order UsKn37Iz) throws AppException {
		Connection GXnoSNLx = DBUtils.getDataConnection();
		PreparedStatement jaVRGRIL = null;
		ResultSet HuXhRxmd = null;
		String OAWulVpS = null;
		String HhjvJrbl = null;
		try {
			GXnoSNLx.setAutoCommit(false);
			OAWulVpS = "insert into SO_SOMain (ID,cSOCode,dDate," + "cBusType,cCusCode,cCusName," + "cDepCode,cSTCode,"
					+ "iVTid,cMaker,cMemo) values (?,?,?,?,?,?,?,?,?,?,?)";
			HhjvJrbl = "insert into SO_SODetails (ID,cSOCode,cInvCode,cInvName,"
					+ "iNum,iQuantity,iTaxUnitPrice,iSum,dPreDate,iSOsID,cFree1,cUnitID) values(?,?,?,?,?,?,?,?,?,?,?,?)";
			jaVRGRIL = GXnoSNLx.prepareStatement(OAWulVpS);
			long KIWvGfJ9 = getMaxID(GXnoSNLx, jaVRGRIL, HuXhRxmd);
			KIWvGfJ9++;
			jaVRGRIL.setLong(1, KIWvGfJ9);
			Long K62atmh4 = KIWvGfJ9;
			UsKn37Iz.setId(K62atmh4.intValue());
			String Dc559FZq = UsKn37Iz.getCode();
			long HsLSRoFg = getMaxCSOCode(Dc559FZq, GXnoSNLx, jaVRGRIL, HuXhRxmd);
			String iFRLIwRZ = getCSOCode(Dc559FZq, HsLSRoFg);
			UsKn37Iz.setCode(iFRLIwRZ);
			jaVRGRIL.setString(2, iFRLIwRZ);
			jaVRGRIL.setDate(3, DateUtil.getSqlDateFormUtilDate(UsKn37Iz.getOrderDate()));
			jaVRGRIL.setString(4, UsKn37Iz.getBusinessType());
			jaVRGRIL.setString(5, UsKn37Iz.getC().getId());
			jaVRGRIL.setString(6, UsKn37Iz.getC().getName());
			jaVRGRIL.setString(7, UsKn37Iz.getP().getDept().getId());
			jaVRGRIL.setString(8, UsKn37Iz.getSaleType().getId());
			jaVRGRIL.setInt(9, UsKn37Iz.getiVtid());
			jaVRGRIL.setString(10, UsKn37Iz.getP().getName());
			jaVRGRIL.setString(11, UsKn37Iz.getRemark());
			jaVRGRIL.executeUpdate();
			jaVRGRIL.clearParameters();
			jaVRGRIL = GXnoSNLx.prepareStatement(HhjvJrbl);
			ArrayList<OrderDetail> QPNxdY4Z = UsKn37Iz.getOds();
			long vTQkJjj1 = getiSOsID(GXnoSNLx, jaVRGRIL, HuXhRxmd);
			for (OrderDetail x8qGnPQZ : QPNxdY4Z) {
				jaVRGRIL.setLong(1, KIWvGfJ9);
				jaVRGRIL.setString(2, iFRLIwRZ);
				jaVRGRIL.setString(3, x8qGnPQZ.getInventory().getId());
				jaVRGRIL.setString(4, x8qGnPQZ.getInventory().getName());
				jaVRGRIL.setInt(5, x8qGnPQZ.getPiece());
				jaVRGRIL.setBigDecimal(6, x8qGnPQZ.getCount());
				jaVRGRIL.setBigDecimal(7, x8qGnPQZ.getPrice());
				jaVRGRIL.setBigDecimal(8, x8qGnPQZ.getSum());
				jaVRGRIL.setDate(9, DateUtil.getSqlDateFormUtilDate(x8qGnPQZ.getSendDate()));
				jaVRGRIL.setLong(10, ++vTQkJjj1);
				jaVRGRIL.setString(11, x8qGnPQZ.getPacking().getcValue());
				jaVRGRIL.setString(12, x8qGnPQZ.getInventory().getSAComUnitCode());
				jaVRGRIL.executeUpdate();
				jaVRGRIL.clearParameters();
			}
			GXnoSNLx.commit();
		} catch (SQLException lXG80MCi) {
			try {
				GXnoSNLx.rollback();
				throw new AppException(lXG80MCi.getMessage());
			} catch (SQLException g5m3xUP2) {
				Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, g5m3xUP2);
				throw new AppException(g5m3xUP2.getMessage());
			}
		} finally {
			DBUtils.closeAll(HuXhRxmd, jaVRGRIL, GXnoSNLx);
		}
	}

}