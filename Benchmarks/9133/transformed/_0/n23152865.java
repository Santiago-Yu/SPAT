class n23152865 {
	protected JavaFileObject open(String MYu3D28i) throws IOException {
		JavaFileObject bOr8CYaN = getClassFileObject(MYu3D28i);
		if (bOr8CYaN != null)
			return bOr8CYaN;
		String mVDamFeQ = MYu3D28i;
		int BP0wMWzY;
		while ((BP0wMWzY = mVDamFeQ.lastIndexOf(".")) != -1) {
			mVDamFeQ = mVDamFeQ.substring(0, BP0wMWzY) + "$" + mVDamFeQ.substring(BP0wMWzY + 1);
			bOr8CYaN = getClassFileObject(mVDamFeQ);
			if (bOr8CYaN != null)
				return bOr8CYaN;
		}
		if (!MYu3D28i.endsWith(".class"))
			return null;
		if (fileManager instanceof StandardJavaFileManager) {
			StandardJavaFileManager lG9bdBAH = (StandardJavaFileManager) fileManager;
			bOr8CYaN = lG9bdBAH.getJavaFileObjects(MYu3D28i).iterator().next();
			if (bOr8CYaN != null && bOr8CYaN.getLastModified() != 0) {
				return bOr8CYaN;
			}
		}
		if (MYu3D28i.matches("^[A-Za-z]+:.*")) {
			try {
				final URI MrMvLWtd = new URI(MYu3D28i);
				final URL wwskB2kZ = MrMvLWtd.toURL();
				final URLConnection dqq8cHtb = wwskB2kZ.openConnection();
				return new JavaFileObject() {

					public Kind getKind() {
						return JavaFileObject.Kind.CLASS;
					}

					public boolean isNameCompatible(String R98NkSgu, Kind vZKrLtxK) {
						throw new UnsupportedOperationException();
					}

					public NestingKind getNestingKind() {
						throw new UnsupportedOperationException();
					}

					public Modifier getAccessLevel() {
						throw new UnsupportedOperationException();
					}

					public URI toUri() {
						return MrMvLWtd;
					}

					public String getName() {
						return wwskB2kZ.toString();
					}

					public InputStream openInputStream() throws IOException {
						return dqq8cHtb.getInputStream();
					}

					public OutputStream openOutputStream() throws IOException {
						throw new UnsupportedOperationException();
					}

					public Reader openReader(boolean cdghE54s) throws IOException {
						throw new UnsupportedOperationException();
					}

					public CharSequence getCharContent(boolean xBGDrcoL) throws IOException {
						throw new UnsupportedOperationException();
					}

					public Writer openWriter() throws IOException {
						throw new UnsupportedOperationException();
					}

					public long getLastModified() {
						return dqq8cHtb.getLastModified();
					}

					public boolean delete() {
						throw new UnsupportedOperationException();
					}
				};
			} catch (URISyntaxException jke8kR0O) {
			} catch (IOException GcoCpZLR) {
			}
		}
		return null;
	}

}