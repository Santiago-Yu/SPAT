class n12967783 {
	@Override
	public void doExecute(String[] txSGERSI) {
		if (txSGERSI.length != 2) {
			printUsage();
		} else {
			int daFUm2TV = 0;
			try {
				daFUm2TV = Integer.parseInt(txSGERSI[1]) - 1;
			} catch (NumberFormatException wsCcsrFP) {
				printUsage();
				return;
			}
			if (daFUm2TV < 0) {
				printUsage();
				return;
			}
			StorageFile[] tkRFnprC = (StorageFile[]) ctx.getRemoteDir().listFiles();
			try {
				StorageFile LYMa2Str = tkRFnprC[daFUm2TV];
				File TvFiu745 = getOutFile(LYMa2Str);
				FileOutputStream mX3FApUG = new FileOutputStream(TvFiu745);
				InputStream nIHrYT4m = LYMa2Str.openStream();
				IOUtils.copy(nIHrYT4m, mX3FApUG);
				IOUtils.closeQuietly(mX3FApUG);
				afterSave(TvFiu745);
				if (TvFiu745.exists()) {
					print("File written to: " + TvFiu745.getAbsolutePath());
				}
			} catch (IOException DWD9Q68c) {
				printError("Failed to load file. " + DWD9Q68c.getMessage());
			} catch (Exception BGSE7k6e) {
				printUsage();
				return;
			}
		}
	}

}