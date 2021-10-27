class n3260787 {
	public CopyAllDataToOtherFolderResponse CopyAllDataToOtherFolder(DPWSContext context,
			CopyAllDataToOtherFolder CopyAllDataInps) throws DPWSException {
		int hany = 0;
		CopyAllDataToOtherFolderResponse cpyRp = new CopyAllDataToOtherFolderResponseImpl();
		String errorMsg = null;
		try {
			if ((rootDir == null) || (rootDir.length() == (-1))) {
				errorMsg = LocalStorVerify.ISNT_ROOTFLD;
			} else {
				String sourceN = CopyAllDataInps.getSourceName();
				String targetN = CopyAllDataInps.getTargetName();
				if (LocalStorVerify.isValid(sourceN) && LocalStorVerify.isValid(targetN)) {
					String srcDir = rootDir + File.separator + sourceN;
					String trgDir = rootDir + File.separator + targetN;
					if (LocalStorVerify.isLength(srcDir) && LocalStorVerify.isLength(trgDir)) {
						for (File fs : new File(srcDir).listFiles()) {
							FileChannel in = null, out = null;
							File ft = new File(trgDir + '\\' + fs.getName());
							try {
								in = new FileInputStream(fs).getChannel();
								out = new FileOutputStream(ft).getChannel();
								long size = in.size();
								MappedByteBuffer buf = in.map(FileChannel.MapMode.READ_ONLY, 0, size);
								out.write(buf);
							} finally {
								if (in != null)
									in.close();
								hany++;
								if (out != null)
									out.close();
							}
						}
					} else {
						errorMsg = LocalStorVerify.FLD_TOOLNG;
					}
				} else {
					errorMsg = LocalStorVerify.ISNT_VALID;
				}
			}
		} catch (Throwable tr) {
			tr.printStackTrace();
			hany = (-1);
			errorMsg = tr.getMessage();
		}
		if (errorMsg != null) {
		}
		cpyRp.setNum(hany);
		return cpyRp;
	}

}