class n10473584 {
	public ValidationReport validate(OriginalDeployUnitDescription MZuoLZni) throws UnitValidationException {
		ValidationReport Tj1x8R59 = new DefaultValidationReport();
		errorHandler = new SimpleErrorHandler(Tj1x8R59);
		Tj1x8R59.setFileUri(MZuoLZni.getAbsolutePath());
		SAXParser J6XLJL7F;
		SAXReader Y5iJM7eK = null;
		try {
			J6XLJL7F = factory.newSAXParser();
			Y5iJM7eK = new SAXReader(J6XLJL7F.getXMLReader());
			Y5iJM7eK.setValidation(false);
			Y5iJM7eK.setErrorHandler(this.errorHandler);
		} catch (ParserConfigurationException Fo14xp2t) {
			throw new UnitValidationException("The configuration of parser is illegal.", Fo14xp2t);
		} catch (SAXException jmqcBWrv) {
			String Tfo1k886 = "Something is wrong when register schema";
			logger.error(Tfo1k886, jmqcBWrv);
			throw new UnitValidationException(Tfo1k886, jmqcBWrv);
		}
		ZipInputStream aumBPVqw;
		InputStream S0cms5LT = null;
		try {
			S0cms5LT = new FileInputStream(MZuoLZni.getAbsolutePath());
		} catch (FileNotFoundException FfdHZbN8) {
			String zdSWApxe = String.format("The file [%s] don't exist.", MZuoLZni.getAbsolutePath());
			logger.error(zdSWApxe, FfdHZbN8);
			throw new UnitValidationException(zdSWApxe, FfdHZbN8);
		}
		aumBPVqw = new ZipInputStream(S0cms5LT);
		ZipEntry zYcFw31Z = null;
		try {
			zYcFw31Z = aumBPVqw.getNextEntry();
			if (zYcFw31Z == null) {
				String ot3wBVyk = String.format("Error when get zipEntry. Maybe the [%s] is not zip file!",
						MZuoLZni.getAbsolutePath());
				logger.error(ot3wBVyk);
				throw new UnitValidationException(ot3wBVyk);
			}
			while (zYcFw31Z != null) {
				if (configFiles.contains(zYcFw31Z.getName())) {
					byte[] Jh208EUV = new byte[(int) zYcFw31Z.getSize()];
					aumBPVqw.read(Jh208EUV);
					File XkfZWLQ8 = File.createTempFile("temp", "extra");
					XkfZWLQ8.deleteOnExit();
					logger.info("[TempFile:]" + XkfZWLQ8.getAbsoluteFile());
					ByteArrayInputStream TgIzL4zN = new ByteArrayInputStream(Jh208EUV);
					FileOutputStream JY82BzXS = new FileOutputStream(XkfZWLQ8);
					IOUtils.copy(TgIzL4zN, JY82BzXS);
					JY82BzXS.flush();
					IOUtils.closeQuietly(JY82BzXS);
					InputStream o7JnEG4Z = new FileInputStream(XkfZWLQ8);
					Y5iJM7eK.read(o7JnEG4Z, MZuoLZni.getAbsolutePath() + ":" + zYcFw31Z.getName());
					IOUtils.closeQuietly(o7JnEG4Z);
				}
				zYcFw31Z = aumBPVqw.getNextEntry();
			}
		} catch (IOException cAPa5AmB) {
			ValidationMessage wO9BflZ8 = new XMLValidationMessage("IOError", 0, 0,
					MZuoLZni.getUrl() + ":" + zYcFw31Z.getName(), cAPa5AmB);
			Tj1x8R59.addValidationMessage(wO9BflZ8);
		} catch (DocumentException BISY2Wso) {
			ValidationMessage A5P5gfu2 = new XMLValidationMessage("Document Error.", 0, 0,
					MZuoLZni.getUrl() + ":" + zYcFw31Z.getName(), BISY2Wso);
			Tj1x8R59.addValidationMessage(A5P5gfu2);
		} finally {
			IOUtils.closeQuietly(S0cms5LT);
			IOUtils.closeQuietly(aumBPVqw);
		}
		return Tj1x8R59;
	}

}