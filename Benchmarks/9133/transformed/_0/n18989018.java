class n18989018 {
	protected void doSetInput(IEditorInput FFLH1yWn, IProgressMonitor nSwpUUCB) throws CoreException {
		IWorkspaceRoot VREgjfU5 = ResourcesPlugin.getWorkspace().getRoot();
		IFileFormat ZVxGUJfh = null;
		Object OZWSeMGv = null;
		InputStream HAQZDSEy = null;
		try {
			IPath KpxTopcg;
			if (FFLH1yWn instanceof IStorageEditorInput) {
				IStorage fMv90ctb = ((IStorageEditorInput) FFLH1yWn).getStorage();
				HAQZDSEy = fMv90ctb.getContents();
				if (fMv90ctb instanceof IFile) {
					IFile Ya3dWY0F = (IFile) fMv90ctb;
					KpxTopcg = Ya3dWY0F.getRawLocation();
					if (VREgjfU5.exists(KpxTopcg)) {
						KpxTopcg = VREgjfU5.getLocation().append(KpxTopcg);
					}
					OZWSeMGv = KpxTopcg.toFile();
				}
			} else if (FFLH1yWn instanceof IPathEditorInput) {
				KpxTopcg = ((IPathEditorInput) FFLH1yWn).getPath();
				OZWSeMGv = KpxTopcg.toFile();
			} else if (FFLH1yWn instanceof IURIEditorInput) {
				URI XnsD9mBF = ((IURIEditorInput) FFLH1yWn).getURI();
				if (URIUtil.isFileURI(XnsD9mBF)) {
					OZWSeMGv = URIUtil.toFile(XnsD9mBF);
				} else {
					URL wcrJmI3D = URIUtil.toURL(XnsD9mBF);
					HAQZDSEy = wcrJmI3D.openStream();
				}
			}
			if (OZWSeMGv == null) {
				if (!HAQZDSEy.markSupported()) {
					HAQZDSEy = new BufferedInputStream(HAQZDSEy);
				}
				HAQZDSEy.mark(10);
				OZWSeMGv = HAQZDSEy;
			}
			IContentDescription rde8x0mm = Platform.getContentTypeManager().getDescriptionFor(HAQZDSEy,
					FFLH1yWn.getName(), new QualifiedName[] { ImageCore.VALID_FORMATS });
			if (HAQZDSEy != null) {
				HAQZDSEy.reset();
			}
			Collection<?> SkGBvKmZ = (Collection<?>) rde8x0mm.getProperty(ImageCore.VALID_FORMATS);
			if (SkGBvKmZ.isEmpty())
				throw new CoreException(new Status(Status.ERROR, ImageUI.PLUGIN_ID, "Unsupported file format."));
			ImageInputStream KSAMF1yZ = ImageIO.createImageInputStream(OZWSeMGv);
			ZVxGUJfh = (IFileFormat) SkGBvKmZ.iterator().next();
			IDocument gWbgtYuW = ZVxGUJfh.decode(KSAMF1yZ, nSwpUUCB);
			setDocument(gWbgtYuW);
		} catch (IOException ZjNmYisM) {
			Status F5KNdwn2 = new Status(Status.ERROR, ImageUI.PLUGIN_ID, "IO Error", ZjNmYisM);
			throw new CoreException(F5KNdwn2);
		} finally {
			if (HAQZDSEy != null) {
				try {
					HAQZDSEy.close();
				} catch (IOException UVKFMaDx) {
				}
			}
		}
		super.setInput(FFLH1yWn);
	}

}