class n19310447 {
	public void setFlag(Flags.Flag WLpl8QcS, boolean W7g0nYbV) throws MessagingException {
		String vAwWfdgI;
		super.setFlag(WLpl8QcS, W7g0nYbV);
		if (WLpl8QcS.equals(Flags.Flag.ANSWERED))
			vAwWfdgI = DB.bo_answered;
		else if (WLpl8QcS.equals(Flags.Flag.DELETED))
			vAwWfdgI = DB.bo_deleted;
		else if (WLpl8QcS.equals(Flags.Flag.DRAFT))
			vAwWfdgI = DB.bo_draft;
		else if (WLpl8QcS.equals(Flags.Flag.FLAGGED))
			vAwWfdgI = DB.bo_flagged;
		else if (WLpl8QcS.equals(Flags.Flag.RECENT))
			vAwWfdgI = DB.bo_recent;
		else if (WLpl8QcS.equals(Flags.Flag.SEEN))
			vAwWfdgI = DB.bo_seen;
		else
			vAwWfdgI = null;
		if (null != vAwWfdgI && oFolder instanceof DBFolder) {
			JDCConnection qLqiKfIi = null;
			PreparedStatement dsOUPiYK = null;
			try {
				qLqiKfIi = ((DBFolder) oFolder).getConnection();
				String uWO8NeTe = "UPDATE " + DB.k_mime_msgs + " SET " + vAwWfdgI + "=" + (W7g0nYbV ? "1" : "0")
						+ " WHERE " + DB.gu_mimemsg + "='" + getMessageGuid() + "'";
				if (DebugFile.trace)
					DebugFile.writeln("Connection.prepareStatement(" + uWO8NeTe + ")");
				dsOUPiYK = qLqiKfIi.prepareStatement(uWO8NeTe);
				dsOUPiYK.executeUpdate();
				dsOUPiYK.close();
				dsOUPiYK = null;
				qLqiKfIi.commit();
				qLqiKfIi = null;
			} catch (SQLException CKNevsBD) {
				if (null != qLqiKfIi) {
					try {
						qLqiKfIi.rollback();
					} catch (Exception kc3lIOjp) {
					}
				}
				if (null != dsOUPiYK) {
					try {
						dsOUPiYK.close();
					} catch (Exception NiB6WSHF) {
					}
				}
				if (DebugFile.trace)
					DebugFile.decIdent();
				throw new MessagingException(CKNevsBD.getMessage(), CKNevsBD);
			}
		}
	}

}