package com.amazonaws.samples;

import java.util.List;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.Bucket;

public class CreateS3Bucket {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
final AmazonS3 s3=AmazonS3ClientBuilder.defaultClient();
String bucket_name="testucketiaavaodeapas";
String bucketName=null;
int flag=0;
List<Bucket> bucketList=s3.listBuckets();
		
//Iterator<Bucket> itr=bucketList.iterator();
for(Bucket b: bucketList) {
	//bucketName=itr.next().getName();
	 bucketName=b.getName();
    System.out.println(bucketName+" "+bucket_name);
    if(bucketName.contentEquals(bucket_name)) {
    	System.out.println("Deleting Bucket .......");
    	s3.deleteBucket(bucket_name);
    	flag=1;
    	
    }
    
}

if (flag==0) {
	//System.out.println("calling if");
	s3.createBucket(bucket_name);
	System.out.println("Bucket was not there and Creating "+bucket_name+" ...........");
	
}
else {
	//System.out.println("calling else");
	System.out.println("Bucket was there and it got deleted");
	
}

}
}