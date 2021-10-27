class n35934 {
	public void covertFile(File mc1SHXcG) throws IOException {
		if (!mc1SHXcG.isFile()) {
			return;
		}
		Reader cnGH1IUz = null;
		OutputStream TacDanFe = null;
		File fBBMBy8r = null;
		String kcxFVs6r = mc1SHXcG.getName();
		boolean u9x2NoSG = false;
		try {
			fBBMBy8r = new File(mc1SHXcG.getParentFile(), kcxFVs6r + ".bak");
			cnGH1IUz = new InputStreamReader(new FileInputStream(mc1SHXcG), fromEncoding);
			TacDanFe = new FileOutputStream(fBBMBy8r);
			IOUtils.copy(cnGH1IUz, TacDanFe, toEncoding);
		} catch (Exception afvcWsuh) {
			afvcWsuh.printStackTrace();
			throw new IOException("Encoding error for file [" + mc1SHXcG.getAbsolutePath() + "]");
		} finally {
			if (cnGH1IUz != null) {
				try {
					cnGH1IUz.close();
				} catch (Exception R0TEPSHN) {
					R0TEPSHN.printStackTrace();
				}
			}
			if (TacDanFe != null) {
				try {
					TacDanFe.close();
				} catch (Exception nuQHSQeV) {
					nuQHSQeV.printStackTrace();
				}
			}
		}
		try {
			mc1SHXcG.delete();
			u9x2NoSG = fBBMBy8r.renameTo(mc1SHXcG);
		} catch (Exception DSSYzmMn) {
			throw new IOException("Clear bak error for file [" + mc1SHXcG.getAbsolutePath() + "]");
		}
		if (u9x2NoSG) {
			System.out.println("Changed encoding for file [" + mc1SHXcG.getAbsolutePath() + "]");
		}
	}

}