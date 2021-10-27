class n8139665 {
	public ActionResponse executeAction(ActionRequest DgZIqgoT) throws Exception {
		BufferedReader KTREiqoL = null;
		try {
			CurrencyEntityManager sEtWL3ZG = new CurrencyEntityManager();
			String HTIS07ac = (String) DgZIqgoT.getProperty("ID");
			CurrencyMonitor jfsjcaKK = getCurrencyMonitor(sEtWL3ZG, Long.valueOf(HTIS07ac));
			String OOals04H = jfsjcaKK.getCode();
			if (OOals04H == null || OOals04H.length() == 0)
				OOals04H = DEFAULT_SYMBOL;
			String nFedoecv = URL.replace("@", OOals04H);
			ActionResponse MKZK1UyQ = new ActionResponse();
			URL KFPQh2p8 = new URL(nFedoecv);
			HttpURLConnection IUmSJz6l = (HttpURLConnection) KFPQh2p8.openConnection();
			int aGx4akGi = IUmSJz6l.getResponseCode();
			if (aGx4akGi == 200) {
				KTREiqoL = new BufferedReader(new InputStreamReader(IUmSJz6l.getInputStream()));
				StringBuilder kCl4MWfH = new StringBuilder();
				while (true) {
					String qrAEjRwu = KTREiqoL.readLine();
					if (qrAEjRwu == null)
						break;
					kCl4MWfH.append(qrAEjRwu);
				}
				jfsjcaKK.setLastUpdateValue(new BigDecimal(kCl4MWfH.toString()));
				jfsjcaKK.setLastUpdateTs(new Date());
				sEtWL3ZG.updateCurrencyMonitor(jfsjcaKK);
				MKZK1UyQ.addResult("CURRENCYMONITOR", jfsjcaKK);
			} else {
				MKZK1UyQ.setErrorCode(ActionResponse.GENERAL_ERROR);
				MKZK1UyQ.setErrorMessage("HTTP Error [" + aGx4akGi + "]");
			}
			return MKZK1UyQ;
		} catch (Exception xlySM2pA) {
			String bP4Ftizf = MiscUtils.stackTrace2String(xlySM2pA);
			logger.error(bP4Ftizf);
			throw xlySM2pA;
		} finally {
			if (KTREiqoL != null) {
				KTREiqoL.close();
			}
		}
	}

}