    protected void doSetInput(IEditorInput input, IProgressMonitor monitor) throws CoreException {
        IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
        IFileFormat format = null;
        Object source = null;
        InputStream in = null;
        try {
            IPath path;
            if (input instanceof IStorageEditorInput) {
                IStorage s = ((IStorageEditorInput) input).getStorage();
                in = s.getContents();
                if (s instanceof IFile) {
                    IFile file = (IFile) s;
                    path = file.getRawLocation();
                    if (root.exists(path)) {
                        path = root.getLocation().append(path);
                    }
                    source = path.toFile();
                }
            } else if (input instanceof IPathEditorInput) {
                path = ((IPathEditorInput) input).getPath();
                source = path.toFile();
            } else if (input instanceof IURIEditorInput) {
                URI uri = ((IURIEditorInput) input).getURI();
                if (URIUtil.isFileURI(uri)) {
                    source = URIUtil.toFile(uri);
                } else {
                    URL url = URIUtil.toURL(uri);
                    in = url.openStream();
                }
            }
            if (source == null) {
                if (!in.markSupported()) {
                    in = new BufferedInputStream(in);
                }
                in.mark(10);
                source = in;
            }
            IContentDescription cd = Platform.getContentTypeManager().getDescriptionFor(in, input.getName(), new QualifiedName[] { ImageCore.VALID_FORMATS });
            if (in != null) {
                in.reset();
            }
            Collection<?> valid = (Collection<?>) cd.getProperty(ImageCore.VALID_FORMATS);
            if (valid.isEmpty()) throw new CoreException(new Status(Status.ERROR, ImageUI.PLUGIN_ID, "Unsupported file format."));
            ImageInputStream stream = ImageIO.createImageInputStream(source);
            format = (IFileFormat) valid.iterator().next();
            IDocument document = format.decode(stream, monitor);
            setDocument(document);
        } catch (IOException e) {
            Status status = new Status(Status.ERROR, ImageUI.PLUGIN_ID, "IO Error", e);
            throw new CoreException(status);
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                }
            }
        }
        super.setInput(input);
    }
