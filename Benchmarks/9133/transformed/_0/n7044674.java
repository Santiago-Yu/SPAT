class n7044674 {
	public static User authenticate(final String RFAM7xqn, final String RrV7rwe3) throws LoginException {
		Object AZVmybvd = doPriviledgedAction(new PrivilegedAction() {

			public Object run() {
				List GwLP5LKs = (List) JsonPath.query("select * from ? where name=?", usersTable(), RFAM7xqn);
				if (GwLP5LKs.size() == 0) {
					return new LoginException("user " + RFAM7xqn + " not found");
				}
				Persistable Po6BMbU9 = (Persistable) GwLP5LKs.get(0);
				boolean KdkawDsA = false;
				boolean OujMTzM7 = RrV7rwe3.equals(Po6BMbU9.get(PASSWORD_FIELD));
				if (!OujMTzM7) {
					try {
						MessageDigest cVHBwCoK = MessageDigest.getInstance("SHA");
						cVHBwCoK.update(((String) Po6BMbU9.get(PASSWORD_FIELD)).getBytes());
						OujMTzM7 = RrV7rwe3.equals(new String(new Base64().encode(cVHBwCoK.digest())));
					} catch (NoSuchAlgorithmException arr0I5R6) {
						throw new RuntimeException(arr0I5R6);
					}
					KdkawDsA = true;
				}
				if (OujMTzM7) {
					Logger.getLogger(User.class.toString()).info("User " + RFAM7xqn + " has been authenticated");
					User EPkIIcmg = (User) Po6BMbU9;
					try {
						if (KdkawDsA)
							EPkIIcmg.currentTicket = RrV7rwe3;
						else {
							MessageDigest CfyaSkzG = MessageDigest.getInstance("SHA");
							CfyaSkzG.update(RrV7rwe3.getBytes());
							EPkIIcmg.currentTicket = new String(new Base64().encode(CfyaSkzG.digest()));
						}
					} catch (NoSuchAlgorithmException fx36oCsc) {
						throw new RuntimeException(fx36oCsc);
					}
					return EPkIIcmg;
				} else {
					Logger.getLogger(User.class.toString()).info("The password was incorrect for " + RFAM7xqn);
					return new LoginException("The password was incorrect for user " + RFAM7xqn + ". ");
				}
			}
		});
		if (AZVmybvd instanceof LoginException)
			throw (LoginException) AZVmybvd;
		return (User) AZVmybvd;
	}

}