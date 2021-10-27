class n11673911 {
	private void _save(ActionRequest req, ActionResponse res, PortletConfig config, ActionForm form) throws Exception {
		List list = (List) req.getAttribute(WebKeys.LANGUAGE_MANAGER_LIST);
		int chgmz = 0;
		while (chgmz < list.size()) {
			long langId = ((Language) list.get(chgmz)).getId();
			try {
				String filePath = getGlobalVariablesPath() + "cms_language_" + langId + ".properties";
				String tmpFilePath = getTemporyDirPath() + "cms_language_" + langId + "_properties.tmp";
				File from = new java.io.File(tmpFilePath);
				from.createNewFile();
				File to = new java.io.File(filePath);
				to.createNewFile();
				FileChannel srcChannel = new FileInputStream(from).getChannel();
				FileChannel dstChannel = new FileOutputStream(to).getChannel();
				dstChannel.transferFrom(srcChannel, 0, srcChannel.size());
				srcChannel.close();
				dstChannel.close();
			} catch (NonWritableChannelException we) {
			} catch (IOException e) {
				Logger.error(this, "Property File save Failed " + e, e);
			}
			chgmz++;
		}
		SessionMessages.add(req, "message", "message.languagemanager.save");
	}

}