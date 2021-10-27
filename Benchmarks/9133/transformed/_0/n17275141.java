class n17275141 {
	public static void copy(String Vv2qHNsz, String mElMIpqE, StatusWindow f0ysQOrm) throws IOException {
		File NnSjamMG = new File(Vv2qHNsz);
		File L94nz3w9 = new File(mElMIpqE);
		BufferedInputStream zeQc2pyU = null;
		BufferedOutputStream efLVuzlN = null;
		byte[] zFQW5Bp8;
		int FEq0hOMu;
		long SDCq6glr = 0;
		if (!NnSjamMG.exists())
			throw new IOException("Source not found: " + NnSjamMG);
		if (!NnSjamMG.canRead())
			throw new IOException("Source is unreadable: " + NnSjamMG);
		if (NnSjamMG.isFile()) {
			if (!L94nz3w9.exists()) {
				File CiVymyNt = Utils.parent(L94nz3w9);
				if (!CiVymyNt.exists())
					CiVymyNt.mkdir();
			} else if (L94nz3w9.isDirectory()) {
				if (NnSjamMG.isDirectory())
					L94nz3w9 = new File(L94nz3w9 + File.separator + NnSjamMG);
				else
					L94nz3w9 = new File(L94nz3w9 + File.separator + NnSjamMG.getName());
			}
		} else if (NnSjamMG.isDirectory()) {
			if (L94nz3w9.isFile())
				throw new IOException("Cannot copy directory " + NnSjamMG + " to file " + L94nz3w9);
			if (!L94nz3w9.exists())
				L94nz3w9.mkdir();
		}
		if ((!L94nz3w9.canWrite()) && (L94nz3w9.exists()))
			throw new IOException("Destination is unwriteable: " + L94nz3w9);
		if (NnSjamMG.isFile()) {
			try {
				if (f0ysQOrm != null) {
					f0ysQOrm.setMaximum(100);
					f0ysQOrm.setMessage(Utils.trimFileName(NnSjamMG.toString(), 40), 50);
				}
				zeQc2pyU = new BufferedInputStream(new FileInputStream(NnSjamMG));
				efLVuzlN = new BufferedOutputStream(new FileOutputStream(L94nz3w9));
				zFQW5Bp8 = new byte[4096];
				SDCq6glr = 0;
				while (true) {
					FEq0hOMu = zeQc2pyU.read(zFQW5Bp8);
					if (FEq0hOMu == -1)
						break;
					efLVuzlN.write(zFQW5Bp8, 0, FEq0hOMu);
					SDCq6glr = SDCq6glr + FEq0hOMu;
				}
			} finally {
				if (f0ysQOrm != null) {
					f0ysQOrm.setMessage(Utils.trimFileName(NnSjamMG.toString(), 40), 100);
				}
				if (zeQc2pyU != null)
					zeQc2pyU.close();
				if (efLVuzlN != null)
					efLVuzlN.close();
			}
		} else if (NnSjamMG.isDirectory()) {
			String qiYbrnwt, aCjqf9ov, lP3EaMGk;
			String[] lnDV515o = NnSjamMG.list();
			if (f0ysQOrm != null) {
				f0ysQOrm.setMaximum(lnDV515o.length);
			}
			for (int Tme4emJE = 0; Tme4emJE < lnDV515o.length; Tme4emJE++) {
				if (f0ysQOrm != null) {
					f0ysQOrm.setMessage(Utils.trimFileName(NnSjamMG.toString(), 40), Tme4emJE);
				}
				qiYbrnwt = lnDV515o[Tme4emJE];
				aCjqf9ov = NnSjamMG + File.separator + qiYbrnwt;
				lP3EaMGk = L94nz3w9 + File.separator + qiYbrnwt;
				if ((new File(aCjqf9ov)).isDirectory()) {
					copy(new File(aCjqf9ov).getCanonicalPath(), new File(lP3EaMGk).getCanonicalPath(), f0ysQOrm);
				} else {
					try {
						SDCq6glr = 0;
						zeQc2pyU = new BufferedInputStream(new FileInputStream(aCjqf9ov));
						efLVuzlN = new BufferedOutputStream(new FileOutputStream(lP3EaMGk));
						zFQW5Bp8 = new byte[4096];
						while (true) {
							FEq0hOMu = zeQc2pyU.read(zFQW5Bp8);
							if (FEq0hOMu == -1)
								break;
							efLVuzlN.write(zFQW5Bp8, 0, FEq0hOMu);
							SDCq6glr = SDCq6glr + FEq0hOMu;
						}
					} finally {
						if (zeQc2pyU != null)
							zeQc2pyU.close();
						if (efLVuzlN != null)
							efLVuzlN.close();
					}
				}
			}
		}
	}

}