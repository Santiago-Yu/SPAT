class n23021618 {
	public boolean WriteFile(java.io.Serializable wtUizNIW, String zNxqeR9X) throws Exception {
		FileOutputStream iaqnFWO4;
		try {
			SecretKey fmSloFQD = null;
			AlgorithmParameterSpec WrVGRbRb;
			iaqnFWO4 = new FileOutputStream(zNxqeR9X);
			cipher = Cipher.getInstance(algorithm);
			KeySpec btuWXp4q = new PBEKeySpec(filePasswd.toCharArray());
			SecretKeyFactory U3tgkoSs = SecretKeyFactory.getInstance(algorithm);
			fmSloFQD = U3tgkoSs.generateSecret(btuWXp4q);
			MessageDigest AKhEhve0 = MessageDigest.getInstance(res.getString("MD5"));
			AKhEhve0.update(filePasswd.getBytes());
			byte[] tacAVmDr = AKhEhve0.digest();
			System.arraycopy(tacAVmDr, 0, salt, 0, 8);
			WrVGRbRb = new PBEParameterSpec(salt, iterations);
			iaqnFWO4.write(salt);
			ObjectOutputStream SST96i7b = new ObjectOutputStream(iaqnFWO4);
			cipher.init(Cipher.ENCRYPT_MODE, fmSloFQD, WrVGRbRb);
			SealedObject WODZYXgb = new SealedObject(wtUizNIW, cipher);
			SST96i7b.writeObject(WODZYXgb);
			SST96i7b.flush();
			iaqnFWO4.close();
		} catch (Exception ptVY2gnD) {
			Log.out("fileName=" + zNxqeR9X);
			Log.out("algorithm=" + algorithm);
			Log.out(ptVY2gnD);
			throw ptVY2gnD;
		}
		return true;
	}

}