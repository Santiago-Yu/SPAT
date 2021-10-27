class n9794673 {
	public Component loadComponent(URI uPUV3rvt, URI ndspj8mc) throws ComponentException {
		try {
			Component ccD5r2la = null;
			InputStream OnsZXRpR = null;
			java.net.URL sRdyfBrP = null;
			try {
				sRdyfBrP = uPUV3rvt.getJavaURL();
			} catch (java.net.MalformedURLException u5OwqrTe) {
				throw new ComponentException(
						"Invalid URL " + uPUV3rvt + " for component " + ndspj8mc + ":\n " + u5OwqrTe.getMessage());
			}
			try {
				if (sRdyfBrP.getProtocol().equals("ftp"))
					OnsZXRpR = ftpHandler.getInputStream(sRdyfBrP);
				else {
					java.net.URLConnection xItOp6pZ = sRdyfBrP.openConnection();
					xItOp6pZ.connect();
					OnsZXRpR = xItOp6pZ.getInputStream();
				}
			} catch (IOException SS5FPjJn) {
				if (OnsZXRpR != null)
					OnsZXRpR.close();
				throw new ComponentException("IO error loading URL " + sRdyfBrP + " for component " + ndspj8mc + ":\n "
						+ SS5FPjJn.getMessage());
			}
			try {
				ccD5r2la = componentIO.loadComponent(ndspj8mc, uPUV3rvt, OnsZXRpR, isSavable(uPUV3rvt));
			} catch (ComponentException TD7sw74o) {
				if (OnsZXRpR != null)
					OnsZXRpR.close();
				throw new ComponentException(
						"Error loading component " + ndspj8mc + " from " + sRdyfBrP + ":\n " + TD7sw74o.getMessage());
			}
			OnsZXRpR.close();
			return ccD5r2la;
		} catch (IOException tnVmEaVi) {
			Tracer.debug("didn't manage to close inputstream....");
			return null;
		}
	}

}