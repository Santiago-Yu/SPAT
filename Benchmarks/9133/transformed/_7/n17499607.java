class n17499607 {
	@Override
	public Void doInBackground() {
		java.io.FileOutputStream fos = null;
		try {
			String localFile = "JavaPointNew.jar";
			java.io.BufferedInputStream in = null;
			try {
				HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
				contentLength = httpConn.getContentLength();
				if (contentLength == -1) {
					System.out.println("unknown content length");
				} else {
					System.out.println("content length: " + contentLength + " bytes");
				}
				in = new java.io.BufferedInputStream(httpConn.getInputStream());
			} catch (IOException ex) {
				ex.printStackTrace();
			}
			fos = new java.io.FileOutputStream(localFile);
			java.io.BufferedOutputStream bout = new BufferedOutputStream(fos, 1024);
			byte[] data = new byte[1024];
			int x = 0;
			int bytes = 0;
			while ((x = in.read(data, 0, 1024)) >= 0) {
				bout.write(data, 0, x);
				bytes = bytes + (x);
				setProgress((int) ((Math.min(bytes * 100 / contentLength, 100)) + .5));
			}
			bout.close();
			in.close();
			File jarFile = mainFrame.presentationFile;
			if (jarFile.exists()) {
				final File temporaryJarFile = Utilities.createTemporaryFile("presentation", ".jar", false, null);
				final JarFile updatedJarFile = new JarFile(localFile);
				final JarOutputStream output = new JarOutputStream(new FileOutputStream(temporaryJarFile));
				for (final JarEntry entry : Utilities.toList(updatedJarFile.entries())) {
					if (!entry.getName().startsWith(Constants.JAR_ENTRY_PRESENTATION_PREFIX)) {
						final InputStream entryStream = updatedJarFile.getInputStream(entry);
						output.putNextEntry(entry);
						Utilities.write(entryStream, output);
					}
				}
				new SlidesWriter().write(mainFrame.getSlides(), output);
				jarFile.delete();
				new File(localFile).delete();
				if (!temporaryJarFile.renameTo(jarFile)) {
					throw new RuntimeException("Failed to update " + jarFile);
				}
			} else {
				new SlidesWriter().write(mainFrame.getSlides(), new JarOutputStream(new FileOutputStream(jarFile)));
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			try {
				fos.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return null;
	}

}