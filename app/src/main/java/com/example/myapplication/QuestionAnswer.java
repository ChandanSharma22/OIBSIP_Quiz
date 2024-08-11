package com.example.myapplication;

public class QuestionAnswer {

    public static String question[]={
        "How does the Auto Scaling feature help you to improve fault tolerance when using Amazon EC2?",
        "Which statement is beneficial for the pricing model in the AWS cloud? ",
        "Which service is used to analyze data in Amazon S3 using standard SQL?",
        "What AWS service can be used to manage member accounts? "
    };

    public static String choices[][]={
            {"Distribute incoming traffic to Elastic Load Balancing (ELB) ","Block extra incoming traffic in the instance","Increase the instance compute (CPU and RAM) size","Remove unhealthy instances and create a new one."},
            {"Fixed large upfront payments ","Pay only when consume resources ","Large variable payments ","Start with low upfront payment"},
            {"Amazon Athena","Amazon CloudWatch ","Amazon FinSpace ","Amazon Redshift "},
            {"AWS Config","AWS Organizations ","AWS IAM","AWS CloudFormation "}
    };

    public static String correctAnswers[]={
            "Remove unhealthy instances and create a new one.",
            "Pay only when consume resources ",
            "Amazon Athena",
            "AWS Organizations "
    };


}
