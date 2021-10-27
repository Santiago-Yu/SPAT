class n22382481 {
	public boolean ReadFile() {
		boolean BkdejGBx = false;
		FilenameFilter wB2e7B3A = null;
		File y5RksGme = new File(fDir);
		String[] w32LPG25;
		int hqJmHcp6 = 0;
		BufferedReader n9HfdBMu = null;
		PreparedStatement KYgAYfCw = null, hfMVV0j5 = null;
		String G5OonKeR = null, wPNlIp7e = null, fc8fZJIH = null, bSn0faFG = null, IXkFUfqL = null;
		double[] SDPFwguL = new double[US_D + 1];
		double CBw3aZTx = 0;
		String IlPvBxSi = "INSERT INTO reporter.term_fee (TERM, TERM_TYPE, THEM_VC,	THEM_VE, THEM_EC, THEM_EE, THEM_D,"
				+ "BA_VC, BA_VE, BA_EC, BA_EE, BA_D," + "US_VC, US_VE, US_EC, US_EE, US_D)"
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			wB2e7B3A = new FilenameFilter() {

				public boolean accept(File yfFAqeUB, String nsMZIcy6) {
					if ((new File(yfFAqeUB, nsMZIcy6)).isDirectory())
						return false;
					else
						return (nsMZIcy6.matches(fFileMask));
				}
			};
			w32LPG25 = y5RksGme.list(wB2e7B3A);
			java.util.Arrays.sort(w32LPG25);
			System.out.println(w32LPG25[w32LPG25.length - 1] + " "
					+ (new SimpleDateFormat("dd.MM.yy HH:mm:ss")).format(new Date()));
			Log.info(String.format("Load = %1s", fDir + w32LPG25[w32LPG25.length - 1]));
			n9HfdBMu = new BufferedReader(new FileReader(fDir + w32LPG25[w32LPG25.length - 1]));
			FeeZero(SDPFwguL);
			KYgAYfCw = cnProd.prepareStatement("delete from reporter.term_fee");
			KYgAYfCw.executeUpdate();
			hfMVV0j5 = cnProd.prepareStatement(IlPvBxSi);
			WriteTerm(
					w32LPG25[w32LPG25.length - 1] + " "
							+ (new SimpleDateFormat("dd.MM.yy HH:mm:ss")).format(new Date()),
					"XXX", SDPFwguL, hfMVV0j5);
			while ((G5OonKeR = n9HfdBMu.readLine()) != null) {
				hqJmHcp6++;
				if (!G5OonKeR.matches("\\d{15}\\s+????????.+"))
					continue;
				wPNlIp7e = G5OonKeR.substring(7, 15);
				if ((fc8fZJIH == null) || !wPNlIp7e.equals(fc8fZJIH)) {
					if (fc8fZJIH != null) {
						WriteTerm(fc8fZJIH, bSn0faFG, SDPFwguL, hfMVV0j5);
					}
					fc8fZJIH = wPNlIp7e;
					if (G5OonKeR.indexOf("???") > 0)
						bSn0faFG = "???";
					else
						bSn0faFG = "???";
					FeeZero(SDPFwguL);
				}
				IXkFUfqL = G5OonKeR.substring(64, 68).trim().toUpperCase();
				if (IXkFUfqL.equals("ST") || IXkFUfqL.equals("AC") || IXkFUfqL.equals("8110")
						|| IXkFUfqL.equals("8160"))
					continue;
				CBw3aZTx = new Double(G5OonKeR.substring(140, 160)).doubleValue();
				if (G5OonKeR.indexOf("?? ????? ??????") > 0)
					SetFee(SDPFwguL, CARD_THEM, IXkFUfqL, CBw3aZTx);
				else if (G5OonKeR.indexOf("?? ?????? ?????") > 0)
					SetFee(SDPFwguL, CARD_BA, IXkFUfqL, CBw3aZTx);
				else if (G5OonKeR.indexOf("?? ?????? ??") > 0)
					SetFee(SDPFwguL, CARD_US, IXkFUfqL, CBw3aZTx);
				else
					throw new Exception("?????? ???? ????.:" + G5OonKeR);
			}
			WriteTerm(fc8fZJIH, bSn0faFG, SDPFwguL, hfMVV0j5);
			cnProd.commit();
			BkdejGBx = true;
		} catch (Exception xBPjQIyC) {
			System.out.printf("Err = %1s\r\n", xBPjQIyC.getMessage());
			Log.error(String.format("Err = %1s", xBPjQIyC.getMessage()));
			Log.error(String.format("Line = %1s", G5OonKeR));
			try {
				cnProd.rollback();
			} catch (Exception DLU23U5J) {
			}
			;
		} finally {
			try {
				if (n9HfdBMu != null)
					n9HfdBMu.close();
			} catch (Exception pRLq59yG) {
			}
		}
		try {
			if (KYgAYfCw != null)
				KYgAYfCw.close();
			if (hfMVV0j5 != null)
				hfMVV0j5.close();
			cnProd.setAutoCommit(true);
		} catch (Exception Q06BmFCA) {
		}
		Log.info(String.format("Lines = %1d", hqJmHcp6));
		return (BkdejGBx);
	}

}