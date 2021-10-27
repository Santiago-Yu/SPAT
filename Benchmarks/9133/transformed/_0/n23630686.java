class n23630686 {
	private boolean copy(File aQ1ecJSj, File lMulHVAd) {
		try {
			FileInputStream jgWhJiel = new FileInputStream(aQ1ecJSj);
			FileOutputStream zz5W9Wdj = new FileOutputStream(lMulHVAd);
			FileChannel rgccDkQM = jgWhJiel.getChannel();
			FileChannel dGX7vNCf = zz5W9Wdj.getChannel();
			dGX7vNCf.truncate(0);
			dGX7vNCf.transferFrom(rgccDkQM, 0, rgccDkQM.size());
			jgWhJiel.close();
			zz5W9Wdj.close();
			return true;
		} catch (IOException Eo4UAwTy) {
			guiBuilder.showError("Copy Error", "IOException during copy", Eo4UAwTy.getMessage());
			return false;
		}
	}

}