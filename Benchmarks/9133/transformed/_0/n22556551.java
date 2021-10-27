class n22556551 {
	private void copyOneFile(String eRkNkeCa, String FqBkfm8U) {
		File x83b39jc = new File(FqBkfm8U);
		try {
			FileInputStream r8w6k6fS = new FileInputStream(eRkNkeCa);
			FileOutputStream WmacLmvx = new FileOutputStream(x83b39jc);
			FileChannel tktTTd5R = r8w6k6fS.getChannel();
			FileChannel Ak85q1jk = WmacLmvx.getChannel();
			long pTpCw17P = tktTTd5R.size();
			tktTTd5R.transferTo(0, pTpCw17P, Ak85q1jk);
			r8w6k6fS.close();
			WmacLmvx.close();
		} catch (Exception c0RpT890) {
			c0RpT890.printStackTrace();
		}
	}

}