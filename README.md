# Big-Data-Analyze-Based-on-Hadoop
The project is about how to use the hadoop(open-source project of Apache Foundation) to consturct basic computer cluster and the MapReduce program will exeute a simple hadoop job for “THE SONNETS” by William Shakespeare. 

## Installation

It needs the pre-conditions for the tasks.
```
•	CentOS 6.2
•	JDK 6 (1.6.0 32)
•	Hadoop 2.3.0
•	Eclipse 4.2.6 (Juno)
```
## DataSet

You can download the "THE SONNETS".http://triggs.djvu.org/djvu-editions.com/SHAKESPEARE/SONNETS/Download.pdf

## Tasks

```
T1:Output only the top 10 most common bigram (pair of adjacent words) in the given dataset, what are they and how many appearances?
T2:Output only the lines that contain the word ‘torture’.
```

## Command Line
You need to run the following command line to analyze the "THE SONNETS" based on the hadoop platform. (NOTE: pg100.txt is the dataset / task_all.jar is the source code)
```
Line: start-all.sh
Line: cd /mnt/hgfs/share/
Line: hadoop fs -ls -R
Line: hadoop fs -mkdir /user
Line:hadoop dfs -put pg100.txt /user/
Line:hadoop jar task_all.jar /user/pg100.txt /user/out1
Line:hadoop fs -cat /user/out1/part-r-00000
Line:hadoop dfs -get /user/out1 /mnt/hgfs/Downloads
```

## Result
The final result can be observed in the result.txt.
```
th	113718
he	83251
an	61317
er	59039
ou	55632
in	54012
re	44693
nd	44668
ha	44362
or	40855
torture所在行：	647
torture所在行：	2428
torture所在行：	3664
torture所在行：	5165
torture所在行：	8733
torture所在行：	9406
torture所在行：	22663
torture所在行：	22729
torture所在行：	23407
torture所在行：	23414
torture所在行：	23415
torture所在行：	23496
torture所在行：	33106
torture所在行：	42200
torture所在行：	43465
torture所在行：	44025
torture所在行：	44283
torture所在行：	44577
torture所在行：	44736
torture所在行：	44769
torture所在行：	47634
torture所在行：	55229
torture所在行：	55808
torture所在行：	65580
torture所在行：	67932
torture所在行：	74098
torture所在行：	74102
torture所在行：	74158
torture所在行：	77114
torture所在行：	83140
torture所在行：	86189
torture所在行：	87934
torture所在行：	89738
torture所在行：	94565
torture所在行：	95950
torture所在行：	97732
torture所在行：	97865
torture所在行：	97876
torture所在行：	121600
torture所在行：	121895
torture所在行：	123229
```



## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.
## License
[MIT](https://choosealicense.com/licenses/mit/)
[xjtlu] Xi 'an Jiaotong Liverpool University
