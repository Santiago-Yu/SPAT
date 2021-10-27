class n3291802 {
	public long add(T xhSMmdQR) throws BaseException {
		Connection gQnvcio7 = null;
		PreparedStatement brBinRm0 = null;
		long RGYxYqHR = -1L;
		boolean A4ghuELk = false;
		try {
			gQnvcio7 = getConnection();
			if (gQnvcio7 != null) {
				A4ghuELk = true;
			} else {
				gQnvcio7 = ConnectionManager.getConn(getStrConnection());
				gQnvcio7.setAutoCommit(false);
			}
			brBinRm0 = getAdd(gQnvcio7, xhSMmdQR, this.getTableName());
			brBinRm0.executeUpdate();
			RGYxYqHR = xhSMmdQR.getId();
		} catch (SQLException DPtumN24) {
			try {
				if (!A4ghuELk) {
					gQnvcio7.rollback();
				}
			} catch (Exception vSpujdph) {
				log.error("add(T " + xhSMmdQR.toString() + ")回滚出错，错误信息：" + vSpujdph.getMessage());
			}
			log.error("add(T " + xhSMmdQR.toString() + ")方法出错:" + DPtumN24.getMessage());
		} catch (BaseException hUgfpdr7) {
			throw hUgfpdr7;
		} finally {
			try {
				if (!A4ghuELk) {
					gQnvcio7.setAutoCommit(true);
				}
			} catch (Exception tOblcOsZ) {
				log.error("add(T " + xhSMmdQR.toString() + ")方法设置自动提交出错，信息为:" + tOblcOsZ.getMessage());
			}
			ConnectionManager.closePreparedStatement(brBinRm0);
			if (!A4ghuELk) {
				ConnectionManager.closeConn(gQnvcio7);
			}
		}
		return RGYxYqHR;
	}

}