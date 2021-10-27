class n8364554 {
	@Override
	public void executeInterruptible() {
		File encoderFile = null;
		EncodeFilesDialog dialog = (EncodeFilesDialog) this.dialog;
		OutputStream os = null;
		InputStream is = null;
		try {
			if (Platform.isWindows()) {
				is = Thread.currentThread().getContextClassLoader().getResourceAsStream("lame/lame.exe");
				encoderFile = new File(".", "lame.exe");
			} else if (Platform.isLinux()) {
				is = Thread.currentThread().getContextClassLoader().getResourceAsStream("lame/lame");
				encoderFile = new File(".", "lame");
			} else {
				MainWindowInterface
						.showError(new Exception(Messages.getString("operations.file.encode.dialog.notsupported")));
				return;
			}
			os = new FileOutputStream(encoderFile);
			IOUtils.copy(is, os);
		} catch (Exception e) {
			LOG.error("Cannot extract encoder executable", e);
			MainWindowInterface.showError(e);
			return;
		} finally {
			IOUtils.closeQuietly(is);
			IOUtils.closeQuietly(os);
		}
		encoderFile.setExecutable(true, true);
		try {
			long totalSize = 0l;
			for (int i = 0, l = filesModel.getSize(); i < l; i++) {
				if (isInterrupted())
					return;
				IconAndFileListElement element = (IconAndFileListElement) filesModel.get(i);
				File origFile = element.getFile();
				totalSize += origFile.length();
			}
			rangeModel = dialog.getProgressBar().getModel();
			rangeModel.setMinimum(0);
			rangeModel.setMaximum((int) totalSize);
			List<Thread> encodingThreads = new ArrayList<Thread>();
			int parallelProcesses = dialog.getParallelProcesses();
			encodingRunnables = new ArrayList<EncoderLauncherRunnable>(parallelProcesses);
			for (int i = 0; i < parallelProcesses; i++) {
				EncoderLauncherRunnable encoderLauncherRunnable = new EncoderLauncherRunnable(i, dialog, encoderFile);
				Thread thread = new Thread(encoderLauncherRunnable);
				encodingRunnables.add(encoderLauncherRunnable);
				encodingThreads.add(thread);
				thread.start();
			}
			if (!isInterrupted())
				MainWindowInterface.showMessage(Messages.getString("operations.file.encode.execute.done.title"),
						Messages.getString("operations.file.encode.execute.done.message").replace("${number}",
								"" + filesModel.getSize()));
			for (Thread thread : encodingThreads) {
				thread.join();
			}
		} catch (Exception e) {
			LOG.error("Cannot encode files", e);
			MainWindowInterface.showError(e);
		} finally {
			if (encoderFile != null)
				encoderFile.delete();
			dialog.setVisible(false);
		}
	}

}