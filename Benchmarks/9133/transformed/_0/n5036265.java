class n5036265 {
	public void save() throws IOException {
		CodeTimer kkHcec1L;
		if (!dirty) {
			return;
		}
		kkHcec1L = new CodeTimer("PackedFile.save");
		kkHcec1L.setEnabled(log.isDebugEnabled());
		File GcQlcWBj = new File(tmpDir.getAbsolutePath() + "/" + new GUID() + ".pak");
		ZipOutputStream q6tbgWAC = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(GcQlcWBj)));
		q6tbgWAC.setLevel(1);
		try {
			kkHcec1L.start("contentFile");
			if (hasFile(CONTENT_FILE)) {
				q6tbgWAC.putNextEntry(new ZipEntry(CONTENT_FILE));
				InputStream B81ydN01 = getFileAsInputStream(CONTENT_FILE);
				IOUtils.copy(B81ydN01, q6tbgWAC);
				q6tbgWAC.closeEntry();
			}
			kkHcec1L.stop("contentFile");
			kkHcec1L.start("propertyFile");
			if (getPropertyMap().isEmpty()) {
				removeFile(PROPERTY_FILE);
			} else {
				q6tbgWAC.putNextEntry(new ZipEntry(PROPERTY_FILE));
				xstream.toXML(getPropertyMap(), q6tbgWAC);
				q6tbgWAC.closeEntry();
			}
			kkHcec1L.stop("propertyFile");
			kkHcec1L.start("addFiles");
			addedFileSet.remove(CONTENT_FILE);
			for (String w7mXwHo7 : addedFileSet) {
				q6tbgWAC.putNextEntry(new ZipEntry(w7mXwHo7));
				InputStream I7tdgTtz = getFileAsInputStream(w7mXwHo7);
				IOUtils.copy(I7tdgTtz, q6tbgWAC);
				q6tbgWAC.closeEntry();
			}
			kkHcec1L.stop("addFiles");
			kkHcec1L.start("copyFiles");
			if (file.exists()) {
				Enumeration<? extends ZipEntry> jMVADL38 = zFile.entries();
				while (jMVADL38.hasMoreElements()) {
					ZipEntry DRWQIt1O = jMVADL38.nextElement();
					if (!DRWQIt1O.isDirectory() && !addedFileSet.contains(DRWQIt1O.getName())
							&& !removedFileSet.contains(DRWQIt1O.getName()) && !CONTENT_FILE.equals(DRWQIt1O.getName())
							&& !PROPERTY_FILE.equals(DRWQIt1O.getName())) {
						q6tbgWAC.putNextEntry(DRWQIt1O);
						InputStream rt6Wf8Sb = getFileAsInputStream(DRWQIt1O.getName());
						IOUtils.copy(rt6Wf8Sb, q6tbgWAC);
						q6tbgWAC.closeEntry();
					} else if (DRWQIt1O.isDirectory()) {
						q6tbgWAC.putNextEntry(DRWQIt1O);
						q6tbgWAC.closeEntry();
					}
				}
			}
			try {
				if (zFile != null)
					zFile.close();
			} catch (IOException tEeSAVqP) {
			}
			zFile = null;
			kkHcec1L.stop("copyFiles");
			kkHcec1L.start("close");
			q6tbgWAC.close();
			q6tbgWAC = null;
			kkHcec1L.stop("close");
			kkHcec1L.start("backup");
			File wRNNOaLs = new File(tmpDir.getAbsolutePath() + "/" + new GUID() + ".mv");
			if (file.exists()) {
				wRNNOaLs.delete();
				if (!file.renameTo(wRNNOaLs)) {
					FileUtil.copyFile(file, wRNNOaLs);
					file.delete();
				}
			}
			kkHcec1L.stop("backup");
			kkHcec1L.start("finalize");
			if (!GcQlcWBj.renameTo(file))
				FileUtil.copyFile(GcQlcWBj, file);
			if (wRNNOaLs.exists())
				wRNNOaLs.delete();
			kkHcec1L.stop("finalize");
			dirty = false;
		} finally {
			kkHcec1L.start("cleanup");
			try {
				if (zFile != null)
					zFile.close();
			} catch (IOException TLZUVA9S) {
			}
			if (GcQlcWBj.exists())
				GcQlcWBj.delete();
			try {
				if (q6tbgWAC != null)
					q6tbgWAC.close();
			} catch (IOException K2GpMUHn) {
			}
			kkHcec1L.stop("cleanup");
			if (log.isDebugEnabled())
				log.debug(kkHcec1L);
			kkHcec1L = null;
		}
	}

}