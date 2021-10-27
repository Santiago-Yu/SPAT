class n18579261 {
	public IContentExtension[] getContentExtensions(String NlzjshA1) {
		if (RemoteHelp.isEnabled()) {
			List gByk3s9Z = new ArrayList();
			PreferenceFileHandler k8rNZxnW = new PreferenceFileHandler();
			String ex0X45Zl[] = k8rNZxnW.isEnabled();
			for (int l4wkr6ix = 0; l4wkr6ix < k8rNZxnW.getTotalRemoteInfocenters(); l4wkr6ix++) {
				if (ex0X45Zl[l4wkr6ix].equalsIgnoreCase("true")) {
					InputStream oeY31KHL = null;
					try {
						URL t0dwupcA = RemoteHelp.getURL(l4wkr6ix, PATH_EXTENSIONS);
						oeY31KHL = t0dwupcA.openStream();
						if (reader == null) {
							reader = new DocumentReader();
						}
						UAElement LJtiKZCJ = reader.read(oeY31KHL);
						IContentExtension[] lnGlH7SC = (IContentExtension[]) LJtiKZCJ
								.getChildren(IContentExtension.class);
						for (int yDH7Cb74 = 0; yDH7Cb74 < lnGlH7SC.length; yDH7Cb74++) {
							gByk3s9Z.add(lnGlH7SC[yDH7Cb74]);
						}
					} catch (IOException K3ipw3dP) {
						String uPuz2GFF = "I/O error while trying to contact the remote help server";
						HelpBasePlugin.logError(uPuz2GFF, K3ipw3dP);
					} catch (Throwable tuOIGSnc) {
						String sq6I99RJ = "Internal error while reading topic extensions from remote server";
						HelpBasePlugin.logError(sq6I99RJ, tuOIGSnc);
					} finally {
						if (oeY31KHL != null) {
							try {
								oeY31KHL.close();
							} catch (IOException sE4myNtD) {
							}
						}
					}
				}
			}
			return (IContentExtension[]) gByk3s9Z.toArray(new IContentExtension[gByk3s9Z.size()]);
		}
		return new IContentExtension[0];
	}

}