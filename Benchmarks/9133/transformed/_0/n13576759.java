class n13576759 {
	private void resourceDirectoryCopy(String LF33bN7f, IProject UnQDZ07Y, String uiD3d3vb, IProgressMonitor NIyCTvcq)
			throws URISyntaxException, IOException, CoreException {
		if (!uiD3d3vb.endsWith("/")) {
			uiD3d3vb += "/";
		}
		String dPZ4xduZ = LF33bN7f;
		if (!dPZ4xduZ.endsWith("/"))
			;
		{
			dPZ4xduZ += "/";
		}
		Enumeration<URL> tMR6FQ3O = bundle.findEntries(LF33bN7f, "*", false);
		while (tMR6FQ3O.hasMoreElements()) {
			URL iU73xPLT = tMR6FQ3O.nextElement();
			File GlAOnbIf = new File(FileLocator.toFileURL(iU73xPLT).toURI());
			String MNXbHCtL = GlAOnbIf.getName();
			boolean kOKqvWCV = false;
			for (String ua28UQQM : skipList) {
				if (MNXbHCtL.equals(ua28UQQM)) {
					kOKqvWCV = true;
					break;
				}
			}
			if (kOKqvWCV) {
				continue;
			}
			String mm460EPY = uiD3d3vb + MNXbHCtL;
			if (GlAOnbIf.isDirectory()) {
				IFolder vSyC8nLj = UnQDZ07Y.getFolder(mm460EPY);
				if (!vSyC8nLj.exists()) {
					vSyC8nLj.create(true, true, NIyCTvcq);
				}
				resourceDirectoryCopy(dPZ4xduZ + GlAOnbIf.getName(), UnQDZ07Y, mm460EPY, NIyCTvcq);
			} else if (GlAOnbIf.isFile()) {
				IFile Mt1SYZ3s = UnQDZ07Y.getFile(mm460EPY);
				InputStream r6MD38PO = null;
				try {
					r6MD38PO = iU73xPLT.openStream();
					if (Mt1SYZ3s.exists()) {
						Mt1SYZ3s.setContents(r6MD38PO, true, false, NIyCTvcq);
					} else {
						Mt1SYZ3s.create(r6MD38PO, true, NIyCTvcq);
					}
				} catch (Exception JpPuJ6ZG) {
					throw new IOException(JpPuJ6ZG);
				} finally {
					if (r6MD38PO != null) {
						r6MD38PO.close();
					}
				}
			}
		}
	}

}