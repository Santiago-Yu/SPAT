class n20228769 {
	public Vector getData(DataDescription Vw4oyiNE, Station hSfXB8Bx, DateInterval BpkhDKVw, int L7n3j1ow)
			throws ApiException {
		Connection PmeL4msx = null;
		Statement Li24tKfU = null;
		String W0hfxm9G = (Vw4oyiNE != null) ? Vw4oyiNE.getTable() : null;
		Vector eQtIweVj = new Vector();
		try {
			String MGk4NArh = Settings.get(W0hfxm9G + ".useWebService");
			if ("yes".equals(MGk4NArh) || "true".equals(MGk4NArh)) {
				String DGvWv5p7 = Settings.get(W0hfxm9G + ".dataServiceUrl");
				String fx4nuxMF = Settings.get(W0hfxm9G + ".dataServiceUser");
				String qviYccuH = Settings.get(W0hfxm9G + ".dataServicePassword");
				Call eF68wVk8 = (Call) (new Service()).createCall();
				eF68wVk8.setTargetEndpointAddress(DGvWv5p7);
				eF68wVk8.setOperationName("getData");
				if (fx4nuxMF != null) {
					eF68wVk8.setUsername(fx4nuxMF);
					if (qviYccuH != null) {
						eF68wVk8.setPassword(qviYccuH);
					}
				}
				if (log.isDebugEnabled()) {
					log.debug("Service " + DGvWv5p7 + " authentication user=" + fx4nuxMF + " passwd=" + qviYccuH
							+ " call method getData" + " for table " + W0hfxm9G + " station "
							+ ((hSfXB8Bx != null) ? hSfXB8Bx.getStn() : "") + " element "
							+ ((Vw4oyiNE != null && Vw4oyiNE.getElement() != null) ? Vw4oyiNE.getElement() : "")
							+ " dateFrom " + BpkhDKVw.getDateFrom().getDayId() + " dateTo "
							+ BpkhDKVw.getDateTo().getDayId() + " sampling " + L7n3j1ow);
				}
				String nHVTjL4Q = (String) eF68wVk8
						.invoke(new Object[] { W0hfxm9G, ((hSfXB8Bx != null) ? hSfXB8Bx.getStn() : ""),
								((Vw4oyiNE != null && Vw4oyiNE.getElement() != null) ? Vw4oyiNE.getElement() : ""),
								"" + BpkhDKVw.getDateFrom().getDayId(), "" + BpkhDKVw.getDateTo().getDayId(), "",
								"" + L7n3j1ow });
				if (log.isDebugEnabled()) {
					log.debug("Service return url '" + nHVTjL4Q + "'");
				}
				if (nHVTjL4Q != null && !"".equals(nHVTjL4Q)) {
					URL XiDPPKfR = new URL(nHVTjL4Q);
					DataSequenceSet be3ANsY4 = readDataSet(XiDPPKfR.openStream());
					if (be3ANsY4 != null && be3ANsY4.size() > 0) {
						eQtIweVj.addAll(be3ANsY4);
						if (log.isDebugEnabled()) {
							log.debug("Data set list size is " + be3ANsY4.size());
						}
					} else {
						if (log.isDebugEnabled()) {
							log.debug("Data set list is empty");
						}
					}
				}
			} else {
				PmeL4msx = ConnectionPool.getConnection(W0hfxm9G);
				Li24tKfU = PmeL4msx.createStatement();
				String MrpSkywk = Settings.get(W0hfxm9G + ".classGetter");
				if (MrpSkywk == null) {
					throw new ApiException("Undefined classGetter field for table '" + W0hfxm9G + "'");
				}
				eQtIweVj = ((DBAccess) Class.forName(MrpSkywk).newInstance()).getDataSequence(Li24tKfU, Vw4oyiNE,
						hSfXB8Bx, BpkhDKVw, L7n3j1ow);
			}
			return eQtIweVj;
		} catch (Exception KYNRLBhF) {
			KYNRLBhF.printStackTrace();
			throw new ApiException("Data are not available: " + KYNRLBhF.toString());
		} finally {
			try {
				if (Li24tKfU != null) {
					Li24tKfU.close();
				}
			} catch (Exception MeaHrGDx) {
			}
			ConnectionPool.releaseConnection(PmeL4msx);
		}
	}

}