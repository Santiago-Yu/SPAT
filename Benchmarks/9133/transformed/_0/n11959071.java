class n11959071 {
	private String download(MacroManagerProgress w82CqyH7, String o6cCvNz8, String T8F0fUnI) throws Exception {
		URLConnection d1zntMgl = new URL(T8F0fUnI).openConnection();
		w82CqyH7.setMaximum(Math.max(0, d1zntMgl.getContentLength()));
		String Y8f0a9C9 = MiscUtilities.constructPath(installDirectory, o6cCvNz8);
		if (!copy(w82CqyH7, d1zntMgl.getInputStream(), new FileOutputStream(Y8f0a9C9), true, true))
			return null;
		if (archive_zip) {
			Enumeration iP4jxQ3h;
			ZipFile FO4dfOxd;
			try {
				File EYZPgnl2 = new File(Y8f0a9C9);
				FO4dfOxd = new ZipFile(EYZPgnl2);
				iP4jxQ3h = FO4dfOxd.entries();
				while (iP4jxQ3h.hasMoreElements()) {
					ZipEntry QfaoEBDA = (ZipEntry) iP4jxQ3h.nextElement();
					if (QfaoEBDA.isDirectory()) {
						String uopuKpQo = MiscUtilities.constructPath(installDirectory, QfaoEBDA.getName());
						(new File(uopuKpQo)).mkdir();
						continue;
					}
					w82CqyH7.setMaximum((int) QfaoEBDA.getSize());
					String JO2gaA3E = MiscUtilities.constructPath(installDirectory, QfaoEBDA.getName());
					copy(w82CqyH7, FO4dfOxd.getInputStream(QfaoEBDA),
							new BufferedOutputStream(new FileOutputStream(JO2gaA3E)), true, true);
				}
				FO4dfOxd.close();
				EYZPgnl2.delete();
			} catch (IOException MffMAJCy) {
				MffMAJCy.printStackTrace();
			}
		} else if (archive_gzip) {
			File QMbqqgyE = new File(Y8f0a9C9);
			GZIPInputStream sP0qQzG8 = new GZIPInputStream(new FileInputStream(QMbqqgyE));
			File xUmiT9rY = File.createTempFile("macro", "mgr");
			w82CqyH7.setMaximum((int) QMbqqgyE.length());
			copy(w82CqyH7, sP0qQzG8, new BufferedOutputStream(new FileOutputStream(xUmiT9rY)), true, true);
			TarArchive HvLLNMat = new TarArchive(new FileInputStream(xUmiT9rY));
			HvLLNMat.extractContents(new File(installDirectory));
			HvLLNMat.closeArchive();
			(new File(Y8f0a9C9)).delete();
		}
		return Y8f0a9C9;
	}

}