class n8364547 {
	@Override
	public void executeInterruptible() {
		encodingTerminated = false;
		File enBo08tB = null;
		try {
			Runtime Z8jHuwXM = Runtime.getRuntime();
			IconAndFileListElement XKDb6WDW;
			while ((XKDb6WDW = getNextFileElement()) != null) {
				File Ex24CkRS = XKDb6WDW.getFile();
				enBo08tB = new File(encodeFileCard.getDestinationFolder().getValue(), Ex24CkRS.getName());
				if (!enBo08tB.getParentFile().exists()) {
					enBo08tB.getParentFile().mkdirs();
				}
				actualFileLabel.setText(Ex24CkRS.getName());
				actualFileModel.setMaximum((int) Ex24CkRS.length());
				actualFileModel.setValue(0);
				int XqVF51fO;
				synchronized (bitratePattern) {
					Matcher vAZDPq5O = bitratePattern.matcher(encodeFileCard.getBitrate().getValue());
					vAZDPq5O.find();
					XqVF51fO = Integer.parseInt(vAZDPq5O.group(1));
				}
				List<String> vTxYKBQV = new LinkedList<String>();
				vTxYKBQV.add(encoderFile.getCanonicalPath());
				vTxYKBQV.add("--mp3input");
				vTxYKBQV.add("-m");
				vTxYKBQV.add("j");
				String biisQSJG = Settings.getSetting("encode.sample.freq");
				if (Util.isNotEmpty(biisQSJG)) {
					vTxYKBQV.add("--resample");
					vTxYKBQV.add(biisQSJG);
				}
				QualityElement x5N9nuso = (QualityElement) ((JComboBox) encodeFileCard.getQuality().getValueComponent())
						.getSelectedItem();
				vTxYKBQV.add("-q");
				vTxYKBQV.add(Integer.toString(x5N9nuso.getValue()));
				vTxYKBQV.add("-b");
				vTxYKBQV.add(Integer.toString(XqVF51fO));
				vTxYKBQV.add("--cbr");
				vTxYKBQV.add("-");
				vTxYKBQV.add(enBo08tB.getCanonicalPath());
				if (LOG.isDebugEnabled()) {
					StringBuilder wkncbnVf = new StringBuilder();
					boolean xgqPTvcc = true;
					for (String rOqPKUar : vTxYKBQV) {
						if (!xgqPTvcc)
							wkncbnVf.append(" ");
						wkncbnVf.append(rOqPKUar);
						xgqPTvcc = false;
					}
					LOG.debug("Command line: " + wkncbnVf.toString());
				}
				encodingProcess = Z8jHuwXM.exec(vTxYKBQV.toArray(new String[0]));
				lastPosition = 0l;
				InputStream dUhE4Ygr = null;
				try {
					dUhE4Ygr = new PositionNotifierInputStream(new FileInputStream(Ex24CkRS), Ex24CkRS.length(), 2048,
							this);
					IOUtils.copy(dUhE4Ygr, encodingProcess.getOutputStream());
					encodingProcess.getOutputStream().close();
				} finally {
					IOUtils.closeQuietly(dUhE4Ygr);
					if (LOG.isDebugEnabled()) {
						InputStream TXUI6Kzz = null;
						try {
							TXUI6Kzz = encodingProcess.getInputStream();
							StringWriter okB9WdMW = new StringWriter();
							IOUtils.copy(TXUI6Kzz, okB9WdMW);
							LOG.debug("Process output stream:\n" + okB9WdMW);
							IOUtils.closeQuietly(TXUI6Kzz);
							TXUI6Kzz = encodingProcess.getErrorStream();
							okB9WdMW = new StringWriter();
							IOUtils.copy(TXUI6Kzz, okB9WdMW);
							LOG.debug("Process error stream:\n" + okB9WdMW);
						} finally {
							IOUtils.closeQuietly(TXUI6Kzz);
						}
					}
				}
				int fGAnHK0J = encodingProcess.waitFor();
				encodingProcess = null;
				if (fGAnHK0J != 0) {
					LOG.warn("Encoder process returned error code " + fGAnHK0J);
				}
				if (Boolean.parseBoolean(encodeFileCard.getCopyTag().getValue())) {
					MP3File Vd1bGh6c = new MP3File(Ex24CkRS);
					MP3File PePplQRT = new MP3File(enBo08tB);
					boolean pA6LnyNZ = false;
					if (Vd1bGh6c.hasID3v2tag()) {
						ID3v2Tag vxoSefsO = new ID3v2Tag();
						for (ID3v2Frame e85OEszQ : Vd1bGh6c.getID3v2tag().getAllframes()) {
							vxoSefsO.addFrame(e85OEszQ);
						}
						PePplQRT.setID3v2tag(vxoSefsO);
						pA6LnyNZ = true;
					}
					if (Vd1bGh6c.hasID3v11tag()) {
						PePplQRT.setID3v11tag(Vd1bGh6c.getID3v11tag());
						pA6LnyNZ = true;
					}
					if (pA6LnyNZ)
						PePplQRT.write();
				}
			}
			actualFileLabel.setText(Messages.getString("operations.file.encode.execute.actualfile.terminated"));
			actualFileModel.setValue(actualFileModel.getMaximum());
		} catch (Exception YgL0tcGQ) {
			LOG.error("Cannot encode files", YgL0tcGQ);
			if (!(YgL0tcGQ instanceof IOException && encodingTerminated))
				MainWindowInterface.showError(YgL0tcGQ);
			if (enBo08tB != null)
				enBo08tB.delete();
		}
	}

}