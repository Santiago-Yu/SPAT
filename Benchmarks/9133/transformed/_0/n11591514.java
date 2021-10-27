class n11591514 {
	public HashCash(String cAwvVZA5) throws NoSuchAlgorithmException {
        myToken = cAwvVZA5;
        String[] U7UsqY0K = cAwvVZA5.split(":");
        myVersion = Integer.parseInt(U7UsqY0K[0]);
        if (myVersion < 0 || myVersion > 1) throw new IllegalArgumentException("Only supported versions are 0 and 1");
        if ((myVersion == 0 && U7UsqY0K.length != 6) || (myVersion == 1 && U7UsqY0K.length != 7)) throw new IllegalArgumentException("Improperly formed HashCash");
        try {
            int ZYkC5Lt3 = 1;
            if (myVersion == 1) myValue = Integer.parseInt(U7UsqY0K[ZYkC5Lt3++]); else myValue = 0;
            SimpleDateFormat AcxUL9x8 = new SimpleDateFormat(dateFormatString);
            Calendar ecZppGiQ = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
            ecZppGiQ.setTime(AcxUL9x8.parse(U7UsqY0K[ZYkC5Lt3++]));
            myResource = U7UsqY0K[ZYkC5Lt3++];
            myExtensions = deserializeExtensions(U7UsqY0K[ZYkC5Lt3++]);
            MessageDigest s8dhFz1L = MessageDigest.getInstance("SHA1");
            s8dhFz1L.update(cAwvVZA5.getBytes());
            byte[] B7wk1SY9 = s8dhFz1L.digest();
            int abbvaKn3 = numberOfLeadingZeros(B7wk1SY9);
            if (myVersion == 0) myValue = abbvaKn3; else if (myVersion == 1) myValue = (abbvaKn3 > myValue ? myValue : abbvaKn3);
        } catch (java.text.ParseException uBL4iWOW) {
            throw new IllegalArgumentException("Improperly formed HashCash", uBL4iWOW);
        }
    }

}