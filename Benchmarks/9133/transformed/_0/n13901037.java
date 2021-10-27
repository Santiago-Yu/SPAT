class n13901037 {
	public static String generateGuid(boolean EvP56BbK) {
		MessageDigest QcowdKnq = null;
		String qvOBiFZV = null;
		String CKXQqZZI = null;
		StringBuffer bHq2nftt = new StringBuffer();
		try {
			QcowdKnq = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException aOaIxH6X) {
			log.error("Error: " + aOaIxH6X);
		}
		try {
			long o3O1ZMIB = System.currentTimeMillis();
			long qD30oMQg = 0L;
			if (EvP56BbK)
				qD30oMQg = mySecureRand.nextLong();
			else
				qD30oMQg = myRand.nextLong();
			bHq2nftt.append(s_id);
			bHq2nftt.append(":");
			bHq2nftt.append(Long.toString(o3O1ZMIB));
			bHq2nftt.append(":");
			bHq2nftt.append(Long.toString(qD30oMQg));
			qvOBiFZV = bHq2nftt.toString();
			QcowdKnq.update(qvOBiFZV.getBytes());
			byte MODz9qG7[] = QcowdKnq.digest();
			StringBuffer xuImsFk9 = new StringBuffer();
			for (int aYGmEU6p = 0; aYGmEU6p < MODz9qG7.length; aYGmEU6p++) {
				int apa3DKbe = MODz9qG7[aYGmEU6p] & 0xff;
				if (apa3DKbe < 16)
					xuImsFk9.append('0');
				xuImsFk9.append(Integer.toHexString(apa3DKbe));
			}
			CKXQqZZI = xuImsFk9.toString();
		} catch (Exception ZogOvhJe) {
			log.error("Error:" + ZogOvhJe);
		}
		String hVgAuwOP = CKXQqZZI.toUpperCase();
		StringBuffer YwhAIasN = new StringBuffer();
		YwhAIasN.append(hVgAuwOP.substring(0, 8));
		YwhAIasN.append("-");
		YwhAIasN.append(hVgAuwOP.substring(8, 12));
		YwhAIasN.append("-");
		YwhAIasN.append(hVgAuwOP.substring(12, 16));
		YwhAIasN.append("-");
		YwhAIasN.append(hVgAuwOP.substring(16, 20));
		YwhAIasN.append("-");
		YwhAIasN.append(hVgAuwOP.substring(20));
		return YwhAIasN.toString();
	}

}