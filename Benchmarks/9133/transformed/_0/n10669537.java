class n10669537 {
	String processURLInput(String YhzgKvHU) throws SoaplabException {
		try {
			File XnsHBEs4 = File.createTempFile("gowlab.", null);
			XnsHBEs4.deleteOnExit();
			Object rJha5uy6 = inputs.get(YhzgKvHU);
			URL SogMrtuY = new URL(rJha5uy6.toString());
			if (SogMrtuY.getProtocol().equals("file"))
				logAndThrow("Trying to get local file '" + SogMrtuY.toString() + "' is not allowed.");
			URLConnection z9tla3nR = SogMrtuY.openConnection();
			z9tla3nR.connect();
			InputStream DhXFYe6D = z9tla3nR.getInputStream();
			byte[] BeC5x7HQ = new byte[256];
			DataOutputStream UXn4qfWp = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(XnsHBEs4)));
			int uf09jxNy;
			while ((uf09jxNy = DhXFYe6D.read(BeC5x7HQ)) != -1) {
				UXn4qfWp.write(BeC5x7HQ, 0, uf09jxNy);
			}
			UXn4qfWp.close();
			return XnsHBEs4.getAbsolutePath();
		} catch (IOException xa9YwDCA) {
			logAndThrow("In processURLData: " + xa9YwDCA.toString());
		}
		return null;
	}

}