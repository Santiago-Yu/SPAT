class n15464749 {
	@Override
	protected String doWget(final URL AEW10qQx, final boolean ux20Ee0Y, final boolean PDmXbfPr,
			final String... SW8NBVFb) throws Exception {
		String PROITeF7 = "";
		InputStream y9yfcAeg = null;
		OutputStream BsnOKyJF = null;
		String pHaxaLLD = null;
		try {
			final URLConnection Rzg4Ko7e = AEW10qQx.openConnection();
			if (ux20Ee0Y) {
				boolean Li0fcC09 = false;
				for (final String PNa9yQau : SW8NBVFb) {
					PROITeF7 += URLEncoder.encode(PNa9yQau, "UTF-8");
					if (Li0fcC09 = !Li0fcC09) {
						PROITeF7 += "=";
					} else {
						PROITeF7 += "&";
					}
				}
				Rzg4Ko7e.setDoOutput(true);
				BsnOKyJF = Rzg4Ko7e.getOutputStream();
				BsnOKyJF.write(PROITeF7.getBytes());
			}
			y9yfcAeg = Rzg4Ko7e.getInputStream();
			pHaxaLLD = PDmXbfPr ? null : "";
			int hUR7Om1V;
			final byte[] ErmIWpgy = new byte[1023];
			while ((hUR7Om1V = y9yfcAeg.read(ErmIWpgy)) >= 0) {
				if (!PDmXbfPr) {
					pHaxaLLD += new String(ErmIWpgy, 0, hUR7Om1V);
				}
			}
			if (LogHelper.isLogLevelEnabled(LogLevel.DEBUG, DefaultCommunicationHelper.class)) {
				LogHelper.log(DefaultCommunicationHelper.class, LogLevel.DEBUG,
						"WGET= URL[" + AEW10qQx.toString() + "?" + PROITeF7 + "] RETURN[" + pHaxaLLD + "]");
			}
			return pHaxaLLD;
		} catch (final Exception N5avJBSL) {
			LogHelper.log(DefaultCommunicationHelper.class, LogLevel.WARN, "An error occurred while submitting "
					+ PROITeF7 + " request to " + AEW10qQx.toString() + " with the following data: " + pHaxaLLD,
					N5avJBSL);
			throw N5avJBSL;
		} finally {
			if (y9yfcAeg != null) {
				try {
					y9yfcAeg.close();
				} catch (final Exception U2lHMkOS) {
					LogHelper.log(DefaultCommunicationHelper.class, LogLevel.DEBUG,
							"An error occurred while closing an input stream", U2lHMkOS);
				}
			}
			if (BsnOKyJF != null) {
				try {
					BsnOKyJF.close();
				} catch (final Exception tdzkj0O0) {
					LogHelper.log(DefaultCommunicationHelper.class, LogLevel.DEBUG,
							"An error occurred while closing an output stream", tdzkj0O0);
				}
			}
		}
	}

}