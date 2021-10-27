class n12914949 {
	private void downloadImage(final String xGs2MPm1) {
		if (xGs2MPm1 != null && xGs2MPm1.length() > 0) {
			File jb28Gl7l = new File(m_sTargetDir);
			if (jb28Gl7l.canWrite()) {
				jb28Gl7l = new File(jb28Gl7l, xGs2MPm1);
				if (!jb28Gl7l.exists()) {
					try {
						URL c3dC73KC = new URL(m_sCodeBase + '/' + xGs2MPm1);
						BufferedInputStream TuuzwNGh = new BufferedInputStream(c3dC73KC.openStream());
						BufferedOutputStream dUf3bP0c = new BufferedOutputStream(new FileOutputStream(jb28Gl7l));
						int KCd4BgOJ;
						while ((KCd4BgOJ = TuuzwNGh.read()) != -1) {
							dUf3bP0c.write(KCd4BgOJ);
						}
						TuuzwNGh.close();
						dUf3bP0c.close();
					} catch (Exception MpzDd5eg) {
						System.out.println("TestImagesHelper::downloadImage(): " + MpzDd5eg);
					}
				}
			}
		}
	}

}