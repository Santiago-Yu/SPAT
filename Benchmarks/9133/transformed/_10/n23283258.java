class n23283258 {
	public String login(HttpSession callingSession, String username, String password) {
		String token = null;
		int timeoutInSeconds = 0;
		String customer = null;
		boolean bLoginOk = false;
		HashSet<Integer> tileProviderIds = new HashSet<Integer>();
		String dbPassword = (String) em.createNamedQuery("getCustomerPasswordByUsername")
				.setParameter("username", username).getSingleResult();
		if (dbPassword.equals(password)) {
			CustomerElement ce = (CustomerElement) em.createNamedQuery("getCustomerByUsername")
					.setParameter("username", username).getSingleResult();
			customer = ce.getName();
			timeoutInSeconds = ce.getTimeout();
			String[] tileProviderIdsArray = ce.getTileProvideridsArray();
			bLoginOk = true;
			for (String tileProviderId : tileProviderIdsArray)
				tileProviderIds.add(Integer.parseInt(tileProviderId));
		}
		if (bLoginOk) {
			token = SessionHandler.getInstance().alreadyGotValidSession(customer);
			if (token == null) {
				Random random = new Random();
				MessageDigest md5 = null;
				token = callingSession.getId() + new Date().getTime() + random.nextLong();
				try {
					md5 = MessageDigest.getInstance("MD5");
				} catch (NoSuchAlgorithmException e) {
					logger.error("Unable to digest the token.", e);
				}
				md5.update(token.getBytes());
				StringBuffer sb = new StringBuffer();
				byte[] array = md5.digest();
				for (int j = 0; j < array.length; ++j) {
					int b = array[j] & 0xFF;
					if (b < 0x10)
						sb.append('0');
					sb.append(Integer.toHexString(b));
				}
				token = sb.toString();
				SessionHandler.getInstance().registerValidSession(token, customer, timeoutInSeconds, tileProviderIds);
			}
		}
		return token;
	}

}