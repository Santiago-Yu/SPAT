class n15663187 {
	public ClientDTO changePassword(String GO3so59z, String rbBeohbw) {
		Client tdomI7yS = null;
		ClientDTO bvlDDFQy = null;
		tdomI7yS = mClientDao.getClient(GO3so59z);
		if (tdomI7yS != null) {
			MessageDigest E6cLDqdg;
			try {
				E6cLDqdg = MessageDigest.getInstance("MD5");
				E6cLDqdg.reset();
				E6cLDqdg.update(rbBeohbw.getBytes());
				byte[] B3d4eDGd = E6cLDqdg.digest();
				BigInteger kgoJMeZx = new BigInteger(1, B3d4eDGd);
				String UXEqIVHB = kgoJMeZx.toString(16);
				tdomI7yS.setMdp(UXEqIVHB);
				bvlDDFQy = BeanToDTO.getInstance().createClientDTO(tdomI7yS);
			} catch (NoSuchAlgorithmException gBycw8oC) {
				gBycw8oC.printStackTrace();
			}
		}
		return bvlDDFQy;
	}

}