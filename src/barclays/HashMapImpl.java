package barclays;

import java.util.HashMap;

public class HashMapImpl {
	private static final int DEFAULT_CAPACITY = 16;

	static class Node {
		String key, value;
		Node next;

		public Node(String key, String value, Node next) {
			this.key = key;
			this.value = value;
			this.next = next;
		}

		public final String getKey() {
			return key;
		}

		public final String getValue() {
			return value;
		}

		public final String toString() {
			return key + "=" + value;
		}

		@Override
		public int hashCode() {
			return key.chars().boxed().hashCode();
		}

		@Override
		public boolean equals(Object obj) {
			Node other = (Node) obj;
			if (key == null) {
				if (other.key != null)
					return false;
			} else if (!key.equals(other.key))
				return false;
			if (next == null) {
				if (other.next != null)
					return false;
			} else if (!next.equals(other.next))
				return false;
			if (value == null) {
				if (other.value != null)
					return false;
			} else if (!value.equals(other.value))
				return false;
			return true;
		}

	}

}
