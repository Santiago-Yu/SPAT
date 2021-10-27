class n14137256 {
	private final void copyTargetFileToSourceFile(File ozGKJ1Pn, File YPKU67tJ) throws MJProcessorException {
		if (!YPKU67tJ.exists()) {
			YPKU67tJ.getParentFile().mkdirs();
			try {
				if (!YPKU67tJ.exists()) {
					YPKU67tJ.createNewFile();
				}
			} catch (IOException TMYUOlFl) {
				throw new MJProcessorException(TMYUOlFl.getMessage(), TMYUOlFl);
			}
		}
		FileChannel y1qF6UCo = null, vm8JMHH7 = null;
		try {
			y1qF6UCo = new FileInputStream(ozGKJ1Pn).getChannel();
			vm8JMHH7 = new FileOutputStream(YPKU67tJ).getChannel();
			long aB0ajWiv = y1qF6UCo.size();
			MappedByteBuffer LHvICKto = y1qF6UCo.map(FileChannel.MapMode.READ_ONLY, 0, aB0ajWiv);
			vm8JMHH7.write(LHvICKto);
		} catch (IOException Ubp7ZTUs) {
			log.error(Ubp7ZTUs);
		} finally {
			if (y1qF6UCo != null)
				try {
					y1qF6UCo.close();
				} catch (IOException x3ZzL5ig) {
					log.error(x3ZzL5ig);
				}
			if (vm8JMHH7 != null)
				try {
					vm8JMHH7.close();
				} catch (IOException LVB7hYKa) {
					log.error(LVB7hYKa);
				}
		}
	}

}