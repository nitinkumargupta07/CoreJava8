package lambdasinaction.chap8;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Stream;

public class Debugging {
	public static void main(String[] args) {
        List<Point> points = Arrays.asList(new Point(12, 2), new Point(132, 32) ,
        		new Point(132, 32), new Point(132, 32), new Point(132, 32), new Point(132, 32));
        points.stream().map(p -> p.getX()).forEach(System.out::println);
        Function<String, String>  function = (String text) -> ""+text;  
        Arrays.asList("nitin","kumar","gupta","son" ,"of","siyaram","gupta").stream().map(s  -> s).
        		forEach(s ->System.out.print("  "+s));
        
    }

	private static class Point {
		private int x;
		private int y;

		private Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public int getX() {
			return x;
		}

		public void setX(int x) {
			this.x = x;
		}
	}
}
