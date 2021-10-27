class n5545050 {
	public void sendFile(File VcwNf90n, String vRbAeuop, String hk4mjN0D) throws SearchLibException {
		response.setContentType(hk4mjN0D);
		response.addHeader("Content-Disposition", "attachment; filename=" + vRbAeuop);
		FileInputStream QmSSq7QL = null;
		try {
			QmSSq7QL = new FileInputStream(VcwNf90n);
			ServletOutputStream ToRgp15R = getOutputStream();
			IOUtils.copy(QmSSq7QL, ToRgp15R);
			ToRgp15R.close();
		} catch (FileNotFoundException WbympBDY) {
			throw new SearchLibException(WbympBDY);
		} catch (IOException WjKkBCMy) {
			throw new SearchLibException(WjKkBCMy);
		} finally {
			if (QmSSq7QL != null)
				IOUtils.closeQuietly(QmSSq7QL);
		}
	}

}