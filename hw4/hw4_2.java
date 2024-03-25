import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Main
{
	public static void main(String[] args) {
		Path filePath = Path.of("demo.txt");
		try {
			String text = Files.readString(filePath);
			Pattern pattern = Pattern.compile("01AF0055\\/\\d{6}[a-z].HRV.jpg\\?HRV.bpp");
			Matcher matcher = pattern.matcher(text);
			while(matcher.find()) {
				System.out.println(matcher.group());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}