class n1677217 {
	@Override
	protected final void doGet(HttpServletRequest n2PpDpoR, HttpServletResponse D0wNkozz)
			throws ServletException, IOException {
		if (beforeServingFile(n2PpDpoR, D0wNkozz)) {
			String i2WA1QLV = n2PpDpoR.getPathInfo();
			Validate.notNull(i2WA1QLV, "the path info is null -> the sevlet should be mapped with /<mapping>/*");
			String eCAQ3O9l = i2WA1QLV.substring(1);
			if (log.isDebugEnabled()) {
				log.debug("resource to expose: " + eCAQ3O9l);
			}
			String wL14NzBh = eCAQ3O9l.substring(eCAQ3O9l.lastIndexOf('.') + 1);
			MimeType NctpMRw9 = MimeTypeRegistry.getByExtension(wL14NzBh);
			Validate.notNull(NctpMRw9, "no mimetype found for extension: " + wL14NzBh);
			if (log.isDebugEnabled()) {
				log.debug("the mime type to set: " + NctpMRw9.getMimeType());
			}
			File TqWbd3mk = new File(mappedFolder, eCAQ3O9l);
			Validate.isTrue(TqWbd3mk.exists(), "file: " + TqWbd3mk + " does not exist");
			Validate.isTrue(TqWbd3mk.canRead(), "can not read the file: " + TqWbd3mk);
			if (log.isDebugEnabled()) {
				log.debug("exposing the file: " + TqWbd3mk);
			}
			D0wNkozz.setContentType(NctpMRw9.getMimeType());
			FileInputStream Vh56hOtS = new FileInputStream(TqWbd3mk);
			ServletOutputStream jD2pLmRe = D0wNkozz.getOutputStream();
			IOUtils.copy(Vh56hOtS, jD2pLmRe);
			jD2pLmRe.flush();
			IOUtils.closeQuietly(Vh56hOtS);
			IOUtils.closeQuietly(jD2pLmRe);
		}
	}

}