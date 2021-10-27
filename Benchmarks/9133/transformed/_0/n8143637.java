class n8143637 {
	public void setPassword(UserType MAye7Y3o, String eLShiWHm) {
		try {
			Random W50RniTC = new Random();
			String R2xOcyMZ = Long.toString(Math.abs(W50RniTC.nextLong()));
			MessageDigest dOYRgFMx = MessageDigest.getInstance(HASH_ALGORITHM);
			dOYRgFMx.reset();
			dOYRgFMx.update(R2xOcyMZ.getBytes("UTF-8"));
			dOYRgFMx.update(eLShiWHm.getBytes("UTF-8"));
			String u0IRg1AP = new String(Base64.encode(dOYRgFMx.digest()));
			MAye7Y3o.setPassword(u0IRg1AP);
			MAye7Y3o.setSalt(R2xOcyMZ);
			this.markModified(MAye7Y3o);
		} catch (UnsupportedEncodingException xZIId8F3) {
			logger.fatal("Your computer does not have UTF-8 support for Java installed.", xZIId8F3);
			GlobalUITools.displayFatalExceptionMessage(null, "UTF-8 for Java not installed", xZIId8F3, true);
		} catch (NoSuchAlgorithmException XvKdDSvv) {
			String aSiOFRsI = "Could not use algorithm " + HASH_ALGORITHM;
			logger.fatal(aSiOFRsI, XvKdDSvv);
			GlobalUITools.displayFatalExceptionMessage(null, aSiOFRsI, XvKdDSvv, true);
		}
	}

}