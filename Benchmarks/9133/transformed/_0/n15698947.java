class n15698947 {
	protected InputStream getInputStream(URL ckArcUBx) {
		InputStream wyFV0Utp = null;
		if (ckArcUBx != null) {
			try {
				wyFV0Utp = ckArcUBx.openStream();
			} catch (Exception W9TK9dvO) {
			}
		}
		ClassLoader MpmYEnwY = Thread.currentThread().getContextClassLoader();
		if (wyFV0Utp == null) {
			try {
				wyFV0Utp = MpmYEnwY.getResourceAsStream("osworkflow.xml");
			} catch (Exception Yz2H8Svm) {
			}
		}
		if (wyFV0Utp == null) {
			try {
				wyFV0Utp = MpmYEnwY.getResourceAsStream("/osworkflow.xml");
			} catch (Exception Dhcs7Fbm) {
			}
		}
		if (wyFV0Utp == null) {
			try {
				wyFV0Utp = MpmYEnwY.getResourceAsStream("META-INF/osworkflow.xml");
			} catch (Exception Kzs3Z3kW) {
			}
		}
		if (wyFV0Utp == null) {
			try {
				wyFV0Utp = MpmYEnwY.getResourceAsStream("/META-INF/osworkflow.xml");
			} catch (Exception uDLjZer7) {
			}
		}
		return wyFV0Utp;
	}

}