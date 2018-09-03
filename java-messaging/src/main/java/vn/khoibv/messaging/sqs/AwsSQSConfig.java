package vn.khoibv.messaging.sqs;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClient;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration for Amazon Simple Queue Service
 * <p>
 * Created by khoibv on 2018/01/30.
 */
@Configuration
@Slf4j
public class AwsSQSConfig {

    @Value("${app.aws.sqs.endpoint}")
    private String endpoint;

    @Value("${app.aws.sqs.region}")
    private String region;


    @Value("${app.aws.accessKeyId}")
    private String accessKeyId;

    @Value("${app.aws.secretKey}")
    private String secretKey;


    public AmazonSQS createSQSClient() {
        AmazonSQSClientBuilder builder = AmazonSQSClientBuilder.standard();
        builder.setCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials(accessKeyId, secretKey)));

        /**
         * @param serviceEndpoint the service endpoint either with or without the protocol (e.g. https://sns.us-west-1.amazonaws.com or sns.us-west-1.amazonaws.com)
         * @param signingRegion the region to use for SigV4 signing of requests (e.g. us-west-1)
         */
        AwsClientBuilder.EndpointConfiguration endpointConfiguration = new AwsClientBuilder.EndpointConfiguration(endpoint, region);
        builder.setEndpointConfiguration(endpointConfiguration);

        return builder.build();
    }


}
