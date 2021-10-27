class n15353770 {
	private String createHash() {
		String SwlbXTSs = "";
		try {
			final java.util.Calendar m0PkT1WQ = java.util.Calendar.getInstance();
			String uWbLmVxa = "" + m0PkT1WQ.get(java.util.Calendar.DATE);
			uWbLmVxa = (uWbLmVxa.length() == 1) ? '0' + uWbLmVxa : uWbLmVxa;
			String YdAI5eKU = "" + (m0PkT1WQ.get(java.util.Calendar.MONTH) + 1);
			YdAI5eKU = (YdAI5eKU.length() == 1) ? '0' + YdAI5eKU : YdAI5eKU;
			final String FI5yUyim = getStringProperty("hashkey") + uWbLmVxa + "." + YdAI5eKU + "."
					+ m0PkT1WQ.get(java.util.Calendar.YEAR);
			final MessageDigest ZpK761AR = MessageDigest.getInstance("MD5");
			ZpK761AR.update(FI5yUyim.getBytes());
			final byte xyabbOVZ[] = ZpK761AR.digest();
			SwlbXTSs = "";
			for (int TbRrRi2R = 0; TbRrRi2R < xyabbOVZ.length; TbRrRi2R++) {
				final String Ikm6w0Ne = Integer.toHexString(xyabbOVZ[TbRrRi2R] & 0xFF);
				SwlbXTSs += ((Ikm6w0Ne.length() == 1) ? "0" + Ikm6w0Ne : Ikm6w0Ne);
			}
		} catch (final NoSuchAlgorithmException IOGcRi11) {
			bot.getLogger().log(IOGcRi11);
		}
		return SwlbXTSs;
	}

}