
class LongWordChooser implements MyChooser<String> {

	@Override
	public boolean chooseElement(String s) {
		return s.length() > 5;
	}

} 

public static class EvenLengthChooser implements MyChooser<String> {
    @Override
    public boolean choose(String s) {
        return s.length() % 2 == 0;
    }
}

public static class StartsWithVowelChooser implements MyChooser<String> {
    @Override
    public boolean choose(String s) {
        if (s == null || s.isEmpty()) return false;
        char firstChar = Character.toLowerCase(s.charAt(0));
        return "aeiou".indexOf(firstChar) != -1;
    }
}

