class n14533184 {
	public boolean delete(int xNdP1ulw) {
		boolean OLuxPNOT = false;
		Connection XIFLNwAR = null;
		try {
			XIFLNwAR = db.getConnection();
			XIFLNwAR.setAutoCommit(false);
			String UEamPnvv = "DELETE FROM keyphrases WHERE website_id=?";
			PreparedStatement sLqcx9f5 = XIFLNwAR.prepareStatement(UEamPnvv);
			sLqcx9f5.setInt(1, xNdP1ulw);
			OLuxPNOT = sLqcx9f5.executeUpdate() == 1;
			sLqcx9f5.close();
			UEamPnvv = "DELETE FROM websites WHERE id=?";
			sLqcx9f5 = XIFLNwAR.prepareStatement(UEamPnvv);
			sLqcx9f5.setInt(1, xNdP1ulw);
			boolean fsZC2p0F = sLqcx9f5.executeUpdate() == 1;
			OLuxPNOT = OLuxPNOT && fsZC2p0F;
			sLqcx9f5.close();
			XIFLNwAR.commit();
			XIFLNwAR.setAutoCommit(true);
		} catch (SQLException BFFFgLOq) {
			try {
				XIFLNwAR.rollback();
				XIFLNwAR.setAutoCommit(true);
			} catch (SQLException MVpfDxsK) {
				throw new OsseoFailure("SQL error: roll back failed. ", MVpfDxsK);
			}
			throw new OsseoFailure("SQL error: cannot remove website with id " + xNdP1ulw + ".", BFFFgLOq);
		} finally {
			db.putConnection(XIFLNwAR);
		}
		return OLuxPNOT;
	}

}