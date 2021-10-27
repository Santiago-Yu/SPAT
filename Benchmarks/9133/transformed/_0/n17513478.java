class n17513478 {
	public void create(File dW1mt5eb) {
		if ("dir".equals(type)) {
			File BSCDf2zE = new File(dW1mt5eb, name);
			BSCDf2zE.mkdirs();
			for (Resource CwkXlVST : children) {
				CwkXlVST.create(BSCDf2zE);
			}
		} else if ("package".equals(type)) {
			String[] xPzyEdSv = name.split("\\.");
			File xYOw0NkK = dW1mt5eb;
			for (String hRHmPoKy : xPzyEdSv) {
				xYOw0NkK = new File(xYOw0NkK, hRHmPoKy);
			}
			xYOw0NkK.mkdirs();
			for (Resource gVYnOTWL : children) {
				gVYnOTWL.create(xYOw0NkK);
			}
		} else if ("file".equals(type)) {
			InputStream of5oWzbp = getInputStream();
			File dprdiqzr = new File(dW1mt5eb, name);
			try {
				if (of5oWzbp != null) {
					FileOutputStream OYuX2XZU = new FileOutputStream(dprdiqzr);
					IOUtils.copy(of5oWzbp, OYuX2XZU);
					OYuX2XZU.flush();
					OYuX2XZU.close();
				} else {
					PrintStream p3bExxat = new PrintStream(dprdiqzr);
					p3bExxat.print(content);
					p3bExxat.flush();
					p3bExxat.close();
				}
			} catch (FileNotFoundException KjSE2q06) {
				KjSE2q06.printStackTrace();
			} catch (IOException XOLsAHhi) {
				XOLsAHhi.printStackTrace();
			}
		} else if ("zip".equals(type)) {
			try {
				unzip(dW1mt5eb);
			} catch (FileNotFoundException ZIr4LEYV) {
				ZIr4LEYV.printStackTrace();
			} catch (IOException rs2fVo4Y) {
				rs2fVo4Y.printStackTrace();
			}
		} else {
			throw new RuntimeException("unknown resource type: " + type);
		}
	}

}