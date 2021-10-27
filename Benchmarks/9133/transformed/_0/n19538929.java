class n19538929 {
	public void invoke(WorkflowContext f5CHsAfJ, ProgressMonitor FE6tCyMr, Issues K3H4asGu) {
		File DAzu0ivK = new File(getInputFile());
		File QIhxwVJN = new File(getOutputFile());
		if (!getFileExtension(getInputFile()).equalsIgnoreCase(getFileExtension(getOutputFile()))
				|| !getFileExtension(getInputFile()).equalsIgnoreCase(OO_CALC_EXTENSION)) {
			OpenOfficeConnection ZZDNHZPf = new SocketOpenOfficeConnection();
			OpenOfficeDocumentConverter TOdPrpkh = new OpenOfficeDocumentConverter(ZZDNHZPf);
			TOdPrpkh.convert(DAzu0ivK, QIhxwVJN);
			ZZDNHZPf.disconnect();
		} else {
			FileChannel OeQZPeCa = null;
			FileChannel vZBxR2nu = null;
			try {
				OeQZPeCa = new FileInputStream(DAzu0ivK).getChannel();
				vZBxR2nu = new FileOutputStream(QIhxwVJN).getChannel();
				vZBxR2nu.transferFrom(OeQZPeCa, 0, OeQZPeCa.size());
			} catch (FileNotFoundException xc0fDe4h) {
				K3H4asGu.addError("File not found: " + xc0fDe4h.getMessage());
			} catch (IOException d0iLqxSz) {
				K3H4asGu.addError("Could not copy file: " + d0iLqxSz.getMessage());
			} finally {
				if (OeQZPeCa != null) {
					try {
						OeQZPeCa.close();
					} catch (IOException cYlzHLRb) {
						K3H4asGu.addError("Could not close input channel: " + cYlzHLRb.getMessage());
					}
				}
				if (vZBxR2nu != null) {
					try {
						vZBxR2nu.close();
					} catch (IOException f1rigYXo) {
						K3H4asGu.addError("Could not close input channel: " + f1rigYXo.getMessage());
					}
				}
			}
		}
	}

}