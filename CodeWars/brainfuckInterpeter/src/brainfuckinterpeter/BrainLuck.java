
import java.util.*;

public class BrainLuck {

	final private String code;

	public BrainLuck(String code) {
		this.code = code;
	}

	private static int findEndParen(String str, int startParen) {
		int index = startParen;
		for (int parenDepth = 1; parenDepth > 0;) {
			index++;
			switch (str.charAt(index)) {
				case '[':
					parenDepth++;
					break;
				case ']':
					parenDepth--;
					break;
			}
		}
		return index;
	}

	public String process(String input) {
		int inputIndex = 0;
		StringBuilder output = new StringBuilder();
		ArrayList<Integer> data = new ArrayList<>();
		data.add(0);
		int ptr = 0;
		Stack<Integer> loopStack = new Stack<>();

		for (int i = 0; i < code.length(); i++) {
			switch (code.charAt(i)) {
				case '>':
					if (++ptr == data.size()) {
						data.add(0);
					}
					break;
				case '<':
					if (ptr == 0) {
						data.add(0, 0);
					} else {
						--ptr;
					}
					break;
				case '+':
					data.set(ptr, (data.get(ptr) + 1) % 256);
					break;
				case '-':
					data.set(ptr, (data.get(ptr) + 255) % 256);
					break;
				case '.':
					output.append((char) data.get(ptr).byteValue());
					break;
				case ',':
					data.set(ptr, (int) input.charAt(inputIndex++));
					break;
				case '[':
					if (data.get(ptr) == 0) {
						i = findEndParen(code, i);
					} else {
						loopStack.push(i);
					}
					break;
				case ']':
					if (data.get(ptr) == 0) {
						loopStack.pop();
					} else {
						i = loopStack.pop() - 1;
					}
			}
		}

		return output.toString();
	}
}
