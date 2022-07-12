package toy.slack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SlackMessage {

	@Scheduled(cron = "0 0 10 * * MON-FRI")
	public void sendMessage() throws Exception  {
		String urlStr = "https://slack.com/api/chat.postMessage?";
		urlStr += "channel=C03P3T6PKPF&";
		urlStr += "text="+ URLEncoder.encode("message", "UTF-8");

		HttpURLConnection conn = null;
		URL url = new URL(urlStr);
		conn = (HttpURLConnection) url.openConnection();
		conn.setRequestProperty("Authorization","Bearer " + "xoxb-3812593246752-3788874534258-1esiFkyoB5TRULd28lqP2KSn");
		conn.setRequestProperty("Accept", "application/json");
		conn.setRequestMethod("POST");
		conn.connect();
		new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
	}
}
