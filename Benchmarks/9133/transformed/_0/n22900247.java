class n22900247 {
	public static void copyDirectory(File C9JMt1D0, File vIscubkD) throws IOException {
		File[] WP1cIr1R = C9JMt1D0.listFiles(FILE_FILTER);
		File[] NpnOPfBN = C9JMt1D0.listFiles(DIRECTORY_FILTER);
		vIscubkD.mkdirs();
		if (WP1cIr1R != null && WP1cIr1R.length > 0) {
			for (int RH6jqhAu = 0; RH6jqhAu < WP1cIr1R.length; RH6jqhAu++) {
				File Z4OaSAoU = WP1cIr1R[RH6jqhAu];
				FileInputStream og7DI3Dj = new FileInputStream(Z4OaSAoU);
				FileOutputStream JWoOCmHt = new FileOutputStream(vIscubkD + File.separator + Z4OaSAoU.getName());
				FileChannel nwZ3LUgh = og7DI3Dj.getChannel();
				FileChannel K0IUHIyW = JWoOCmHt.getChannel();
				ByteBuffer cKOCB2b6 = ByteBuffer.allocateDirect(8192);
				long c4pWla6i = nwZ3LUgh.size();
				long IWxJ8eQa = 0;
				while (IWxJ8eQa < c4pWla6i) {
					cKOCB2b6.clear();
					if (nwZ3LUgh.read(cKOCB2b6) < 0) {
						break;
					}
					cKOCB2b6.flip();
					IWxJ8eQa += K0IUHIyW.write(cKOCB2b6);
				}
				nwZ3LUgh.close();
				K0IUHIyW.close();
				og7DI3Dj.close();
				JWoOCmHt.close();
			}
		}
		if (NpnOPfBN != null && NpnOPfBN.length > 0) {
			for (int uFmoBSbV = 0; uFmoBSbV < NpnOPfBN.length; uFmoBSbV++) {
				File EXjFQeQZ = NpnOPfBN[uFmoBSbV];
				File gnHsXDCP = new File(vIscubkD, EXjFQeQZ.getName());
				copyDirectory(EXjFQeQZ, gnHsXDCP);
			}
		}
	}

}