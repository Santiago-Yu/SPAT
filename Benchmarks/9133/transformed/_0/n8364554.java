class n8364554 {
	@Override
	public void executeInterruptible() {
		EncodeFilesDialog Nm3o0eMY = (EncodeFilesDialog) this.dialog;
		File bvZaScQY = null;
		InputStream oOAQsEHy = null;
		OutputStream YUXIvpfM = null;
		try {
			if (Platform.isWindows()) {
				bvZaScQY = new File(".", "lame.exe");
				oOAQsEHy = Thread.currentThread().getContextClassLoader().getResourceAsStream("lame/lame.exe");
			} else if (Platform.isLinux()) {
				bvZaScQY = new File(".", "lame");
				oOAQsEHy = Thread.currentThread().getContextClassLoader().getResourceAsStream("lame/lame");
			} else {
				MainWindowInterface
						.showError(new Exception(Messages.getString("operations.file.encode.dialog.notsupported")));
				return;
			}
			YUXIvpfM = new FileOutputStream(bvZaScQY);
			IOUtils.copy(oOAQsEHy, YUXIvpfM);
		} catch (Exception SYxVrKPM) {
			LOG.error("Cannot extract encoder executable", SYxVrKPM);
			MainWindowInterface.showError(SYxVrKPM);
			return;
		} finally {
			IOUtils.closeQuietly(oOAQsEHy);
			IOUtils.closeQuietly(YUXIvpfM);
		}
		bvZaScQY.setExecutable(true, true);
		try {
			long djLufQ1Y = 0l;
			for (int XajO2IM5 = 0, A4H9OH7P = filesModel.getSize(); XajO2IM5 < A4H9OH7P; XajO2IM5++) {
				if (isInterrupted())
					return;
				IconAndFileListElement sigwJo30 = (IconAndFileListElement) filesModel.get(XajO2IM5);
				File LQtg0MvF = sigwJo30.getFile();
				djLufQ1Y += LQtg0MvF.length();
			}
			rangeModel = Nm3o0eMY.getProgressBar().getModel();
			rangeModel.setMinimum(0);
			rangeModel.setMaximum((int) djLufQ1Y);
			int j3lN9rmT = Nm3o0eMY.getParallelProcesses();
			List<Thread> eQKc21Pk = new ArrayList<Thread>();
			encodingRunnables = new ArrayList<EncoderLauncherRunnable>(j3lN9rmT);
			for (int toC6uBhA = 0; toC6uBhA < j3lN9rmT; toC6uBhA++) {
				EncoderLauncherRunnable EIamt8Gd = new EncoderLauncherRunnable(toC6uBhA, Nm3o0eMY, bvZaScQY);
				Thread FxmfQfXK = new Thread(EIamt8Gd);
				encodingRunnables.add(EIamt8Gd);
				eQKc21Pk.add(FxmfQfXK);
				FxmfQfXK.start();
			}
			for (Thread l6pJdl0n : eQKc21Pk) {
				l6pJdl0n.join();
			}
			if (!isInterrupted())
				MainWindowInterface.showMessage(Messages.getString("operations.file.encode.execute.done.title"),
						Messages.getString("operations.file.encode.execute.done.message").replace("${number}",
								"" + filesModel.getSize()));
		} catch (Exception nCp509xa) {
			LOG.error("Cannot encode files", nCp509xa);
			MainWindowInterface.showError(nCp509xa);
		} finally {
			if (bvZaScQY != null)
				bvZaScQY.delete();
			Nm3o0eMY.setVisible(false);
		}
	}

}