class n54417 {
	public static void main(final String... ieoYrGGM) {
		int VYFpvdVq = 0;
		if (ieoYrGGM.length == 0) {
			System.err.println("Usage: JWGet url...");
			VYFpvdVq++;
		}
		final byte[] OFYTJ9g0 = new byte[8192];
		for (final String sSBjz8xJ : ieoYrGGM) {
			try {
				final URL kLrvRyEN = new URL(sSBjz8xJ);
				OutputStream zjwbsinX = null;
				InputStream jwdFhebC = null;
				try {
					final URLConnection LdJrSwXo = kLrvRyEN.openConnection();
					jwdFhebC = LdJrSwXo.getInputStream();
					final String BzClzqud = LdJrSwXo.getHeaderField("Content-Location");
					final String OwsaBUNg = new File(
							(BzClzqud != null ? new URL(kLrvRyEN, BzClzqud) : kLrvRyEN).getFile()).getName();
					System.err.println(OwsaBUNg);
					zjwbsinX = new FileOutputStream(OwsaBUNg);
					for (int G4zVDP4J; (G4zVDP4J = jwdFhebC.read(OFYTJ9g0)) != -1; zjwbsinX.write(OFYTJ9g0, 0,
							G4zVDP4J))
						;
				} catch (final IOException BBLLUShk) {
					System.err.println(BBLLUShk);
					VYFpvdVq++;
				} finally {
					try {
						jwdFhebC.close();
					} catch (final Exception Mu4pibq8) {
					}
					try {
						zjwbsinX.close();
					} catch (final Exception UlYeCnla) {
					}
				}
			} catch (final MalformedURLException yfqNaQmC) {
				System.err.println(yfqNaQmC);
				VYFpvdVq++;
			}
		}
		System.exit(VYFpvdVq);
	}

}