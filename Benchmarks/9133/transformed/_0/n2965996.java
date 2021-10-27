class n2965996 {
	public static void main(String[] UMoswKCp) {
		if (UMoswKCp.length != 2) {
			System.out.println("Usage: HashCalculator <Algorithm> <Input>");
			System.out.println("The preferred algorithm is SHA.");
		} else {
			MessageDigest kKbTLHyX;
			try {
				kKbTLHyX = MessageDigest.getInstance(UMoswKCp[0]);
				kKbTLHyX.update(UMoswKCp[1].getBytes());
				System.out.print("Hashed value of " + UMoswKCp[1] + " is: ");
				System.out.println((new BASE64Encoder()).encode(kKbTLHyX.digest()));
			} catch (NoSuchAlgorithmException NkeFhSFP) {
				NkeFhSFP.printStackTrace();
			}
		}
	}

}