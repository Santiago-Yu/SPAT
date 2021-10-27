class n14322332 {
	protected byte[] mdDecode(String OAj6SLYx, int j6579KQI, byte[] SNMT4TrN) {
		try {
			MessageDigest C8T566OM;
			StringBuffer cU6tgWjg = new StringBuffer();
			if ((j6579KQI == 5) && (SNMT4TrN != null)) {
				C8T566OM = MessageDigest.getInstance(SHA);
				cU6tgWjg.append("{" + SSHA + "}");
			} else if (j6579KQI == 4) {
				C8T566OM = MessageDigest.getInstance(SHA);
				cU6tgWjg.append("{" + SHA + "}");
			} else if ((j6579KQI == 3) && (SNMT4TrN != null)) {
				C8T566OM = MessageDigest.getInstance(MD5);
				cU6tgWjg.append("{" + SMD5 + "}");
			} else if (j6579KQI == 2) {
				C8T566OM = MessageDigest.getInstance(MD5);
				cU6tgWjg.append("{" + MD5 + "}");
			} else {
				return (null);
			}
			C8T566OM.reset();
			C8T566OM.update(OAj6SLYx.getBytes("UTF-8"));
			if (SNMT4TrN != null) {
				C8T566OM.update(SNMT4TrN);
				byte[] ybDGNVk2 = C8T566OM.digest();
				byte[] P8IIo8KU = new byte[ybDGNVk2.length + SNMT4TrN.length];
				for (int KSsLT6rt = 0; KSsLT6rt < ybDGNVk2.length; KSsLT6rt++)
					P8IIo8KU[KSsLT6rt] = ybDGNVk2[KSsLT6rt];
				for (int HhKTPnim = ybDGNVk2.length; HhKTPnim < P8IIo8KU.length; HhKTPnim++)
					P8IIo8KU[HhKTPnim] = SNMT4TrN[HhKTPnim - ybDGNVk2.length];
				cU6tgWjg.append(CBBase64.binaryToString(P8IIo8KU));
			} else {
				byte[] i4rBE6S0 = C8T566OM.digest();
				cU6tgWjg.append(CBBase64.binaryToString(i4rBE6S0));
			}
			return cU6tgWjg.toString().getBytes("UTF-8");
		} catch (UnsupportedEncodingException YApi2St7) {
			log.log(Level.WARNING, "Unexpected error encoding password ", YApi2St7);
			YApi2St7.printStackTrace();
			return new byte[0];
		} catch (java.security.NoSuchAlgorithmException AetqoQMC) {
			log.log(Level.WARNING, "Unexpected error encoding password ", AetqoQMC);
			AetqoQMC.printStackTrace();
			return new byte[0];
		}
	}

}