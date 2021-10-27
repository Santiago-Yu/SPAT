class n3637605 {
	public void actionPerformed(ActionEvent Sg14jFRA) {
		String hC63DmoN = null;
		try {
			MessageDigest IC7yBCXv = MessageDigest.getInstance("sha1");
			IC7yBCXv.reset();
			String QReLOaoB = String.copyValueOf(this.login.getPassword());
			IC7yBCXv.update(QReLOaoB.getBytes());
			byte[] C2tPmNd5 = IC7yBCXv.digest();
			BigInteger b6bit8VA = new BigInteger(C2tPmNd5);
			hC63DmoN = b6bit8VA.toString();
			System.out.println(hC63DmoN);
		} catch (NoSuchAlgorithmException ayaz4Otw) {
			ayaz4Otw.printStackTrace();
		}
		this.model.login(this.login.getHost(), this.login.getPort(), this.login.getUser(), hC63DmoN);
	}

}