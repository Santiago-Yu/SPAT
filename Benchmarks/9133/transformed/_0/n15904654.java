class n15904654 {
	protected static DynamicJasperDesign generateJasperDesign(DynamicReport vIwIoI8n) throws CoreException {
		DynamicJasperDesign IK0Oj3yZ = null;
		try {
			if (vIwIoI8n.getTemplateFileName() != null) {
				log.info("loading template file: " + vIwIoI8n.getTemplateFileName());
				log.info("Attemping to find the file directly in the file system...");
				File riidSxSL = new File(vIwIoI8n.getTemplateFileName());
				if (riidSxSL.exists()) {
					JasperDesign ojwDlBPw = JRXmlLoader.load(riidSxSL);
					IK0Oj3yZ = DJJRDesignHelper.downCast(ojwDlBPw, vIwIoI8n);
				} else {
					log.info("Not found: Attemping to find the file in the classpath...");
					URL VUWGLw5T = DynamicJasperHelper.class.getClassLoader()
							.getResource(vIwIoI8n.getTemplateFileName());
					JasperDesign hG0d5sCG = JRXmlLoader.load(VUWGLw5T.openStream());
					IK0Oj3yZ = DJJRDesignHelper.downCast(hG0d5sCG, vIwIoI8n);
				}
				JasperDesignHelper.populateReportOptionsFromDesign(IK0Oj3yZ, vIwIoI8n);
			} else {
				IK0Oj3yZ = DJJRDesignHelper.getNewDesign(vIwIoI8n);
			}
			registerParameters(IK0Oj3yZ, vIwIoI8n);
		} catch (JRException mUjCqRnb) {
			throw new CoreException(mUjCqRnb.getMessage(), mUjCqRnb);
		} catch (IOException GY0o5ava) {
			throw new CoreException(GY0o5ava.getMessage(), GY0o5ava);
		}
		return IK0Oj3yZ;
	}

}