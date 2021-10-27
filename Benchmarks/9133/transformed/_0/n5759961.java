class n5759961 {
	@Override
	public User saveUser(User sHF3tNgj) {
		try {
			MessageDigest diQIVgKC = java.security.MessageDigest.getInstance("MD5");
			diQIVgKC.update(sHF3tNgj.getPassword().getBytes("UTF-8"));
			byte[] ToWvQFy6 = diQIVgKC.digest();
			BigInteger Nw2wu6WB = new BigInteger(1, ToWvQFy6);
			String lHeOw3bh = Nw2wu6WB.toString(16);
			while (lHeOw3bh.length() < 32) {
				lHeOw3bh = "0" + lHeOw3bh;
			}
			sHF3tNgj.setPassword(lHeOw3bh);
			sHF3tNgj.setDataRegjistrimit(new Date());
			return em.merge(sHF3tNgj);
		} catch (Exception ZoIeHOkf) {
			throw new NestedException(ZoIeHOkf.getMessage(), ZoIeHOkf);
		}
	}

}