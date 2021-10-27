class n11081583 {
	public void rename(String WHBG7Xsn, String P9Rcmacq, String euXNHou4) throws Exception {
		Connection nywqpWVP = DatabaseConnection.getConnection();
		try {
			boolean Stm57qii = false;
			nywqpWVP.setAutoCommit(false);
			try {
				PreparedStatement QdTfCT5g = nywqpWVP.prepareStatement(STATEMENT_RENAME);
				try {
					QdTfCT5g.setString(1, euXNHou4);
					QdTfCT5g.setString(2, P9Rcmacq);
					QdTfCT5g.setString(3, WHBG7Xsn);
					if (QdTfCT5g.executeUpdate() == 0)
						throw new SQLException("Unable to rename topic " + P9Rcmacq + " on wiki " + WHBG7Xsn);
				} finally {
					QdTfCT5g.close();
				}
				doUnlockTopic(nywqpWVP, WHBG7Xsn, P9Rcmacq);
				doRenameAllVersions(nywqpWVP, WHBG7Xsn, P9Rcmacq, euXNHou4);
				Stm57qii = true;
			} finally {
				if (Stm57qii)
					nywqpWVP.commit();
				else
					nywqpWVP.rollback();
			}
		} finally {
			nywqpWVP.close();
		}
	}

}