package javaSwing;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;




public class weatherForecast {

	private static JFrame frame;
	private static JTextField locationField;
	private static JTextArea weatherDisplay;
	private static JButton fetchButton;
	private static String apikey = "28bd1c6d39443ad70c426073e90d7523";

	private static String fetchWeatherData(String City) {
		try {
			URL url = new URL("https://api.openweathermap.org/data/2.5/weather?q=" + City + "&appid=" + apikey
);
			HttpURLConnection Connection = (HttpURLConnection) url.openConnection();
			Connection.setRequestMethod("GET");
			BufferedReader Reader=new BufferedReader(new InputStreamReader(Connection.getInputStream()));
			String response="";
			String Line;
			while((Line=Reader.readLine())!=null) {
				response+=Line;
			}
			Reader.close();
			
			JSONObject jsonObject=(JSONObject) JSONValue.parse(response.toString());
			JSONObject mainObj = (JSONObject) JSONObject.get("main");
			double temperatureKelvin = (double) mainObj.get("temp");
			long humidity = (long)mainObj.get("humidity");
			
			double temperatureCelcius=temperatureKelvin-273.15;
			
			JSONArray weatherArray= (JSONArray)jsonObject.get("weather");
			JSONObject weather=(JSONObject) weatherArray.get(0);
			String description = (String) weather.get("description");
			return "description"+description+"\ntemperature :"+temperatureCelcius+"celcius\nhumidity"+humidity+"%";
		} catch (Exception e) {
			return "Failed to fetch wether data";
		}
	}

	public static void main(String[] args) {
		frame = new JFrame("Wheathe Forecast App");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 400);
		frame.setLayout(new FlowLayout());
		locationField = new JTextField(15);
		fetchButton = new JButton("Fetch Weather");
		weatherDisplay = new JTextArea(10, 30);
		weatherDisplay.setEditable(false);
		frame.add(new JLabel("Enter City Name"));
		frame.add(locationField);
		frame.add(fetchButton);
		frame.add(weatherDisplay);
		fetchButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String City = locationField.getText();
				String weatherInfo = fetchWeatherData(City);
				weatherDisplay.setText(weatherInfo);
			}

		});

		frame.setVisible(true);
	}
}
