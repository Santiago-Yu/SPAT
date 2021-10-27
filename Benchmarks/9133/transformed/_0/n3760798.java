class n3760798 {
	public void setNewPassword(String V7kLhUN1) {
		try {
			final MessageDigest OM8YsEH2 = MessageDigest.getInstance("MD5");
			OM8YsEH2.update(V7kLhUN1.getBytes());
			final String h0clVcBG = "{MD5}" + new String(Base64Encoder.encode(OM8YsEH2.digest()));
			setUserPassword(h0clVcBG.getBytes());
			this.newPassword = V7kLhUN1;
			firePropertyChange("newPassword", "", V7kLhUN1);
			firePropertyChange("password", new byte[0], getUserPassword());
		} catch (final NoSuchAlgorithmException YEWd52da) {
			throw new RuntimeException("Can't encrypt user's password", YEWd52da);
		}
	}

}