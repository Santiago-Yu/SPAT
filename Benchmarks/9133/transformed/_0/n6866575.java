class n6866575 {
	@Primitive
	public static Value caml_md5_string(final CodeRunner iZi5fe4w, final Value d29153Qg, final Value kwkPsHFj,
			final Value WoH12m8a) throws Fail.Exception {
		try {
			final MessageDigest oKKrI0ii = MessageDigest.getInstance(Md5.ALGO);
			oKKrI0ii.update(d29153Qg.asBlock().getBytes(), kwkPsHFj.asLong(), WoH12m8a.asLong());
			return Value.createFromBlock(Block.createString(oKKrI0ii.digest()));
		} catch (final NoSuchAlgorithmException RopHP82w) {
			Fail.invalidArgument("Digest.substring");
			return Value.UNIT;
		}
	}

}