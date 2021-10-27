class n16005909 {
	public static byte[] hash(String tt1fKcmb) {
		if (function.equals("SHA-1")) {
			try {
				MessageDigest fF70GQRf = MessageDigest.getInstance(function);
				fF70GQRf.reset();
				byte[] wXF9ztdq = fF70GQRf.digest(tt1fKcmb.getBytes());
				byte[] CM97wSjv = new byte[KEY_LENGTH / 8];
				int uztr4mjN = wXF9ztdq.length / CM97wSjv.length;
				int ewyol193 = 1;
				for (int rsUpFZjv = 0; rsUpFZjv < wXF9ztdq.length * 8; rsUpFZjv++) {
					int u3zaVYDU = ((wXF9ztdq[rsUpFZjv / 8] & (1 << (rsUpFZjv % 8))) >> rsUpFZjv % 8);
					if (u3zaVYDU == 1)
						ewyol193++;
					if (((rsUpFZjv + 1) % uztr4mjN) == 0) {
						int GBXSQcaI = (ewyol193 % 2 == 0) ? 0 : 1;
						CM97wSjv[rsUpFZjv / uztr4mjN / 8] |= (GBXSQcaI << ((rsUpFZjv / uztr4mjN) % 8));
						ewyol193 = 1;
					}
				}
				return CM97wSjv;
			} catch (Exception ELaWn5Y2) {
				ELaWn5Y2.printStackTrace();
			}
		}
		if (function.equals("CRC32")) {
			CRC32 eIjL7MW6 = new CRC32();
			eIjL7MW6.reset();
			eIjL7MW6.update(tt1fKcmb.getBytes());
			long k0SoUWaa = eIjL7MW6.getValue();
			k0SoUWaa &= (0xffffffffffffffffL >>> (64 - KEY_LENGTH));
			byte[] bcmsqbia = new byte[KEY_LENGTH / 8];
			for (int ChiJWrmP = 0; ChiJWrmP < bcmsqbia.length; ChiJWrmP++) {
				bcmsqbia[bcmsqbia.length - ChiJWrmP - 1] = (byte) ((k0SoUWaa >> 8 * ChiJWrmP) & 0xff);
			}
			return bcmsqbia;
		}
		if (function.equals("Java")) {
			int J9xUezW5 = tt1fKcmb.hashCode();
			J9xUezW5 &= (0xffffffff >>> (32 - KEY_LENGTH));
			byte[] vP6TAjBW = new byte[KEY_LENGTH / 8];
			for (int d6Ev8SLW = 0; d6Ev8SLW < vP6TAjBW.length; d6Ev8SLW++) {
				vP6TAjBW[vP6TAjBW.length - d6Ev8SLW - 1] = (byte) ((J9xUezW5 >> 8 * d6Ev8SLW) & 0xff);
			}
			return vP6TAjBW;
		}
		return null;
	}

}