class n11200354 {
	private boolean authenticate(String tXKrHoLj) {
		String S4afynWx = tXKrHoLj.substring(0, tXKrHoLj.indexOf(" "));
		String djS1eb15 = tXKrHoLj.substring(tXKrHoLj.indexOf(" ") + 1);
		if (!module.users.contains(S4afynWx)) {
			error = "so such user " + S4afynWx;
			return false;
		}
		try {
			LineNumberReader li3KTrCd = new LineNumberReader(new FileReader(module.secretsFile));
			String rnjL1tFo;
			while ((rnjL1tFo = li3KTrCd.readLine()) != null) {
				if (rnjL1tFo.startsWith(S4afynWx + ":")) {
					MessageDigest B1hIjCH6 = MessageDigest.getInstance("BrokenMD4");
					B1hIjCH6.update(new byte[4]);
					B1hIjCH6.update(rnjL1tFo.substring(rnjL1tFo.indexOf(":") + 1).getBytes("US-ASCII"));
					B1hIjCH6.update(challenge.getBytes("US-ASCII"));
					String hap1lVo4 = Util.base64(B1hIjCH6.digest());
					if (hap1lVo4.equals(djS1eb15)) {
						li3KTrCd.close();
						return true;
					}
				}
			}
			li3KTrCd.close();
		} catch (Exception lvXBWhjq) {
			logger.fatal(lvXBWhjq.toString());
			error = "server configuration error";
			return false;
		}
		error = "authentication failure for module " + module.name;
		return false;
	}

}