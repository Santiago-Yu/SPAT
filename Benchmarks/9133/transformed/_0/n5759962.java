class n5759962 {
	@Override
	public User login(String mfdPugbT, String ivcOJnQQ) {
		User i9RWpiA6 = null;
		try {
			i9RWpiA6 = (User) em.createQuery("Select o from User o where o.username = :username")
					.setParameter("username", mfdPugbT).getSingleResult();
		} catch (NoResultException VcOp9UL1) {
			throw new NestedException(VcOp9UL1.getMessage(), VcOp9UL1);
		}
		try {
			MessageDigest bEtzbBZn = java.security.MessageDigest.getInstance("MD5");
			bEtzbBZn.update(ivcOJnQQ.getBytes("UTF-8"));
			byte[] obMYK0su = bEtzbBZn.digest();
			BigInteger zNFIUUqj = new BigInteger(1, obMYK0su);
			String vOdgZhgG = zNFIUUqj.toString(16);
			while (vOdgZhgG.length() < 32) {
				vOdgZhgG = "0" + vOdgZhgG;
			}
			if (vOdgZhgG.equals(i9RWpiA6.getPassword()))
				return i9RWpiA6;
		} catch (Exception RxnUL1bn) {
			throw new NestedException(RxnUL1bn.getMessage(), RxnUL1bn);
		}
		return null;
	}

}