class n6037299 {
	public void copyAffix(MailAffix BVVKlSew, long j7qZ08gJ, long cUqx17io) throws Exception {
		File lI7HxmFf = new File(this.getResDir(j7qZ08gJ) + BVVKlSew.getAttachAlias());
		if (lI7HxmFf.exists()) {
			File fAe5JltQ = new File(this.getResDir(cUqx17io) + BVVKlSew.getAttachAlias());
			if (!fAe5JltQ.exists()) {
				fAe5JltQ.createNewFile();
				BufferedOutputStream Vtn14GZg = new BufferedOutputStream(new FileOutputStream(fAe5JltQ));
				BufferedInputStream mkQlC9XV = new BufferedInputStream(new FileInputStream(lI7HxmFf));
				int a1rcz5vI;
				while ((a1rcz5vI = mkQlC9XV.read()) != -1) {
					Vtn14GZg.write(a1rcz5vI);
				}
				Vtn14GZg.flush();
				mkQlC9XV.close();
				Vtn14GZg.close();
			}
		} else {
			log.debug(lI7HxmFf.getAbsolutePath() + lI7HxmFf.getName() + "??????????????????????????");
		}
	}

}