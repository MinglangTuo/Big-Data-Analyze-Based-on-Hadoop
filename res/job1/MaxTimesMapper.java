package com.annn.job1;

import java.io.IOException;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Mapper.Context;
import org.apache.hadoop.yarn.util.Times;

import com.annn.test.Zmtime;

/**
 * Mapper类
 * @author Administrator
 *
 */
public class MaxTimesMapper extends Mapper<LongWritable, Text, Text, IntWritable> {

	
	InetAddress addr;
	String ip ;
	String hostname;
	

	
	public void map(LongWritable key, Text value, Context context)
			throws IOException, InterruptedException {
		
	
		String teString = value.toString();
		
		teString = teString.toLowerCase();
		
		List<Zmtime> list = new ArrayList<Zmtime>();
	
		String demo = "";
		
		for(int i = 0 ;i+2<=teString.length();i++) {
			demo = teString.substring(i, i+2);
			char c1 = demo.toCharArray()[0];
			
			Integer value1 = Integer.valueOf(c1);
		
			char c2 = demo.toCharArray()[1];
			Integer value2 = Integer.valueOf(c2);
	
			if ((value1 > 96)&(value1 <123)&(value2 > 96)&(value2 <123)) {
				
				Zmtime zmtime = new Zmtime();
				zmtime.setName(demo);
				zmtime.setTimes(1);
				
				list.add(zmtime);
			}
		}
		
		for (Zmtime zmtime : list) {
			
			context.write(new Text(zmtime.getName()), new IntWritable(zmtime.getTimes()));
		}
		
	
		String teString1 = value.toString();		
		Text text1 =  new Text();
		
		IntWritable iWritable1 = new IntWritable(Integer.valueOf(key.toString()));
		
		String demo1 = "";
	
		text1 = new Text("1");
		
		for(int i = 0 ;i+7<=teString1.length();i++) {
			demo1 = teString1.substring(i, i+7);
			
			if (demo1.equals("torture")) {
				text1 = new Text(demo1);			
				break;
			}
		}
		
		context.write(text1,iWritable1);
	}


	
	protected void setup(org.apache.hadoop.mapreduce.Mapper.Context context)
			throws IOException, InterruptedException {
		
		addr = InetAddress.getLocalHost();
	
		ip = addr.getHostAddress();
		
		hostname = addr.getHostName();
		SimpleDateFormat sdf = new SimpleDateFormat();
		sdf.applyPattern("yyyy-MM-dd hh:mm:ss");
		
		System.out.println(hostname+":"+ip + sdf.format(new Date()) + ":map()");

	}

}
