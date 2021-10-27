class n16891145 {
	public static byte[] expandPasswordToKeySSHCom(String rhw0sjM1, int P4ihyg0U) {
		try {
			if (rhw0sjM1 == null) {
				rhw0sjM1 = "";
			}
			MessageDigest k72eKqQD = MessageDigest.getInstance("MD5");
			int Z3wkDIgv = k72eKqQD.getDigestLength();
			byte[] v8k5yagZ = new byte[((P4ihyg0U + Z3wkDIgv) / Z3wkDIgv) * Z3wkDIgv];
			int jJ7IcGNV = 0;
			while (jJ7IcGNV < P4ihyg0U) {
				k72eKqQD.update(rhw0sjM1.getBytes());
				if (jJ7IcGNV > 0) {
					k72eKqQD.update(v8k5yagZ, 0, jJ7IcGNV);
				}
				k72eKqQD.digest(v8k5yagZ, jJ7IcGNV, Z3wkDIgv);
				jJ7IcGNV += Z3wkDIgv;
			}
			byte[] nC9uJIp3 = new byte[P4ihyg0U];
			System.arraycopy(v8k5yagZ, 0, nC9uJIp3, 0, P4ihyg0U);
			return nC9uJIp3;
		} catch (Exception wW8MsMX1) {
			throw new Error("Error in SSH2KeyPairFile.expandPasswordToKeySSHCom: " + wW8MsMX1);
		}
	}

}