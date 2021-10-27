class n9070085 {
	public String getMd5CodeOf16(String Qy6oPyHy) {
		StringBuffer qFx3YC1S = null;
		try {
			MessageDigest jACxNRP3 = MessageDigest.getInstance("MD5");
			jACxNRP3.update(Qy6oPyHy.getBytes());
			byte trpqfdhd[] = jACxNRP3.digest();
			int dwQX6QmS;
			qFx3YC1S = new StringBuffer("");
			for (int eSRaJFeq = 0; eSRaJFeq < trpqfdhd.length; eSRaJFeq++) {
				dwQX6QmS = trpqfdhd[eSRaJFeq];
				if (dwQX6QmS < 0)
					dwQX6QmS += 256;
				if (dwQX6QmS < 16)
					qFx3YC1S.append("0");
				qFx3YC1S.append(Integer.toHexString(dwQX6QmS));
			}
		} catch (NoSuchAlgorithmException SAH9kOuV) {
			SAH9kOuV.printStackTrace();
		} finally {
			return qFx3YC1S.toString().substring(8, 24);
		}
	}

}