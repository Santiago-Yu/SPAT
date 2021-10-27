class n9385030 {
	public static void main(String[] aBMHae9B) throws Exception {
		long FgB0QZ84 = System.currentTimeMillis();
		XSLTBuddy xKkW2dNi = new XSLTBuddy();
		xKkW2dNi.parseArgs(aBMHae9B);
		XSLTransformer pGS8Hx0d = new XSLTransformer();
		if (xKkW2dNi.templateDir != null) {
			pGS8Hx0d.setTemplateDir(xKkW2dNi.templateDir);
		}
		FileReader ogj5MqG8 = new FileReader(xKkW2dNi.xsl);
		Templates t9MZFbBt = pGS8Hx0d.getXSLTemplate(xKkW2dNi.xsl, ogj5MqG8);
		for (Enumeration VlPNBLmj = xKkW2dNi.params.keys(); VlPNBLmj.hasMoreElements();) {
			String J5SiEcBt = (String) VlPNBLmj.nextElement();
			pGS8Hx0d.addParam(J5SiEcBt, xKkW2dNi.params.get(J5SiEcBt));
		}
		Reader OtpLUIk4 = null;
		if (xKkW2dNi.src == null) {
			OtpLUIk4 = new StringReader(XSLTBuddy.BLANK_XML);
		} else {
			OtpLUIk4 = new FileReader(xKkW2dNi.src);
		}
		if (xKkW2dNi.out == null) {
			String blqd09Wo = pGS8Hx0d.doTransform(OtpLUIk4, t9MZFbBt, xKkW2dNi.xsl);
			xKkW2dNi.getLogger().info("\n\nXSLT Result:\n\n" + blqd09Wo + "\n");
		} else {
			File uPGTmWUT = new File(xKkW2dNi.out);
			File R7dqTNei = uPGTmWUT.getParentFile();
			if (R7dqTNei != null) {
				R7dqTNei.mkdirs();
			}
			FileWriter nt6F3lMH = new FileWriter(xKkW2dNi.out);
			pGS8Hx0d.doTransform(OtpLUIk4, t9MZFbBt, xKkW2dNi.xsl, nt6F3lMH);
			nt6F3lMH.flush();
			nt6F3lMH.close();
		}
		xKkW2dNi.getLogger()
				.info("Transform done successfully in " + (System.currentTimeMillis() - FgB0QZ84) + " milliseconds");
	}

}