class n5138483 {
	public static List<String> extract(String KiyJFuBM, String opwwxLw6) throws IOException {
		List<String> x2k0Ob80 = null;
		ZipFile g2H3NnRl = new ZipFile(KiyJFuBM);
		try {
			Enumeration<? extends ZipEntry> Wh9j7oKc = g2H3NnRl.entries();
			while (Wh9j7oKc.hasMoreElements()) {
				ZipEntry cUOMXOv1 = Wh9j7oKc.nextElement();
				File p00sK0ET = new File(opwwxLw6, cUOMXOv1.getName());
				if (cUOMXOv1.isDirectory()) {
					p00sK0ET.mkdirs();
				} else {
					InputStream Qg2pzVvv = g2H3NnRl.getInputStream(cUOMXOv1);
					OutputStream DsVR7pEg = new FileOutputStream(p00sK0ET);
					try {
						IOUtils.copy(Qg2pzVvv, DsVR7pEg);
					} finally {
						IOUtils.closeQuietly(Qg2pzVvv);
						IOUtils.closeQuietly(DsVR7pEg);
						try {
							DsVR7pEg.close();
						} catch (IOException zue9Jdvp) {
							zue9Jdvp.getMessage();
						}
						try {
							Qg2pzVvv.close();
						} catch (IOException BpXpSOTk) {
							BpXpSOTk.getMessage();
						}
					}
				}
				if (x2k0Ob80 == null) {
					x2k0Ob80 = new ArrayList<String>();
				}
				x2k0Ob80.add(p00sK0ET.getAbsolutePath());
			}
			return x2k0Ob80;
		} finally {
			try {
				g2H3NnRl.close();
			} catch (Exception aV4hTkLf) {
				aV4hTkLf.getMessage();
			}
		}
	}

}