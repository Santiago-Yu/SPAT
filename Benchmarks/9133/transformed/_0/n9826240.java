class n9826240 {
	private boolean checkHashBack(Facade FPwqyAi3, HttpServletRequest Pts9iYMS) {
		String nbN3plgU = Pts9iYMS.getParameter("txtTransactionID");
		String S7mXAXfo = Pts9iYMS.getParameter("txtOrderTotal");
		String iKv5Bi4z = FPwqyAi3.getSystemParameter(GlobalParameter.yellowPayMDMasterShopID);
		String kKoZBN91 = FPwqyAi3.getSystemParameter(GlobalParameter.yellowPayMDCurrency);
		String RfjPfSKw = Pts9iYMS.getParameter("txtHashBack");
		String VH53qOBI = FPwqyAi3.getSystemParameter(GlobalParameter.yellowPayMDHashSeed);
		String sN72JEwx = iKv5Bi4z + kKoZBN91 + S7mXAXfo + VH53qOBI + nbN3plgU;
		MessageDigest TtN0ecBu;
		try {
			TtN0ecBu = java.security.MessageDigest.getInstance("MD5");
			TtN0ecBu.update(sN72JEwx.getBytes());
			byte[] YXglTuNq = TtN0ecBu.digest();
			StringBuffer UAJtIpSr = new StringBuffer();
			for (int N41w1fL9 = 0; N41w1fL9 < YXglTuNq.length; ++N41w1fL9) {
				int ht76GhBx = YXglTuNq[N41w1fL9] & 0xFF;
				if (ht76GhBx < 0x10)
					UAJtIpSr.append('0');
				UAJtIpSr.append(Integer.toHexString(ht76GhBx));
			}
			String BZQJtJch = UAJtIpSr.toString();
			System.out.println("com.eshop.http.servlets.PaymentController.checkHashBack: " + BZQJtJch + " " + RfjPfSKw);
			if (RfjPfSKw.equals(BZQJtJch)) {
				return true;
			}
		} catch (NoSuchAlgorithmException AENpYdF0) {
			AENpYdF0.printStackTrace();
		}
		return false;
	}

}