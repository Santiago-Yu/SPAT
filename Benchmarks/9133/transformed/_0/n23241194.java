class n23241194 {
	private void publishZip(LWMap Q9kLBIvW) {
		try {
			if (Q9kLBIvW.getFile() == null) {
				VueUtil.alert(VueResources.getString("dialog.mapsave.message"),
						VueResources.getString("dialog.mapsave.title"));
				return;
			}
			File lFRm37GY = PublishUtil.createZip(Q9kLBIvW, Publisher.resourceVector);
			InputStream dmu8kIpr = new BufferedInputStream(new FileInputStream(lFRm37GY));
			OutputStream VunLnp1W = new BufferedOutputStream(
					new FileOutputStream(ActionUtil.selectFile("Export to Zip File", "zip")));
			int JFfFYgry = (int) lFRm37GY.length();
			byte f5jVXKK4[] = new byte[JFfFYgry];
			while (dmu8kIpr.read(f5jVXKK4, 0, JFfFYgry) != -1)
				VunLnp1W.write(f5jVXKK4, 0, JFfFYgry);
			dmu8kIpr.close();
			VunLnp1W.close();
		} catch (Exception qoxcyL18) {
			System.out.println(qoxcyL18);
			VueUtil.alert(VUE.getDialogParent(),
					VueResources.getString("dialog.export.message") + qoxcyL18.getMessage(),
					VueResources.getString("dialog.export.title"), JOptionPane.ERROR_MESSAGE);
			qoxcyL18.printStackTrace();
		}
	}

}