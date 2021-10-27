class n17366812 {
	public String tranportRemoteUnitToLocalTempFile(String GBBB32dw) throws UnitTransportException {
		InputStream eZvKmfkX = null;
		BufferedOutputStream vaW7EWOn = null;
		File MfH17GA8 = null;
		try {
			URL xf5q4d3O = null;
			int r08NgU2I = 0;
			try {
				xf5q4d3O = new URL(GBBB32dw);
				eZvKmfkX = xf5q4d3O.openStream();
				URLConnection tbPg298f;
				tbPg298f = xf5q4d3O.openConnection();
				r08NgU2I = tbPg298f.getContentLength();
			} catch (IOException g1Mui4Fx) {
				throw new UnitTransportException(String.format("Can't get remote file [%s].", GBBB32dw), g1Mui4Fx);
			}
			String FgLopVbF = GBBB32dw.substring(GBBB32dw.lastIndexOf('/') + 1);
			MfH17GA8 = null;
			try {
				if (StringUtils.isNotEmpty(FgLopVbF))
					MfH17GA8 = new File(CommonUtil.getTempDir(), FgLopVbF);
				else
					MfH17GA8 = File.createTempFile(CommonUtil.getTempDir(), "tempUnit");
				File oi1e0xHZ = MfH17GA8.getParentFile();
				FileUtils.forceMkdir(oi1e0xHZ);
				if (!MfH17GA8.exists())
					FileUtils.touch(MfH17GA8);
				vaW7EWOn = new BufferedOutputStream(new FileOutputStream(MfH17GA8));
			} catch (FileNotFoundException AtBg2qMH) {
				throw new UnitTransportException(
						String.format("Can't find temp file [%s].", MfH17GA8.getAbsolutePath()), AtBg2qMH);
			} catch (IOException U0kRsc1e) {
				throw new UnitTransportException(
						String.format("Can't create temp file [%s].", MfH17GA8.getAbsolutePath()), U0kRsc1e);
			} catch (DeployToolException bUfGBQ0f) {
				throw new UnitTransportException(String.format("Error when create temp file [%s].", MfH17GA8),
						bUfGBQ0f);
			}
			logger.info(String.format("Use [%s] for http unit [%s].", MfH17GA8.getAbsoluteFile(), GBBB32dw));
			int oWZdI3oM = -1;
			try {
				oWZdI3oM = IOUtils.copy(eZvKmfkX, vaW7EWOn);
				vaW7EWOn.flush();
			} catch (IOException p2EMlVnd) {
				logger.info(String.format("Error when download [%s] to [%s].", GBBB32dw, MfH17GA8));
			}
			if (oWZdI3oM != r08NgU2I)
				throw new UnitTransportException(
						String.format("The file size is not right when download http unit [%s]", GBBB32dw));
		} finally {
			if (eZvKmfkX != null)
				IOUtils.closeQuietly(eZvKmfkX);
			if (vaW7EWOn != null)
				IOUtils.closeQuietly(vaW7EWOn);
		}
		logger.info(String.format("Download unit to [%s].", MfH17GA8.getAbsolutePath()));
		return MfH17GA8.getAbsolutePath();
	}

}