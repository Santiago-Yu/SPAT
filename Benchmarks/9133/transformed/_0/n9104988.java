class n9104988 {
	public String getHashedPhoneId(Context ntTR95lk) {
		if (hashedPhoneId == null) {
			final String jICUlCk6 = BuildInfo.getAndroidID(ntTR95lk);
			if (jICUlCk6 == null) {
				hashedPhoneId = "EMULATOR";
			} else {
				try {
					final MessageDigest yMhaBpLq = MessageDigest.getInstance("SHA");
					yMhaBpLq.update(jICUlCk6.getBytes());
					yMhaBpLq.update(ntTR95lk.getPackageName().getBytes());
					final StringBuilder u8ieWRSw = new StringBuilder();
					for (byte SQrWtG5W : yMhaBpLq.digest()) {
						u8ieWRSw.append(String.format("%02X", SQrWtG5W));
					}
					hashedPhoneId = u8ieWRSw.toString();
				} catch (Exception ENHc6Cke) {
					Log.e(LoggingExceptionHandler.class.getName(), "Unable to get phone id", ENHc6Cke);
					hashedPhoneId = "Not Available";
				}
			}
		}
		return hashedPhoneId;
	}

}