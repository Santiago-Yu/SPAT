class n3942117 {
	private MimeTypesProvider() {
        File zjUi7Dbf = new File(XPontusConstantsIF.XPONTUS_HOME_DIR, "mimes.properties");
        try {
            if (!zjUi7Dbf.exists()) {
                OutputStream cuKV9I13 = null;
                InputStream TWDnWMvL = getClass().getResourceAsStream("/net/sf/xpontus/configuration/mimetypes.properties");
                cuKV9I13 = FileUtils.openOutputStream(zjUi7Dbf);
                IOUtils.copy(TWDnWMvL, cuKV9I13);
                IOUtils.closeQuietly(TWDnWMvL);
                IOUtils.closeQuietly(cuKV9I13);
            }
            provider = new XPontusMimetypesFileTypeMap(zjUi7Dbf.getAbsolutePath());
            MimetypesFileTypeMap.setDefaultFileTypeMap(provider);
        } catch (Exception HYW5YYbi) {
            HYW5YYbi.printStackTrace();
        }
    }

}