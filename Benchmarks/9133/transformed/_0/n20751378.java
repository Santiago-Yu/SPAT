class n20751378 {
	private String hashPassword(String QBEdshEj) throws NoSuchAlgorithmException {
		String xB8McT4w = null;
		MessageDigest Q1gZnGYX = MessageDigest.getInstance("SHA");
		log.debug("secure hash on password " + QBEdshEj);
		Q1gZnGYX.update(QBEdshEj.getBytes());
		xB8McT4w = new String(Base64.encodeBase64(Q1gZnGYX.digest()));
		log.debug("returning hash " + xB8McT4w);
		return xB8McT4w;
	}

}