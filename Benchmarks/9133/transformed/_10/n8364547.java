class n8364547 {
	@Override
	public void executeInterruptible() {
		File destinationFile = null;
		encodingTerminated = false;
		try {
			IconAndFileListElement element;
			Runtime runtime = Runtime.getRuntime();
			while ((element = getNextFileElement()) != null) {
				File origFile = element.getFile();
				destinationFile = new File(encodeFileCard.getDestinationFolder().getValue(), origFile.getName());
				if (!destinationFile.getParentFile().exists()) {
					destinationFile.getParentFile().mkdirs();
				}
				actualFileLabel.setText(origFile.getName());
				actualFileModel.setMaximum((int) origFile.length());
				actualFileModel.setValue(0);
				int bitrate;
				List<String> command = new LinkedList<String>();
				synchronized (bitratePattern) {
					Matcher bitrateMatcher = bitratePattern.matcher(encodeFileCard.getBitrate().getValue());
					bitrateMatcher.find();
					bitrate = Integer.parseInt(bitrateMatcher.group(1));
				}
				command.add(encoderFile.getCanonicalPath());
				command.add("--mp3input");
				command.add("-m");
				command.add("j");
				String sampleFreq = Settings.getSetting("encode.sample.freq");
				if (Util.isNotEmpty(sampleFreq)) {
					command.add("--resample");
					command.add(sampleFreq);
				}
				QualityElement quality = (QualityElement) ((JComboBox) encodeFileCard.getQuality().getValueComponent())
						.getSelectedItem();
				command.add("-q");
				command.add(Integer.toString(quality.getValue()));
				command.add("-b");
				command.add(Integer.toString(bitrate));
				command.add("--cbr");
				command.add("-");
				command.add(destinationFile.getCanonicalPath());
				if (LOG.isDebugEnabled()) {
					boolean first = true;
					StringBuilder commandLine = new StringBuilder();
					for (String part : command) {
						if (!first)
							commandLine.append(" ");
						commandLine.append(part);
						first = false;
					}
					LOG.debug("Command line: " + commandLine.toString());
				}
				encodingProcess = runtime.exec(command.toArray(new String[0]));
				InputStream fileStream = null;
				lastPosition = 0l;
				try {
					fileStream = new PositionNotifierInputStream(new FileInputStream(origFile), origFile.length(), 2048,
							this);
					IOUtils.copy(fileStream, encodingProcess.getOutputStream());
					encodingProcess.getOutputStream().close();
				} finally {
					IOUtils.closeQuietly(fileStream);
					if (LOG.isDebugEnabled()) {
						InputStream processOut = null;
						try {
							StringWriter sw = new StringWriter();
							processOut = encodingProcess.getInputStream();
							IOUtils.copy(processOut, sw);
							LOG.debug("Process output stream:\n" + sw);
							IOUtils.closeQuietly(processOut);
							sw = new StringWriter();
							processOut = encodingProcess.getErrorStream();
							IOUtils.copy(processOut, sw);
							LOG.debug("Process error stream:\n" + sw);
						} finally {
							IOUtils.closeQuietly(processOut);
						}
					}
				}
				int result = encodingProcess.waitFor();
				encodingProcess = null;
				if (result != 0) {
					LOG.warn("Encoder process returned error code " + result);
				}
				if (Boolean.parseBoolean(encodeFileCard.getCopyTag().getValue())) {
					MP3File mp3Output = new MP3File(destinationFile);
					MP3File mp3Input = new MP3File(origFile);
					boolean write = false;
					if (mp3Input.hasID3v2tag()) {
						ID3v2Tag id3v2Tag = new ID3v2Tag();
						for (ID3v2Frame frame : mp3Input.getID3v2tag().getAllframes()) {
							id3v2Tag.addFrame(frame);
						}
						mp3Output.setID3v2tag(id3v2Tag);
						write = true;
					}
					if (mp3Input.hasID3v11tag()) {
						mp3Output.setID3v11tag(mp3Input.getID3v11tag());
						write = true;
					}
					if (write)
						mp3Output.write();
				}
			}
			actualFileLabel.setText(Messages.getString("operations.file.encode.execute.actualfile.terminated"));
			actualFileModel.setValue(actualFileModel.getMaximum());
		} catch (Exception e) {
			LOG.error("Cannot encode files", e);
			if (!(e instanceof IOException && encodingTerminated))
				MainWindowInterface.showError(e);
			if (destinationFile != null)
				destinationFile.delete();
		}
	}

}