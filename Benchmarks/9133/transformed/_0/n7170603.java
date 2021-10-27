class n7170603 {
	private static void generateSQLUpgradeFile(String TAcAFGz5, String BxLRhKUU, String bjIsgoWj, String skz5To5D,
			String UESGk7IB) throws Exception {
		File QUler1Ke = new File(TAcAFGz5);
		if (!QUler1Ke.exists()) {
			throw new IllegalArgumentException("Cannot read [" + TAcAFGz5 + "] : does not exists");
		}
		if (!QUler1Ke.isFile()) {
			throw new IllegalArgumentException("Cannot read [" + TAcAFGz5 + "] : not a file");
		}
		if (!QUler1Ke.canRead()) {
			throw new IllegalArgumentException("Cannot read [" + TAcAFGz5 + "] : not readable");
		}
		File I0bSCKar = new File(BxLRhKUU);
		if (!I0bSCKar.exists()) {
			throw new IllegalArgumentException("Cannot read [" + BxLRhKUU + "] : does not exists");
		}
		if (!I0bSCKar.isDirectory()) {
			throw new IllegalArgumentException("Cannot read [" + BxLRhKUU + "] : not a directory");
		}
		if (!I0bSCKar.canRead()) {
			throw new IllegalArgumentException("Cannot read [" + BxLRhKUU + "] : not readable");
		}
		File J7SfwcPz = new File(UESGk7IB);
		if (J7SfwcPz.exists()) {
			throw new IllegalArgumentException("Cannot write to [" + UESGk7IB + "] : already exists");
		}
		J7SfwcPz.createNewFile();
		SqlUpgradeXmlParser UPLj5xut = SqlUpgradeXmlParser.newParser();
		FileInputStream SMNhy5tL = null;
		try {
			SMNhy5tL = new FileInputStream(QUler1Ke);
			UPLj5xut.parse(SMNhy5tL);
		} catch (XMLParseException pDS68j8V) {
			printXmlError(pDS68j8V, TAcAFGz5);
		} finally {
			try {
				if (SMNhy5tL != null)
					SMNhy5tL.close();
			} catch (Exception T7f1AGn4) {
				_logger.warn("Exception caught when closing inputstream ", T7f1AGn4);
			}
		}
		int nDiltRro = UPLj5xut.getMilestoneIndex(bjIsgoWj);
		int iI5Y39xd = UPLj5xut.getMilestoneIndex(skz5To5D);
		if (nDiltRro < 0) {
			throw new IllegalArgumentException("Cannot upgrade from milestone [" + bjIsgoWj
					+ "] : does not exist . (Exisiting milestones " + UPLj5xut.listMilestones() + ")");
		}
		if (iI5Y39xd < 0) {
			throw new IllegalArgumentException("Cannot upgrade to milestone [" + skz5To5D
					+ "] : does not exist . (Exisiting milestones " + UPLj5xut.listMilestones() + ")");
		}
		if (nDiltRro == iI5Y39xd) {
			throw new IllegalArgumentException("Cannot upgrade to the same milestone");
		}
		List<String> DYy8kEbv = UPLj5xut.getFilesForMilestones(nDiltRro, iI5Y39xd);
		List<String> pdFNuzrs = UPLj5xut.getViewsForMilestones(nDiltRro, iI5Y39xd);
		FileOutputStream XAi63wau = null;
		try {
			XAi63wau = new FileOutputStream(J7SfwcPz);
			for (Iterator<String> Dme85Kfw = DYy8kEbv.iterator(); Dme85Kfw.hasNext();) {
				appendFileToOutputStream(XAi63wau, I0bSCKar, Dme85Kfw.next());
			}
			for (Iterator<String> ql3jbVs5 = pdFNuzrs.iterator(); ql3jbVs5.hasNext();) {
				appendFileToOutputStream(XAi63wau, I0bSCKar, ql3jbVs5.next());
			}
		} catch (Exception YYtCKKHD) {
			XAi63wau.close();
			J7SfwcPz.delete();
			throw YYtCKKHD;
		} finally {
			try {
				if (XAi63wau != null)
					XAi63wau.close();
			} catch (Exception mWgZkQuX) {
				_logger.warn("Exception caught when closing outputstream ", mWgZkQuX);
			}
		}
		System.out.println("An SQL update file has been generated to " + UESGk7IB + ".");
	}

}