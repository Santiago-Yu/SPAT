class n4470706 {
	@Override
	public boolean validatePublisher(Object hgJTJO4E, String... QlBLMRmF) {
		DBConnectionListener IuqAFuBe = (DBConnectionListener) hgJTJO4E;
		String Uz4Rmk7V = QlBLMRmF[0];
		String axDJNA6M = QlBLMRmF[1];
		String N9XcwEaH = QlBLMRmF[2];
		String W9xW5fjE = QlBLMRmF[3];
		String fh55E362 = QlBLMRmF[4];
		String mLVsG7dU = QlBLMRmF[5];
		String ig4CrnvE = QlBLMRmF[6];
		String vpG3a5BK = QlBLMRmF[7];
		boolean LfFTc7Bw = false;
		String nAWutKoy = "http://" + Uz4Rmk7V + ":" + axDJNA6M + "/reports";
		try {
			URL bRk93bAo = new URL(nAWutKoy);
			bRk93bAo.openConnection().connect();
			LfFTc7Bw = true;
		} catch (Exception S1JwgdpF) {
			log.log(Level.FINE, "Failed validating url " + nAWutKoy, S1JwgdpF);
		}
		if (LfFTc7Bw) {
			Connection qftDRfPM;
			try {
				if (N9XcwEaH != null) {
					qftDRfPM = DBProperties.getInstance().getConnection(N9XcwEaH, fh55E362, mLVsG7dU, W9xW5fjE,
							ig4CrnvE, vpG3a5BK);
				} else {
					qftDRfPM = DBProperties.getInstance().getConnection();
				}
			} catch (Exception P2z12DEs) {
				qftDRfPM = null;
				IuqAFuBe.connectionIsOk(false, null);
				LfFTc7Bw = false;
			}
			if (LfFTc7Bw) {
				if (!allNecessaryTablesCreated(qftDRfPM)) {
					qftDRfPM = null;
					IuqAFuBe.connectionIsOk(false, null);
					LfFTc7Bw = false;
				}
				IuqAFuBe.connectionIsOk(true, qftDRfPM);
			}
		} else {
			IuqAFuBe.connectionIsOk(false, null);
		}
		return LfFTc7Bw;
	}

}