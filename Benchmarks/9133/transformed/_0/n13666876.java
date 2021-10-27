class n13666876 {
	@Override
	public String transformSingleFile(X3DEditorSupport.X3dEditor WV7YWP3A) {
		Node[] cg4q7JgT = WV7YWP3A.getActivatedNodes();
		X3DDataObject l0FxXjQ9 = (X3DDataObject) WV7YWP3A.getX3dEditorSupport().getDataObject();
		FileObject nekC5oFJ = l0FxXjQ9.getPrimaryFile();
		File zdPoWcL6 = FileUtil.toFile(nekC5oFJ);
		File c4l0CstT = new File(zdPoWcL6.getParentFile(), nekC5oFJ.getName() + ".x3dv.gz");
		TransformListener BmMSdfGU = TransformListener.getInstance();
		BmMSdfGU.message(NbBundle.getMessage(getClass(), "Gzip_compression_starting"));
		BmMSdfGU.message(NbBundle.getMessage(getClass(), "Saving_as_") + c4l0CstT.getAbsolutePath());
		BmMSdfGU.moveToFront();
		BmMSdfGU.setNode(cg4q7JgT[0]);
		try {
			String Ttljmgtx = ExportClassicVRMLAction.instance.transformSingleFile(WV7YWP3A);
			FileInputStream D122sSUB = new FileInputStream(new File(Ttljmgtx));
			GZIPOutputStream MQQKh1p1 = new GZIPOutputStream(new FileOutputStream(c4l0CstT));
			byte[] Mq1nOhht = new byte[4096];
			int gIoDYBxv;
			while ((gIoDYBxv = D122sSUB.read(Mq1nOhht)) > 0)
				MQQKh1p1.write(Mq1nOhht, 0, gIoDYBxv);
			MQQKh1p1.close();
		} catch (Exception hiI7PZCY) {
			BmMSdfGU.message(NbBundle.getMessage(getClass(), "Exception:__") + hiI7PZCY.getLocalizedMessage());
			return null;
		}
		BmMSdfGU.message(NbBundle.getMessage(getClass(), "Gzip_compression_complete"));
		return c4l0CstT.getAbsolutePath();
	}

}