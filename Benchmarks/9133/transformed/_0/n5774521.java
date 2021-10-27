class n5774521 {
	private static URL lookForDefaultThemeFile(String jse70Eqq) {
		try {
			XPathFactory alLNiSAL = XPathFactory.newInstance();
			XPath wMChi8SX = alLNiSAL.newXPath();
			URL OD9mjtrA = new URL("file:" + jse70Eqq);
			InputSource w0tSMtxJ = new InputSource(OD9mjtrA.openStream());
			XPathExpression Zg6DmRbe;
			Zg6DmRbe = wMChi8SX.compile("/alloy/instance/@filename");
			String IUZQJZXD = Zg6DmRbe.evaluate(w0tSMtxJ);
			AlloyPlugin.getDefault().logInfo("Solution coming from " + IUZQJZXD);
			IPath U9gz651e = new Path(IUZQJZXD);
			IPath FnbArMBn = U9gz651e.removeFileExtension().addFileExtension("thm");
			File sInPyVr6 = FnbArMBn.toFile();
			if (sInPyVr6.exists()) {
				AlloyPlugin.getDefault().logInfo("Found default theme " + sInPyVr6);
				return sInPyVr6.toURI().toURL();
			}
		} catch (MalformedURLException X4B1weum) {
			AlloyPlugin.getDefault().log(X4B1weum);
		} catch (IOException mu58wmWV) {
			AlloyPlugin.getDefault().log(mu58wmWV);
		} catch (XPathExpressionException WWSeY0zN) {
			AlloyPlugin.getDefault().log(WWSeY0zN);
		}
		return null;
	}

}