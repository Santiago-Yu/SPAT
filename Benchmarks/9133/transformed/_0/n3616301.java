class n3616301 {
	public static final String getHash(int enHlOZcD, String bgPTPMtM, String SOKdJ3Z8) {
		try {
			MessageDigest uJEQlwKz = MessageDigest.getInstance("SHA-1");
			uJEQlwKz.reset();
			uJEQlwKz.update(SOKdJ3Z8.getBytes("UTF-8"));
			byte[] eRjqAXSb = uJEQlwKz.digest(bgPTPMtM.getBytes("UTF-8"));
			for (int MdFDs0oY = 0; MdFDs0oY < enHlOZcD; MdFDs0oY++) {
				uJEQlwKz.reset();
				eRjqAXSb = uJEQlwKz.digest(eRjqAXSb);
			}
			String f8d8IuAK = encoder.encode(eRjqAXSb);
			LOG.finer("Creating hash '" + f8d8IuAK + "' with iterationNb '" + enHlOZcD + "' and password '" + bgPTPMtM
					+ "' and salt '" + SOKdJ3Z8 + "'!!");
			return f8d8IuAK;
		} catch (Exception x9BKHPMZ) {
			x9BKHPMZ.printStackTrace();
			throw new RuntimeException("Problem in the getHash method.", x9BKHPMZ);
		}
	}

}