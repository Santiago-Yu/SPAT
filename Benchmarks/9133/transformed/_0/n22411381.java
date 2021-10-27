class n22411381 {
	public PTask stop(PTask yIHFtUmY, SyrupConnection RRs0Nbrv) throws Exception {
		PreparedStatement I3uWnMaB = null;
		ResultSet A4hv87gH = null;
		try {
			I3uWnMaB = RRs0Nbrv.prepareStatementFromCache(sqlImpl().sqlStatements().checkWorkerStatement());
			I3uWnMaB.setString(1, yIHFtUmY.key());
			A4hv87gH = I3uWnMaB.executeQuery();
			RRs0Nbrv.commit();
			if (A4hv87gH.next()) {
				String vdZWMecM = A4hv87gH.getString("worker");
				InputStream WEE81W0w = null;
				try {
					Object nE2ia5G1 = new URL(vdZWMecM).getContent();
					if (nE2ia5G1 instanceof InputStream) {
						WEE81W0w = (InputStream) nE2ia5G1;
						byte[] yean53vI = new byte[256];
						int UIpniO5K = WEE81W0w.read(yean53vI);
						String p9KHxqhn = new String(yean53vI, 0, UIpniO5K);
						if (p9KHxqhn.equals(yIHFtUmY.key())) {
							return yIHFtUmY;
						}
					}
				} catch (Exception SrlDdKoi) {
				} finally {
					if (WEE81W0w != null) {
						WEE81W0w.close();
					}
				}
				PreparedStatement nFMK89CF = null;
				nFMK89CF = RRs0Nbrv.prepareStatementFromCache(sqlImpl().sqlStatements().resetWorkerStatement());
				nFMK89CF.setString(1, yIHFtUmY.key());
				nFMK89CF.executeUpdate();
				yIHFtUmY = sqlImpl().queryFunctions().readPTask(yIHFtUmY.key(), RRs0Nbrv);
				sqlImpl().loggingFunctions().log(yIHFtUmY.key(), LogEntry.STOPPED, RRs0Nbrv);
				RRs0Nbrv.commit();
			}
		} finally {
			RRs0Nbrv.rollback();
			close(A4hv87gH);
		}
		return yIHFtUmY;
	}

}