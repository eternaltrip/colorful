package com.colorful.nuoche.common.units;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;


/**
 * 读取Resource下面的字符文件
 * @author travel
 *
 */
public class TextFilesReader {
	
	
	/**
	 * 读取字符文件并返回字符集合
	 * @param filePath_name
	 * @return
	 */
	public  static List<String> read(String filePath_name) {
		Resource resource = new ClassPathResource(filePath_name);
		
		InputStream is = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		List<String> lines = null;
		try {
			is = resource.getInputStream();
			isr = new InputStreamReader(is,"UTF-8");
			br = new BufferedReader(isr);
			lines = new ArrayList<String>();
			String data = null;
			while ((data = br.readLine()) != null) {
				lines.add(data);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(isr != null) {
				try {
					isr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(is != null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return lines;
	}
}
