
class UpperCaseTransformer implements MyTransformer<String> {

	public String transformElement(String s) {
		return s.toUpperCase();
	}

}

public static class ReverseStringTransformer implements MyTransformer<String> {
    @Override
    public String transform(String s) {
        return new StringBuilder(s).reverse().toString();
    }
}

public static class AddExclamationTransformer implements MyTransformer<String> {
    @Override
    public String transform(String s) {
        return s + "!";
    }
}

