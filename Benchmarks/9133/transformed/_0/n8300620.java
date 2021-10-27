class n8300620 {
	@Override
	public void copierPhotos(FileInputStream oirKnJW4, FileOutputStream SkdH53Hv) {
		FileChannel bMky2ucC = null;
		FileChannel CMSpkKQD = null;
		try {
			bMky2ucC = oirKnJW4.getChannel();
			CMSpkKQD = SkdH53Hv.getChannel();
			bMky2ucC.transferTo(0, bMky2ucC.size(), CMSpkKQD);
		} catch (Exception LmSMhHdo) {
			LmSMhHdo.printStackTrace();
		} finally {
			if (bMky2ucC != null) {
				try {
					bMky2ucC.close();
				} catch (IOException jqEJn7W0) {
				}
			}
			if (CMSpkKQD != null) {
				try {
					CMSpkKQD.close();
				} catch (IOException FznIMH4L) {
				}
			}
		}
	}

}