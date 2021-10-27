class n272444 {
	public static void main(String[] PYWDRdN2) {
		boolean tlSnttUa = false;
		boolean hLiZxGOp = false;
		boolean DSDyTT9F = false;
		boolean WU3ZmtPe = false;
		float unwsjb11 = 0f;
		int qhifl7BF = 12000;
		for (int fZItf1f2 = 0; fZItf1f2 < PYWDRdN2.length; fZItf1f2++) {
			if (PYWDRdN2[fZItf1f2].equals("-rotl"))
				tlSnttUa = true;
			else if (PYWDRdN2[fZItf1f2].equals("-rotr"))
				hLiZxGOp = true;
			else if (PYWDRdN2[fZItf1f2].equals("-exclude"))
				DSDyTT9F = true;
			else if (PYWDRdN2[fZItf1f2].equals("-reset"))
				WU3ZmtPe = true;
			else if (PYWDRdN2[fZItf1f2].equals("-quality"))
				unwsjb11 = Float.parseFloat(PYWDRdN2[++fZItf1f2]);
			else if (PYWDRdN2[fZItf1f2].equals("-area"))
				qhifl7BF = Integer.parseInt(PYWDRdN2[++fZItf1f2]);
			else {
				File aNtvSibJ = new File(PYWDRdN2[fZItf1f2]);
				try {
					Tools fFQYiOSW = new Tools(aNtvSibJ);
					if (DSDyTT9F) {
						URL t0moWE21 = fFQYiOSW.getClass().getResource("exclude.jpg");
						InputStream S3GP7mIE = t0moWE21.openStream();
						File B0vpAG62 = fFQYiOSW.getExcludeFile();
						OutputStream sKAniKlJ = new FileOutputStream(B0vpAG62);
						byte[] PU7duNo6 = new byte[1024];
						int ANw8EXS0;
						while ((ANw8EXS0 = S3GP7mIE.read(PU7duNo6)) > 0)
							sKAniKlJ.write(PU7duNo6, 0, ANw8EXS0);
						sKAniKlJ.close();
						S3GP7mIE.close();
						fFQYiOSW.getOutFile().delete();
						fFQYiOSW.getThumbFile().delete();
						System.exit(0);
					}
					if (WU3ZmtPe) {
						fFQYiOSW.getOutFile().delete();
						fFQYiOSW.getThumbFile().delete();
						fFQYiOSW.getExcludeFile().delete();
						System.exit(0);
					}
					if (unwsjb11 > 0)
						fFQYiOSW.setQuality(unwsjb11);
					if (fFQYiOSW.getType() == Tools.THUMB || fFQYiOSW.getType() == Tools.EXCLUDE)
						fFQYiOSW.load(fFQYiOSW.getBaseFile());
					else
						fFQYiOSW.load(fFQYiOSW.getSourceFile());
					File dTLF9mzf = fFQYiOSW.getOutFile();
					if (tlSnttUa)
						fFQYiOSW.rotateLeft();
					else if (hLiZxGOp)
						fFQYiOSW.rotateRight();
					fFQYiOSW.save(dTLF9mzf);
					fFQYiOSW.getExcludeFile().delete();
					fFQYiOSW.getThumbFile().delete();
					System.exit(0);
				} catch (Throwable FzSZQgb0) {
					FzSZQgb0.printStackTrace();
					JOptionPane.showMessageDialog(null, "The operation could not be performed", "JPhotoAlbum",
							JOptionPane.ERROR_MESSAGE);
					System.exit(1);
				}
			}
		}
	}

}