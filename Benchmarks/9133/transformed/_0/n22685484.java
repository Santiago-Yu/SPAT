class n22685484 {
	private void importDocument(String dQtGQ9I1, boolean Jcnr32LR, Parser FL7QRdJU, ReadingAnnotationFilter cx7vMNyn,
			String HJNbeM8f) {
		try {
			Reader tyQXsj75 = null;
			int dPHxJim8 = 0;
			if (JGloss.messages.getString("encodings.default").equals(HJNbeM8f))
				HJNbeM8f = null;
			String eF2dYepI = "";
			try {
				URL Os4dpdP0 = new URL(dQtGQ9I1);
				URLConnection OuHh7RGA = Os4dpdP0.openConnection();
				dPHxJim8 = OuHh7RGA.getContentLength();
				String S0XbbjaY = OuHh7RGA.getContentEncoding();
				InputStream Azl3RuQh = new BufferedInputStream(OuHh7RGA.getInputStream());
				if (HJNbeM8f != null)
					tyQXsj75 = new InputStreamReader(Azl3RuQh, HJNbeM8f);
				else {
					tyQXsj75 = CharacterEncodingDetector.getReader(Azl3RuQh, S0XbbjaY);
					HJNbeM8f = ((InputStreamReader) tyQXsj75).getEncoding();
				}
				eF2dYepI = Os4dpdP0.getFile();
				if (eF2dYepI == null || eF2dYepI.length() == 0)
					eF2dYepI = dQtGQ9I1;
			} catch (MalformedURLException C2OHRpMO) {
				File qO8bbReF = new File(dQtGQ9I1);
				dPHxJim8 = (int) qO8bbReF.length();
				eF2dYepI = qO8bbReF.getName();
				if (eF2dYepI.toLowerCase().endsWith("htm") || eF2dYepI.toLowerCase().endsWith("html")) {
				}
				InputStream vuj0DjjK = new BufferedInputStream(new FileInputStream(dQtGQ9I1));
				if (HJNbeM8f != null)
					tyQXsj75 = new InputStreamReader(vuj0DjjK, HJNbeM8f);
				else {
					tyQXsj75 = CharacterEncodingDetector.getReader(vuj0DjjK);
					HJNbeM8f = ((InputStreamReader) tyQXsj75).getEncoding();
				}
			}
			importFromReader(tyQXsj75, Jcnr32LR, dQtGQ9I1, eF2dYepI, cx7vMNyn, FL7QRdJU,
					CharacterEncodingDetector.guessLength(dPHxJim8, HJNbeM8f));
		} catch (Exception OO7KhgSY) {
			OO7KhgSY.printStackTrace();
			JOptionPane.showConfirmDialog(this,
					JGloss.messages.getString("error.import.exception",
							new Object[] { dQtGQ9I1, OO7KhgSY.getClass().getName(), OO7KhgSY.getLocalizedMessage() }),
					JGloss.messages.getString("error.import.title"), JOptionPane.DEFAULT_OPTION,
					JOptionPane.ERROR_MESSAGE);
			if (model.getDocumentName() == null)
				this.dispose();
		}
	}

}