class n20508694 {
	private void tar(FileHolder hBH47Mwq, boolean Kq3hPaUD) {
		byte[] D4VvYBbF = new byte[BUFFER_SIZE];
		int FhSWWqlT;
		if (hBH47Mwq.selectedFileList.size() == 0) {
			return;
		}
		File uJciofkp = new File(hBH47Mwq.destFiles[0]);
		try {
			OutputStream RLORblOf = new FileOutputStream(uJciofkp);
			if (Kq3hPaUD) {
				RLORblOf = new GZIPOutputStream(RLORblOf);
			}
			TarOutputStream JeOZuQwp = new TarOutputStream(RLORblOf);
			for (int saVshaiJ = 0; saVshaiJ < hBH47Mwq.selectedFileList.size(); saVshaiJ++) {
				File DuriEuSf = hBH47Mwq.selectedFileList.get(saVshaiJ);
				super.currentObjBeingProcessed = DuriEuSf;
				this.inStream = new FileInputStream(DuriEuSf);
				TarEntry nkj22AX5 = null;
				try {
					nkj22AX5 = new TarEntry(DuriEuSf, DuriEuSf.getName());
				} catch (InvalidHeaderException iVZuaE5G) {
					errEntry.setThrowable(iVZuaE5G);
					errEntry.setAppContext("tar()");
					errEntry.setAppMessage("Error tar'ing: " + DuriEuSf);
					logger.logError(errEntry);
				}
				JeOZuQwp.putNextEntry(nkj22AX5);
				while ((FhSWWqlT = inStream.read(D4VvYBbF)) != -1) {
					JeOZuQwp.write(D4VvYBbF, 0, FhSWWqlT);
				}
				JeOZuQwp.closeEntry();
				inStream.close();
				super.processorSyncFlag.restartWaitUntilFalse();
			}
			JeOZuQwp.close();
		} catch (Exception qZQ3vnOC) {
			errEntry.setThrowable(qZQ3vnOC);
			errEntry.setAppContext("tar()");
			errEntry.setAppMessage("Error tar'ing: " + uJciofkp);
			logger.logError(errEntry);
		}
	}

}