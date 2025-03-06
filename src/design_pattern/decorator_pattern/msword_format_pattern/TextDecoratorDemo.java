package design_pattern.decorator_pattern.msword_format_pattern;

interface Text {
    String format();
}

class PlainText implements Text {
    public String format() { return "Hello"; }
}

class BoldText implements Text {
    private Text text;
    public BoldText(Text text) { this.text = text; }
    public String format() { return "**" + text.format() + "**"; }
}

class ItalicText implements Text {
    private Text text;
    public ItalicText(Text text) { this.text = text; }
    public String format() { return "_" + text.format() + "_"; }
}

public class TextDecoratorDemo {
    public static void main(String[] args) {
        Text text = new ItalicText(new BoldText(new PlainText()));
        System.out.println(text.format()); // Output: _**Hello**_
    }
}
