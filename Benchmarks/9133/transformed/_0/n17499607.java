class n17499607 {
	@Override
	public Void doInBackground() {
		java.io.FileOutputStream ukkwlPl0 = null;
		try {
			String xAVWzpPt = "JavaPointNew.jar";
			java.io.BufferedInputStream cnVQY8p0 = null;
			try {
				HttpURLConnection VZhV1ujX = (HttpURLConnection) url.openConnection();
				contentLength = VZhV1ujX.getContentLength();
				if (contentLength == -1) {
					System.out.println("unknown content length");
				} else {
					System.out.println("content length: " + contentLength + " bytes");
				}
				cnVQY8p0 = new java.io.BufferedInputStream(VZhV1ujX.getInputStream());
			} catch (IOException lpT97mK4) {
				lpT97mK4.printStackTrace();
			}
			ukkwlPl0 = new java.io.FileOutputStream(xAVWzpPt);
			java.io.BufferedOutputStream RXLDpzFI = new BufferedOutputStream(ukkwlPl0, 1024);
			byte[] nEUkte0j = new byte[1024];
			int HegkoG7a = 0;
			int IpK6zGqX = 0;
			while ((HegkoG7a = cnVQY8p0.read(nEUkte0j, 0, 1024)) >= 0) {
				RXLDpzFI.write(nEUkte0j, 0, HegkoG7a);
				IpK6zGqX += HegkoG7a;
				setProgress((int) ((Math.min(IpK6zGqX * 100 / contentLength, 100)) + .5));
			}
			RXLDpzFI.close();
			cnVQY8p0.close();
			File hp1iHpwN = mainFrame.presentationFile;
			if (hp1iHpwN.exists()) {
				final File kIyUGp9v = Utilities.createTemporaryFile("presentation", ".jar", false, null);
				final JarFile Wzt47s9M = new JarFile(xAVWzpPt);
				final JarOutputStream vTWTDMHo = new JarOutputStream(new FileOutputStream(kIyUGp9v));
				for (final JarEntry vO57JMH4 : Utilities.toList(Wzt47s9M.entries())) {
					if (!vO57JMH4.getName().startsWith(Constants.JAR_ENTRY_PRESENTATION_PREFIX)) {
						final InputStream BobVJVNN = Wzt47s9M.getInputStream(vO57JMH4);
						vTWTDMHo.putNextEntry(vO57JMH4);
						Utilities.write(BobVJVNN, vTWTDMHo);
					}
				}
				new SlidesWriter().write(mainFrame.getSlides(), vTWTDMHo);
				hp1iHpwN.delete();
				new File(xAVWzpPt).delete();
				if (!kIyUGp9v.renameTo(hp1iHpwN)) {
					throw new RuntimeException("Failed to update " + hp1iHpwN);
				}
			} else {
				new SlidesWriter().write(mainFrame.getSlides(), new JarOutputStream(new FileOutputStream(hp1iHpwN)));
			}
		} catch (IOException to9qEdH3) {
			to9qEdH3.printStackTrace();
		} finally {
			try {
				ukkwlPl0.close();
			} catch (IOException IYBMhcAR) {
				IYBMhcAR.printStackTrace();
			}
		}
		return null;
	}

}