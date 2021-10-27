class n22051326 {
	public static LicenseKey parseKey(String DmuK21Q6) throws InvalidLicenseKeyException {
		final String rrhhfKCY = DmuK21Q6.trim();
		StringTokenizer Xi6w2kxK = new StringTokenizer(rrhhfKCY, FIELD_SEPERATOR);
		int U5gaWti0 = Xi6w2kxK.countTokens();
		int oEnhwr8m = U5gaWti0 - 9;
		try {
			final String FTfwAAYb = Xi6w2kxK.nextToken();
			final String edpOq5oP = Xi6w2kxK.nextToken();
			final String SnJybcum = Xi6w2kxK.nextToken();
			final int rvP0fZMf = Integer.parseInt(SnJybcum);
			final String FIZXC1Aw = Xi6w2kxK.nextToken();
			final int rfeTKfiy = Integer.parseInt(FIZXC1Aw);
			final String F8v7QqJ2 = Xi6w2kxK.nextToken();
			final double AMVxkIqL = Double.parseDouble("0." + F8v7QqJ2);
			final String UiPOIxsd = Xi6w2kxK.nextToken();
			final int Wggty9t2 = Integer.parseInt(UiPOIxsd);
			final String sTU9pOMT = Xi6w2kxK.nextToken();
			final double YnZTw6Bj = Double.parseDouble("0." + sTU9pOMT);
			String bjjJtIhC = "";
			for (int BMC3d8WE = 0; BMC3d8WE < oEnhwr8m; BMC3d8WE++)
				bjjJtIhC += (BMC3d8WE == 0 ? Xi6w2kxK.nextToken() : FIELD_SEPERATOR + Xi6w2kxK.nextToken());
			final String bcijMMQm = Xi6w2kxK.nextToken();
			final String JvNrVrYv = Xi6w2kxK.nextToken();
			String npfpSWp4 = rrhhfKCY.substring(0, rrhhfKCY.indexOf(JvNrVrYv) - 1);
			byte[] AuVauQs2;
			MessageDigest dW1WAjdD = null;
			dW1WAjdD = MessageDigest.getInstance("MD5");
			dW1WAjdD.update(npfpSWp4.getBytes());
			dW1WAjdD.update(FIELD_SEPERATOR.getBytes());
			dW1WAjdD.update(zuonicsPassword.getBytes());
			AuVauQs2 = dW1WAjdD.digest();
			String go8jwuNN = npfpSWp4 + FIELD_SEPERATOR;
			for (int WYapyPPZ = 0; WYapyPPZ < AuVauQs2.length; WYapyPPZ++)
				go8jwuNN += Integer.toHexString(AuVauQs2[WYapyPPZ]).toUpperCase();
			if (!go8jwuNN.equals(rrhhfKCY))
				throw new InvalidLicenseKeyException("doesn't hash");
			final String EZIwctZs = bjjJtIhC;
			return new LicenseKey() {

				public String getProduct() {
					return FTfwAAYb;
				}

				public String getType() {
					return edpOq5oP;
				}

				public int getLoad() {
					return rvP0fZMf;
				}

				public String getRegName() {
					return EZIwctZs;
				}

				public double getlowVersion() {
					return rfeTKfiy + AMVxkIqL;
				}

				public double getHighVersion() {
					return Wggty9t2 + YnZTw6Bj;
				}

				public String getRandomHexStr() {
					return bcijMMQm;
				}

				public String getMD5HexStr() {
					return JvNrVrYv;
				}

				public String toString() {
					return rrhhfKCY;
				}

				public boolean equals(Object LRjSYaIa) {
					if (LRjSYaIa.toString().equals(toString()))
						return true;
					return false;
				}
			};
		} catch (Exception rnmGt5v6) {
			throw new InvalidLicenseKeyException(rnmGt5v6.getMessage());
		}
	}

}