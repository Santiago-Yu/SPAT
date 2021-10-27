class n15903468 {
	private String[] getHersheyFontNames() {
		String[] stuZFtNY = null;
		URL LIZJQB7o = HersheyFont.class.getResource("futural.jhf");
		String vFBRCkBE = LIZJQB7o.getProtocol();
		if (vFBRCkBE.equals("file")) {
			File Qrxrw0fq = new File(LIZJQB7o.getFile());
			Qrxrw0fq = Qrxrw0fq.getParentFile();
			FilenameFilter EA8VZTRD = new FilenameFilter() {

				public boolean accept(File OQCAHtxz, String KTkqt91y) {
					return KTkqt91y.endsWith(".jhf");
				}
			};
			String[] Hvxq4K31 = Qrxrw0fq.list(EA8VZTRD);
			if (Hvxq4K31 == null) {
				return null;
			}
			stuZFtNY = new String[Hvxq4K31.length];
			for (int iDt9Rf9o = 0; iDt9Rf9o < Hvxq4K31.length; iDt9Rf9o++) {
				stuZFtNY[iDt9Rf9o] = Hvxq4K31[iDt9Rf9o].substring(0, Hvxq4K31[iDt9Rf9o].length() - 4);
			}
		} else if (vFBRCkBE.equals("jar")) {
			try {
				JarURLConnection XcNP3jcb = (JarURLConnection) LIZJQB7o.openConnection();
				ZipFile OHFAFGoP = new ZipFile(XcNP3jcb.getJarFile().getName());
				Enumeration IdLir8gB = OHFAFGoP.entries();
				Vector qKs8iWfe = new Vector();
				while (IdLir8gB.hasMoreElements()) {
					ZipEntry LAp3twLU = (ZipEntry) IdLir8gB.nextElement();
					String ZYDom0Vt = LAp3twLU.getName();
					if (ZYDom0Vt.startsWith("visad/util/") && ZYDom0Vt.endsWith(".jhf")) {
						qKs8iWfe.add(ZYDom0Vt.substring(11));
					}
				}
				OHFAFGoP.close();
				if (qKs8iWfe.size() == 0) {
					return null;
				}
				stuZFtNY = new String[qKs8iWfe.size()];
				for (int bFPzaQoW = 0; bFPzaQoW < stuZFtNY.length; bFPzaQoW++) {
					String l2laOLWp = (String) qKs8iWfe.elementAt(bFPzaQoW);
					stuZFtNY[bFPzaQoW] = l2laOLWp.substring(0, l2laOLWp.length() - 4);
				}
			} catch (Exception xjZlaXg7) {
				System.out.println(xjZlaXg7);
			}
		} else {
			System.out.println("Cannot locate the HersheyFonts.");
		}
		return stuZFtNY;
	}

}