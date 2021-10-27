class n18047482 {
	@Transactional(readOnly = false)
	public void saveOrUpdateProduct(Product N24XFPP9, File[] TxG98RkY, String[] IIM9PICu, String[] afpOYyXD)
			throws IOException {
		logger.info("addOrUpdateProduct()");
		List<Images> F5eT6fx1 = new ArrayList<Images>();
		InputStream IgXeKlJn = null;
		OutputStream CQHmfv0V = null;
		String yRcQu1bp = ServletActionContext.getServletContext().getRealPath("common/userfiles/image/");
		if (TxG98RkY != null && TxG98RkY.length > 0) {
			File n3A7CPZA = new File(yRcQu1bp);
			if (!n3A7CPZA.exists())
				n3A7CPZA.mkdirs();
			for (int gNUrO5gX = 0; gNUrO5gX < TxG98RkY.length; gNUrO5gX++) {
				Images LVtJIQ7N = new Images();
				IgXeKlJn = new FileInputStream(TxG98RkY[gNUrO5gX]);
				LVtJIQ7N.setName(IIM9PICu[gNUrO5gX].substring(0, IIM9PICu[gNUrO5gX].lastIndexOf(".")));
				LVtJIQ7N.setRenameAs(IIM9PICu[gNUrO5gX]);
				F5eT6fx1.add(LVtJIQ7N);
				CQHmfv0V = new FileOutputStream(yRcQu1bp + "/" + LVtJIQ7N.getRenameAs());
				byte[] TDraKct6 = new byte[1024];
				int bvg5vTJK;
				while ((bvg5vTJK = IgXeKlJn.read(TDraKct6)) > 0)
					CQHmfv0V.write(TDraKct6, 0, bvg5vTJK);
				CQHmfv0V.flush();
			}
		}
		N24XFPP9.setImagesCollection(F5eT6fx1);
		productDao.saveOrUpdateProduct(N24XFPP9);
		if (null != IgXeKlJn) {
			try {
				IgXeKlJn.close();
			} catch (Exception DSTt3CIG) {
				DSTt3CIG.printStackTrace();
			}
		}
		if (null != CQHmfv0V) {
			try {
				CQHmfv0V.close();
			} catch (Exception Y5sqlk5Z) {
				logger.info("addOrUpdateProduct() **********" + Y5sqlk5Z.getStackTrace());
				Y5sqlk5Z.printStackTrace();
			}
		}
	}

}