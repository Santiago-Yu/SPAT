class n7377245 {
	public void write(HttpServletRequest gz3nZH8l, HttpServletResponse ZO2ZU91Z, Object HAWY6oPR)
			throws IntrospectionException, IllegalAccessException, NoSuchMethodException, InvocationTargetException,
			IOException {
		ZO2ZU91Z.setContentType(contentType);
		final Object g7q3Zx5x;
		if (HttpRpcServer.HttpRpcOutput.class.isAssignableFrom(HAWY6oPR.getClass())) {
			HttpRpcServer.HttpRpcOutput F4aW8XCL = (HttpRpcServer.HttpRpcOutput) HAWY6oPR;
			g7q3Zx5x = F4aW8XCL.getResult();
		} else
			g7q3Zx5x = HAWY6oPR;
		if (g7q3Zx5x != null) {
			if (File.class.isAssignableFrom(g7q3Zx5x.getClass())) {
				File Fxm8pp3c = (File) g7q3Zx5x;
				InputStream WFYkr91X = null;
				try {
					WFYkr91X = new FileInputStream(Fxm8pp3c);
					IOUtils.copy(WFYkr91X, ZO2ZU91Z.getOutputStream());
				} finally {
					if (WFYkr91X != null)
						WFYkr91X.close();
				}
			} else if (InputStream.class.isAssignableFrom(g7q3Zx5x.getClass())) {
				InputStream X2QZtG6i = null;
				try {
					X2QZtG6i = (InputStream) g7q3Zx5x;
					IOUtils.copy(X2QZtG6i, ZO2ZU91Z.getOutputStream());
				} finally {
					if (X2QZtG6i != null)
						X2QZtG6i.close();
				}
			} else if (XFile.class.isAssignableFrom(g7q3Zx5x.getClass())) {
				XFile guws4ncH = (XFile) g7q3Zx5x;
				InputStream gCOdgs8n = null;
				try {
					gCOdgs8n = new XFileInputStream(guws4ncH);
					IOUtils.copy(gCOdgs8n, ZO2ZU91Z.getOutputStream());
				} finally {
					if (gCOdgs8n != null)
						gCOdgs8n.close();
				}
			}
			ZO2ZU91Z.getOutputStream().flush();
		}
	}

}