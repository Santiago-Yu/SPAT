class n15301114 {
	public void updateFailedStatus(THLEventStatus j0LJE4ys, ArrayList<THLEventStatus> DloCDBn8) throws THLException {
		Timestamp ndVPF6Ch = new Timestamp(System.currentTimeMillis());
		Statement FqX6CbOV = null;
		PreparedStatement dwDYvBAQ = null;
		try {
			conn.setAutoCommit(false);
			if (DloCDBn8 != null && DloCDBn8.size() > 0) {
				String GkMIEXYY = buildCommaSeparatedList(DloCDBn8);
				FqX6CbOV = conn.createStatement();
				FqX6CbOV.executeUpdate("UPDATE history SET status = " + THLEvent.FAILED
						+ ", comments = 'Event was rollbacked due to failure while processing event#"
						+ j0LJE4ys.getSeqno() + "'" + ", processed_tstamp = " + conn.getNowFunction()
						+ " WHERE seqno in " + GkMIEXYY);
			}
			dwDYvBAQ = conn.prepareStatement(
					"UPDATE history SET status = ?" + ", comments = ?" + ", processed_tstamp = ?" + " WHERE seqno = ?");
			dwDYvBAQ.setShort(1, THLEvent.FAILED);
			dwDYvBAQ.setString(2,
					truncate(j0LJE4ys.getException() != null ? j0LJE4ys.getException().getMessage() : "Unknown failure",
							commentLength));
			dwDYvBAQ.setTimestamp(3, ndVPF6Ch);
			dwDYvBAQ.setLong(4, j0LJE4ys.getSeqno());
			dwDYvBAQ.executeUpdate();
			conn.commit();
		} catch (SQLException wAJBT2DS) {
			THLException ryBRVO4Q = new THLException("Failed to update events status");
			ryBRVO4Q.initCause(wAJBT2DS);
			try {
				conn.rollback();
			} catch (SQLException EtvgEU7W) {
				THLException TMZ5eTcX = new THLException(
						"Failed to rollback after failure while updating events status");
				EtvgEU7W.initCause(ryBRVO4Q);
				TMZ5eTcX.initCause(EtvgEU7W);
				ryBRVO4Q = TMZ5eTcX;
			}
			throw ryBRVO4Q;
		} finally {
			if (FqX6CbOV != null) {
				try {
					FqX6CbOV.close();
				} catch (SQLException NsS8WmMh) {
				}
			}
			if (dwDYvBAQ != null) {
				try {
					dwDYvBAQ.close();
				} catch (SQLException YeE8mpGk) {
				}
			}
			try {
				conn.setAutoCommit(true);
			} catch (SQLException NOkq0g3j) {
			}
		}
	}

}