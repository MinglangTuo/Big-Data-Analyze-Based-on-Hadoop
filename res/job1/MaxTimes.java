package com.annn.job1;

import java.io.IOException;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class MaxTimes {

	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {

	
		Job job = new Job();
		job.setJarByClass(MaxTimes.class);
		
		
	
		job.setJobName("out put times");
		
		FileInputFormat.addInputPath(job, new Path(args[0]));
		
		
		FileOutputFormat.setOutputPath(job, new Path(args[1]));
		
	
		job.setMapperClass(MaxTimesMapper.class);
	
		job.setReducerClass(MaxTimesReducer.class);
		
	
		job.setOutputKeyClass(Text.class);
		
		job.setOutputValueClass(IntWritable.class);
		
	
		job.waitForCompletion(true);

	}

}
