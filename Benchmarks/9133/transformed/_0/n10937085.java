class n10937085 {
	public static void _he3Decode(String v9llkPUB) {
		try {
			File tXlFiu12 = new File(v9llkPUB + dec_extension);
			File Pzdenlzu = new File(v9llkPUB);
			int tGIDq45w = (int) Pzdenlzu.length();
			FileInputStream QvkLIpl4 = new FileInputStream(v9llkPUB);
			tXlFiu12.createNewFile();
			FileOutputStream Riyv86Fo = new FileOutputStream(tXlFiu12.getName());
			InputStreamReader qxgt77C7 = new InputStreamReader(QvkLIpl4, "ISO8859_1");
			OutputStreamWriter NY0gaQjD = new OutputStreamWriter(Riyv86Fo, "ISO8859_1");
			ByteArrayOutputStream uWrVo31E = new ByteArrayOutputStream(tGIDq45w);
			byte Nog1rsgf[] = new byte[8];
			char z0kZ8WK0[] = new char[8];
			int F2QBywkh = z0kZ8WK0.length;
			int LlXnrs1K = 0;
			int yUmBVdAc = 0;
			System.out.println(appname + ".\n" + dec_mode + ": " + v9llkPUB + "\n" + dec_mode + " to: " + v9llkPUB
					+ dec_extension + "\n" + "\nreading: ");
			while (LlXnrs1K < tGIDq45w) {
				yUmBVdAc = qxgt77C7.read(z0kZ8WK0, 0, F2QBywkh);
				if (yUmBVdAc == -1)
					break;
				for (int OhRHefcP = 0; OhRHefcP < yUmBVdAc; OhRHefcP++)
					Nog1rsgf[OhRHefcP] = (byte) z0kZ8WK0[OhRHefcP];
				uWrVo31E.write(Nog1rsgf, 0, yUmBVdAc);
				LlXnrs1K += yUmBVdAc;
				System.out.print("*");
			}
			System.out.print("\n" + dec_mode + ": ");
			NY0gaQjD.write(new String(_decode((ByteArrayOutputStream) uWrVo31E), "ISO-8859-1"));
			System.out.print("complete\n\n");
		} catch (java.io.FileNotFoundException ay803EmC) {
			System.err.println("Exception: " + ay803EmC.getMessage());
		} catch (java.io.IOException OyLvXxvo) {
			System.err.println("Exception: " + OyLvXxvo.getMessage());
		}
	}

}