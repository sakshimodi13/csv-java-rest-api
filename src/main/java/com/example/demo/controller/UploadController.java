package com.example.demo.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.User;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import java.util.*;

@Controller
public class UploadController {

	@GetMapping("/")
	public String index() {
		return "index";
	}

	@PostMapping("/upload-csv-file")
	public String uploadCSVFile(@RequestParam("file") MultipartFile file, Model model) {
		 List<String[]> elements = new ArrayList<String[]>();
	       

		// validate file
		if (file.isEmpty()) {
			model.addAttribute("message", "Please select a CSV file to upload.");
			model.addAttribute("status", false);
		} else {

			// parse CSV file to create a list of `User` objects
			try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
				
				String filename = file.getName();
				/*
				 * if(filename == "gaussian.csv") { String[] columnNames = new String[] {
				 * "att1", "att2", "att3", "att4", "att5", "att6", "att7", "label" }; Object[][]
				 * content = new Object[elements.size()][8];{ for(int i=1; i<elements.size();
				 * i++) { content[i][0] = elements.get(i)[0]; content[i][1] =
				 * elements.get(i)[1]; content[i][2] = elements.get(i)[2]; content[i][3] =
				 * elements.get(i)[3]; content[i][4] = elements.get(i)[4]; content[i][5] =
				 * elements.get(i)[5]; content[i][6] = elements.get(i)[6]; content[i][7] =
				 * elements.get(i)[7]; } }
				 * 
				 * } else if(filename == "multi.csv") { String[] columnNames = new String[] {
				 * "att1", "att2", "att3", "att4", "att5","label" }; Object[][] content = new
				 * Object[elements.size()][6];{ for(int i=1; i<elements.size(); i++) {
				 * content[i][0] = elements.get(i)[0]; content[i][1] = elements.get(i)[1];
				 * content[i][2] = elements.get(i)[2]; content[i][3] = elements.get(i)[3];
				 * content[i][4] = elements.get(i)[4]; content[i][5] = elements.get(i)[5];
				 * 
				 * } }
				 * 
				 * }
				 * 
				 * else if(filename == "iris.csv") { String[] columnNames = new String[] { "a1",
				 * "a2", "a3", "a4", "id","label" }; Object[][] content = new
				 * Object[elements.size()][6];{ for(int i=1; i<elements.size(); i++) {
				 * content[i][0] = elements.get(i)[0]; content[i][1] = elements.get(i)[1];
				 * content[i][2] = elements.get(i)[2]; content[i][3] = elements.get(i)[3];
				 * content[i][4] = elements.get(i)[4]; content[i][5] = elements.get(i)[5];
				 * 
				 * } }
				 * 
				 * }
				 */


				// create csv bean reader
				CsvToBean<User> csvToBean = new CsvToBeanBuilder(reader).withType(User.class)
						.withIgnoreLeadingWhiteSpace(true).build();

				// convert `CsvToBean` object to list of users
				List<User> users = csvToBean.parse();

				// Build json body
				String median = UploadController.getJsonResponse("json body");

				// write CSV
				ArrayList<String> list = new ArrayList<String>();
				BufferedWriter writer = null;
				writer = new BufferedWriter(new FileWriter("c:\\Assignment\\output_" + filename));
				
				writer.write(median);
				writer.write("\n");
				
				// TODO: save users in DB?

				// save users list on model
				model.addAttribute("median", median);
				model.addAttribute("users", users);
				model.addAttribute("status", true);

			} catch (Exception ex) {
				model.addAttribute("message", "An error occurred while processing the CSV file.");
				model.addAttribute("status", false);
			}
		}

		return "file-upload-status";
	}

	public static String getJsonResponse(String searchProduct) throws Exception {

		String url = "http://localhost:8030/median";
		String requestBody = "{\"json\": \"" + searchProduct + "\"}";

		URL obj = new URL(url);

		HttpURLConnection connection = (HttpURLConnection) obj.openConnection();

		connection.setDoOutput(true);
		connection.setRequestMethod("POST");
		connection.setRequestProperty("Content-Type", "application/json");

		OutputStream outputStream = connection.getOutputStream(); // <-- I get an exception.

		outputStream.write(requestBody.getBytes());
		outputStream.flush();

		BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}

		in.close();

		return response.toString();

	}
}
