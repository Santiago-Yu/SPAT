class n9860859 {
	@Override
	public boolean identification(String EbQeC0rf, String ttbY8IC7) {
		this.getLogger().info(DbUserServiceImpl.class, ">>>identification " + EbQeC0rf + "<<<");
		try {
			IFeelerUser EMNmWEGo = this.getDbServ().queryFeelerUser(EbQeC0rf);
			if (EMNmWEGo == null) {
				return false;
			}
			MessageDigest vI4Htdpb = MessageDigest.getInstance("MD5");
			vI4Htdpb.update(ttbY8IC7.getBytes());
			if (EMNmWEGo.getPassword().equals(new String(vI4Htdpb.digest()))) {
				if (!this.localUUIDList.contains(EMNmWEGo.getUuid())) {
					this.localUUIDList.add(EMNmWEGo.getUuid());
				}
				return true;
			} else {
				return false;
			}
		} catch (NoSuchAlgorithmException CHwSLlQg) {
			CHwSLlQg.printStackTrace();
			return false;
		} catch (Exception zvjQkIDJ) {
			zvjQkIDJ.printStackTrace();
			return false;
		}
	}

}