class n15301113 {
	public void updateSuccessStatus(ArrayList<THLEventStatus> qwyffjHm, ArrayList<THLEventStatus> NcKSQlNN)
			throws THLException {
		Statement mGb9pCFn = null;
		PreparedStatement XZXFzcty = null;
		try {
			conn.setAutoCommit(false);
			if (qwyffjHm != null && qwyffjHm.size() > 0) {
				mGb9pCFn = conn.createStatement();
				String dptZHpCN = buildCommaSeparatedList(qwyffjHm);
				mGb9pCFn.executeUpdate("UPDATE " + history + " SET status = " + THLEvent.COMPLETED
						+ ", processed_tstamp = " + conn.getNowFunction() + " WHERE seqno in " + dptZHpCN);
			}
			if (NcKSQlNN != null && NcKSQlNN.size() > 0) {
				XZXFzcty = conn.prepareStatement("UPDATE " + history + " SET status = ?, comments = ?,"
						+ " processed_tstamp = ? WHERE seqno = ?");
				Timestamp GxgDVpkz = new Timestamp(System.currentTimeMillis());
				for (THLEventStatus Po3bfBsK : NcKSQlNN) {
					XZXFzcty.setShort(1, THLEvent.SKIPPED);
					XZXFzcty.setString(2,
							truncate(Po3bfBsK.getException() != null ? Po3bfBsK.getException().getMessage()
									: "Unknown event failure", commentLength));
					XZXFzcty.setTimestamp(3, GxgDVpkz);
					XZXFzcty.setLong(4, Po3bfBsK.getSeqno());
					XZXFzcty.addBatch();
				}
				XZXFzcty.executeBatch();
				XZXFzcty.close();
			}
			conn.commit();
		} catch (SQLException d1XcLRtC) {
			THLException NkRvGHIs = new THLException("Failed to update events status");
			NkRvGHIs.initCause(d1XcLRtC);
			try {
				conn.rollback();
			} catch (SQLException I3DezXO0) {
				THLException MgQEeYXw = new THLException(
						"Failed to rollback after failure while updating events status");
				I3DezXO0.initCause(NkRvGHIs);
				MgQEeYXw.initCause(I3DezXO0);
				NkRvGHIs = MgQEeYXw;
			}
			throw NkRvGHIs;
		} finally {
			if (mGb9pCFn != null) {
				try {
					mGb9pCFn.close();
				} catch (SQLException Gy2YnMfJ) {
				}
			}
			if (XZXFzcty != null) {
				try {
					XZXFzcty.close();
				} catch (SQLException CgOk2cEg) {
				}
			}
			try {
				conn.setAutoCommit(true);
			} catch (SQLException fbFCyjdS) {
			}
		}
	}

}