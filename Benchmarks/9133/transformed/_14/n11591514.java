class n11591514 {
	public HashCash(String cash) throws NoSuchAlgorithmException {
        myToken = cash;
        String[] parts = cash.split(":");
        myVersion = Integer.parseInt(parts[0]);
        if (myVersion < 0 || myVersion > 1) throw new IllegalArgumentException("Only supported versions are 0 and 1");
        if ((0 == myVersion && parts.length != 6) || (1 == myVersion && parts.length != 7)) throw new IllegalArgumentException("Improperly formed HashCash");
        try {
            int index = 1;
            if (1 == myVersion) myValue = Integer.parseInt(parts[index++]); else myValue = 0;
            SimpleDateFormat dateFormat = new SimpleDateFormat(dateFormatString);
            Calendar tempCal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
            tempCal.setTime(dateFormat.parse(parts[index++]));
            myResource = parts[index++];
            myExtensions = deserializeExtensions(parts[index++]);
            MessageDigest md = MessageDigest.getInstance("SHA1");
            md.update(cash.getBytes());
            byte[] tempBytes = md.digest();
            int tempValue = numberOfLeadingZeros(tempBytes);
            if (0 == myVersion) myValue = tempValue; else if (1 == myVersion) myValue = (tempValue > myValue ? myValue : tempValue);
        } catch (java.text.ParseException ex) {
            throw new IllegalArgumentException("Improperly formed HashCash", ex);
        }
    }

}