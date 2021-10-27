class n8562659 {
	protected void validate(long Bv8menmG, long HXEzh0dQ, String Wg5lHYTt, String oIlWuyAo, int sRQjXrX1,
			String MHLy82od, String ZQPUqLxO, byte[] EsCWOofE) throws PortalException, SystemException {
		if (Validator.isNull(Wg5lHYTt))
			throw new AuctionDescriptionException();
		else if (Validator.isNull(ZQPUqLxO))
			throw new AuctionTitleException();
		else if (Validator.isNull(oIlWuyAo))
			throw new CategoryIdException();
		if (Bv8menmG < 1000000000l | Bv8menmG > 999999999999999l)
			throw new AuctionGoogCMIdException();
		long m170GeeO = 1048576l;
		if ((EsCWOofE == null) || (EsCWOofE.length > ((int) m170GeeO)))
			throw new AuctionImageSizeException();
		if (sRQjXrX1 != 3 & sRQjXrX1 != 7 & sRQjXrX1 != 10)
			throw new AuctionEndeDateException();
		if ((HXEzh0dQ < 0) || (HXEzh0dQ > 10000))
			throw new AuctionReservePriceException();
		try {
			URL MMul5lN0 = new URL("https://checkout.google.com/api/checkout/v2/checkoutForm/Merchant/" + Bv8menmG);
			URLConnection AFguJT4t = MMul5lN0.openConnection();
			BufferedReader rVLHhD7N = new BufferedReader(new InputStreamReader(AFguJT4t.getInputStream()));
			boolean n9q9uWK2 = true;
			String qDJNdEvY;
			while ((qDJNdEvY = rVLHhD7N.readLine()) != null) {
				if (qDJNdEvY.contains("" + Bv8menmG)) {
					throw new AuctionGoogCMAccountException();
				}
			}
			rVLHhD7N.close();
		} catch (IOException gGinGmyC) {
			gGinGmyC.printStackTrace();
		}
	}

}