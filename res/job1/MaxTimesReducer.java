package com.annn.job1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.Reducer.Context;
import org.apache.hadoop.mapreduce.lib.reduce.LongSumReducer;

import com.annn.test.Zmtime;

public class MaxTimesReducer extends
			Reducer<Text, IntWritable, Text, IntWritable>	 {

	private List<Zmtime> list1 = new ArrayList<Zmtime>();
	private List<Zmtime> list2 = new ArrayList<Zmtime>();
	
	protected void reduce(Text keyin, Iterable<IntWritable> valuein,Context context)
			throws IOException, InterruptedException {
		
		if (keyin.toString().length() == 2) {
		
			int i = 0;
		
			for (IntWritable value : valuein) {
				i++;
			}
			
			Zmtime zmtime = new Zmtime(keyin.toString(),i);
			
			list1.add(zmtime);
			
		} else {
			
		
			for (IntWritable value : valuein) {
				list2.add(new Zmtime(keyin.toString(),Integer.valueOf(value.toString())));
				//context.write(keyin, value);
			}
		}
		
		
		
		
		
		
	}

	protected void cleanup(Reducer<Text, IntWritable, Text, IntWritable>.Context context)
			throws IOException, InterruptedException {
		
		Collections.sort(list1,Comparator.comparing(Zmtime::getTimes).reversed());
		
		for (int i = 0; i < 10; i++) {
			Text text = new Text(list1.get(i).getName());
			context.write(text, new IntWritable(list1.get(i).getTimes()));
		}
		
		
		Collections.sort(list2,Comparator.comparing(Zmtime::getTimes));
		for (Zmtime zmtime : list2) {
			if (zmtime.getName().equals("torture")) {
				context.write(new Text("tortureËùÔÚÐÐ£º"), new IntWritable(list2.indexOf(zmtime) + 1));
			}
		}
		
			
			
	}


	
	
	
	
}
