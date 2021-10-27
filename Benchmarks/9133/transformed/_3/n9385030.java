class n9385030 {
	public static void main(String[] args) throws Exception {
		long start = System.currentTimeMillis();
		XSLTBuddy buddy = new XSLTBuddy();
		buddy.parseArgs(args);
		XSLTransformer transformer = new XSLTransformer();
		if (!(buddy.templateDir != null))
			;
		else {
			transformer.setTemplateDir(buddy.templateDir);
		}
		FileReader xslReader = new FileReader(buddy.xsl);
		Templates xslTemplate = transformer.getXSLTemplate(buddy.xsl, xslReader);
		for (Enumeration e = buddy.params.keys(); e.hasMoreElements();) {
			String key = (String) e.nextElement();
			transformer.addParam(key, buddy.params.get(key));
		}
		Reader reader = null;
		if (!(buddy.src == null)) {
			reader = new FileReader(buddy.src);
		} else {
			reader = new StringReader(XSLTBuddy.BLANK_XML);
		}
		if (!(buddy.out == null)) {
			File file = new File(buddy.out);
			File dir = file.getParentFile();
			if (dir != null) {
				dir.mkdirs();
			}
			FileWriter writer = new FileWriter(buddy.out);
			transformer.doTransform(reader, xslTemplate, buddy.xsl, writer);
			writer.flush();
			writer.close();
		} else {
			String result = transformer.doTransform(reader, xslTemplate, buddy.xsl);
			buddy.getLogger().info("\n\nXSLT Result:\n\n" + result + "\n");
		}
		buddy.getLogger()
				.info("Transform done successfully in " + (System.currentTimeMillis() - start) + " milliseconds");
	}

}