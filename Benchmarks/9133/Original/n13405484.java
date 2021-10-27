class n13405484{
    public boolean send(String number, String message) throws IOException {
        init();
        message = message.substring(0, Math.min(MAX_PAYLOAD, message.length()));
        message = message.replace('\r', ' ');
        message = message.replace('\n', ' ');
        ActualFormParameters params = new ActualFormParameters();
        String strippedNumber = strip(number);
        ActualFormParameter number1Param;
        ActualFormParameter number2Param;
        if (strippedNumber.startsWith("00")) strippedNumber = "+" + strippedNumber.substring(2); else if (strippedNumber.startsWith("0")) strippedNumber = "+49" + strippedNumber.substring(1);
        number1Param = new ActualFormParameter(number1InputElement.getName(), strippedNumber.substring(0, 6));
        number2Param = new ActualFormParameter(number2InputElement.getName(), strippedNumber.substring(6));
        params.add(number1Param);
        params.add(number2Param);
        ActualFormParameter messageParam = new ActualFormParameter(messageInputElement.getName(), message);
        params.add(messageParam);
        ActualFormParameter letterCountParam = new ActualFormParameter(letterCountInputElement.getName(), "" + (MAX_PAYLOAD - message.length()));
        params.add(letterCountParam);
        form.addDefaultParametersTo(params);
        Reader r = form.submitForm(params, form.getNetscapeRequestProperties());
        String result = getStringFromReader(r);
        String pattern = "<meta http-equiv = \"refresh\" content=\"1; url=";
        int patternIndex = result.indexOf(pattern);
        if (patternIndex < 0) return false;
        int end = result.lastIndexOf("\">");
        if (end < 0) return false;
        String url = result.substring(patternIndex + pattern.length(), end);
        result = getStringFromReader(new InputStreamReader(new URL(url).openStream()));
        return result.indexOf("wurde erfolgreich verschickt") >= 0;
    }

}