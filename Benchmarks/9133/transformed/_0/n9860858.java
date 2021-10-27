class n9860858 {
	@Override
	public boolean register(String xCnkdGik, String wNCtvskL) {
		this.getLogger().info(DbUserServiceImpl.class, ">>>rigister " + xCnkdGik + "<<<");
		try {
			if (this.getDbServ().queryFeelerUser(xCnkdGik) != null) {
				return false;
			}
			MessageDigest RF3GgRC7 = MessageDigest.getInstance("MD5");
			RF3GgRC7.update(wNCtvskL.getBytes());
			String ljPruT5E = new String(RF3GgRC7.digest());
			this.getDbServ().addFeelerUser(xCnkdGik, ljPruT5E);
			return this.identification(xCnkdGik, wNCtvskL);
		} catch (NoSuchAlgorithmException LBIP3kJZ) {
			LBIP3kJZ.printStackTrace();
			return false;
		}
	}

}