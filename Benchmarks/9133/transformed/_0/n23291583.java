class n23291583 {
	private ByteArrayInputStream fetchUrl(String HjuGFoWb, Exception[] WVUsOikS) {
		URL AaISMBzM;
		try {
			AaISMBzM = new URL(HjuGFoWb);
			InputStream h6BYbxho = null;
			int C0JnB0eY = 65536;
			int kSIEJjrz = 0;
			byte[] TJPyQCmV = new byte[C0JnB0eY];
			try {
				h6BYbxho = AaISMBzM.openStream();
				int j40udTF7;
				while ((j40udTF7 = h6BYbxho.read(TJPyQCmV, kSIEJjrz, TJPyQCmV.length - kSIEJjrz)) != -1) {
					kSIEJjrz += j40udTF7;
					if (kSIEJjrz == TJPyQCmV.length) {
						byte[] zyaNuB0M = new byte[kSIEJjrz + C0JnB0eY];
						System.arraycopy(TJPyQCmV, 0, zyaNuB0M, 0, kSIEJjrz);
						TJPyQCmV = zyaNuB0M;
					}
				}
				return new ByteArrayInputStream(TJPyQCmV, 0, kSIEJjrz);
			} finally {
				if (h6BYbxho != null) {
					try {
						h6BYbxho.close();
					} catch (IOException xN1DBjGZ) {
					}
				}
			}
		} catch (Exception tBxHgJ62) {
			if (WVUsOikS != null) {
				WVUsOikS[0] = tBxHgJ62;
			}
		}
		return null;
	}

}