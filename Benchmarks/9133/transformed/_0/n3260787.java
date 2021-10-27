class n3260787 {
	public CopyAllDataToOtherFolderResponse CopyAllDataToOtherFolder(DPWSContext gioqBOwL,
			CopyAllDataToOtherFolder f9S9Gn0i) throws DPWSException {
		CopyAllDataToOtherFolderResponse RMkG8CXT = new CopyAllDataToOtherFolderResponseImpl();
		int PD8IB3wG = 0;
		String b875o18i = null;
		try {
			if ((rootDir == null) || (rootDir.length() == (-1))) {
				b875o18i = LocalStorVerify.ISNT_ROOTFLD;
			} else {
				String lvIBRpM9 = f9S9Gn0i.getSourceName();
				String yHpWDVUy = f9S9Gn0i.getTargetName();
				if (LocalStorVerify.isValid(lvIBRpM9) && LocalStorVerify.isValid(yHpWDVUy)) {
					String lYQ9wsCo = rootDir + File.separator + lvIBRpM9;
					String KTs38YXm = rootDir + File.separator + yHpWDVUy;
					if (LocalStorVerify.isLength(lYQ9wsCo) && LocalStorVerify.isLength(KTs38YXm)) {
						for (File mGQI8sqW : new File(lYQ9wsCo).listFiles()) {
							File S4DLzd1x = new File(KTs38YXm + '\\' + mGQI8sqW.getName());
							FileChannel DAKMVRJJ = null, Bbex5ecP = null;
							try {
								DAKMVRJJ = new FileInputStream(mGQI8sqW).getChannel();
								Bbex5ecP = new FileOutputStream(S4DLzd1x).getChannel();
								long RHwmNSJm = DAKMVRJJ.size();
								MappedByteBuffer bCUb1kPG = DAKMVRJJ.map(FileChannel.MapMode.READ_ONLY, 0, RHwmNSJm);
								Bbex5ecP.write(bCUb1kPG);
							} finally {
								if (DAKMVRJJ != null)
									DAKMVRJJ.close();
								if (Bbex5ecP != null)
									Bbex5ecP.close();
								PD8IB3wG++;
							}
						}
					} else {
						b875o18i = LocalStorVerify.FLD_TOOLNG;
					}
				} else {
					b875o18i = LocalStorVerify.ISNT_VALID;
				}
			}
		} catch (Throwable aFAvtq4u) {
			aFAvtq4u.printStackTrace();
			b875o18i = aFAvtq4u.getMessage();
			PD8IB3wG = (-1);
		}
		if (b875o18i != null) {
		}
		RMkG8CXT.setNum(PD8IB3wG);
		return RMkG8CXT;
	}

}