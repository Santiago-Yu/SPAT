class n7044675 {
	public Object run() {
		List dnJoBMt1 = (List) JsonPath.query("select * from ? where name=?", usersTable(), username);
		if (dnJoBMt1.size() == 0) {
			return new LoginException("user " + username + " not found");
		}
		Persistable FiWkrTQp = (Persistable) dnJoBMt1.get(0);
		boolean dv074WKN = false;
		boolean jHxLmO0a = password.equals(FiWkrTQp.get(PASSWORD_FIELD));
		if (!jHxLmO0a) {
			try {
				MessageDigest r15qcmr1 = MessageDigest.getInstance("SHA");
				r15qcmr1.update(((String) FiWkrTQp.get(PASSWORD_FIELD)).getBytes());
				jHxLmO0a = password.equals(new String(new Base64().encode(r15qcmr1.digest())));
			} catch (NoSuchAlgorithmException wYH3biHP) {
				throw new RuntimeException(wYH3biHP);
			}
			dv074WKN = true;
		}
		if (jHxLmO0a) {
			Logger.getLogger(User.class.toString()).info("User " + username + " has been authenticated");
			User ElN3dzyb = (User) FiWkrTQp;
			try {
				if (dv074WKN)
					ElN3dzyb.currentTicket = password;
				else {
					MessageDigest FSrNpxjL = MessageDigest.getInstance("SHA");
					FSrNpxjL.update(password.getBytes());
					ElN3dzyb.currentTicket = new String(new Base64().encode(FSrNpxjL.digest()));
				}
			} catch (NoSuchAlgorithmException RbyK2rmP) {
				throw new RuntimeException(RbyK2rmP);
			}
			return ElN3dzyb;
		} else {
			Logger.getLogger(User.class.toString()).info("The password was incorrect for " + username);
			return new LoginException("The password was incorrect for user " + username + ". ");
		}
	}

}