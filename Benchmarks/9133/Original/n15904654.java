class n15904654{
    protected static DynamicJasperDesign generateJasperDesign(DynamicReport dr) throws CoreException {
        DynamicJasperDesign jd = null;
        try {
            if (dr.getTemplateFileName() != null) {
                log.info("loading template file: " + dr.getTemplateFileName());
                log.info("Attemping to find the file directly in the file system...");
                File file = new File(dr.getTemplateFileName());
                if (file.exists()) {
                    JasperDesign jdesign = JRXmlLoader.load(file);
                    jd = DJJRDesignHelper.downCast(jdesign, dr);
                } else {
                    log.info("Not found: Attemping to find the file in the classpath...");
                    URL url = DynamicJasperHelper.class.getClassLoader().getResource(dr.getTemplateFileName());
                    JasperDesign jdesign = JRXmlLoader.load(url.openStream());
                    jd = DJJRDesignHelper.downCast(jdesign, dr);
                }
                JasperDesignHelper.populateReportOptionsFromDesign(jd, dr);
            } else {
                jd = DJJRDesignHelper.getNewDesign(dr);
            }
            registerParameters(jd, dr);
        } catch (JRException e) {
            throw new CoreException(e.getMessage(), e);
        } catch (IOException e) {
            throw new CoreException(e.getMessage(), e);
        }
        return jd;
    }

}