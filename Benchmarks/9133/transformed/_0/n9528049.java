class n9528049 {
	private void copyFile(File nv5nWcdY, File CMMRwkWa) {
		try {
			BufferedInputStream FReh9Cd9 = new BufferedInputStream(new FileInputStream(nv5nWcdY));
			BufferedOutputStream EGnzE4C4 = new BufferedOutputStream(new FileOutputStream(CMMRwkWa));
			byte[] yZTEQevr = new byte[8192];
			int qgaEBPJi = -1;
			while ((qgaEBPJi = FReh9Cd9.read(yZTEQevr)) > 0) {
				EGnzE4C4.write(yZTEQevr, 0, qgaEBPJi);
			}
			FReh9Cd9.close();
			EGnzE4C4.close();
		} catch (Exception DqaxP4bf) {
			if (!CMMRwkWa.delete()) {
				System.err.println("Ups, created copy cant be deleted (" + CMMRwkWa.getAbsolutePath() + ")");
			}
		}
	}

}