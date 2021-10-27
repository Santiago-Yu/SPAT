class n19217522 {
	boolean copyFileStructure(File noQeRYfK, File Up23eQr9) {
		if (noQeRYfK == null || Up23eQr9 == null)
			return false;
		File j4pdos3Z = Up23eQr9;
		do {
			if (noQeRYfK.equals(j4pdos3Z))
				return false;
			j4pdos3Z = j4pdos3Z.getParentFile();
		} while (j4pdos3Z != null);
		if (noQeRYfK.isDirectory()) {
			if (progressDialog != null) {
				progressDialog.setDetailFile(noQeRYfK, ProgressDialog.COPY);
			}
			if (simulateOnly) {
			} else {
				if (!Up23eQr9.mkdirs())
					return false;
			}
			File[] eeNZ9F84 = noQeRYfK.listFiles();
			if (eeNZ9F84 != null) {
				if (progressDialog != null) {
					progressDialog.addWorkUnits(eeNZ9F84.length);
				}
				for (int RE1eK6EI = 0; RE1eK6EI < eeNZ9F84.length; RE1eK6EI++) {
					File bsCdYoSk = eeNZ9F84[RE1eK6EI];
					File Ju9vS6PR = new File(Up23eQr9, bsCdYoSk.getName());
					if (!copyFileStructure(bsCdYoSk, Ju9vS6PR))
						return false;
					if (progressDialog != null) {
						progressDialog.addProgress(1);
						if (progressDialog.isCancelled())
							return false;
					}
				}
			}
		} else {
			if (simulateOnly) {
			} else {
				FileReader dEO35RUJ = null;
				FileWriter aWXmEoYW = null;
				try {
					dEO35RUJ = new FileReader(noQeRYfK);
					aWXmEoYW = new FileWriter(Up23eQr9);
					int WpoMDUfP;
					while ((WpoMDUfP = dEO35RUJ.read()) != -1)
						aWXmEoYW.write(WpoMDUfP);
				} catch (FileNotFoundException g1ThAuN4) {
					return false;
				} catch (IOException yegQMPqa) {
					return false;
				} finally {
					try {
						if (dEO35RUJ != null)
							dEO35RUJ.close();
						if (aWXmEoYW != null)
							aWXmEoYW.close();
					} catch (IOException aoHv3trD) {
						return false;
					}
				}
			}
		}
		return true;
	}

}