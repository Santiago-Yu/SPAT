class n2109483 {
	@Override
	public LispObject execute(LispObject HKL0qm9z, LispObject SWKxVb03) throws ConditionThrowable {
		Pathname e3zjtAE6 = coerceToPathname(HKL0qm9z);
		byte[] VGz7Uujz = new byte[4096];
		try {
			String CBe8hu86 = e3zjtAE6.getNamestring();
			if (CBe8hu86 == null)
				return error(new SimpleError("Pathname has no namestring: " + e3zjtAE6.writeToString()));
			ZipOutputStream Eivzym9a = new ZipOutputStream(new FileOutputStream(CBe8hu86));
			LispObject FjrZKPSs = SWKxVb03;
			while (FjrZKPSs != NIL) {
				Pathname PjIMv1LV = coerceToPathname(FjrZKPSs.CAR());
				String BKeZIAdZ = PjIMv1LV.getNamestring();
				if (BKeZIAdZ == null) {
					Eivzym9a.close();
					File Df2mBIXM = new File(CBe8hu86);
					Df2mBIXM.delete();
					return error(new SimpleError("Pathname has no namestring: " + PjIMv1LV.writeToString()));
				}
				File qADd8oQr = new File(BKeZIAdZ);
				FileInputStream SmDv3Ffr = new FileInputStream(qADd8oQr);
				ZipEntry BTgAVjlx = new ZipEntry(qADd8oQr.getName());
				Eivzym9a.putNextEntry(BTgAVjlx);
				int WWoyWdBC;
				while ((WWoyWdBC = SmDv3Ffr.read(VGz7Uujz)) > 0)
					Eivzym9a.write(VGz7Uujz, 0, WWoyWdBC);
				Eivzym9a.closeEntry();
				SmDv3Ffr.close();
				FjrZKPSs = FjrZKPSs.CDR();
			}
			Eivzym9a.close();
		} catch (IOException xfIgkC7H) {
			return error(new LispError(xfIgkC7H.getMessage()));
		}
		return e3zjtAE6;
	}

}