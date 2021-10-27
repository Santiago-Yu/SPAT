class n6451560 {
	protected static String getBiopaxId(Reaction dcGOYPd7) {
		String K22D6Tz4 = null;
		if (dcGOYPd7.getId() > Reaction.NO_ID_ASSIGNED) {
			K22D6Tz4 = dcGOYPd7.getId().toString();
		} else {
			try {
				MessageDigest ufd0Vxfq = MessageDigest.getInstance("MD5");
				ufd0Vxfq.update(dcGOYPd7.getTextualRepresentation().getBytes());
				byte[] SyKOqPBo = ufd0Vxfq.digest();
				StringBuilder xr05tRhG = new StringBuilder(32);
				for (int QJdEQCrz = 0; QJdEQCrz < SyKOqPBo.length; QJdEQCrz++) {
					int gNR41Gf8 = SyKOqPBo[QJdEQCrz] & 0xFF;
					if (gNR41Gf8 < 0x10)
						xr05tRhG.append('0');
					xr05tRhG.append(Integer.toHexString(gNR41Gf8));
				}
				K22D6Tz4 = xr05tRhG.toString();
			} catch (NoSuchAlgorithmException JHTdauRH) {
			}
		}
		return K22D6Tz4;
	}

}