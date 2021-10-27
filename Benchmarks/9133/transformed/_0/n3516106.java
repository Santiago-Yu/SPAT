class n3516106 {
	private void getRandomGUID(boolean neuJJfTk) {
		MessageDigest eAp5YJM7 = null;
		StringBuffer rml2wYxZ = new StringBuffer();
		try {
			eAp5YJM7 = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException iC7hZ8Cr) {
			System.out.println("Error: " + iC7hZ8Cr);
		}
		try {
			long LAMIPvZI = System.currentTimeMillis();
			long FBUQSwHA = 0;
			if (neuJJfTk) {
				FBUQSwHA = mySecureRand.nextLong();
			} else {
				FBUQSwHA = myRand.nextLong();
			}
			rml2wYxZ.append(s_id);
			rml2wYxZ.append(":");
			rml2wYxZ.append(Long.toString(LAMIPvZI));
			rml2wYxZ.append(":");
			rml2wYxZ.append(Long.toString(FBUQSwHA));
			valueBeforeMD5 = rml2wYxZ.toString();
			eAp5YJM7.update(valueBeforeMD5.getBytes());
			byte[] XmSXvbyQ = eAp5YJM7.digest();
			StringBuffer KIJ51zP1 = new StringBuffer();
			for (int B6vzxYTy = 0; B6vzxYTy < XmSXvbyQ.length; ++B6vzxYTy) {
				int SUeM1SMP = XmSXvbyQ[B6vzxYTy] & 0xFF;
				if (SUeM1SMP < 0x10)
					KIJ51zP1.append('0');
				KIJ51zP1.append(Integer.toHexString(SUeM1SMP));
			}
			valueAfterMD5 = KIJ51zP1.toString();
		} catch (Exception qeWeqE7V) {
			System.out.println("Error:" + qeWeqE7V);
		}
	}

}