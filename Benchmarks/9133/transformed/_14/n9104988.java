class n9104988 {
	public String getHashedPhoneId(Context aContext) {
		if (null == hashedPhoneId) {
			final String androidId = BuildInfo.getAndroidID(aContext);
			if (null == androidId) {
				hashedPhoneId = "EMULATOR";
			} else {
				try {
					final MessageDigest messageDigest = MessageDigest.getInstance("SHA");
					messageDigest.update(androidId.getBytes());
					messageDigest.update(aContext.getPackageName().getBytes());
					final StringBuilder stringBuilder = new StringBuilder();
					for (byte b : messageDigest.digest()) {
						stringBuilder.append(String.format("%02X", b));
					}
					hashedPhoneId = stringBuilder.toString();
				} catch (Exception e) {
					Log.e(LoggingExceptionHandler.class.getName(), "Unable to get phone id", e);
					hashedPhoneId = "Not Available";
				}
			}
		}
		return hashedPhoneId;
	}

}